package comparador;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para la clase {@link Ej3Comparador}. Esta clase verifica el
 * correcto funcionamiento del método
 * {@link Ej3Comparador#compararNumeros(float, float)} para los diferentes
 * escenarios de comparación: mayor, menor o igual.
 *
 * @see Ej3Comparador
 * @author MiyoBran
 * @version 1.0
 */
class ComparadorTest {

	/**
	 * Prueba el método {@link Ej3Comparador#compararNumeros(float, float)} cuando
	 * el primer número (num1) es mayor que el segundo número (num2).
	 */
	@Test
	@DisplayName("Prueba num1 > num2: el primer número es mayor")
	void testCompararNumeros_num1MayorQueNum2() {
		float num1 = 10.5f;
		float num2 = 5.2f;
		String expectedMessage = num1 + " es mas grande."; // Construye el mensaje esperado tal como lo hace el método
															// original
		String actualMessage = Ej3Comparador.compararNumeros(num1, num2);
		assertEquals(expectedMessage, actualMessage, "Fallo cuando num1 (" + num1 + ") > num2 (" + num2 + ")");

		// Otro caso para num1 > num2 con diferentes valores (ej. negativos)
		float num1Neg = -2.0f;
		float num2Neg = -5.0f;
		expectedMessage = num1Neg + " es mas grande.";
		actualMessage = Ej3Comparador.compararNumeros(num1Neg, num2Neg);
		assertEquals(expectedMessage, actualMessage, "Fallo cuando num1 (" + num1Neg + ") > num2 (" + num2Neg + ")");
	}

	/**
	 * Prueba el método {@link Ej3Comparador#compararNumeros(float, float)} cuando
	 * el segundo número (num2) es mayor que el primer número (num1).
	 */
	@Test
	@DisplayName("Prueba num2 > num1: el segundo número es mayor")
	void testCompararNumeros_num2MayorQueNum1() {
		float num1 = 3.0f;
		float num2 = 7.5f;
		String expectedMessage = num2 + " es mas grande.";
		String actualMessage = Ej3Comparador.compararNumeros(num1, num2);
		assertEquals(expectedMessage, actualMessage, "Fallo cuando num2 (" + num2 + ") > num1 (" + num1 + ")");

		// Otro caso para num2 > num1 con diferentes valores
		float num1Neg = -10.0f;
		float num2Neg = -1.0f;
		expectedMessage = num2Neg + " es mas grande.";
		actualMessage = Ej3Comparador.compararNumeros(num1Neg, num2Neg);
		assertEquals(expectedMessage, actualMessage, "Fallo cuando num2 (" + num2Neg + ") > num1 (" + num1Neg + ")");
	}

	/**
	 * Prueba el método {@link Ej3Comparador#compararNumeros(float, float)} cuando
	 * ambos números son iguales.
	 */
	@Test
	@DisplayName("Prueba num1 == num2: los números son iguales")
	void testCompararNumeros_numerosIguales() {
		float num1 = 8.8f;
		float num2 = 8.8f;
		String expectedMessage = "Los numeros son iguales.";
		String actualMessage = Ej3Comparador.compararNumeros(num1, num2);
		assertEquals(expectedMessage, actualMessage, "Fallo cuando num1 (" + num1 + ") == num2 (" + num2 + ")");

		// Otro caso de igualdad con cero
		float num1Cero = 0.0f;
		float num2Cero = 0.0f;
		actualMessage = Ej3Comparador.compararNumeros(num1Cero, num2Cero);
		assertEquals(expectedMessage, actualMessage, "Fallo cuando num1 (0.0) == num2 (0.0)");
	}
}
