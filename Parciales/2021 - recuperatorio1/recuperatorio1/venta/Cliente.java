package venta;

public abstract class Cliente {

	private String nombre;
	private String email;
	private Venta ventas[];
	private static int MAX_VENTA = 10;
	private int indice;

	public Cliente(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email;
		ventas = new Venta[MAX_VENTA];
		indice = 0;
	}

	public void agregarVenta(Producto producto, int cantidad) {
		if (indice == MAX_VENTA)
			throw new IndexOutOfBoundsException("Puede tener hasta " + MAX_VENTA + " ventas por cliente");

		ventas[indice++] = new Venta(producto, cantidad);
	}

	public double calcularTotal() {
		double total = 0;
		for (int i = 0; i < indice; i++)
			total += ventas[i].getProducto().getPrecio() * ventas[i].getCantidad();
		return total;
	}

	public abstract double calcularVenta();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
