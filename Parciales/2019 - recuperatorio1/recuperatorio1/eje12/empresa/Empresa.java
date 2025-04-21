package empresa;

public class Empresa extends Cliente {

	private int cantEmpleados;
	private static double porcEmpleados;

	public Empresa(int nroCliente, String nombre, Plan plan, int cantEmpleados) {
		super(nroCliente, nombre, plan);
		this.cantEmpleados = cantEmpleados;
	}

	public int getCantEmpleados() {
		return cantEmpleados;
	}

	public void setCantEmpleados(int cantEmpleados) {
		this.cantEmpleados = cantEmpleados;
	}

	
	public static double getPorcEmpleados() {
		return porcEmpleados;
	}

	public static void setPorcEmpleados(double porcEmpleados) {
		Empresa.porcEmpleados = porcEmpleados;
	}

	@Override
	public double calcularFactura() {
		return super.calcularFactura() + super.calcularFactura()
				* cantEmpleados * porcEmpleados / 100;
	}

}
