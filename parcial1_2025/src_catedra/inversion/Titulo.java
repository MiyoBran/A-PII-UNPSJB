package inversion;

public abstract class Titulo {

	private String simbolo;
	private String descripcion;
	private double precio;
	private static double comision = 0.005;

	public Titulo(String simbolo, String descripcion, double precio) {
		super();
		this.simbolo = simbolo;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public static double getComision() {
		return comision;
	}

	public static void setComision(double comision) {
		Titulo.comision = comision;
	}

	/**
	 * Calcula el impuesto por la compra realizada (cantidad * precio *
	 * impuesto)
	 * 
	 * @param cantidad: cantidad de t�tulos comprados
	 * @return impuesto 
	 */
	public abstract double calcularImpuesto(int cantidad);

	/**
	 * Calcula la comisi�n del banco por la compra realizada (cantidad * precio *
	 * comision)
	 * 
	 * @param cantidad: cantidad de t�tulos comprados
	 * @return comisi�n del banco
	 */
	public double calcularComision(int cantidad) {
		return precio * cantidad * comision;
	}

	/**
	 * Calcula el precio total de la compra incluida la comisi�n del banco y los
	 * impuestos (precio * cantidad + comisi�n + impuestos)
	 * 
	 * @param cantidad: cantidad de t�tulos comprados
	 * @return precio total de compra
	 */
	public double calcularPrecio(int cantidad) {
		return precio * cantidad + calcularComision(cantidad) + calcularImpuesto(cantidad);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((simbolo == null) ? 0 : simbolo.hashCode());
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
		Titulo other = (Titulo) obj;
		if (simbolo == null) {
			if (other.simbolo != null)
				return false;
		} else if (!simbolo.equals(other.simbolo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Titulo [simbolo=" + simbolo + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}

}
