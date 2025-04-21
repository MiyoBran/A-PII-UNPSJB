package banco;

public class PruebaCuenta {

	private static int MAX_CLIENTE = 5;

	public static void main(String[] args) {

		Cliente clientes[] = new Cliente[MAX_CLIENTE];

		clientes[0] = new Cliente("Juan", "11111111");
		clientes[0].agregarCuenta(new CajaAhorro(123, 1000));
		clientes[0].agregarCuenta(new CuentaCorriente(232, 2000));

		clientes[1] = new Cliente("Ana", "22222222");
		CuentaCorriente cc1 = new CuentaCorriente(321, 0);
		clientes[1].agregarCuenta(cc1);
		cc1.extraer(5000);
		try {
			cc1.extraer(1000);
		} catch (RuntimeException e) {
			System.out.println(e);
			System.out.println("Saldo actual: " + cc1.getSaldo());
		}

		clientes[2] = new Cliente("Pedro", "33333333");

		clientes[3] = new Cliente("María", "44444444");
		CajaAhorro ca3 = new CajaAhorro(432, 1000);
		clientes[3].agregarCuenta(ca3);
		try {
			ca3.extraer(2000);
		} catch (RuntimeException e) {
			System.out.println(e);
			System.out.println("Saldo actual: " + ca3.getSaldo());
		}

		clientes[4] = new Cliente("Jorge", "55555555");
		try {
			clientes[4].agregarCuenta(new CajaAhorro(543, 1000));
			clientes[4].agregarCuenta(new CajaAhorro(632, 1000));
			clientes[4].agregarCuenta(new CajaAhorro(777, 1000));
			clientes[4].agregarCuenta(new CajaAhorro(787, 1000));
			clientes[4].agregarCuenta(new CajaAhorro(987, 1000));
			clientes[4].agregarCuenta(new CajaAhorro(997, 1000));
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}

		double total = 0;
		double saldo;
		for (Cliente c : clientes) {
			saldo = c.calcularSaldo();
			System.out.println(c.getNombre() + ": " + saldo);
			total += saldo;
		}

		System.out.println("Total de depósitos en el banco: " + total);
	}

}
