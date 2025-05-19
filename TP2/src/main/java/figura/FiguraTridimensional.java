package figura;
/*
 * ✔ Las figuras 3D implementan calcularVolumen().
 */
public abstract class FiguraTridimensional extends Figura {

    public FiguraTridimensional(Punto posicion) {
        super(posicion);
    }

    @Override
    public abstract double calcularVolumen();
}
