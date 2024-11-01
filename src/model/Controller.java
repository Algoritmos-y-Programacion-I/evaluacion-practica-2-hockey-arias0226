package model;

import java.util.Random;

public class Controller {

    private Equipo[] equipos;
    private Arbitro[] arbitros;

    private final int CANTIDAD_EQUIPOS = 4;
    private final int CANTIDAD_ARBITROS = 4;

    private int contadorEquipos = 0;
    private int contadorArbitros = 0;

    private Random random;

    /**
     * Constructor de la clase Controller para inicializar variables globales.
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controller con arreglos de equipos y árbitros vacíos.
     */
    public Controller() {
        equipos = new Equipo[CANTIDAD_EQUIPOS];
        arbitros = new Arbitro[CANTIDAD_ARBITROS];
        random = new Random();
    }

    /**
     * Genera y devuelve un fixture de partidos.
     *
     * @return String con el fixture de dos partidos.
     */
    public String fixture() {
        StringBuilder fixture = new StringBuilder();
        int equipo1 = random.nextInt(CANTIDAD_EQUIPOS);
        int equipo2;
        do {
            equipo2 = random.nextInt(CANTIDAD_EQUIPOS);
        } while (equipo2 == equipo1);

        fixture.append("Partido 1: ").append(equipos[equipo1].getNombre()).append(" vs ").append(equipos[equipo2].getNombre()).append("\n");

        do {
            equipo1 = random.nextInt(CANTIDAD_EQUIPOS);
            equipo2 = random.nextInt(CANTIDAD_EQUIPOS);
        } while (equipo2 == equipo1);

        fixture.append("Partido 2: ").append(equipos[equipo1].getNombre()).append(" vs ").append(equipos[equipo2].getNombre());
        return fixture.toString();
    }

    /**
     * Precarga información de equipos y árbitros.
     */
    public void precargarInformacion() {
        // Precargar equipos
        for (int i = 0; i < CANTIDAD_EQUIPOS; i++) {
            Equipo equipo = new Equipo("Equipo " + (i + 1));
            for (int j = 0; j < 5; j++) {
                JugadorHockey jugador = new JugadorHockey("Jugador " + (j + 1), j + 1, equipo.getNombre());
                equipo.agregarJugador(jugador);
            }
            equipos[contadorEquipos++] = equipo;
        }

        // Precargar árbitros
        for (int i = 0; i < CANTIDAD_ARBITROS; i++) {
            arbitros[contadorArbitros++] = new Arbitro("Arbitro " + (i + 1));
        }
    }

    /**
     * Realiza un partido entre dos equipos.
     *
     * @param nombreEquipo1 Nombre del primer equipo.
     * @param nombreEquipo2 Nombre del segundo equipo.
     */
    public void realizarPartido(String nombreEquipo1, String nombreEquipo2) {
        Equipo equipo1 = buscarEquipo(nombreEquipo1);
        Equipo equipo2 = buscarEquipo(nombreEquipo2);

        if (equipo1 == null || equipo2 == null) {
            System.out.println("Error: Uno o ambos equipos no existen.");
            return;
        }

        System.out.println("Partido entre " + equipo1.getNombre() + " y " + equipo2.getNombre());
        int golesEquipo1 = random.nextInt(5);
        int golesEquipo2 = random.nextInt(5);
        System.out.println("Resultado: " + equipo1.getNombre() + " " + golesEquipo1 + " - " + golesEquipo2 + " " + equipo2.getNombre());
    }

    /**
     * Simula una jugada aleatoria.
     */
    public void simularJugada() {
        String[] jugadas = {"Pase largo", "Tiro al arco", "Intercepción", "Dribbling", "Pase corto"};
        String jugada = jugadas[random.nextInt(jugadas.length)];
        System.out.println("Se realiza un " + jugada);
    }

    /**
     * Busca un equipo por su nombre.
     *
     * @param nombre Nombre del equipo a buscar.
     * @return El equipo encontrado o null si no existe.
     */
    private Equipo buscarEquipo(String nombre) {
        for (Equipo equipo : equipos) {
            if (equipo != null && equipo.getNombre().equalsIgnoreCase(nombre)) {
                return equipo;
            }
        }
        return null;
    }

    /**
     * Muestra el fixture generado.
     */
    public void mostrarFixture() {
        System.out.println("Fixture del torneo:");
        System.out.println(fixture());
    }
}