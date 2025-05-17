public abstract class Vehiculo {
	private String patente;
	private String marca;
	private int modelo;

	
	public Vehiculo(String patente, String marca, int modelo) {
		super();
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
	}

	public abstract double calcularAlquiler(int dias, int kms);

	@Override
	public String toString() {
		return "Vehiculo [patente=" + patente + ", marca=" + marca
				+ ", modelo=" + modelo + "]";
	}
	
	
}
