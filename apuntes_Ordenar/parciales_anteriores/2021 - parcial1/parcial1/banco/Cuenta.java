package banco;

public abstract class Cuenta {

	private int nroCuenta;
	private double saldo;
	
	public Cuenta(int nroCuenta, double saldo) {
		super();
		this.nroCuenta = nroCuenta;
		this.saldo = saldo;
	}

	public void depositar(double importe) {
		saldo += importe;
	}
		
	public abstract void extraer(double importe);

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	
}
