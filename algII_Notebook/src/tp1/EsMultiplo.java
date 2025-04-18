/**
 * Esta clase proporciona los métodos para determinar si un numero es multiplo de otro
 * @author MiyoBran
 * @version 1.0
 * 
 */

package tp1;

public class EsMultiplo {
	/**
	 * Determina si el primer numero es multiplo del segundo
	 * 
	 * @param num1 El numero a verificar si es múltiplo
	 * @param num2 El número por el cual se verifica la divisivilidad
	 * @return true si num1 es múltiplo de num2, false en caso contrario.
	 * @throws IllegalArgumentException si num2  es cero.
	 * 
	 * 
	 */
	public static boolean esMultiplo(int num1 , int num2) {
		if (num2 == 0) {
			throw new IllegalArgumentException("El divisor no puede ser cero.");
		}
		
		// Un número es multiplo de otro si la division tiene resto 0
		return num1 % num2 == 0;
	}
	
	/**
	 * Genera un mensaje determinado si el primer numero es multiplo del segundo
	 * 
	 * @param num1 El numero a verificar si es multiplo
	 * @param num2 El numero por el cual se verifica la divisivilidad
	 * @return un mensaje indicando si num1 es multiplo de num2
	 * @throws IllegalArgumentException  Si num2 es cero.
	 */
	public static String verificarMultiplo(int num1, int num2) {
		if (num2 == 0) {
			throw new IllegalArgumentException("El divisor no puede ser cero.");
		}
		
		if (esMultiplo(num1, num2)) {
			return num1 + " es multiplo de " + num2;
		}else {
			return num1 + " no es multiplo de " + num2;
		}
	}

}
