package club;

public class SocioActivo extends Socio {

	private static double porcDescuento = 30;
	private static int cantActividades = 3;

	public SocioActivo(int nroSocio, String nombre) {
		super(nroSocio, nombre);
	}

	@Override
	public double calcularCuota() {
		double total = super.calcularActividades() + super.getValorCuota();
		if (super.getNroActividades() >= cantActividades)
			total = total - total * porcDescuento / 100;
		return total;
	}

	public static double getPorcDescuento() {
		return porcDescuento;
	}

	public static void setPorcDescuento(double porcDescuento) {
		SocioActivo.porcDescuento = porcDescuento;
	}

	public static int getCantActividades() {
		return cantActividades;
	}

	public static void setCantActividades(int cantActividades) {
		SocioActivo.cantActividades = cantActividades;
	}

	
}
