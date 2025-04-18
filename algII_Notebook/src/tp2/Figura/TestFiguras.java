package tp2.Figura;

public class TestFiguras {
    public static void main(String[] args) {
        Circulo c = new Circulo(new Punto(1, 2), 5);
        Rectangulo r = new Rectangulo(new Punto(3, 4), 6, 8);
        Esfera e = new Esfera(new Punto(0, 0, 0), 4);
        PrismaRectangular p = new PrismaRectangular(new Punto(2, 3, 4), 5, 6, 7);

        Figura[] figuras = {c, r, e, p};

        for (Figura f : figuras) {
            System.out.println(f);
            System.out.println("Área: " + f.calcularArea());
            System.out.println("Perímetro: " + f.calcularPerimetro());
            System.out.println("Volumen: " + f.calcularVolumen());
            System.out.println("-------------------------");
        }
    }
}
