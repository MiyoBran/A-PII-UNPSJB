package empresa;

public class Empleado extends Personal{
	
	private double sueldo;

	public Empleado(String nombre, String dni, Departamento departamento,
			double sueldo) {
		super(nombre, dni, departamento);
		this.sueldo = sueldo;
	}

	@Override
	public double calcularSueldo() {		
		return sueldo;
	}
	
	

}
