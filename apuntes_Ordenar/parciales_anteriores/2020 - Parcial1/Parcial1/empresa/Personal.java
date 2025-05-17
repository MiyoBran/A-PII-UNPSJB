package empresa;

public abstract class Personal {

	private String nombre;
	private String dni;
	private Departamento departamento;
	
	public Personal(String nombre, String dni, Departamento departamento) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.departamento = departamento;
	}
	
	public abstract double calcularSueldo();

	@Override
	public String toString() {
		return "Personal [nombre=" + nombre + ", dni=" + dni
				+ ", departamento=" + departamento + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Personal other = (Personal) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	
	
}
