package test; // Paquete para las clases de prueba

// Importamos todas las clases del paquete banco y LocalDate
import banco.*;
import java.time.LocalDate;

/**
 * Clase de prueba para el sistema de gestión de activos del banco (Parcial 2025).
 */
public class PruebaBanco {

    public static void main(String[] args) {

        System.out.println("--- Creando Títulos y Clientes ---");
        // --- Creación de Títulos (Ej 3) ---
        Accion a1 = new Accion("ALUA", "Aluar", 750, false);
        Accion a2 = new Accion("YPF", "YPF", 36100, true);
        Bono b1 = new Bono("AL30", "Bono AL 30", 73500, LocalDate.of(2030, 6, 30));
        Bono b2 = new Bono("GD35", "Bono GD 35", 74100, LocalDate.of(2035, 9, 30));

        System.out.println("Títulos creados:");
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(b1);
        System.out.println(b2);

        // --- Creación de Clientes (Ej 3) ---
        Cliente c1 = new Cliente("Juan", "juan@gmail.com");
        Cliente c2 = new Cliente("Ana", "ana@gmail.com");

        System.out.println("\n--- Realizando Compras de Activos ---");
        // --- Compras (Ej 3) ---
        // Usamos un bloque try-catch por si se supera MAX_ACTIVOS_DISTINTOS
        try {
            c1.comprarActivo(a1, 1200); // Juan compra ALUA
            c1.comprarActivo(b1, 12);  // Juan compra AL30

            c2.comprarActivo(a2, 150); // Ana compra YPF
            c2.comprarActivo(b2, 45);  // Ana compra GD35

            c1.comprarActivo(a1, 1500); // Juan compra MÁS ALUA (actualiza cantidad)
            c2.comprarActivo(b2, 35);  // Ana compra MÁS GD35 (actualiza cantidad)

            // Intento de compra que podría fallar si MAX_ACTIVOS_DISTINTOS es bajo (ej. 2)
            // Cliente c3 = new Cliente("Pedro", "pedro@mail.com");
            // c3.comprarActivo(a1, 100);
            // c3.comprarActivo(a2, 100);
            // c3.comprarActivo(b1, 10); // Esta podría lanzar la excepción si MAX_ACTIVOS_DISTINTOS = 2

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("\n*** ERROR al comprar activo: " + e.getMessage() + " ***");
        } catch (IllegalArgumentException e) {
            System.err.println("\n*** ERROR en datos de compra: " + e.getMessage() + " ***");
        }

 
        System.out.println("\n--- Calculando Total Activo por Cliente (Ej 3.1) ---");
        // --- Cálculo Total Activo (Ej 3.1) ---
        System.out.println("Valor total del portafolio de " + c1.getNombre() + ": $" + String.format("%.2f", c1.totalActivo()));
        System.out.println("Valor total del portafolio de " + c2.getNombre() + ": $" + String.format("%.2f", c2.totalActivo()));


        System.out.println("\n--- Calculando Costos Individuales (Ej 3.2) ---");
        // --- Cálculo Costos Individuales (Ej 3.2) ---
        // Colocar en un arreglo los objetos a1, a2, b1 y b2.
        Titulo[] titulos = { a1, a2, b1, b2 };
        int cantidadPrueba = 100; // Cantidad para probar los cálculos

        System.out.println("Calculando costos para una compra simulada de " + cantidadPrueba + " unidades de cada título:");
        // Recorrerlo y llamar a los métodos
        for (Titulo t : titulos) {
            System.out.println("-----------------------------------------");
            System.out.println("Título: " + t.getSimbolo() + " (" + t.getDescripcion() + ")");
            try {
                double comision = t.calcularComision(cantidadPrueba);
                // Llamada polimórfica a calcularImpuesto
                double impuesto = t.calcularImpuesto(cantidadPrueba);
                double precioTotal = t.calcularPrecio(cantidadPrueba);

                System.out.println("  Comisión Banco : $" + String.format("%.2f", comision));
                System.out.println("  Impuesto       : $" + String.format("%.2f", impuesto));
                System.out.println("  Precio Total   : $" + String.format("%.2f", precioTotal));

            } catch (Exception e) {
                // Captura genérica por si algún cálculo interno fallara
                System.err.println("Error calculando costos para " + t.getSimbolo() + ": " + e.getMessage());
            }
        }
        System.out.println("-----------------------------------------");

    } // Fin main
} // Fin clase PruebaBanco