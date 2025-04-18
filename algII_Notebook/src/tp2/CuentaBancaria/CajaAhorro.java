package tp2.CuentaBancaria;
/*
 * ✔ Depósitos y extracciones solo si el saldo no queda negativo.
 */
public class CajaAhorro extends CuentaBancaria {

    public CajaAhorro(String numeroCuenta, String titular, double saldo) {
        super(numeroCuenta, titular, saldo);
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito de $" + monto + " realizado.");
        } else {
            System.out.println("El monto a depositar debe ser positivo.");
        }
    }

    public void extraer(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            System.out.println("Extracción de $" + monto + " realizada.");
        } else {
            System.out.println("Fondos insuficientes para extraer $" + monto);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " (Caja de Ahorro)";
    }
}
