package figura;

public abstract class Figura {

	private String nombre;	
	
	public Figura(String nombre) {
		super();
		this.nombre = nombre;
	}

	public abstract double area();
	public abstract double perimetro();

	@Override
	public String toString() {
		return nombre;
	}
	
}
