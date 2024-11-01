package ui;

import java.util.*;
import model.Controller;

public class Executable {

    private Scanner escaner;
    private Controller controladora;
    private static boolean flag;

    /**
     * Constructor de la clase Executable para inicializar el lector de entrada y el
     * controlador.
     */
    public Executable() {
        escaner = new Scanner(System.in);
        controladora = new Controller();
    }

    /**
     * Ejecuta el programa principal.
     */
    public void run(boolean flag) {
        flag = false;

        while (!flag) {
            mostrarMenu();
            int option = leerOpcion();

            switch (option) {
                case 1:
                    System.out.println("\nMostrando fixture del torneo:");
                    mostrarFixture();
                    break;
                case 2:
                    System.out.println("\nPrecargando información del juego:");
                    precargarInformacion();
                    break;
                case 3:
                    System.out.println("\nPreparación para realizar partido:");
                    realizarPartido();
                    break;
                case 4:
                    System.out.println("\nSimulando jugada de gol:");
                    simularJugada();
                    break;
                case 5:
                    flag = true;
                    System.out.println("Gracias por usar el programa. ¡Hasta pronto!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Por favor ingrese una opción válida");
                    continue;
            }
            
            System.out.println("\nPresione Enter para continuar...");
            escaner.nextLine();
        }
    }

    /**
     * Muestra el menú principal
     */
    private void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE GESTIÓN DE TORNEO DE HOCKEY ===\n");
        System.out.println("1. Mostrar Fixture del Torneo");
        System.out.println("2. Precargar Información");
        System.out.println("3. Realizar Partido");
        System.out.println("4. Simular Jugada");
        System.out.println("5. Salir del Programa");
        System.out.print("\nSeleccione una opción: ");
    }

    /**
     * Lee y valida la opción ingresada por el usuario
     */
    private int leerOpcion() {
        try {
            return Integer.parseInt(escaner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Método para mostrar el fixture del torneo
     */
    private void mostrarFixture() {
        try {
            String fixture = controladora.fixture();
            System.out.println("\n=== FIXTURE DEL TORNEO ===");
            System.out.println(fixture);
        } catch (Exception e) {
            System.out.println("Error al mostrar el fixture: " + e.getMessage());
        }
    }

    /**
     * Método para precargar información del juego
     */
    private void precargarInformacion() {
        try {
            controladora.precargarInformacion();
            System.out.println("Información precargada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al precargar información: " + e.getMessage());
        }
    }

    /**
     * Método para realizar un partido entre dos equipos
     */
    private void realizarPartido() {
        try {
            System.out.println("\n=== REALIZAR PARTIDO ===");
            System.out.println("Ingrese el nombre del primer equipo:");
            String equipo1 = escaner.nextLine();
            System.out.println("Ingrese el nombre del segundo equipo:");
            String equipo2 = escaner.nextLine();
            
            if (equipo1.equals(equipo2)) {
                System.out.println("Error: No se puede jugar un partido entre el mismo equipo");
                return;
            }
            
            controladora.realizarPartido(equipo1, equipo2);
        } catch (Exception e) {
            System.out.println("Error al realizar el partido: " + e.getMessage());
        }
    }

    /**
     * Método para simular una jugada de gol
     */
    private void simularJugada() {
        try {
            System.out.println("\n=== SIMULACIÓN DE JUGADA ===");
            controladora.simularJugada();
        } catch (Exception e) {
            System.out.println("Error al simular la jugada: " + e.getMessage());
        }
    }

    /**
     * Método principal (main) para iniciar la ejecución del programa.
     */
    public static void main(String[] args) {
        try {
            System.out.println("Iniciando sistema de gestión de torneo de hockey...");
            Executable mainApp = new Executable();
            mainApp.run(flag);
        } catch (Exception e) {
            System.out.println("Error fatal en la ejecución del programa: " + e.getMessage());
        } finally {
            System.out.println("Finalizando programa...");
        }
    }
}