package empresa;

public abstract class Cliente {

	private int nroCliente;
	private String nombre;
	private Plan planes[];
	private int indice;
	private final static int MAXPLAN = 3;

	public Cliente(int nroCliente, String nombre, Plan plan) {
		super();
		this.nroCliente = nroCliente;
		this.nombre = nombre;
		this.planes = new Plan[MAXPLAN];
		indice = 0;
		agregarPlan(plan);
	}

	public void agregarPlan(Plan plan) {
		if (indice == MAXPLAN)
			throw new IndexOutOfBoundsException("Supera máximo de planes");

		for (int i = 0; i < indice; i++)
			if (planes[i].equals(plan))
				throw new IllegalArgumentException("Plan duplicado");

		planes[indice++] = plan;
	}

	public int getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(int nroCliente) {
		this.nroCliente = nroCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double calcularFactura() {
		double importe = 0;
		for (int i = 0; i < indice; i++)
			importe += planes[i].getTarifa();
		return importe;
	}

}
