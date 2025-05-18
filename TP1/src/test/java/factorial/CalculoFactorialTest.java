package factorial;

import static org.junit.jupiter.api.Assertions.*; // Para assertEquals, assertThrows
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para la clase {@link CalculoFactorial}.
 * Verifica el método {@link CalculoFactorial#calcular(int)} para diferentes escenarios,
 * incluyendo casos base, números positivos y manejo de entradas negativas.
 *
 * @see CalculoFactorial
 * @author MiyoBran // O tu nombre de autor preferido para las pruebas
 * @version 1.0
 */
public class CalculoFactorialTest {

    /**
     * Prueba {@link CalculoFactorial#calcular(int)} para el caso base del factorial de 0.
     * Se espera que el factorial de 0 sea 1.
     */
    @Test
    @DisplayName("Factorial de 0 debe ser 1")
    public void testCalcular_factorialDeCero() {
        assertEquals(1L, CalculoFactorial.calcular(0), "El factorial de 0 debería ser 1");
    }

    /**
     * Prueba {@link CalculoFactorial#calcular(int)} para el factorial de 1.
     * Se espera que el factorial de 1 sea 1.
     */
    @Test
    @DisplayName("Factorial de 1 debe ser 1")
    public void testCalcular_factorialDeUno() {
        assertEquals(1L, CalculoFactorial.calcular(1), "El factorial de 1 debería ser 1");
    }

    /**
     * Prueba {@link CalculoFactorial#calcular(int)} para números positivos pequeños.
     */
    @Test
    @DisplayName("Factorial de números positivos pequeños (2, 3, 5)")
    public void testCalcular_factorialesPositivosPequeños() {
        assertEquals(2L, CalculoFactorial.calcular(2), "Factorial de 2");
        assertEquals(6L, CalculoFactorial.calcular(3), "Factorial de 3");
        assertEquals(120L, CalculoFactorial.calcular(5), "Factorial de 5");
    }

    /**
     * Prueba {@link CalculoFactorial#calcular(int)} para un número positivo más grande.
     * Se utiliza 10! como ejemplo para verificar el tipo long.
     */
    @Test
    @DisplayName("Factorial de un número positivo más grande (10)")
    public void testCalcular_factorialPositivoMayor() {
        // 10! = 3,628,800
        assertEquals(3628800L, CalculoFactorial.calcular(10), "Factorial de 10");
    }
    
    /**
     * Prueba {@link CalculoFactorial#calcular(int)} para un número cercano al límite de long.
     * El factorial de 20 es el más grande que cabe en un long.
     * 20! = 2,432,902,008,176,640,000
     */
    @Test
    @DisplayName("Factorial de 20 (cercano al límite de long)")
    public void testCalcular_factorialDeVeinte() {
        assertEquals(2432902008176640000L, CalculoFactorial.calcular(20), "Factorial de 20");
    }


    /**
     * Prueba {@link CalculoFactorial#calcular(int)} cuando la entrada es un número negativo.
     * Se espera que se lance una {@link IllegalArgumentException}.
     */
    @Test
    @DisplayName("Factorial de número negativo lanza IllegalArgumentException")
    public void testCalcular_entradaNegativaLanzaExcepcion() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculoFactorial.calcular(-1);
        }, "Se esperaba IllegalArgumentException para n = -1");

        // Verificar el mensaje de la excepción
        assertEquals("No se puede realizar el factorial a numeros negativos!", exception.getMessage(),
                     "Mensaje de excepción incorrecto para n = -1");

        // Probar con otro número negativo
        exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculoFactorial.calcular(-5);
        }, "Se esperaba IllegalArgumentException para n = -5");
        
        assertEquals("No se puede realizar el factorial a numeros negativos!", exception.getMessage(),
                     "Mensaje de excepción incorrecto para n = -5");
    }
}