package ej07PorPagarQueue; // Asegúrate que todas tus clases estén en este paquete

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ProcesadorPagosConArrayQueueTest {

    private ArrayQueue<PorPagar> colaDePagos;
    private Empleado emp1, emp2, emp3, emp4;
    private Factura factura1;

    // Capacidad fija para la cola en estas pruebas
    private static final int CAPACIDAD_COLA = 5;

    @BeforeEach
    void setUp() {
        // Inicializar la cola con capacidad fija para cada prueba
        colaDePagos = new ArrayQueue<>(CAPACIDAD_COLA);

        // Crear empleados usando el constructor real
        emp1 = new Empleado(1010, "Carlos", null, 45, 30.0); // 45*30 = 1350.0
        Empleado supervisorCarlos = emp1; // Para claridad
        emp2 = new Empleado(2020, "Lucia", supervisorCarlos, 38, 28.0); // 38*28 = 1064.0
        emp3 = new Empleado(3030, "Pedro", supervisorCarlos, 40, 32.0); // 40*32 = 1280.0
        Empleado supervisorLucia = emp2;
        emp4 = new Empleado(4040, "Mariana", supervisorLucia, 42, 27.0); // 42*27 = 1134.0


        // Crear factura y agregar ítems
        factura1 = new Factura("Insumos Industriales SA", 33333, "2021-07-15");
        factura1.agregarItem("Tornillos", 50, 0.25);    // 12.5
        factura1.agregarItem("Clavos", 100, 0.1);       // 10.0
        factura1.agregarItem("Martillos", 10, 15.0);    // 150.0
        // Total Parcial: 12.5 + 10 + 150 = 172.5
    }

    @Test
    @DisplayName("La cola debe estar vacía al inicio")
    void testQueueIsEmptyInitially() {
        assertTrue(colaDePagos.isEmpty(), "La cola debería estar vacía al crearse.");
        assertEquals(0, colaDePagos.size(), "El tamaño de la cola vacía debería ser 0.");
    }

    @Test
    @DisplayName("Enqueue de elementos PorPagar y verificar tamaño")
    void testEnqueueElementsAndCheckSize() {
        colaDePagos.enqueue(emp1);
        assertEquals(1, colaDePagos.size());
        assertFalse(colaDePagos.isEmpty());

        colaDePagos.enqueue(factura1);
        assertEquals(2, colaDePagos.size());
    }

    @Test
    @DisplayName("First debe devolver el primer elemento sin removerlo")
    void testFirstElement() {
        assertNull(colaDePagos.first(), "First en cola vacía debe ser null.");

        colaDePagos.enqueue(emp1);
        colaDePagos.enqueue(factura1);

        // Comparamos la instancia ya que first() debe devolver el mismo objeto
        assertSame(emp1, colaDePagos.first(), "First debe devolver el primer elemento encolado (emp1).");
        assertEquals(2, colaDePagos.size(), "El tamaño no debe cambiar después de llamar a first().");
        assertSame(emp1, colaDePagos.first(), "Llamar a first() de nuevo debe devolver el mismo elemento.");
    }

    @Test
    @DisplayName("Dequeue debe remover y devolver elementos en orden FIFO")
    void testDequeueOrderAndContent() {
        colaDePagos.enqueue(emp1);       // Pago: 1350.0
        colaDePagos.enqueue(factura1);   // Pago: 172.5 (con los ítems de setUp)
        colaDePagos.enqueue(emp2);       // Pago: 1064.0

        assertEquals(3, colaDePagos.size());

        PorPagar p1 = colaDePagos.dequeue();
        assertNotNull(p1);
        assertSame(emp1, p1, "Primer elemento desencolado debe ser la instancia de emp1.");
        assertEquals(1350.0, p1.obtenerPago(), 0.001, "Monto de emp1 incorrecto.");

        PorPagar p2 = colaDePagos.dequeue();
        assertNotNull(p2);
        assertSame(factura1, p2, "Segundo elemento desencolado debe ser la instancia de factura1.");
        assertEquals(172.5, p2.obtenerPago(), 0.001, "Monto de factura1 incorrecto.");

        PorPagar p3 = colaDePagos.dequeue();
        assertNotNull(p3);
        assertSame(emp2, p3, "Tercer elemento desencolado debe ser la instancia de emp2.");
        assertEquals(1064.0, p3.obtenerPago(), 0.001, "Monto de emp2 incorrecto.");

        assertTrue(colaDePagos.isEmpty(), "La cola debería estar vacía después de desencoar todo.");
        assertNull(colaDePagos.dequeue(), "Dequeue de cola vacía debe ser null.");
    }

    @Test
    @DisplayName("Procesar todos los pagos de la cola (simula TestFactura)")
    void testProcessAllPayments() {
        // Usaremos la capacidad total de la cola para esta prueba
        PorPagar[] itemsAEncolar = {emp1, emp2, factura1, emp3, emp4}; // 5 elementos
        
        for (PorPagar item : itemsAEncolar) {
            colaDePagos.enqueue(item);
        }
        assertEquals(CAPACIDAD_COLA, colaDePagos.size(), "La cola debería estar llena a su capacidad.");

        System.out.println("\nListado de Pagos (desde JUnit con ArrayQueue - Capacidad Fija):");
        int count = 0;
        List<PorPagar> itemsProcesados = new ArrayList<>();
        while (!colaDePagos.isEmpty()) {
            PorPagar p = colaDePagos.dequeue();
            assertNotNull(p);
            itemsProcesados.add(p);
            System.out.println(p.toString()); // Imprime para visualización, similar a TestFactura
            count++;
        }
        assertEquals(itemsAEncolar.length, count, "Se deben haber procesado todos los items encolados.");
        assertTrue(colaDePagos.isEmpty(), "La cola debe estar vacía al final del procesamiento.");

        // Verificar que los items se procesaron en el orden correcto (FIFO)
        // Usamos assertSame para cada elemento porque no hemos implementado equals en Empleado/Factura
        for(int i=0; i < itemsAEncolar.length; i++){
            assertSame(itemsAEncolar[i], itemsProcesados.get(i), "Elemento en la posición " + i + " no coincide con el orden esperado.");
        }
    }

    @Test
    @DisplayName("Enqueue en una cola llena debe lanzar IllegalStateException")
    void testEnqueueOnFullQueueThrowsException() {
        // Llenar la cola hasta su capacidad (CAPACIDAD_COLA = 5)
        colaDePagos.enqueue(emp1);
        colaDePagos.enqueue(emp2);
        colaDePagos.enqueue(factura1);
        colaDePagos.enqueue(emp3);
        colaDePagos.enqueue(emp4);

        assertEquals(CAPACIDAD_COLA, colaDePagos.size(), "La cola debería estar llena.");
        assertFalse(colaDePagos.isEmpty());

        // Intentar encolar un elemento más debería lanzar la excepción
        Empleado empExtra = new Empleado(5050, "Extra", null, 50, 10.0);
        final ArrayQueue<PorPagar> finalCola = colaDePagos; // Necesario para lambda
        
        IllegalStateException thrownException = assertThrows(IllegalStateException.class, () -> {
            finalCola.enqueue(empExtra);
        }, "Se esperaba IllegalStateException al encolar en una cola llena.");
        
        // Opcional: verificar el mensaje de la excepción si es relevante
        assertEquals("Queue is full", thrownException.getMessage(), "El mensaje de la excepción no es el esperado.");
        
        // Verificar que la cola no cambió su tamaño ni su contenido después del intento fallido
        assertEquals(CAPACIDAD_COLA, colaDePagos.size(), "El tamaño de la cola no debería cambiar después del enqueue fallido.");
        assertSame(emp1, colaDePagos.first(), "El primer elemento no debería cambiar después del enqueue fallido.");
    }

    @Test
    @DisplayName("Dequeue de cola vacía devuelve null")
    void testDequeueFromEmptyQueue() {
        assertTrue(colaDePagos.isEmpty());
        assertNull(colaDePagos.dequeue());
    }

    @Test
    @DisplayName("First en cola vacía devuelve null")
    void testFirstOnEmptyQueue() {
        assertTrue(colaDePagos.isEmpty());
        assertNull(colaDePagos.first());
    }
}