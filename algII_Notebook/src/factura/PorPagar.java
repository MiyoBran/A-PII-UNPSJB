package factura;

/**
 * Interfaz que define un contrato para todas las entidades que requieren un
 * pago. Cualquier clase que implemente esta interfaz debe proporcionar una
 * implementación del método obtenerPago().
 *
 * Este enfoque permite tratar de manera uniforme a diferentes tipos de
 * entidades que tienen un monto a pagar, como empleados y facturas.
 *
 *
 * @author ArispeClaudio crapz0190@gmail.com
 * @author BrandolinoCarlos miyenbran@gmail.com
 * @author ColipanAxel maurocolipannn@gmail.com
 * @author MarinoLizandro lizandro.e.marino@gmail.com
 * @version 1.0
 */
public interface PorPagar {
	double obtenerPago();
}
