package venta;

public class Empresa extends Cliente {

	private static double DESCUENTO;

	public Empresa(String nombre, String email) {
		super(nombre, email);
	}

	@Override
	public double calcularVenta() {
		double total = calcularTotal();
		return total - total * DESCUENTO / 100;
	}

}
