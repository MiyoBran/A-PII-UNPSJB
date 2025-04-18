package tp2.Factura;

import tp2.Factura.PorPagar;
import java.util.ArrayList;

/**
 * Representa una factura con un proveedor, un número de factura y una fecha.
 * Contiene una lista de ítems adquiridos, permitiendo calcular el total a
 * pagar.
 * 
 * Implementa la interfaz PorPagar, lo que permite tratar las facturas como
 * entidades con un importe a pagar.
 * 
 * @author MiyenBrandolino
 * @version 1.1
 */
public class Factura implements PorPagar {
	private String proveedor;
	private int numero;
	private String fecha;
	private ArrayList<Item> articulos;

	public Factura(String proveedor, int numero, String fecha) {
		this.proveedor = proveedor;
		this.numero = numero;
		this.fecha = fecha;
		this.articulos = new ArrayList<>();
	}

	// Método para agregar un ítem a la factura.
	public void agregarItem(String descripcion, int cantidad, double precioUnitario) {
		Item nuevoItem = new Item(descripcion, cantidad, precioUnitario);
		articulos.add(nuevoItem);
	}

	// Implementación de PorPagar: suma de (cantidad * precioUnitario) de todos los
	// ítems.
	@Override
	public double obtenerPago() {
		double total = 0;
		for (Item item : articulos) {
			total += item.getCantidad() * item.getPrecioUnitario();
		}
		return total;
	}

	@Override
	public String toString() {
		return "Factura [Proveedor: " + proveedor + ", Número: " + numero + ", Fecha: " + fecha + ", Total a Pagar: $"
				+ obtenerPago() + "]";
	}

	/**
	 * Representa un ítem dentro de una factura, con una descripción, cantidad
	 * comprada y precio unitario.
	 * 
	 * Esta clase es interna a Factura y solo se utiliza dentro de ella.
	 * 
	 * @author MiyenBrandolino
	 * @version 1.0
	 */
	private class Item {
		private String descripcion;
		private int cantidad;
		private double precioUnitario;

		public Item(String descripcion, int cantidad, double precioUnitario) {
			this.descripcion = descripcion;
			this.cantidad = cantidad;
			this.precioUnitario = precioUnitario;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public int getCantidad() {
			return cantidad;
		}

		public double getPrecioUnitario() {
			return precioUnitario;
		}
	}
}
