package util;

import java.util.Scanner;

public class ConsolaUtils {

    private static final Scanner scanner = new Scanner(System.in);

    /* =========================
       ENTRADA DE DATOS
       ========================= */

    /**
     * Lee una cadena no vacía desde consola.
     */
    public static String leerString(String mensaje) {
        String input;
        do {
            System.out.print(mensaje);
            input = scanner.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }

    /**
     * Lee un entero con validación.
     */
    public static int leerInt(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                imprimirError("Debe ingresar un número entero válido.");
            }
        }
    }

    /**
     * Lee un entero dentro de un rango.
     */
    public static int leerIntRango(String mensaje, int min, int max) {
        int valor;
        do {
            valor = leerInt(mensaje);
            if (valor < min || valor > max) {
                imprimirError(
                        "El número debe estar entre " + min + " y " + max
                );
            }
        } while (valor < min || valor > max);
        return valor;
    }

    /**
     * Pregunta Sí / No (S/N).
     */
    public static boolean confirmar(String mensaje) {
        System.out.print(mensaje + " (S/N): ");
        String respuesta = scanner.nextLine().trim().toUpperCase();
        return respuesta.equals("S");
    }

    /* =========================
       SALIDA FORMATEADA
       ========================= */

    public static void imprimirTitulo(String titulo) {
        System.out.println();
        System.out.println("====================================");
        System.out.println(" " + titulo.toUpperCase());
        System.out.println("====================================");
    }

    public static void imprimirSubtitulo(String subtitulo) {
        System.out.println("\n--- " + subtitulo + " ---");
    }

    public static void imprimirLinea() {
        System.out.println("------------------------------------");
    }

    public static void imprimirMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void imprimirError(String mensaje) {
        System.out.println("[ERROR] " + mensaje);
    }

    public static void imprimirExito(String mensaje) {
        System.out.println("[OK] " + mensaje);
    }

    /* =========================
       UTILIDADES
       ========================= */

    /**
     * Pausa la ejecución hasta que el usuario presione ENTER.
     */
    public static void pausar() {
        System.out.println("\nPresione ENTER para continuar...");
        scanner.nextLine();
    }

    /**
     * Limpia la consola (funciona en la mayoría de terminales).
     */
    public static void limpiarPantalla() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Si falla, no hacemos nada
        }
    }
}