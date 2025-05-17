package ejemplos_TP03.ejemplo_clone.lista;
public class Empleado implements Cloneable {

	private int legajo;
	private String nombre;
	
	public Empleado(int legajo, String nombre) {

		this.legajo = legajo;
		this.nombre = nombre;		
	}
	
	@Override
	public String toString() {
		return "Empleado [legajo=" + legajo + ", nombre=" + nombre + "]";
	}

	@Override
    public Empleado clone() throws CloneNotSupportedException {
        return (Empleado) super.clone();
    }


	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + legajo;
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
		Empleado other = (Empleado) obj;
		if (legajo != other.legajo)
			return false;
		return true;
	}
	
	
}
