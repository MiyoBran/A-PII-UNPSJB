package venta;

public class Persona extends Cliente {

	private static double BASE;
	private static double PORC_DESCUENTO;

	public Persona(String nombre, String email) {
		super(nombre, email);
	}

	@Override
	public double calcularVenta() {
		double total = calcularTotal();
		if (total > BASE)
			total -= total * PORC_DESCUENTO / 100;
		return total;
	}

}
