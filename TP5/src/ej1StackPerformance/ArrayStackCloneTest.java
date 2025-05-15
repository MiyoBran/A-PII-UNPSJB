package ej1StackPerformance; // Mismo paquete que ArrayStack

// Importaciones de JUnit 5
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*; // Para aserciones como assertEquals, assertNotSame, etc.

// Asumo que tienes una interfaz Stack o que ArrayStack tiene estos métodos públicos
// Si no, ajusta según tu implementación de ArrayStack
// interface Stack<E> { void push(E e); E pop(); E top(); int size(); boolean isEmpty(); }


public class ArrayStackCloneTest {

    private ArrayStack<String> originalStack;
    private ArrayStack<String> emptyStack;

    @BeforeEach
    void setUp() {
        // Se ejecuta antes de cada método @Test
        originalStack = new ArrayStack<>(5); // Capacidad inicial de 5 para pruebas
        originalStack.push("A");
        originalStack.push("B");
        originalStack.push("C");

        emptyStack = new ArrayStack<>(5);
    }

    // Aquí irán los métodos de prueba (@Test)
    @Test
    @DisplayName("El clon no debe ser nulo y debe ser una instancia diferente")
    void testCloneIsNotNullAndDifferentInstance() {
        ArrayStack<String> clonedStack = originalStack.clone();
        assertNotNull(clonedStack, "El clon no debería ser nulo.");
        assertNotSame(originalStack, clonedStack, "El original y el clon deberían ser instancias diferentes en memoria.");
    }

    @Test
    @DisplayName("El clon de una pila no vacía debe tener el mismo tamaño y tope que el original")
    void testCloneHasSameSizeAndTopAsOriginal() {
        ArrayStack<String> clonedStack = originalStack.clone();
        assertEquals(originalStack.size(), clonedStack.size(), "El tamaño del clon debe ser igual al del original.");
        assertEquals(originalStack.top(), clonedStack.top(), "El elemento tope del clon debe ser igual al del original.");
    }

    @Test
    @DisplayName("El clon de una pila vacía debe estar vacío")
    void testCloneIsEmptyForEmptyOriginal() {
        ArrayStack<String> clonedEmptyStack = emptyStack.clone();
        assertNotNull(clonedEmptyStack, "El clon de una pila vacía no debería ser nulo.");
        assertTrue(clonedEmptyStack.isEmpty(), "El clon de una pila vacía debería estar vacío.");
        assertEquals(0, clonedEmptyStack.size(), "El tamaño del clon de una pila vacía debería ser 0.");
    }

    @Test
    @DisplayName("Modificar la pila clonada no debe afectar a la original")
    void testModifyingClonedStackDoesNotAffectOriginal() {
        ArrayStack<String> clonedStack = originalStack.clone();

        // Guardar estado original para comparación
        int originalSizeBeforeMod = originalStack.size();
        String originalTopBeforeMod = originalStack.top();

        // Modificar el clon
        clonedStack.pop();              // Quita "C" del clon
        clonedStack.push("D");          // Añade "D" al clon. Clon: [A, B, D]

        // Verificar que el original no cambió
        assertEquals(originalSizeBeforeMod, originalStack.size(), "El tamaño del original no debe cambiar después de modificar el clon.");
        assertEquals(originalTopBeforeMod, originalStack.top(), "El tope del original no debe cambiar después de modificar el clon.");
        assertNotEquals(clonedStack.top(), originalStack.top(), "El tope del clon modificado debe ser diferente al del original.");
    }

    @Test
    @DisplayName("Modificar la pila original no debe afectar a la clonada")
    void testModifyingOriginalStackDoesNotAffectCloned() {
        ArrayStack<String> clonedStack = originalStack.clone();

        // Guardar estado del clon para comparación
        int clonedSizeBeforeMod = clonedStack.size();
        String clonedTopBeforeMod = clonedStack.top();

        // Modificar el original
        originalStack.pop();            // Quita "C" del original
        originalStack.push("X");        // Añade "X" al original. Original: [A, B, X]

        // Verificar que el clon no cambió
        assertEquals(clonedSizeBeforeMod, clonedStack.size(), "El tamaño del clon no debe cambiar después de modificar el original.");
        assertEquals(clonedTopBeforeMod, clonedStack.top(), "El tope del clon no debe cambiar después de modificar el original.");
        assertNotEquals(originalStack.top(), clonedStack.top(), "El tope del original modificado debe ser diferente al del clon.");
    }

    @Test
    @DisplayName("Clonar una pila vacía, luego hacer push en el clon")
    void testCloneOfEmptyStackThenPushOnCloned() {
        ArrayStack<String> clonedEmptyStack = emptyStack.clone();
        clonedEmptyStack.push("Z");

        assertTrue(emptyStack.isEmpty(), "La pila original vacía debe permanecer vacía.");
        assertEquals(0, emptyStack.size(), "El tamaño de la pila original vacía debe ser 0.");

        assertFalse(clonedEmptyStack.isEmpty(), "El clon no debe estar vacío después de un push.");
        assertEquals(1, clonedEmptyStack.size(), "El tamaño del clon debe ser 1 después de un push.");
        assertEquals("Z", clonedEmptyStack.top(), "El tope del clon debe ser 'Z'.");
    }

    @Test
    @DisplayName("Clonar pila con un solo elemento y verificar independencia")
    void testCloneOfSingleElementStack() {
        ArrayStack<String> singleItemStack = new ArrayStack<>(3);
        singleItemStack.push("Single");

        ArrayStack<String> clonedSingleItemStack = singleItemStack.clone();

        assertNotSame(singleItemStack, clonedSingleItemStack);
        assertEquals(1, clonedSingleItemStack.size());
        assertEquals("Single", clonedSingleItemStack.top());

        // Modificar original
        singleItemStack.pop();
        assertTrue(singleItemStack.isEmpty());

        // Clon no debe haber cambiado
        assertEquals(1, clonedSingleItemStack.size(), "El clon no debe cambiar cuando el original con un elemento se vacía.");
        assertEquals("Single", clonedSingleItemStack.top(), "El tope del clon no debe cambiar.");

        // Modificar clon
        clonedSingleItemStack.push("Another");
        singleItemStack.push("OriginalAgain"); // Restaura el original para otra comprobación

        assertEquals("Another", clonedSingleItemStack.top(), "El tope del clon modificado debe ser correcto.");
        assertEquals(2, clonedSingleItemStack.size());
        assertEquals("OriginalAgain", singleItemStack.top(), "El tope del original restaurado debe ser correcto.");
    }

//    @Test
//    @DisplayName("El clon debe tener su propia capacidad (implícito por independencia)")
//    void testCloneHasIndependentCapacity() {
//        // Esta prueba es más relevante si ArrayStack redimensiona.
//        // Aquí, se asume una capacidad fija inicial para simplificar,
//        // pero la independencia de 'data' array es clave.
//        ArrayStack<Integer> stack1 = new ArrayStack<>(1); // Capacidad de 1
//        stack1.push(10);
//
//        ArrayStack<Integer> stack2 = stack1.clone();
//
//        // Si intento hacer push en stack1, debería fallar si la capacidad es fija y no hay redimensionamiento.
//        // Si redimensiona, la prueba de independencia de 'data' es lo que se valida.
//        assertThrows(IllegalStateException.class, () -> {
//            stack1.push(20); // Asumiendo que esto causa un error si la capacidad es 1 y está lleno
//        }, "Empujar a una pila original llena (capacidad fija) debería causar una excepción.");
//
//        // El clon no debería verse afectado y debería poder hacer pop.
//        assertEquals(Integer.valueOf(10), stack2.pop(), "El clon debería poder desapilar su elemento.");
//        assertTrue(stack2.isEmpty(), "El clon debería estar vacío después del pop.");
//    }
}