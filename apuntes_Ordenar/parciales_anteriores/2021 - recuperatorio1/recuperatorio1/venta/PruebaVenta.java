package venta;

public class PruebaVenta {

	private static int MAX_CLIENTE = 4;

	public static void main(String[] args) {

		Producto p1 = new Producto(25, "Teclado", 1300);
		Producto p2 = new Producto(78, "Mouse", 250);
		Producto p3 = new Producto(250, "Switch", 3500);
		Producto p4 = new Producto(390, "Monitor", 12000);

		Cliente clientes[] = new Cliente[MAX_CLIENTE];

		clientes[0] = new Empresa("Aluar", "aluar@aluar.com.ar");
		clientes[0].agregarVenta(p1, 10);
		clientes[0].agregarVenta(p2, 10);

		clientes[1] = new Persona("Juan", "juan@gmail.com");
		clientes[1].agregarVenta(p3, 1);

		clientes[2] = new Empresa("Infa", "infa@infa.com.ar");
		clientes[2].agregarVenta(p4, 2);

		clientes[3] = new Persona("Ana", "ana@gmail.com");
		clientes[3].agregarVenta(p1, 1);
		clientes[3].agregarVenta(p2, 1);
		clientes[3].agregarVenta(p3, 1);

		double total = 0;
		double venta;
		for (Cliente c : clientes) {
			venta = c.calcularVenta();
			total += venta;
			System.out.println(c.getNombre() + " - Ventas: " + venta);
		}
		System.out.println("Total de ventas: " + total);

	}

}
