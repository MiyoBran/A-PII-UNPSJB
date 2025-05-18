/**
 * Esta clase proporciona metodos para calcular el diámetro, la circunferencia
 * y el area de un circulo dado  su radio.
 * 
 * @author MiyoBran
 * @version 1.0
 * 
 * 
 */

package circulo;

public class Ej2Circulo {

	// Definimos el valor de Pi como constante
	private static final float PI = 3.14159f;
	
	/**
	 * Calcula el diametro de un círculo.
	 * 
	 * @param radio El radio del circulo.
	 * @return El diametro del circulo.
	 * 
	 */
	public static float calcularDiametro(float radio) {
		return 2 * radio;
	}
	/**
	 * Calcula la circunferencia de un circulo
	 * @param radio El radio del circulo.
	 * @return La circunferencia del circulo.
	 * 
	 */
	public static float calcularCircunferencia(float radio) {
		return 2 * PI * radio;
	}
	
	/**
	 * Calcula el área del circulo
	 * @param radio El radio del circulo
	 * @return	El area del circulo.
	 */
	public static float calcularAreaCirculo(float radio) {
		return  PI * radio * radio;
	}
	
}
