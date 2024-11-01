package model;

public class JugadorHockey extends Jugador {
    public JugadorHockey(String nombre, int numero, String equipo) {
        super(nombre, numero, equipo);
    }

    @Override
    public void desplazarse() {
        System.out.println(getNombre() + " se desplaza como jugador de hockey.");
    }
}