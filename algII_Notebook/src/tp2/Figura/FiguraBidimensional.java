package tp2.Figura;
// ✔ Las figuras 2D no tienen volumen.
public abstract class FiguraBidimensional extends Figura {

    public FiguraBidimensional(Punto posicion) {
        super(posicion);
    }

    @Override
    public double calcularVolumen() {
        return 0; // No tienen volumen
    }
}
