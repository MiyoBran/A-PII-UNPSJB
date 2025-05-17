package banco;

public class Cliente {

	private String nombre;
	private String dni;
	private Cuenta cuentas[];
	private static int MAX_CUENTA = 5;
	private int indice;

	public Cliente(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		cuentas = new Cuenta[MAX_CUENTA];
		indice = 0;
	}

	public void agregarCuenta(Cuenta cuenta) {
		if (indice == MAX_CUENTA)
			throw new IndexOutOfBoundsException("Puede tener hasta " + MAX_CUENTA + " cuentas");

		cuentas[indice++] = cuenta;
	}

	public double calcularSaldo() {
		double saldo = 0;
		for (int i = 0; i < indice; i++)
			saldo += cuentas[i].getSaldo();
		return saldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
