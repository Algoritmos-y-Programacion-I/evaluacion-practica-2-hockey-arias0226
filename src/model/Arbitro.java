package model;

public class Arbitro extends Persona {
    public Arbitro(String nombre, int edad) {
    super(nombre, edad);
}

    @Override
    public void desplazarse() {
        System.out.println(getNombre() + " se desplaza como árbitro en la pista.");
    }
}