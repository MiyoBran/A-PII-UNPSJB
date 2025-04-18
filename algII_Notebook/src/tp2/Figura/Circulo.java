package tp2.Figura;
/*
 * ✔ Implementa área y perímetro para un círculo.
 */
public class Circulo extends FiguraBidimensional {
    private double radio;

    public Circulo(Punto posicion, double radio) {
        super(posicion);
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public String toString() {
        return "Círculo en " + posicion + " con radio " + radio;
    }
}
