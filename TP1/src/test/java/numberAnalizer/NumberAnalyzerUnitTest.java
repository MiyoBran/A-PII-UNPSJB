package numberAnalizer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para la clase {@link NumberAnalyzer}.
 * Verifica el comportamiento del constructor, la adición de números,
 * y la obtención de los números menor, mayor, la cuenta y la representación en String.
 *
 * @see NumberAnalyzer
 * @author MiyoBran // O tu nombre de autor preferido para las pruebas
 * @version 1.0
 */
public class NumberAnalyzerUnitTest { // Cambiado a public para seguir la convención general

    private NumberAnalyzer analyzer;

    /**
     * Configura un nuevo objeto NumberAnalyzer antes de cada prueba
     * para asegurar que cada prueba se ejecute con un estado limpio.
     */
    @BeforeEach
    public void setUp() {
        analyzer = new NumberAnalyzer();
    }

    /**
     * Prueba el estado inicial del {@link NumberAnalyzer} después de la construcción.
     * Verifica que el contador sea cero y que los métodos getter para menor/mayor
     * lancen una excepción apropiada. También prueba el método toString en estado inicial.
     */
    @Test
    @DisplayName("Estado inicial después de la construcción")
    public void testNumberAnalyzer_initialState() {
        assertEquals(0, analyzer.getCount(), "El contador inicial debería ser 0.");
        
        assertThrows(IllegalStateException.class, () -> {
            analyzer.getSmallest();
        }, "getSmallest debería lanzar IllegalStateException si no hay números.");
        
        assertThrows(IllegalStateException.class, () -> {
            analyzer.getLargest();
        }, "getLargest debería lanzar IllegalStateException si no hay números.");

        assertEquals("No numbers have been added yet.", analyzer.toString(), 
                     "toString() en estado inicial debería devolver el mensaje correcto.");
    }

    /**
     * Prueba exhaustiva del método {@link NumberAnalyzer#addNumber(int)} y cómo
     * afecta a los valores de menor, mayor y contador.
     * Cubre escenarios como añadir un solo número, múltiples números en diferentes órdenes,
     * números negativos y positivos, y duplicados.
     */
    @Test
    @DisplayName("Adición de números y su efecto en menor, mayor y contador")
    public void testAddNumber_variousScenarios() {
        // 1. Añadir un solo número
        analyzer.addNumber(10);
        assertEquals(10, analyzer.getSmallest(), "Menor después de un solo número (10).");
        assertEquals(10, analyzer.getLargest(), "Mayor después de un solo número (10).");
        assertEquals(1, analyzer.getCount(), "Contador después de un solo número.");

        // Reiniciar para la siguiente sub-prueba (o usar instancias separadas por prueba)
        analyzer = new NumberAnalyzer(); 

        // 2. Añadir múltiples números positivos en orden ascendente
        analyzer.addNumber(5);
        analyzer.addNumber(10);
        analyzer.addNumber(15);
        assertEquals(5, analyzer.getSmallest(), "Menor con números ascendentes (5, 10, 15).");
        assertEquals(15, analyzer.getLargest(), "Mayor con números ascendentes (5, 10, 15).");
        assertEquals(3, analyzer.getCount(), "Contador con números ascendentes.");

        analyzer = new NumberAnalyzer();
        // 3. Añadir múltiples números positivos en orden descendente
        analyzer.addNumber(15);
        analyzer.addNumber(10);
        analyzer.addNumber(5);
        assertEquals(5, analyzer.getSmallest(), "Menor con números descendentes (15, 10, 5).");
        assertEquals(15, analyzer.getLargest(), "Mayor con números descendentes (15, 10, 5).");
        assertEquals(3, analyzer.getCount(), "Contador con números descendentes.");
        
        analyzer = new NumberAnalyzer();
        // 4. Añadir números negativos
        analyzer.addNumber(-5);
        analyzer.addNumber(-10);
        analyzer.addNumber(-1);
        assertEquals(-10, analyzer.getSmallest(), "Menor con números negativos (-5, -10, -1).");
        assertEquals(-1, analyzer.getLargest(), "Mayor con números negativos (-5, -10, -1).");
        assertEquals(3, analyzer.getCount(), "Contador con números negativos.");

        analyzer = new NumberAnalyzer();
        // 5. Añadir mezcla de positivos, negativos y cero
        analyzer.addNumber(10);
        analyzer.addNumber(-5);
        analyzer.addNumber(0);
        analyzer.addNumber(20);
        analyzer.addNumber(-1);
        assertEquals(-5, analyzer.getSmallest(), "Menor con mezcla de números (10, -5, 0, 20, -1).");
        assertEquals(20, analyzer.getLargest(), "Mayor con mezcla de números (10, -5, 0, 20, -1).");
        assertEquals(5, analyzer.getCount(), "Contador con mezcla de números.");
        
        analyzer = new NumberAnalyzer();
        // 6. Añadir números duplicados
        analyzer.addNumber(5);
        analyzer.addNumber(10);
        analyzer.addNumber(5); // duplicado
        assertEquals(5, analyzer.getSmallest(), "Menor con duplicados (5, 10, 5).");
        assertEquals(10, analyzer.getLargest(), "Mayor con duplicados (5, 10, 5).");
        assertEquals(3, analyzer.getCount(), "Contador con duplicados.");
    }

    /**
     * Prueba específica del método {@link NumberAnalyzer#getSmallest()} después de añadir números.
     * También verifica que lance una excepción si no se han añadido números.
     */
    @Test
    @DisplayName("Obtención del menor número")
    public void testGetSmallest() {
        // Caso: Sin números añadidos (debería lanzar excepción)
        assertThrows(IllegalStateException.class, () -> {
            analyzer.getSmallest();
        }, "getSmallest debería lanzar excepción si no hay números.");

        // Caso: Después de añadir números
        analyzer.addNumber(100);
        analyzer.addNumber(50);
        analyzer.addNumber(75);
        assertEquals(50, analyzer.getSmallest(), "getSmallest debería devolver 50.");
    }

    /**
     * Prueba específica del método {@link NumberAnalyzer#getLargest()} después de añadir números.
     * También verifica que lance una excepción si no se han añadido números.
     */
    @Test
    @DisplayName("Obtención del mayor número")
    public void testGetLargest() {
        // Caso: Sin números añadidos (debería lanzar excepción)
        assertThrows(IllegalStateException.class, () -> {
            analyzer.getLargest();
        }, "getLargest debería lanzar excepción si no hay números.");

        // Caso: Después de añadir números
        analyzer.addNumber(-10);
        analyzer.addNumber(-50);
        analyzer.addNumber(-5);
        assertEquals(-5, analyzer.getLargest(), "getLargest debería devolver -5.");
    }

    /**
     * Prueba el método {@link NumberAnalyzer#getCount()}.
     * Verifica el contador en estado inicial y después de añadir varios números.
     */
    @Test
    @DisplayName("Obtención del contador de números")
    public void testGetCount() {
        assertEquals(0, analyzer.getCount(), "Contador inicial es 0.");
        
        analyzer.addNumber(1);
        assertEquals(1, analyzer.getCount(), "Contador después de 1 número.");

        analyzer.addNumber(2);
        analyzer.addNumber(3);
        assertEquals(3, analyzer.getCount(), "Contador después de 3 números.");
    }

    /**
     * Prueba el método {@link NumberAnalyzer#toString()}.
     * Verifica la representación en String en estado inicial y después de añadir números.
     */
    @Test
    @DisplayName("Representación en String del analizador")
    public void testToString() {
        // Caso: Sin números añadidos
        assertEquals("No numbers have been added yet.", analyzer.toString(),
                     "toString() cuando no hay números.");

        // Caso: Después de añadir números
        analyzer.addNumber(10);
        analyzer.addNumber(2);
        analyzer.addNumber(25); // Smallest: 2, Largest: 25, Count: 3
        String expected = String.format("Smallest: %d, Largest: %d, Numbers added: %d", 2, 25, 3);
        assertEquals(expected, analyzer.toString(), "toString() después de añadir números.");
    }
    
    /**
     * Probar con Integer.MAX_VALUE y Integer.MIN_VALUE
     */
    @Test
    @DisplayName("Adición de Integer.MAX_VALUE y Integer.MIN_VALUE")
    public void testAddNumber_integerExtremes() {
        analyzer.addNumber(100);
        analyzer.addNumber(Integer.MAX_VALUE);
        analyzer.addNumber(0);
        analyzer.addNumber(Integer.MIN_VALUE);
        analyzer.addNumber(-200);

        assertEquals(Integer.MIN_VALUE, analyzer.getSmallest(), "Menor debería ser Integer.MIN_VALUE.");
        assertEquals(Integer.MAX_VALUE, analyzer.getLargest(), "Mayor debería ser Integer.MAX_VALUE.");
        assertEquals(5, analyzer.getCount());
    }
    
    /**
     * Probar que añadir el mismo número múltiples veces no cambia el menor/mayor (solo el contador)
     */
    @Test
    @DisplayName("Adición repetida del mismo número")
    public void testAddNumber_repeatedSameNumber() {
        analyzer.addNumber(7);
        analyzer.addNumber(7);
        analyzer.addNumber(7);

        assertEquals(7, analyzer.getSmallest());
        assertEquals(7, analyzer.getLargest());
        assertEquals(3, analyzer.getCount());
    }
    
    @Test
    @DisplayName("Comenzar con Integer.MAX_VALUE y luego añadir uno menor")
    public void testAddNumber_startWithMaxThenSmaller() {
        analyzer.addNumber(Integer.MAX_VALUE);
        analyzer.addNumber(100);
        assertEquals(100, analyzer.getSmallest());
        assertEquals(Integer.MAX_VALUE, analyzer.getLargest());
    }

    /**
     * Probar comenzando con los valores extremos
     */
    @Test
    @DisplayName("Comenzar con Integer.MIN_VALUE y luego añadir uno mayor")
    public void testAddNumber_startWithMinThenLarger() {
        analyzer.addNumber(Integer.MIN_VALUE);
        analyzer.addNumber(-100);
        assertEquals(Integer.MIN_VALUE, analyzer.getSmallest());
        assertEquals(-100, analyzer.getLargest());
    }
}