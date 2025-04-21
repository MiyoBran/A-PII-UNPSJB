package club;

public class SocioTemporario extends Socio {

	public SocioTemporario(int nroSocio, String nombre) {
		super(nroSocio, nombre);
	}

	@Override
	public double calcularCuota() {
		return super.calcularActividades() + super.getValorCuota();
	}

}
