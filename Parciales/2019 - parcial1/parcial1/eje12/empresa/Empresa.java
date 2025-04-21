package empresa;

public class Empresa extends Cliente {

	private int cantEmpleados;
	private static double baseEmpresa;
	
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

	public static double getBaseEmpresa() {
		return baseEmpresa;
	}

	public static void setBaseEmpresa(double baseEmpresa) {
		Empresa.baseEmpresa = baseEmpresa;
	}

	@Override
	public double calcularFactura() {
		return baseEmpresa + super.getPlan().getTarifa();
	}

}
