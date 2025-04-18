package empresa;

/**
 * Clase de prueba para la clase Factura.
 * 
 * Se crean instancias de facturas, se agregan ítems a cada una y se imprime su contenido.
 * Finalmente, se muestra el total a pagar de cada factura.
 * 
 * @author Catedra
 * @author ArispeClaudio crapz0190@gmail.com
 * @author BrandolinoCarlos miyenbran@gmail.com
 * @author ColipanAxel maurocolipannn@gmail.com
 * @author MarinoLizandro lizandro.e.marino@gmail.com
 * @version 1.5
 */
public class PruebaFactura {

	public static void main(String[] args) {

		Factura f2 = new Factura("FortinRepublica", 22222, "2017-05-05");
		f2.agregarItem("Tornillo", 50, 0.25);
		f2.agregarItem("Clavos", 100, 0.1);
		f2.agregarItem("Cualquier Cosa", 10, 100);

		System.out.println(f2);
		System.out.println("Total de la factura: " + f2.obtenerPago());
		
		
		Factura f3 = new Factura("FerreteriaCentral", 33333, "2025-04-02");
		f3.agregarItem("Martillo", 5, 15.0);
		f3.agregarItem("Destornillador", 8, 12.5);
		f3.agregarItem("Caja de Tornillos", 3, 50.0);
		f3.agregarItem("Llave Inglesa", 4, 20.0);
		f3.agregarItem("Cinta Aisladora", 10, 5.0);
		f3.agregarItem("Pegamento Industrial", 2, 30.0);

		System.out.println("\n" + f3);
		System.out.println("Total de la factura: " + f3.obtenerPago());

	}
	
}
