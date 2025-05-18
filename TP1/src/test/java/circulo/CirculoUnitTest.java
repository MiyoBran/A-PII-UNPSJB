package circulo; // Mismo paquete que la clase probada



import static org.junit.jupiter.api.Assertions.*; // Para usar assertEquals, etc.
import org.junit.jupiter.api.DisplayName; // Para nombres de prueba más descriptivos
import org.junit.jupiter.api.Test; // Para marcar métodos como pruebas


/**
 * Pruebas unitarias para la clase {@link Ej2Circulo}.
 * Esta clase verifica el correcto funcionamiento de los métodos de cálculo
 * relacionados con un círculo (diámetro, circunferencia y área)
 * para diversos escenarios de entrada.
 *
 * @see Ej2Circulo
 * @author MiyoBran
 * @version 1.0
 */
public class CirculoUnitTest {

    // Usamos una pequeña tolerancia (delta) para comparaciones de floats
    private static final float DELTA = 0.0001f; 

    /**
     * Prueba el método {@link Ej2Circulo#calcularDiametro(float)}.
     * Verifica el cálculo del diámetro para radios positivos, cero y negativos.
     * Aunque un radio negativo no es físicamente significativo en este contexto,
     * la prueba verifica el comportamiento actual de la función (que simplemente lo duplica).
     */
    @Test
    @DisplayName("Prueba de cálculo de diámetro con varios radios")
    public void testCalcularDiametro() {
        // Caso 1: Radio positivo
        assertEquals(10.0f, Ej2Circulo.calcularDiametro(5.0f), DELTA, "Diámetro con radio 5.0f");
        
        // Caso 2: Radio cero
        assertEquals(0.0f, Ej2Circulo.calcularDiametro(0.0f), DELTA, "Diámetro con radio 0.0f");
        
        // Caso 3: Radio negativo (comportamiento actual)
        assertEquals(-4.0f, Ej2Circulo.calcularDiametro(-2.0f), DELTA, "Diámetro con radio -2.0f");
    }

    /**
     * Prueba el método {@link Ej2Circulo#calcularCircunferencia(float)}.
     * Verifica el cálculo de la circunferencia.
     * Se usa el valor de PI = 3.14159f definido en Ej2Circulo.
     */
    @Test
    @DisplayName("Prueba de cálculo de circunferencia")
    public void testCalcularCircunferencia() {
        float radio = 1.0f;
        // PI_LOCAL es el mismo valor que en Ej2Circulo para consistencia en la prueba
        float PI_LOCAL = 3.14159f; 
        float expectedCircunferencia = 2 * PI_LOCAL * radio;
        assertEquals(expectedCircunferencia, Ej2Circulo.calcularCircunferencia(radio), DELTA, "Circunferencia con radio 1.0f");

        radio = 0.0f;
        expectedCircunferencia = 2 * PI_LOCAL * radio;
        assertEquals(expectedCircunferencia, Ej2Circulo.calcularCircunferencia(radio), DELTA, "Circunferencia con radio 0.0f");
    }

    /**
     * Prueba el método {@link Ej2Circulo#calcularAreaCirculo(float)}.
     * Verifica el cálculo del área.
     * Se usa el valor de PI = 3.14159f definido en Ej2Circulo.
     */
    @Test
    @DisplayName("Prueba de cálculo de área")
    public void testCalcularAreaCirculo() {
        float radio = 2.0f;
        float PI_LOCAL = 3.14159f;
        float expectedArea = PI_LOCAL * radio * radio;
        assertEquals(expectedArea, Ej2Circulo.calcularAreaCirculo(radio), DELTA, "Área con radio 2.0f");

        radio = 0.0f;
        expectedArea = PI_LOCAL * radio * radio;
        assertEquals(expectedArea, Ej2Circulo.calcularAreaCirculo(radio), DELTA, "Área con radio 0.0f");
    }
}