package model;

public class Jugador extends Persona implements IDesplazarseEnPistaConPalo {
    private int numero;
    private String equipo;

    public Jugador(String nombre, int numero, String equipo) {
        super(nombre);
        this.numero = numero;
        this.equipo = equipo;
    }

    public int getNumero() {
        return numero;
    }

    public String getEquipo() {
        return equipo;
    }

    @Override
    public void desplazarse() {
        System.out.println(getNombre() + " se desplaza como jugador.");
    }

    @Override
    public String desplazarseConPalo() {
        return getNombre() + " se desplaza con el palo.";
    }

    public void pasarDisco(Jugador receptor) {
        System.out.println("Jugador número " + this.numero + " se la pasa a Jugador " + receptor.getNumero());
    }
}