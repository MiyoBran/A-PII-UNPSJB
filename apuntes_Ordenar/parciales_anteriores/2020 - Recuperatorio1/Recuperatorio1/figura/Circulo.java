package figura;

public class Circulo extends Figura {

	private double radio;

	public Circulo(String nombre, double radio) {
		super(nombre);
		this.radio = radio;
	}

	@Override
	public double area() {
		return Math.PI * Math.pow(radio, 2);
	}

	@Override
	public double perimetro() {
		return Math.PI * 2 * radio;
	}

}
