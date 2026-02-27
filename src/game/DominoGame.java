package game;

import dao.EstadisticaDAO;
import dao.JugadorDAO;
import model.Ficha;
import model.Jugador;
import util.ConsolaUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DominoGame {

    private final List<Ficha> pozo = new ArrayList<>();
    private Jugador jugador;
    private Jugador cpu;

    public void iniciar() {

        ConsolaUtils.imprimirTitulo("Dominó con Estadísticas");

        String nombreJugador =
                ConsolaUtils.leerString("Ingrese el nombre del jugador: ");

        jugador = new Jugador(nombreJugador);
        cpu = new Jugador("CPU");

        generarFichas();
        repartir();

        ConsolaUtils.imprimirSubtitulo("Fichas del jugador");
        jugador.getFichas().forEach(System.out::println);

        ConsolaUtils.pausar();

        boolean jugadorGana = jugarPartida();
        int fichasUsadas = jugador.getFichas().size();

        // Persistencia
        JugadorDAO jugadorDAO = new JugadorDAO();
        int jugadorId = jugadorDAO.obtenerOcrearJugador(jugador.getNombre());

        EstadisticaDAO estadisticaDAO = new EstadisticaDAO();
        estadisticaDAO.guardarEstadistica(
                jugadorId,
                jugadorGana,
                fichasUsadas
        );

        ConsolaUtils.imprimirLinea();
        if (jugadorGana) {
            ConsolaUtils.imprimirExito("¡Has ganado la partida!");
        } else {
            ConsolaUtils.imprimirMensaje("Has perdido la partida.");
        }
        ConsolaUtils.imprimirMensaje("Estadísticas registradas correctamente.");
    }

    /* ======================
       LÓGICA DEL JUEGO
       ====================== */

    private boolean jugarPartida() {
        // Lógica simplificada (resultado aleatorio)
        return new Random().nextBoolean();
    }

    private void repartir() {
        for (int i = 0; i < 7; i++) {
            jugador.getFichas().add(pozo.remove(0));
            cpu.getFichas().add(pozo.remove(0));
        }
    }

    private void generarFichas() {
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                pozo.add(new Ficha(i, j));
            }
        }
        Collections.shuffle(pozo);
    }
}