
public class Coche extends Vehiculo{

	private double valorKm;
		
	public Coche(String patente, String marca, int modelo, double valorKm) {
		super(patente, marca, modelo);
		this.valorKm = valorKm;
	}

	@Override
	public double calcularAlquiler(int dias, int kms) {
		// TODO Auto-generated method stub
		return valorKm * kms;
	}

}
