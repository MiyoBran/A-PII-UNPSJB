package tp2.Figura;
//	Representa coordenadas en 2D y 3D.
public class Punto {
    private double x;
    private double y;
    private double z;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
        this.z = 0; // Para figuras bidimensionales
    }

    public Punto(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z; // Para figuras tridimensionales
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
