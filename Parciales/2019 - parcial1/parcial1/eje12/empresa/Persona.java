package empresa;

public class Persona extends Cliente {

	private static int porc_jub = 50;
	private boolean jubilado;

	public Persona(int nroCliente, String nombre, Plan plan, boolean jubilado) {
		super(nroCliente, nombre, plan);
		this.jubilado = jubilado;
	}

	public boolean isJubilado() {
		return jubilado;
	}

	public void setJubilado(boolean jubilado) {
		this.jubilado = jubilado;
	}
	
	public static int getPorc_jub() {
		return porc_jub;
	}

	public static void setPorc_jub(int porc_jub) {
		Persona.porc_jub = porc_jub;
	}

	@Override
	public double calcularFactura() {
		if (jubilado)
			return super.getPlan().getTarifa() * porc_jub / 100;
		return super.getPlan().getTarifa();
	}

}
