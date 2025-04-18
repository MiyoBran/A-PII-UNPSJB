package figura;
/*
 * ✔ Calcula área y volumen (sin perímetro).
 */
public class Esfera extends FiguraTridimensional {
    private double radio;

    public Esfera(Punto posicion, double radio) {
        super(posicion);
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return 4 * Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 0; // No aplica en una esfera
    }

    @Override
    public double calcularVolumen() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
    }

    @Override
    public String toString() {
        return "Esfera en " + posicion + " con radio " + radio;
    }
}
