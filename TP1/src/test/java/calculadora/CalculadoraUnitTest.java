package calculadora;

import org.junit.jupiter.api.Test; // Importación de JUnit
import static org.junit.jupiter.api.Assertions.*; // Importación para las aserciones

class CalculadoraUnitTest {

    // Suponiendo que los métodos de Calculadora son estáticos para este ejemplo
    // o que tienes una forma de instanciarla si no lo son.

    @Test // Anotación que marca esto como un método de prueba
    void testSumarNumeros() {
        assertEquals(5.0f, Calculadora.sumarNumeros(2.0f, 3.0f), "La suma de 2 y 3 debe ser 5");
        assertEquals(0.0f, Calculadora.sumarNumeros(-2.0f, 2.0f), "La suma de -2 y 2 debe ser 0");
    }

    @Test
    void testRestarNumeros() {
        assertEquals(1.0f, Calculadora.restarNumeros(3.0f, 2.0f));
    }

    @Test
    void testDividirNumeros() {
        assertEquals(2.0f, Calculadora.dividirNumeros(4.0f, 2.0f));
    }

    @Test
    void testDividirPorCero() {
        // Prueba que se lanza la excepción esperada
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculadora.dividirNumeros(5.0f, 0.0f);
        });
        // Opcionalmente, puedes verificar el mensaje de la excepción
        // assertEquals("No se puede dividir por cero.", exception.getMessage());
    }
}