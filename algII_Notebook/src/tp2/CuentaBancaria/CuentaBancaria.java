package tp2.CuentaBancaria;

//Clase base con numeroCuenta, titular y saldo (accesible por subclases).
public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    protected double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Cuenta: " + numeroCuenta + ", Titular: " + titular + ", Saldo: $" + saldo;
    }
}
