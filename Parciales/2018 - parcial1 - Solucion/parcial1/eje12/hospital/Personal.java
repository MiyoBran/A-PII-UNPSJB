package hospital;

public abstract class Personal {

	private int legajo;
	private String nombre;
	private int antiguedad;
	private static double basico = 10000;
	
	
	public Personal(int legajo, String nombre, int antiguedad) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.antiguedad = antiguedad;
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


	public int getAntiguedad() {
		return antiguedad;
	}


	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}


	public static double getBasico() {
		return basico;
	}


	public static void setBasico(double basico) {
		Personal.basico = basico;
	}


	public abstract double calcularSueldo();


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
		Personal other = (Personal) obj;
		if (legajo != other.legajo)
			return false;
		return true;
	}
	
	
}
