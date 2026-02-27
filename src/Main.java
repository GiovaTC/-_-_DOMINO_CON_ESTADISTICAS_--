import game.DominoGame;
import util.ConsolaUtils;

public class Main {

    public static void main(String[] args) {

        boolean continuar;

        do {
            ConsolaUtils.limpiarPantalla();

            DominoGame game = new DominoGame();
            game.iniciar();

            ConsolaUtils.imprimirLinea();
            continuar = ConsolaUtils.confirmar(
                    "¿Desea jugar otra partida?"
            );

        } while (continuar);

        ConsolaUtils.imprimirMensaje(
                "\nGracias por jugar Dominó con Estadísticas."
        );
    }
}