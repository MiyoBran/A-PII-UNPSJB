package servicio;

public class Empresa extends Cliente {

	private String razonSocial;
	private boolean ivaExento;

	public Empresa(int id, String direccion, Plan plan, String razonSocial, boolean ivaExento) {
		super(id, direccion, plan);
		this.razonSocial = razonSocial;
		this.ivaExento = ivaExento;
	}

	public String getRazonSocial() {
		return razonSocial;
	}
	
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public boolean isIvaExento() {
		return ivaExento;
	}

	public void setIvaExento(boolean ivaExento) {
		this.ivaExento = ivaExento;
	}

	@Override
	public String toString() {
		return "Empresa [razonSocial=" + razonSocial + ", ivaExento=" + ivaExento + ", getId()=" + getId()
				+ ", getDireccion()=" + getDireccion() + ", getPlan()=" + getPlan() + "]";
	}

	@Override
	public double calcularFactura() {
		double total = super.getPlan().getTarifa();
		if (!ivaExento)
			total += total * Empresa.getIVA() / 100;
		return total;
	}

}
