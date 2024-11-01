package model;

public class Equipo {
    private String nombre;
    private JugadorHockey[] jugadores;
    private int contadorJugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new JugadorHockey[5];
        this.contadorJugadores = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarJugador(JugadorHockey jugador) {
        if (contadorJugadores < jugadores.length) {
            jugadores[contadorJugadores++] = jugador;
        }
    }
}