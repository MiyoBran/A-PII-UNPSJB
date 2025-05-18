/**
 * Esta clase proporciona los métodos para verificar el funcionamiento de Ej1Calculadora.
 *
 * @author MiyoBran
 * @version 1.0
 */

package calculadora;

import java.util.Scanner;

public class CalculadoraTest {

    /**
     * Método principal que permite al usuario ingresar dos números
     * y probar las operaciones aritméticas de la clase Ej1Calculadora.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        float num1 = userInput.nextFloat();

        System.out.print("Ingrese el segundo número: ");
        float num2 = userInput.nextFloat();

        // Se instancia la clase Ej1Calculadora
        Calculadora calculadoraLocal = new Calculadora();

        // Llamada a los métodos usando la instancia (aunque los métodos sean estáticos)
        System.out.println("Suma: " + calculadoraLocal.sumarNumeros(num1, num2));
        System.out.println("Resta: " + calculadoraLocal.restarNumeros(num1, num2));
        System.out.println("Multiplicación: " + calculadoraLocal.multiplicarNumeros(num1, num2));

        // Manejo de excepciones en la división
        try {
            System.out.println("División: " + calculadoraLocal.dividirNumeros(num1, num2));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        userInput.close();
    }
}
