package inversion;

public class Cliente {

	private String nombre;
	private String email;
	private Activo activos[];

	private static final int MAX_ACTIVOS = 10;
	private int indice;

	public Cliente(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email;
		activos = new Activo[MAX_ACTIVOS];
		indice = 0;
	}

	/**
	 * Agrega nuevos activos al cliente. Si el t�tulo no est� en sus activos, lo
	 * agrega. Si ya est� en sus activos, incrementa su cantidad.
	 * 
	 * @param titulo:   t�tulo comprado
	 * @param cantidad: cantidad de t�tulos comprados
	 * @throws ArrayIndexOutOfBoundsException: supera la cantidad m�xima de t�tulos
	 *                                         distintos que puede tener un cliente
	 */
	public void comprarActivo(Titulo titulo, int cantidad) {
		Activo activo = buscarActivo(titulo);
		if (activo != null)
			activo.cantidad += cantidad;
		else {
			if (indice == MAX_ACTIVOS)
				throw new ArrayIndexOutOfBoundsException();
			activos[indice++] = new Activo(titulo, cantidad);
		}
	}

	/**
	 * Realiza la sumatoria de todos los activos del cliente. Multiplica el precio
	 * de cada t�tulo por la cantidad que tiene comprada.
	 * 
	 * @return valuaci�n de la activos del cliente
	 */
	public double totalActivo() {
		double total = 0;
		for (int i = 0; i < indice; i++)
			total += activos[i].getTitulo().getPrecio() * activos[i].getCantidad();
		return total;

	}

	private Activo buscarActivo(Titulo titulo) {
		for (int i = 0; i < indice; i++)
			if (activos[i].getTitulo().equals(titulo))
				return activos[i];

		return null;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", email=" + email + ", activos=" + activos + "]";
	}

	private class Activo {

		private Titulo titulo;
		private int cantidad;

		public Activo(Titulo titulo, int cantidad) {
			super();
			this.titulo = titulo;
			this.cantidad = cantidad;
		}

		public Titulo getTitulo() {
			return titulo;
		}

		public void setTitulo(Titulo titulo) {
			this.titulo = titulo;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

	}

}
