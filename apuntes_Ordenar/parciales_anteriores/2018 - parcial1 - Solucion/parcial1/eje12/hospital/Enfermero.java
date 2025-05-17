package hospital;

public class Enfermero extends Personal {

	public Enfermero(int legajo, String nombre, int antiguedad) {
		super(legajo, nombre, antiguedad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularSueldo() {
		return Personal.getBasico() + Personal.getBasico()
				* super.getAntiguedad() * 0.1;
	}

}
