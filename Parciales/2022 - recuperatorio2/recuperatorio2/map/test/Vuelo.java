package test;

public class Vuelo {

	private int nroVuelo;
	private String codigoOrigen;
	private String codigoDestino;
	private double precio;
	
	
	public Vuelo(int nroVuelo, String codigoOrigen, String codigoDestino, double precio) {
		super();
		this.nroVuelo = nroVuelo;
		this.codigoOrigen = codigoOrigen;
		this.codigoDestino = codigoDestino;
		this.precio = precio;
	}
	
	public int getNroVuelo() {
		return nroVuelo;
	}

	public void setNroVuelo(int nroVuelo) {
		this.nroVuelo = nroVuelo;
	}

	public String getCodigoOrigen() {
		return codigoOrigen;
	}

	public void setCodigoOrigen(String codigoOrigen) {
		this.codigoOrigen = codigoOrigen;
	}

	public String getCodigoDestino() {
		return codigoDestino;
	}

	public void setCodigoDestino(String codigoDestino) {
		this.codigoDestino = codigoDestino;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Vuelo [nroVuelo=" + nroVuelo + ", codigoOrigen=" + codigoOrigen + ", codigoDestino=" + codigoDestino
				+ ", precio=" + precio + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nroVuelo;
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
		Vuelo other = (Vuelo) obj;
		if (nroVuelo != other.nroVuelo)
			return false;
		return true;
	}
		
}
