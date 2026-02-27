package game;

import dao.EstadisticaDAO;
import model.Ficha;
import model.Jugador;

import java.util.*;

public class DominoGame {

    private List<Ficha> pozo = new ArrayList<>();
    private Jugador jugador;
    private Jugador cpu;

    public void iniciar() {
        jugador = new Jugador("Jugador");
        cpu = new Jugador("CPU");

        generarFichas();
        repartir();

        boolean jugadorGana = jugarPartida();
        int fichasUsadas = jugador.getFichas().size();

        EstadisticaDAO dao = new EstadisticaDAO();
        dao.guardarEstadistica(jugadorGana, fichasUsadas);
    }

    private boolean jugarPartida() {
        return false;
    }

    private void repartir() {

    }

    private void generarFichas() {

    }


}
