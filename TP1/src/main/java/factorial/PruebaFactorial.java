package factorial;
import java.util.InputMismatchException; // Importar la nueva excepción
import java.util.Scanner;

/**
 * Clase para probar el cálculo de factorial pidiendo entrada al usuario.
 * @author MiyenBrandolino // Tu autoría aquí
 * @version 1.1 // Ejemplo de versión
 */
public class PruebaFactorial {

    /**
     * Método principal. Pide un número, calcula su factorial usando
     * CalculoFactorial y muestra el resultado o un mensaje de error.
     * @param args Argumentos de línea de comandos (no usados).
     */
    public static void main(String[] args) {

        // Usar try-with-resources para asegurar que el Scanner se cierre
        try (Scanner teclado = new Scanner(System.in)) {

            System.out.print("Ingrese un numero entero no negativo: "); // Usar print
            int numero = teclado.nextInt();	// Lee el entero (puede lanzar InputMismatchException)

            // Intenta calcular el factorial
            try {
                long resultado = CalculoFactorial.calcular(numero); // Llama al método (puede lanzar IllegalArgumentException)
                System.out.println("El factorial de " + numero + " es: " + resultado);
            } catch (IllegalArgumentException e) {
                // Maneja el error si el número es negativo
                System.err.println("Error al calcular: " + e.getMessage());
            }

        } catch (InputMismatchException e) {
             // Maneja el error si la entrada no fue un número entero
             System.err.println("Error de entrada: Debe ingresar un numero entero.");
        }
        // El 'teclado.close()' ya no es necesario aquí gracias al try-with-resources
    }
}