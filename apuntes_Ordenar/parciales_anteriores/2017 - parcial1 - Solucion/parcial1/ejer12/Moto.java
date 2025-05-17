
public class Moto extends Vehiculo {

	private double valorDia;

	public Moto(String patente, String marca, int modelo, double valorDia) {
		super(patente, marca, modelo);
		this.valorDia = valorDia;
	}

	@Override
	public double calcularAlquiler(int dias, int kms) {
		return valorDia * dias;
	}
	
	
	
}
