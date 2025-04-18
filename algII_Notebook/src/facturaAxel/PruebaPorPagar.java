package facturaAxel;
import java.util.*;
// Clase Principal
public class PruebaPorPagar {
    public static void main(String[] args) {
        List<PorPagar> cuentasPorPagar = new ArrayList<>();

        // Crear empleados
        Empleado emp1 = new Empleado("Juan Pérez", 1500.0);
        Empleado emp2 = new Empleado("María Gómez", 1800.0);
        cuentasPorPagar.add(emp1);
        cuentasPorPagar.add(emp2);

        // Crear facturas
        Factura factura1 = new Factura("Proveedor A", "F001", "2025-03-30");
        factura1.agregarItem("Laptop", 1200.0, 1);
        factura1.agregarItem("Mouse", 25.0, 2);
        cuentasPorPagar.add(factura1);

        Factura factura2 = new Factura("Proveedor B", "F002", "2025-03-30");
        factura2.agregarItem("Monitor", 300.0, 2);
        factura2.agregarItem("Teclado", 50.0, 1);
        cuentasPorPagar.add(factura2);

        // Calcular e imprimir importes a pagar
        for (PorPagar cuenta : cuentasPorPagar) {
            System.out.println(cuenta);
        }
    }
}