package ej01StackPerformance; // Mismo paquete que LinkedStack

// Importaciones de JUnit 5
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*; // Para aserciones

// Asumo que tu LinkedStack implementa la interfaz Stack<E> que definimos o una similar.
// Si no, las referencias a los métodos (push, pop, top, etc.) deberían seguir funcionando
// si son públicos en LinkedStack.

public class LinkedStackCloneTest {

    private LinkedStack<String> originalStack;
    private LinkedStack<String> emptyStack;

    @BeforeEach
    void setUp() {
        // Este método se ejecuta antes de cada método @Test
        // Configura una pila con algunos elementos para las pruebas
        originalStack = new LinkedStack<>();
        originalStack.push("Java");
        originalStack.push("Python");
        originalStack.push("JavaScript"); // Tope actual: JavaScript

        // Configura una pila vacía para las pruebas
        emptyStack = new LinkedStack<>();
    }

    @Test
    @DisplayName("El clon no debe ser nulo y debe ser una instancia diferente")
    void testCloneIsNotNullAndDifferentInstance() {
        LinkedStack<String> clonedStack = originalStack.clone();
        assertNotNull(clonedStack, "El clon no debería ser nulo.");
        assertNotSame(originalStack, clonedStack, "El original y el clon deberían ser instancias diferentes en memoria.");
        // También es bueno verificar que la lista interna es una instancia diferente
        // Esto requiere acceso a la lista o inferirlo a través del comportamiento.
        // Si this.list.clone() funciona bien, esta prueba de comportamiento lo cubrirá.
    }

    @Test
    @DisplayName("El clon de una pila no vacía debe tener el mismo tamaño y tope que el original")
    void testCloneHasSameSizeAndTopAsOriginal() {
        LinkedStack<String> clonedStack = originalStack.clone();
        assertEquals(originalStack.size(), clonedStack.size(), "El tamaño del clon debe ser igual al del original.");
        assertEquals(originalStack.top(), clonedStack.top(), "El elemento tope del clon debe ser igual al del original.");
    }

    @Test
    @DisplayName("El clon de una pila vacía debe estar vacío")
    void testCloneIsEmptyForEmptyOriginal() {
        LinkedStack<String> clonedEmptyStack = emptyStack.clone();
        assertNotNull(clonedEmptyStack, "El clon de una pila vacía no debería ser nulo.");
        assertTrue(clonedEmptyStack.isEmpty(), "El clon de una pila vacía debería estar vacío.");
        assertEquals(0, clonedEmptyStack.size(), "El tamaño del clon de una pila vacía debería ser 0.");
        assertNull(clonedEmptyStack.top(), "El tope del clon de una pila vacía debería ser null.");
    }

    @Test
    @DisplayName("Modificar la pila clonada no debe afectar a la original")
    void testModifyingClonedStackDoesNotAffectOriginal() {
        LinkedStack<String> clonedStack = originalStack.clone();

        // Guardar estado original para comparación
        int originalSizeBeforeMod = originalStack.size();
        String originalTopBeforeMod = originalStack.top();

        // Modificar el clon
        String poppedFromCloned = clonedStack.pop(); // Quita "JavaScript" del clon
        clonedStack.push("C++");                     // Añade "C++" al clon. Clon: [Python, Java, C++] (si push es addFirst)

        assertNotNull(poppedFromCloned);
        assertEquals("JavaScript", poppedFromCloned);

        // Verificar que el original no cambió
        assertEquals(originalSizeBeforeMod, originalStack.size(), "El tamaño del original no debe cambiar después de modificar el clon.");
        assertEquals(originalTopBeforeMod, originalStack.top(), "El tope del original no debe cambiar después de modificar el clon.");
        // El tope de originalStack sigue siendo "JavaScript"
        // El tope de clonedStack es ahora "C++"
        assertNotEquals(clonedStack.top(), originalStack.top(), "El tope del clon modificado debe ser diferente al del original.");
    }

    @Test
    @DisplayName("Modificar la pila original no debe afectar a la clonada")
    void testModifyingOriginalStackDoesNotAffectCloned() {
        LinkedStack<String> clonedStack = originalStack.clone();

        // Guardar estado del clon para comparación
        int clonedSizeBeforeMod = clonedStack.size();
        String clonedTopBeforeMod = clonedStack.top();

        // Modificar el original
        String poppedFromOriginal = originalStack.pop(); // Quita "JavaScript" del original
        originalStack.push("Ruby");                       // Añade "Ruby" al original. Original: [Python, Java, Ruby]

        assertNotNull(poppedFromOriginal);
        assertEquals("JavaScript", poppedFromOriginal);

        // Verificar que el clon no cambió
        assertEquals(clonedSizeBeforeMod, clonedStack.size(), "El tamaño del clon no debe cambiar después de modificar el original.");
        assertEquals(clonedTopBeforeMod, clonedStack.top(), "El tope del clon no debe cambiar después de modificar el original.");
        // El tope de clonedStack sigue siendo "JavaScript"
        // El tope de originalStack es ahora "Ruby"
        assertNotEquals(originalStack.top(), clonedStack.top(), "El tope del original modificado debe ser diferente al del clon.");
    }

    @Test
    @DisplayName("Clonar una pila vacía, luego hacer push en el clon")
    void testCloneOfEmptyStackThenPushOnCloned() {
        LinkedStack<String> clonedEmptyStack = emptyStack.clone();
        clonedEmptyStack.push("NewElement");

        assertTrue(emptyStack.isEmpty(), "La pila original vacía debe permanecer vacía.");
        assertEquals(0, emptyStack.size(), "El tamaño de la pila original vacía debe ser 0.");
        assertNull(emptyStack.top(), "El tope de la pila original vacía debe ser null.");

        assertFalse(clonedEmptyStack.isEmpty(), "El clon no debe estar vacío después de un push.");
        assertEquals(1, clonedEmptyStack.size(), "El tamaño del clon debe ser 1 después de un push.");
        assertEquals("NewElement", clonedEmptyStack.top(), "El tope del clon debe ser 'NewElement'.");
    }

    @Test
    @DisplayName("Clonar pila con un solo elemento y verificar independencia")
    void testCloneOfSingleElementStack() {
        LinkedStack<Character> singleItemStack = new LinkedStack<>();
        singleItemStack.push('X');

        LinkedStack<Character> clonedSingleItemStack = singleItemStack.clone();

        assertNotSame(singleItemStack, clonedSingleItemStack);
        assertEquals(1, clonedSingleItemStack.size());
        assertEquals(Character.valueOf('X'), clonedSingleItemStack.top());

        // Modificar original
        singleItemStack.pop();
        assertTrue(singleItemStack.isEmpty());
        singleItemStack.push('Y'); // Original ahora es [Y]

        // Clon no debe haber cambiado
        assertEquals(1, clonedSingleItemStack.size(), "El clon no debe cambiar cuando el original se modifica.");
        assertEquals(Character.valueOf('X'), clonedSingleItemStack.top(), "El tope del clon no debe cambiar.");

        // Modificar clon
        clonedSingleItemStack.push('Z'); // Clon ahora es [X, Z] (si push es addFirst)
        assertEquals(Character.valueOf('Z'), clonedSingleItemStack.top(), "El tope del clon modificado debe ser correcto.");
        assertEquals(2, clonedSingleItemStack.size());
        // Original sigue siendo [Y]
        assertEquals(Character.valueOf('Y'), singleItemStack.top(), "El tope del original no debe cambiar por la modificación del clon.");
    }
}