package esMultiplo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para la clase {@link EsMultiplo} Esta clase verifica el
 * correcto funcionamiento de los métodos
 * {@link EsMultiplo#esMultiplo(int, int)} y
 * {@link EsMultiplo#verificarMultiplo(int, int)} , incluyendo el manejo de
 * divisores igual a cero
 * 
 * @see EsMultiplo
 * @author Miyo
 * @version 1.0
 */
class EsMultiploUnitTest {
	 // --- Pruebas para el método esMultiplo(int, int) ---

    /**
     * Prueba {@link EsMultiplo#esMultiplo(int, int)} cuando num1 es múltiplo de num2.
     * Se esperan resultados verdaderos.
     */
    @Test
    @DisplayName("esMultiplo: Casos donde num1 ES múltiplo de num2")
    public void testEsMultiplo_cuandoEsVerdadero() {
        assertTrue(EsMultiplo.esMultiplo(10, 2), "10 debería ser múltiplo de 2");
        assertTrue(EsMultiplo.esMultiplo(9, 3), "9 debería ser múltiplo de 3");
        assertTrue(EsMultiplo.esMultiplo(0, 5), "0 debería ser múltiplo de 5 (0 % 5 == 0)");
        assertTrue(EsMultiplo.esMultiplo(7, 1), "Todo número es múltiplo de 1");
        assertTrue(EsMultiplo.esMultiplo(5, 5), "Un número es múltiplo de sí mismo");
        assertTrue(EsMultiplo.esMultiplo(-10, 2), "-10 debería ser múltiplo de 2");
        assertTrue(EsMultiplo.esMultiplo(10, -2), "10 debería ser múltiplo de -2");
        assertTrue(EsMultiplo.esMultiplo(-10, -2), "-10 debería ser múltiplo de -2");
    }

    /**
     * Prueba {@link EsMultiplo#esMultiplo(int, int)} cuando num1 NO es múltiplo de num2.
     * Se esperan resultados falsos.
     */
    @Test
    @DisplayName("esMultiplo: Casos donde num1 NO ES múltiplo de num2")
    public void testEsMultiplo_cuandoEsFalso() {
        assertFalse(EsMultiplo.esMultiplo(10, 3), "10 NO debería ser múltiplo de 3");
        assertFalse(EsMultiplo.esMultiplo(7, 2), "7 NO debería ser múltiplo de 2");
        assertFalse(EsMultiplo.esMultiplo(1, 7), "1 NO debería ser múltiplo de 7 (a menos que sea 1 o -1)");
        assertFalse(EsMultiplo.esMultiplo(-10, 3), "-10 NO debería ser múltiplo de 3");
    }

    /**
     * Prueba {@link EsMultiplo#esMultiplo(int, int)} cuando el divisor (num2) es cero.
     * Se espera que lance {@link IllegalArgumentException}.
     */
    @Test
    @DisplayName("esMultiplo: Excepción cuando el divisor es cero")
    public void testEsMultiplo_divisorCeroLanzaExcepcion() {
        // Verificamos que se lanza la excepción esperada
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            EsMultiplo.esMultiplo(10, 0); // Código que debería lanzar la excepción
        });
        // Opcionalmente, verificamos el mensaje de la excepción
        assertEquals("El divisor no puede ser cero.", exception.getMessage(), "Mensaje de excepción incorrecto.");
    }

    // --- Pruebas para el método verificarMultiplo(int, int) ---

    /**
     * Prueba {@link EsMultiplo#verificarMultiplo(int, int)} cuando num1 es múltiplo de num2.
     * Se espera el mensaje afirmativo.
     */
    @Test
    @DisplayName("verificarMultiplo: Mensaje cuando ES múltiplo")
    public void testVerificarMultiplo_cuandoEsMultiplo() {
        int num1 = 12;
        int num2 = 4;
        String expectedMessage = num1 + " es multiplo de " + num2;
        assertEquals(expectedMessage, EsMultiplo.verificarMultiplo(num1, num2));

        num1 = 0;
        num2 = 7;
        expectedMessage = num1 + " es multiplo de " + num2;
        assertEquals(expectedMessage, EsMultiplo.verificarMultiplo(num1, num2));
    }

    /**
     * Prueba {@link EsMultiplo#verificarMultiplo(int, int)} cuando num1 NO es múltiplo de num2.
     * Se espera el mensaje negativo.
     */
    @Test
    @DisplayName("verificarMultiplo: Mensaje cuando NO ES múltiplo")
    public void testVerificarMultiplo_cuandoNoEsMultiplo() {
        int num1 = 13;
        int num2 = 5;
        String expectedMessage = num1 + " no es multiplo de " + num2;
        assertEquals(expectedMessage, EsMultiplo.verificarMultiplo(num1, num2));
    }

    /**
     * Prueba {@link EsMultiplo#verificarMultiplo(int, int)} cuando el divisor (num2) es cero.
     * Se espera que lance {@link IllegalArgumentException}.
     * Esta prueba es similar a la de `esMultiplo` pero para `verificarMultiplo`,
     * asegurando que la validación esté presente o se propague correctamente.
     */
    @Test
    @DisplayName("verificarMultiplo: Excepción cuando el divisor es cero")
    void testVerificarMultiplo_divisorCeroLanzaExcepcion() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            EsMultiplo.verificarMultiplo(15, 0);
        });
        assertEquals("El divisor no puede ser cero.", exception.getMessage());
    }
}