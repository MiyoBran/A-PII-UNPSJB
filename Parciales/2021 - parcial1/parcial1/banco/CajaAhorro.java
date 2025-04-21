package banco;

public class CajaAhorro extends Cuenta {
	
	public CajaAhorro(int nroCuenta, double saldo) {
		super(nroCuenta, saldo);
	}

	@Override
	public void extraer(double importe) {
		if (getSaldo() < importe)
			throw new RuntimeException("Saldo Insuficiente");
		
		setSaldo(getSaldo() - importe);
	}

}
