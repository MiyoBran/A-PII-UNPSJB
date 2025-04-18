package tp2.Figura;
// ✔ Implementa área y perímetro para un rectángulo.
public class Rectangulo extends FiguraBidimensional {
    private double base;
    private double altura;

    public Rectangulo(Punto posicion, double base, double altura) {
        super(posicion);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    @Override
    public String toString() {
        return "Rectángulo en " + posicion + " de " + base + "x" + altura;
    }
}
