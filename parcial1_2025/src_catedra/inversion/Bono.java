package inversion;

import java.time.LocalDate;

public class Bono extends Titulo {

	private LocalDate vencimiento;
	private static double impuesto = 0.01;
	
	public Bono(String simbolo, String descripcion, double precio, LocalDate vencimiento) {
		super(simbolo, descripcion, precio);
		this.vencimiento = vencimiento;
	}
	
	public LocalDate getVencimiento() {
		return vencimiento;
	}


	public void setVencimiento(LocalDate vencimiento) {
		this.vencimiento = vencimiento;
	}

	public static double getImpuesto() {
		return impuesto;
	}

	public static void setImpuesto(double impuesto) {
		Bono.impuesto = impuesto;
	}

	@Override
	public String toString() {
		return "Bono [vencimiento=" + vencimiento + ", toString()=" + super.toString() + "]";
	}

	@Override
	public double calcularImpuesto(int cantidad) {
		return cantidad * super.getPrecio() * impuesto;
	}
}
