package ej01StackPerformance; // Mismo paquete que DoublyLinkedStack

// Importaciones de JUnit 5
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*; // Para aserciones

public class DoublyLinkedStackCloneTest {

    private DoublyLinkedStack<String> originalStack;
    private DoublyLinkedStack<String> emptyStack;

    @BeforeEach
    void setUp() {
        // Este método se ejecuta antes de cada método @Test
        originalStack = new DoublyLinkedStack<>();
        originalStack.push("Primero"); // Base de la pila
        originalStack.push("Segundo");
        originalStack.push("Tercero"); // Tope actual: Tercero

        emptyStack = new DoublyLinkedStack<>();
    }

    @Test
    @DisplayName("El clon no debe ser nulo y debe ser una instancia diferente")
    void testCloneIsNotNullAndDifferentInstance() {
        DoublyLinkedStack<String> clonedStack = originalStack.clone();
        assertNotNull(clonedStack, "El clon no debería ser nulo.");
        assertNotSame(originalStack, clonedStack, "El original y el clon deberían ser instancias diferentes en memoria.");
        // Implícitamente, esto también prueba que clonedStack.list es una instancia diferente de originalStack.list
        // si las pruebas de modificación posteriores pasan.
    }

    @Test
    @DisplayName("El clon de una pila no vacía debe tener el mismo tamaño y tope que el original")
    void testCloneHasSameSizeAndTopAsOriginal() {
        DoublyLinkedStack<String> clonedStack = originalStack.clone();
        assertEquals(originalStack.size(), clonedStack.size(), "El tamaño del clon debe ser igual al del original.");
        assertEquals(originalStack.top(), clonedStack.top(), "El elemento tope del clon debe ser igual al del original.");
    }

    @Test
    @DisplayName("El clon de una pila vacía debe estar vacío")
    void testCloneIsEmptyForEmptyOriginal() {
        DoublyLinkedStack<String> clonedEmptyStack = emptyStack.clone();
        assertNotNull(clonedEmptyStack, "El clon de una pila vacía no debería ser nulo.");
        assertTrue(clonedEmptyStack.isEmpty(), "El clon de una pila vacía debería estar vacío.");
        assertEquals(0, clonedEmptyStack.size(), "El tamaño del clon de una pila vacía debería ser 0.");
        assertNull(clonedEmptyStack.top(), "El tope del clon de una pila vacía debería ser null.");
    }

    @Test
    @DisplayName("Modificar la pila clonada no debe afectar a la original")
    void testModifyingClonedStackDoesNotAffectOriginal() {
        DoublyLinkedStack<String> clonedStack = originalStack.clone();

        // Guardar estado original para comparación
        int originalSizeBeforeMod = originalStack.size();
        String originalTopBeforeMod = originalStack.top(); // Debería ser "Tercero"

        // Modificar el clon
        String poppedFromCloned = clonedStack.pop(); // Quita "Tercero" del clon
        clonedStack.push("NuevoEnClon");          // Añade "NuevoEnClon" al clon. Clon: [Primero, Segundo, NuevoEnClon]

        assertNotNull(poppedFromCloned);
        assertEquals("Tercero", poppedFromCloned, "El elemento desapilado del clon debe ser 'Tercero'.");

        // Verificar que el original no cambió
        assertEquals(originalSizeBeforeMod, originalStack.size(), "El tamaño del original no debe cambiar después de modificar el clon.");
        assertEquals(originalTopBeforeMod, originalStack.top(), "El tope del original no debe cambiar después de modificar el clon.");
        // El tope de originalStack sigue siendo "Tercero"
        // El tope de clonedStack es ahora "NuevoEnClon"
        assertNotEquals(clonedStack.top(), originalStack.top(), "El tope del clon modificado debe ser diferente al del original.");

        // Verificación adicional: si el clone vació y restauró la original,
        // la original debe ser completamente funcional y tener todos sus elementos en orden.
        assertEquals("Tercero", originalStack.pop());
        assertEquals("Segundo", originalStack.pop());
        assertEquals("Primero", originalStack.pop());
        assertTrue(originalStack.isEmpty());
        // Restaurar la pila original para otras pruebas si es necesario (no aplica aquí porque setUp lo hace)
    }

    @Test
    @DisplayName("Modificar la pila original no debe afectar a la clonada")
    void testModifyingOriginalStackDoesNotAffectCloned() {
        DoublyLinkedStack<String> clonedStack = originalStack.clone();

        // Guardar estado del clon para comparación
        int clonedSizeBeforeMod = clonedStack.size();
        String clonedTopBeforeMod = clonedStack.top(); // Debería ser "Tercero"

        // Modificar el original
        String poppedFromOriginal = originalStack.pop(); // Quita "Tercero" del original
        originalStack.push("NuevoEnOriginal");        // Añade "NuevoEnOriginal" al original. Original: [Primero, Segundo, NuevoEnOriginal]

        assertNotNull(poppedFromOriginal);
        assertEquals("Tercero", poppedFromOriginal, "El elemento desapilado del original debe ser 'Tercero'.");

        // Verificar que el clon no cambió
        assertEquals(clonedSizeBeforeMod, clonedStack.size(), "El tamaño del clon no debe cambiar después de modificar el original.");
        assertEquals(clonedTopBeforeMod, clonedStack.top(), "El tope del clon no debe cambiar después de modificar el original.");
        // El tope de clonedStack sigue siendo "Tercero"
        // El tope de originalStack es ahora "NuevoEnOriginal"
        assertNotEquals(originalStack.top(), clonedStack.top(), "El tope del original modificado debe ser diferente al del clon.");
    }

    @Test
    @DisplayName("Clonar una pila vacía, luego hacer push en el clon")
    void testCloneOfEmptyStackThenPushOnCloned() {
        DoublyLinkedStack<String> clonedEmptyStack = emptyStack.clone();
        clonedEmptyStack.push("ElementoUnico");

        assertTrue(emptyStack.isEmpty(), "La pila original vacía debe permanecer vacía.");
        assertEquals(0, emptyStack.size(), "El tamaño de la pila original vacía debe ser 0.");
        assertNull(emptyStack.top(), "El tope de la pila original vacía debe ser null.");

        assertFalse(clonedEmptyStack.isEmpty(), "El clon no debe estar vacío después de un push.");
        assertEquals(1, clonedEmptyStack.size(), "El tamaño del clon debe ser 1 después de un push.");
        assertEquals("ElementoUnico", clonedEmptyStack.top(), "El tope del clon debe ser 'ElementoUnico'.");
    }

    @Test
    @DisplayName("Clonar pila con un solo elemento y verificar independencia")
    void testCloneOfSingleElementStack() {
        DoublyLinkedStack<Character> singleItemStack = new DoublyLinkedStack<>();
        singleItemStack.push('X'); // Pila: [X]

        DoublyLinkedStack<Character> clonedSingleItemStack = singleItemStack.clone();

        assertNotSame(singleItemStack, clonedSingleItemStack);
        assertEquals(1, clonedSingleItemStack.size());
        assertEquals(Character.valueOf('X'), clonedSingleItemStack.top());

        // Modificar original
        singleItemStack.pop(); // Pila: []
        assertTrue(singleItemStack.isEmpty());
        singleItemStack.push('Y'); // Pila: [Y]

        // Clon no debe haber cambiado por la modificación del original
        assertEquals(1, clonedSingleItemStack.size(), "El clon no debe cambiar cuando el original se modifica.");
        assertEquals(Character.valueOf('X'), clonedSingleItemStack.top(), "El tope del clon no debe cambiar.");

        // Modificar clon
        clonedSingleItemStack.push('Z'); // Clon ahora es [X, Z] (porque push usa addLast)
        assertEquals(Character.valueOf('Z'), clonedSingleItemStack.top(), "El tope del clon modificado debe ser correcto.");
        assertEquals(2, clonedSingleItemStack.size());
        // Original sigue siendo [Y]
        assertEquals(Character.valueOf('Y'), singleItemStack.top(), "El tope del original no debe cambiar por la modificación del clon.");
    }

    @Test
    @DisplayName("Verificar el orden de los elementos en el clon")
    void testElementOrderInClone() {
        // originalStack es [Primero, Segundo, Tercero] (Tercero es el tope)
        DoublyLinkedStack<String> clonedStack = originalStack.clone();

        assertEquals(3, clonedStack.size());
        assertEquals("Tercero", clonedStack.pop());
        assertEquals("Segundo", clonedStack.pop());
        assertEquals("Primero", clonedStack.pop());
        assertTrue(clonedStack.isEmpty(), "El clon debería estar vacío después de desapilar todos sus elementos.");
    }
}