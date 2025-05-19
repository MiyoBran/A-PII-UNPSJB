package ej07PorPagarQueue; // Asegúrate que todas tus clases estén en este paquete

import java.util.ArrayList;
import java.util.List;

public class PruebaPorPagarQueue {

    // Capacidad fija para la cola en estas pruebas
    private static final int CAPACIDAD_COLA = 5;

    public static void main(String[] args) {
        System.out.println("=== Iniciando Pruebas para ArrayQueue con PorPagar (sin JUnit) ===");

        // --- Creación de datos de prueba (similar al setUp de JUnit) ---
        Empleado emp1 = new Empleado(1010, "Carlos", null, 45, 30.0); // Pago: 1350.0
        Empleado supervisorCarlos = emp1;
        Empleado emp2 = new Empleado(2020, "Lucia", supervisorCarlos, 38, 28.0); // Pago: 1064.0
        Empleado emp3 = new Empleado(3030, "Pedro", supervisorCarlos, 40, 32.0); // Pago: 1280.0
        Empleado supervisorLucia = emp2;
        Empleado emp4 = new Empleado(4040, "Mariana", supervisorLucia, 42, 27.0); // Pago: 1134.0

        Factura factura1 = new Factura("Insumos Industriales SA", 33333, "2021-07-15");
        factura1.agregarItem("Tornillos", 50, 0.25);    // 12.5
        factura1.agregarItem("Clavos", 100, 0.1);       // 10.0
        factura1.agregarItem("Martillos", 10, 15.0);    // 150.0
        // Total Factura1: 172.5

        // --- INICIO DE BLOQUES DE PRUEBA ---

        // Prueba 1: Cola vacía al inicio
        System.out.println("\n--- PRUEBA 1: Cola vacía al inicio ---");
        ArrayQueue<PorPagar> cola1 = new ArrayQueue<>(CAPACIDAD_COLA);
        if (cola1.isEmpty() && cola1.size() == 0) {
            System.out.println("ÉXITO: La cola está vacía y el tamaño es 0.");
        } else {
            System.out.println("FALLO: La cola no está vacía o el tamaño no es 0. Vacía: " + cola1.isEmpty() + ", Tamaño: " + cola1.size());
        }

        // Prueba 2: Enqueue y Tamaño
        System.out.println("\n--- PRUEBA 2: Enqueue y Tamaño ---");
        ArrayQueue<PorPagar> cola2 = new ArrayQueue<>(CAPACIDAD_COLA);
        cola2.enqueue(emp1);
        if (cola2.size() == 1 && !cola2.isEmpty()) {
            System.out.println("ÉXITO: Enqueue de emp1 y tamaño/vacío correctos.");
        } else {
            System.out.println("FALLO: Enqueue de emp1. Tamaño esperado: 1, Obtenido: " + cola2.size() + ". Vacía esperado: false, Obtenido: " + cola2.isEmpty());
        }
        cola2.enqueue(factura1);
        if (cola2.size() == 2) {
            System.out.println("ÉXITO: Enqueue de factura1 y tamaño correcto.");
        } else {
            System.out.println("FALLO: Enqueue de factura1. Tamaño esperado: 2, Obtenido: " + cola2.size());
        }

        // Prueba 3: Método first()
        System.out.println("\n--- PRUEBA 3: Método first() ---");
        ArrayQueue<PorPagar> cola3 = new ArrayQueue<>(CAPACIDAD_COLA);
        if (cola3.first() == null) {
            System.out.println("ÉXITO: first() en cola vacía devuelve null.");
        } else {
            System.out.println("FALLO: first() en cola vacía. Esperado: null, Obtenido: " + cola3.first());
        }
        cola3.enqueue(emp1);
        cola3.enqueue(factura1);
        if (cola3.first() == emp1 && cola3.size() == 2) {
            System.out.println("ÉXITO: first() devuelve emp1 y el tamaño no cambia.");
        } else {
            System.out.println("FALLO: first() después de encolar. Esperado emp1: " + (cola3.first() == emp1) + ". Tamaño esperado 2: " + (cola3.size() == 2));
        }

        // Prueba 4: Dequeue, orden FIFO y contenido
        System.out.println("\n--- PRUEBA 4: Dequeue, orden FIFO y contenido ---");
        ArrayQueue<PorPagar> cola4 = new ArrayQueue<>(CAPACIDAD_COLA);
        cola4.enqueue(emp1);
        cola4.enqueue(factura1);
        cola4.enqueue(emp2);
        boolean p4_test1 = true, p4_test2 = true, p4_test3 = true, p4_test4 = true, p4_test5 = true;

        PorPagar p1_dq = cola4.dequeue();
        if (p1_dq != emp1 || p1_dq.obtenerPago() != 1350.0) p4_test1 = false;

        PorPagar p2_dq = cola4.dequeue();
        if (p2_dq != factura1 || p2_dq.obtenerPago() != 172.5) p4_test2 = false;
        
        PorPagar p3_dq = cola4.dequeue();
        if (p3_dq != emp2 || p3_dq.obtenerPago() != 1064.0) p4_test3 = false;

        if (!cola4.isEmpty()) p4_test4 = false;
        if (cola4.dequeue() != null) p4_test5 = false; // Dequeue de cola vacía

        if (p4_test1 && p4_test2 && p4_test3 && p4_test4 && p4_test5) {
            System.out.println("ÉXITO: Dequeue funciona en orden FIFO y con contenido correcto.");
        } else {
            System.out.println("FALLO: Dequeue. Detalles:");
            if (!p4_test1) System.out.println("  Error con primer dequeue (emp1).");
            if (!p4_test2) System.out.println("  Error con segundo dequeue (factura1).");
            if (!p4_test3) System.out.println("  Error con tercer dequeue (emp2).");
            if (!p4_test4) System.out.println("  La cola no quedó vacía como se esperaba.");
            if (!p4_test5) System.out.println("  Dequeue de cola vacía no devolvió null.");
        }

        // Prueba 5: Enqueue en cola llena (espera IllegalStateException)
        System.out.println("\n--- PRUEBA 5: Enqueue en cola llena ---");
        ArrayQueue<PorPagar> cola5 = new ArrayQueue<>(CAPACIDAD_COLA); // Capacidad 5
        cola5.enqueue(emp1);
        cola5.enqueue(emp2);
        cola5.enqueue(factura1);
        cola5.enqueue(emp3);
        cola5.enqueue(emp4); // Cola llena

        if (cola5.size() == CAPACIDAD_COLA) {
            System.out.println("INFO: Cola llenada a capacidad " + CAPACIDAD_COLA + " para prueba de excepción.");
        } else {
            System.out.println("ERROR EN PREPARACIÓN DE PRUEBA 5: La cola no se llenó correctamente.");
        }
        
        try {
            Empleado empExtra = new Empleado(5050, "Extra", null, 50, 10.0);
            cola5.enqueue(empExtra);
            // Si llega aquí, la excepción no se lanzó
            System.out.println("FALLO: Se esperaba IllegalStateException al encolar en cola llena, pero no se lanzó.");
        } catch (IllegalStateException e) {
            if ("Queue is full".equals(e.getMessage())) {
                System.out.println("ÉXITO: IllegalStateException lanzada correctamente con mensaje: " + e.getMessage());
            } else {
                System.out.println("FALLO: Se lanzó IllegalStateException, pero con mensaje incorrecto: \"" + e.getMessage() + "\". Se esperaba: \"Queue is full\"");
            }
            // Verificar que la cola no cambió
            if (cola5.size() == CAPACIDAD_COLA && cola5.first() == emp1) {
                 System.out.println("INFO: Estado de la cola después de intento fallido de enqueue es correcto.");
            } else {
                 System.out.println("ERROR EN PRUEBA 5: Estado de la cola incorrecto después de intento fallido de enqueue.");
            }
        } catch (Exception e) {
            System.out.println("FALLO: Se lanzó una excepción inesperada (" + e.getClass().getSimpleName() + ") al encolar en cola llena: " + e.getMessage());
        }


        // Prueba 6: Simular TestFactura original
        System.out.println("\n--- PRUEBA 6: Procesar todos los pagos (simula TestFactura) ---");
        ArrayQueue<PorPagar> cola6 = new ArrayQueue<>(CAPACIDAD_COLA);
        PorPagar[] itemsAEncolar = {emp1, emp2, factura1, emp3, emp4};
        boolean p6_test_encolado = true;
        for (PorPagar item : itemsAEncolar) {
            try {
                cola6.enqueue(item);
            } catch (Exception e) {
                p6_test_encolado = false;
                break;
            }
        }
        if (!p6_test_encolado || cola6.size() != itemsAEncolar.length) {
             System.out.println("FALLO: Error al encolar todos los items para la prueba 6.");
        } else {
            System.out.println("ÉXITO: Todos los items encolados para la prueba 6. Tamaño: " + cola6.size());
            System.out.println("\nListado de Pagos (desde prueba sin JUnit):");
            int count = 0;
            List<PorPagar> itemsProcesados = new ArrayList<>();
            while(!cola6.isEmpty()){
                PorPagar p = cola6.dequeue();
                itemsProcesados.add(p);
                System.out.println(p.toString()); // Imprimir como en el TestFactura original
                count++;
            }
            if (count == itemsAEncolar.length && cola6.isEmpty()) {
                System.out.println("ÉXITO: Todos los items procesados y la cola quedó vacía.");
                // Verificación de orden
                boolean ordenCorrecto = true;
                for(int i=0; i < itemsAEncolar.length; i++){
                    if (itemsAEncolar[i] != itemsProcesados.get(i)) { // Compara referencias
                        ordenCorrecto = false;
                        break;
                    }
                }
                if(ordenCorrecto) {
                    System.out.println("ÉXITO: Items procesados en el orden FIFO esperado.");
                } else {
                    System.out.println("FALLO: Items NO procesados en el orden FIFO esperado.");
                }

            } else {
                System.out.println("FALLO: No se procesaron todos los items o la cola no quedó vacía. Procesados: " + count);
            }
        }

        System.out.println("\n=== Pruebas para ArrayQueue Completadas (sin JUnit) ===");
    }
}