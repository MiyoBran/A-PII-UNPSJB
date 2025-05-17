public class TodoTerreno extends Vehiculo {

	private double valorDia;
	private double valorKm;

	public TodoTerreno(String patente, String marca, int modelo,
			double valorDia, double valorKm) {
		super(patente, marca, modelo);
		this.valorDia = valorDia;
		this.valorKm = valorKm;
	}

	@Override
	public double calcularAlquiler(int dias, int kms) {
		return valorDia * dias + valorKm * kms;
	}

}
