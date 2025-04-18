package tp2.CuentaBancaria;
/*
 * ✔ Permite saldo negativo hasta limiteDescubierto.
 * ✔ Registra datos adicionales (CUIT, dirección, email).
 */
public class CuentaCorriente extends CuentaBancaria {
    private double limiteDescubierto;
    private String cuit;
    private String direccion;
    private String email;

    public CuentaCorriente(String numeroCuenta, String titular, double saldo, double limiteDescubierto, 
                           String cuit, String direccion, String email) {
        super(numeroCuenta, titular, saldo);
        this.limiteDescubierto = limiteDescubierto;
        this.cuit = cuit;
        this.direccion = direccion;
        this.email = email;
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
        if (monto > 0 && (saldo - monto) >= -limiteDescubierto) {
            saldo -= monto;
            System.out.println("Extracción de $" + monto + " realizada.");
        } else {
            System.out.println("Límite de descubierto excedido para extraer $" + monto);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " (Cuenta Corriente, Descubierto: $" + limiteDescubierto + ") " +
               "[CUIT: " + cuit + ", Dirección: " + direccion + ", Email: " + email + "]";
    }
}
