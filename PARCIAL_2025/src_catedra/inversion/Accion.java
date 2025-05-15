package inversion;

public class Accion extends Titulo {

	private boolean pagaDividendo;
	private static double impuesto = 0.2;

	public Accion(String simbolo, String descripcion, double precio, boolean pagaDividendo) {
		super(simbolo, descripcion, precio);
		this.pagaDividendo = pagaDividendo;
	}

	public boolean isPagaDividendo() {
		return pagaDividendo;
	}

	public void setPagaDividendo(boolean pagaDividendo) {
		this.pagaDividendo = pagaDividendo;
	}

	public static double getImpuesto() {
		return impuesto;
	}

	public static void setImpuesto(double impuesto) {
		Accion.impuesto = impuesto;
	}

	@Override
	public String toString() {
		return "Accion [pagaDividendo=" + pagaDividendo + ", toString()=" + super.toString() + "]";
	}

	@Override
	public double calcularImpuesto(int cantidad) {
		return cantidad * super.getPrecio() * impuesto;
	}
}
