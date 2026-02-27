package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EstadisticaDAO {

    public void guardarEstadistica(
            int jugadorId,
            boolean ganada,
            int fichasUsadas) {

        String sql = """
            INSERT INTO ESTADISTICA
            (JUGADOR_ID, PARTIDAS_JUGADAS, GANADAS, PERDIDAS, FICHAS_USADAS, FECHA)
            VALUES (?, 1, ?, ?, ?, SYSDATE)
            """;

        try (Connection con = ConexionOracle.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, jugadorId);
            ps.setInt(2, ganada ? 1 : 0);
            ps.setInt(3, ganada ? 0 : 1);
            ps.setInt(4, fichasUsadas);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}