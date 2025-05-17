package figura;


public class FiguraCompuesta extends Figura {

	private Figura figuras[];
	private static final int MAX_FIGURA = 5;
	private int indice;

	public FiguraCompuesta(String nombre) {
		super(nombre);
		this.figuras = new Figura[MAX_FIGURA];
		indice = 0;
	}

	public void agregarFigura(Figura figura) {
		if (indice == MAX_FIGURA)
			throw new IndexOutOfBoundsException();

		figuras[indice++] = figura;
	}

	@Override
	public double area() {
		double area = 0;
		for (int i = 0; i < indice; i++)
			area += figuras[i].area();
		return area;
	}

	@Override
	public double perimetro() {
		double perimetro = 0;
		for (int i = 0; i < indice; i++)
			perimetro += figuras[i].area();
		return perimetro;
	}


	
}
