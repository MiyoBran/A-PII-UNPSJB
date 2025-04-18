package empresa;

import java.util.Arrays;

/**
 * Representa una factura con un proveedor, un número de factura y una fecha.
 * Contiene una lista de ítems adquiridos, permitiendo calcular el total a
 * pagar.
 * 
 * Implementa la interfaz PorPagar, lo que permite tratar las facturas como
 * entidades con un importe a pagar.
 * 
 * @author catedra
 * @author ArispeClaudio crapz0190@gmail.com
 * @author BrandolinoCarlos miyenbran@gmail.com
 * @author ColipanAxel maurocolipannn@gmail.com
 * @author MarinoLizandro lizandro.e.marino@gmail.com
 * @version 1.5
 */
public class Factura implements PorPagar {

	// Atributos de la clase Factura
	private static final int CANTIDAD_ITEMS = 10;
	private String proveedor;
	private int numero;
	private String fecha;

	private int cantArticulos = 0;
	private Item[] articulos;

	// Constructor
	public Factura(String proveedor, int numero, String fecha) {
		this.proveedor = proveedor;
		this.numero = numero;
		this.fecha = fecha;
		articulos = new Item[CANTIDAD_ITEMS];
	}

	// Metodo implementado por la interfaz
	// Implementación de PorPagar: suma de (cantidad * precioUnitario) de todos los
	// ítems.
	public double obtenerPago() {
		double totalFactura = 0;
		for (int i = 0; i < CANTIDAD_ITEMS; i++) {
			if (articulos[i] != null) {
				totalFactura += articulos[i].getCantidad() * articulos[i].getPrecioUnitario();
			}
		}
		return totalFactura;
	}//

	// Metodo para agregar un articulo al arreglo de tipo Item
	public void agregarItem(String descripcion, int cantidad, double precioUnitario) throws IndexOutOfBoundsException {
		if (cantArticulos >= CANTIDAD_ITEMS)
			throw new IndexOutOfBoundsException("Factura completa");

		this.articulos[cantArticulos++] = new Item(descripcion, cantidad, precioUnitario);
	}

	@Override
	public String toString() {
		return "Factura [proveedor=" + proveedor + ", numero=" + numero + ", fecha=" + fecha + ", cantArticulos="
				+ cantArticulos + ", articulos= "+ "\n"  + Arrays.toString(articulos) + "]";
	}

	/**
	 * Representa un ítem dentro de una factura, con una descripción, cantidad
	 * comprada y precio unitario.
	 * 
	 * Esta clase es interna a Factura y solo se utiliza dentro de ella. Se
	 * agregaron getters
	 * 
	 * @author Catedra
	 * @author MiyenBrandolino
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

		public int getCantidad() {
			return cantidad;
		}

		public double getPrecioUnitario() {
			return precioUnitario;
		}

		@Override
		public String toString() {
			return "Item [descripcion=" + descripcion + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario
					+ "]";
		}

	}

}
