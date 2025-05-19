package ej10DoublyLInkedDeque; // Usando el nombre del paquete que proporcionaste

// Importaciones de JUnit 5
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

// Asumiendo que la interfaz Deque viene de net.datastructures
// import net.datastructures.Deque; // No es necesario si solo pruebas tu implementación

public class DoublyLinkedDequeTest {

    private DoublyLinkedDeque<String> deque; // Usamos tu implementación concreta

    @BeforeEach
    void setUp() {
        // Se ejecuta antes de cada método @Test
        deque = new DoublyLinkedDeque<>();
    }

    @Test
    @DisplayName("Una nueva deque debe estar vacía y tener tamaño cero")
    void testNewDequeIsEmptyAndSizeZero() {
        assertTrue(deque.isEmpty(), "Una nueva deque debería estar vacía.");
        assertEquals(0, deque.size(), "El tamaño de una nueva deque debería ser 0.");
        assertNull(deque.first(), "First() en una deque vacía debería ser null.");
        assertNull(deque.last(), "Last() en una deque vacía debería ser null.");
    }

    @Test
    @DisplayName("addFirst: añadir a una deque vacía")
    void testAddFirstToEmptyDeque() {
        deque.addFirst("A");
        assertFalse(deque.isEmpty());
        assertEquals(1, deque.size());
        assertEquals("A", deque.first(), "First() debería ser 'A'.");
        assertEquals("A", deque.last(), "Last() debería ser 'A'.");
    }

    @Test
    @DisplayName("addFirst: añadir múltiples elementos")
    void testAddFirstMultipleElements() {
        deque.addFirst("A"); // Deque: [A]
        deque.addFirst("B"); // Deque: [B, A]
        deque.addFirst("C"); // Deque: [C, B, A]

        assertEquals(3, deque.size());
        assertEquals("C", deque.first(), "First() debería ser 'C'.");
        assertEquals("A", deque.last(), "Last() debería ser 'A'.");
    }

    @Test
    @DisplayName("addLast: añadir a una deque vacía")
    void testAddLastToEmptyDeque() {
        deque.addLast("A");
        assertFalse(deque.isEmpty());
        assertEquals(1, deque.size());
        assertEquals("A", deque.first(), "First() debería ser 'A'.");
        assertEquals("A", deque.last(), "Last() debería ser 'A'.");
    }

    @Test
    @DisplayName("addLast: añadir múltiples elementos")
    void testAddLastMultipleElements() {
        deque.addLast("A"); // Deque: [A]
        deque.addLast("B"); // Deque: [A, B]
        deque.addLast("C"); // Deque: [A, B, C]

        assertEquals(3, deque.size());
        assertEquals("A", deque.first(), "First() debería ser 'A'.");
        assertEquals("C", deque.last(), "Last() debería ser 'C'.");
    }

    @Test
    @DisplayName("removeFirst: remover de una deque vacía")
    void testRemoveFirstFromEmptyDeque() {
        assertNull(deque.removeFirst(), "removeFirst() en una deque vacía debería ser null.");
        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());
    }

    @Test
    @DisplayName("removeFirst: remover de una deque con un solo elemento")
    void testRemoveFirstFromSingleElementDeque() {
        deque.addFirst("A");
        assertEquals("A", deque.removeFirst());
        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());
    }

    @Test
    @DisplayName("removeFirst: remover de una deque con múltiples elementos")
    void testRemoveFirstFromMultipleElementDeque() {
        deque.addLast("A");
        deque.addLast("B");
        deque.addLast("C"); // Deque: [A, B, C]

        assertEquals("A", deque.removeFirst()); // Deque: [B, C]
        assertEquals(2, deque.size());
        assertEquals("B", deque.first());
        assertEquals("C", deque.last());

        assertEquals("B", deque.removeFirst()); // Deque: [C]
        assertEquals(1, deque.size());
        assertEquals("C", deque.first());
        assertEquals("C", deque.last());
    }

    @Test
    @DisplayName("removeLast: remover de una deque vacía")
    void testRemoveLastFromEmptyDeque() {
        assertNull(deque.removeLast(), "removeLast() en una deque vacía debería ser null.");
        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());
    }

    @Test
    @DisplayName("removeLast: remover de una deque con un solo elemento")
    void testRemoveLastFromSingleElementDeque() {
        deque.addLast("A");
        assertEquals("A", deque.removeLast());
        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());
    }

    @Test
    @DisplayName("removeLast: remover de una deque con múltiples elementos")
    void testRemoveLastFromMultipleElementDeque() {
        deque.addFirst("C");
        deque.addFirst("B");
        deque.addFirst("A"); // Deque: [A, B, C]

        assertEquals("C", deque.removeLast()); // Deque: [A, B]
        assertEquals(2, deque.size());
        assertEquals("A", deque.first());
        assertEquals("B", deque.last());

        assertEquals("B", deque.removeLast()); // Deque: [A]
        assertEquals(1, deque.size());
        assertEquals("A", deque.first());
        assertEquals("A", deque.last());
    }

    @Test
    @DisplayName("Operaciones mixtas para probar robustez y orden")
    void testMixedOperations() {
        // Deque: []
        assertTrue(deque.isEmpty());

        deque.addFirst("B");  // Deque: [B]
        assertEquals("B", deque.first());
        assertEquals("B", deque.last());
        assertEquals(1, deque.size());

        deque.addLast("C");   // Deque: [B, C]
        assertEquals("B", deque.first());
        assertEquals("C", deque.last());
        assertEquals(2, deque.size());

        deque.addFirst("A");  // Deque: [A, B, C]
        assertEquals("A", deque.first());
        assertEquals("C", deque.last());
        assertEquals(3, deque.size());
        assertEquals("(A, B, C)", deque.toString(), "El toString debe reflejar el orden actual. Ajusta si tu DoublyLinkedList.toString() es diferente.");


        assertEquals("A", deque.removeFirst()); // Deque: [B, C]
        assertEquals("B", deque.first());
        assertEquals("C", deque.last());
        assertEquals(2, deque.size());

        assertEquals("C", deque.removeLast());  // Deque: [B]
        assertEquals("B", deque.first());
        assertEquals("B", deque.last());
        assertEquals(1, deque.size());

        deque.addLast("D");   // Deque: [B, D]
        assertEquals("B", deque.first());
        assertEquals("D", deque.last());
        assertEquals(2, deque.size());

        assertEquals("B", deque.removeFirst()); // Deque: [D]
        assertEquals("D", deque.removeFirst()); // Deque: []
        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());
    }

    @Test
    @DisplayName("toString en una deque vacía y con elementos")
    void testToString() {
        assertEquals("()", deque.toString(), "toString de deque vacía. Ajusta si tu DoublyLinkedList.toString() es diferente.");
        deque.addFirst("A");
        deque.addLast("B");
        deque.addFirst("C"); // Deque: C, A, B
        assertEquals("(C, A, B)", deque.toString(), "toString de deque con elementos. Ajusta si tu DoublyLinkedList.toString() es diferente.");
    }
}