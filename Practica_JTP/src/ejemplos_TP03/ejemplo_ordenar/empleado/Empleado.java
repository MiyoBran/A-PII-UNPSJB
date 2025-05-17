package ejemplos_TP03.ejemplo_ordenar.empleado;
public class Empleado implements Comparable<Empleado> {

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
	public int compareTo(Empleado e) {		
		return legajo - e.legajo;
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
	
}
