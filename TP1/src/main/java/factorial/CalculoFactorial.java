package factorial;

/**
 * Proporciona métodos para calcular factoriales.
 * Considera las buenas prácticas y el manejo de errores básicos.
 * 
 * @author MiyenBrandolino
 * * @author Catedra ALGII // Puedes añadir tu nombre aquí también
 * @version 1.0 // O la versión que corresponda
 */
public class CalculoFactorial {

    /**
     * Calcula el factorial de un número entero no negativo.
     * El factorial de 0 es 1.
     * Lanza una excepción si el número es negativo.
     *
     * @param n El número entero no negativo para calcular el factorial.
     * @return El factorial de n como un tipo long (para manejar números grandes).
     * @throws IllegalArgumentException Si n es menor que 0.
     */
    public static long calcular(int n) { // Nombre corregido
        long resultado = 1; // Inicialización, incluye el caso de n=0

        if (n < 0) {
            // Lanzar excepción para entrada inválida (esto está bien)
            throw new IllegalArgumentException("No se puede realizar el factorial a numeros negativos!");
        } else {
            // Calcular factorial para n > 0
            for (int i = 1; i <= n; i++) { // O podría ser desde i = 2, ya que multiplicar por 1 no cambia nada
                resultado *= i; // Multiplica acumulando
            }
        }

        return resultado;
    }
}