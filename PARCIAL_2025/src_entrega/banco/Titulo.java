package banco;

import java.util.Objects;

/**
 * Clase abstracta que representa un título financiero genérico.
 * @author MiyenBrandolino
 */
public abstract class Titulo {

	// --- Atributos ---
	private String simbolo; // Ej. "ALUA", "AL30"
	private String descripcion; // Ej. "Aluar", "Bono AL 30"
	private double precio; // Precio actual del título

	// Comision del Banco --> Comun a todos
	public static final double COMISION = 0.005;

	// --- Constructor ---
	/**
	 * Constructor para inicializar los atributos comunes de un título. Es
	 * 'protected' porque solo debe ser llamado por las clases hijas (Accion, Bono).
	 * 
	 * @param simbolo     Símbolo del título.
	 * @param descripcion Descripción del título.
	 * @param precio      Precio actual.
	 */
	protected Titulo(String simbolo, String descripcion, double precio) {
		this.simbolo = simbolo;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	// --- Getters ---
	public String getSimbolo() {
		return simbolo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	/**
	 * Calcula la comisión del banco por la compra realizada (cantidad * precio *
	 * comision)
	 * 
	 * @param cantidad: cantidad de títulos comprados
	 * @return comisión del banco
	 */
	public double calcularComision(int cantidad) {
		return cantidad * this.precio * COMISION;
	}

	/**
	 * Calcula el impuesto por la compra realizada (cantidad * precio * impuesto)
	 * Método específico de cada sub‑clase (impuesto variable)
	 * 
	 * @param cantidad: cantidad de títulos comprados
	 * @return impuesto
	 */
	public abstract double calcularImpuesto(int cantidad);

	/**
	 * Calcula el precio total de la compra incluida la comisión del banco y los
	 * impuestos (precio * cantidad + comisión + impuestos)
	 * 
	 * @param cantidad: cantidad de títulos comprados
	 * @return precio total de compra
	 */
	public double calcularPrecio(int cantidad) {
		double precioBase = this.precio * cantidad;
		double comision = this.calcularComision(cantidad);
		double impuesto = this.calcularImpuesto(cantidad);
		return precioBase + comision + impuesto;
	}

	// --- equals, hashCode, toString ---

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Titulo titulo = (Titulo) obj;
		return Objects.equals(simbolo, titulo.simbolo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(simbolo);
	}

	@Override
	public String toString() {
		return "Titulo [simbolo=" + simbolo + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
}