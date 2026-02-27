package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JugadorDAO {

    /**
     * Obtiene el ID de un jugador existente o lo crea si no existe.
     *
     * @param nombre Nombre del jugador
     * @return ID del jugador
     */
    public int obtenerOcrearJugador(String nombre) {

        String selectSql =
                "SELECT ID FROM JUGADOR WHERE UPPER(NOMBRE) = UPPER(?)";

        String insertSql =
                "INSERT INTO JUGADOR (NOMBRE) VALUES (?)";

        try (Connection con = ConexionOracle.getConexion()) {

            /* =========================
               1️⃣ Buscar jugador
               ========================= */
            try (PreparedStatement ps = con.prepareStatement(selectSql)) {
                ps.setString(1, nombre);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    return rs.getInt("ID");
                }
            }

            /* =========================
               2️⃣ Crear jugador
               ========================= */
            try (PreparedStatement ps = con.prepareStatement(
                    insertSql, new String[]{"ID"})) {

                ps.setString(1, nombre);
                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }
}