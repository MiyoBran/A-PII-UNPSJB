package factura;

/**
 * Interfaz que define un contrato para todas las entidades que requieren un
 * pago. Cualquier clase que implemente esta interfaz debe proporcionar una
 * implementación del método obtenerPago().
 *
 * Este enfoque permite tratar de manera uniforme a diferentes tipos de
 * entidades que tienen un monto a pagar, como empleados y facturas.
 *
 * @author MiyenBrandolino
 * @version 1.0
 */
public interface PorPagar {
	double obtenerPago();
}
