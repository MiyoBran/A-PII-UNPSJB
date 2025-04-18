/**
 * Esta clase proporciona métodos para comparar numeros.
 * 
 * @author MiyoBran
 * @version 1.0
 * 
 */

package comparador;

public class Ej3Comparador {
	/**
	 * Compara dos números  y devuelve el mensaje  segun la comparacion
	 * 
	 * @param num1 el primer numero a comparar
	 * @param num2 el segundo numero a comparar.
	 * @return Un mensaje  con el resultado de la comparacion.
	 */
	public static String compararNumeros(float num1 , float num2) {
		if (num1 > num2) {
			return num1 + " es mas grande.";
		}else if (num2 > num1) {
			return num2 + " es mas grande.";
		}else {
			return "Los numeros son iguales.";
		}
	}
}
