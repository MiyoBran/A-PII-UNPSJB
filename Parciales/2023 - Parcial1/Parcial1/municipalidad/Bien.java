package municipalidad;

public abstract class Bien {

	private String fechaAlta;
	private Titular titular;
	
	public Bien(String fechaAlta, Titular titular) {
		super();
		this.fechaAlta = fechaAlta;
		this.titular = titular;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Titular getTitular() {
		return titular;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}

	@Override
	public String toString() {
		return "Bien [fechaAlta=" + fechaAlta + ", titular=" + titular + "]";
	}
	
	public abstract double calcularImpuesto();
	
}
