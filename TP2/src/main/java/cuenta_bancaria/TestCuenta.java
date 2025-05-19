package cuenta_bancaria;
/*
 * Crea instancias de CajaAhorro y CuentaCorriente.
 * Realiza depósitos y extracciones.
 * Controla casos de saldo insuficiente.
 */
public class TestCuenta {
    public static void main(String[] args) {
        CajaAhorro cuenta1 = new CajaAhorro("1001", "Juan Perez", 5000);
        CuentaCorriente cuenta2 = new CuentaCorriente("2001", "Maria Lopez", 2000, 1000, "20-12345678-9", "Calle Falsa 123", "maria@email.com");

        System.out.println(cuenta1);
        cuenta1.depositar(1500);
        cuenta1.extraer(4000);
        cuenta1.extraer(5000);  // No debe permitir extracción
        System.out.println(cuenta1);

        System.out.println("\n" + cuenta2);
        cuenta2.depositar(1000);
        cuenta2.extraer(3500);  // Permitido hasta -1000
        cuenta2.extraer(1000);  // No debe permitir extracción
        System.out.println(cuenta2);
    }
}
