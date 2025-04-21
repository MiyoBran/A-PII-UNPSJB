package hospital;

public class Medico extends Personal {

	public Medico(int legajo, String nombre, int antiguedad) {
		super(legajo, nombre, antiguedad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularSueldo() {
		// TODO Auto-generated method stub

		return Personal.getBasico() * 1.5 + Personal.getBasico()
				* super.getAntiguedad() * 0.2;

		// return getBasico() * 1.5 + getBasico() * getAntiguedad() * 0.2;
	}

}
