package tp2.Figura;
/*
 * ✔ Calcula área, perímetro y volumen.
 */
public class PrismaRectangular extends FiguraTridimensional {
    private double largo;
    private double ancho;
    private double altura;

    public PrismaRectangular(Punto posicion, double largo, double ancho, double altura) {
        super(posicion);
        this.largo = largo;
        this.ancho = ancho;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return 2 * (largo * ancho + largo * altura + ancho * altura);
    }

    @Override
    public double calcularPerimetro() {
        return 4 * (largo + ancho + altura);
    }

    @Override
    public double calcularVolumen() {
        return largo * ancho * altura;
    }

    @Override
    public String toString() {
        return "Prisma Rectangular en " + posicion + " de dimensiones " + largo + "x" + ancho + "x" + altura;
    }
}
