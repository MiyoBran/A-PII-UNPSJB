package escuela;


public class Alumno {

	private int legajo;
	private String nombre;

	public Alumno(int legajo, String nombre) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
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
	public String toString() {
		return "Alumno [legajo=" + legajo + ", nombre=" + nombre + "]";
	}
}
