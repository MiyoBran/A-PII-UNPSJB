/**
 * Esta clase proporciona métodos para determinar si un número es par o impar
 * @author MiyoBran
 * @version 1.0
 * 
 */


package tp1;

public class Ej4ParImpar {
	/**
	 * Determina si un número es par o impar
	 * 
	 * @param numero El numero a evaluar
	 * @return true si el numero es par, false si es impar
	 * 
	 *
	 */
	public static boolean esPar(int numero) {
		//Un número es  par si el resto de dividirlo por dos es 0
		return  numero % 2 == 0;
	}
	/**
	 * Genera un mensaje Indicando si un numero es Par o Impar
	 * @param numero El numero a evaluar
	 * @return Un mensaje indicando  el resultado.
	 * 
	 */
	public static String determinarParImpar(int numero) {
		if (esPar(numero)) {
			return "El número " + numero + " es par.";
		}else {
			return "El numero " + numero + " es impar.";
		}
	}

}
