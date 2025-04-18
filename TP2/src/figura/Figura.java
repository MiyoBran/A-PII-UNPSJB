package figura;

/*
 * ✔ Define métodos abstractos para cálculos
 * ✔ Utiliza Punto para almacenar la ubicación.
 */

public abstract class Figura {
    protected Punto posicion;

    public Figura(Punto posicion) {
        this.posicion = posicion;
    }

    public abstract double calcularArea();

    public abstract double calcularPerimetro();

    public abstract double calcularVolumen();

    @Override
    public String toString() {
        return "Posición: " + posicion;
    }
}
