package empresa;

public class Empresa {

	private String nombre;
	private Personal personal[];
	private static final int MAX_PERSONAL = 100;
	private int indice;

	public Empresa(String nombre) {
		super();
		this.nombre = nombre;
		personal = new Personal[MAX_PERSONAL];
		indice = 0;
	}

	public Personal agregarEmpleado(String nombre, String dni,
			Departamento departamento, double sueldo) {
		if (indice == MAX_PERSONAL)
			throw new IndexOutOfBoundsException("Supera máximo personal: "
					+ MAX_PERSONAL);
		Personal p = new Empleado(nombre, dni, departamento, sueldo);
		personal[indice++] = p;
		return p;
	}

	public Personal agregarContratado(String nombre, String dni,
			Departamento departamento, double valorHora, double cantHoras) {
		if (indice == MAX_PERSONAL)
			throw new IndexOutOfBoundsException("Supera máximo personal: "
					+ MAX_PERSONAL);
		Personal p = new Contratado(nombre, dni, departamento, valorHora,
				cantHoras);
		personal[indice++] = p;
		return p;
	}

	public double calcularSueldo() {
		double total = 0;
		for (int i = 0; i < indice; i++)
			total += personal[i].calcularSueldo();
		return total;
	}

	public double calcularSueldo(Departamento departamento) {
		double total = 0;
		for (int i = 0; i < indice; i++)
			if (personal[i].getDepartamento().equals(departamento))
				total += personal[i].calcularSueldo();
		return total;
	}

	public String getNombre() {
		return nombre;
	}

	
	
	
}
