/**
 * Esta clase proporciona métodos para realizar operaciones aritméticas básicas.
 *
 * @author MiyoBran
 * @version 1.0
 */


package tp1;

public class Ej1Calculadora {

	/**
	 * Suma dos numeros
	 * 
	 *@param num1 El primer número
	 *@param num2 El segundo número 
	 *@return  La suma de dos numeros
	 * 
	 * */
	
	public static float sumarNumeros(float num1, float num2) {
		return	num1+num2;		
	}
	
	
	/*
	 * Resta dos numeros
	 * 
 	 *@param num1 El primer número
	 *@param num2 El segundo número 
	 *@return  La diferencia de los dos numeros
	 *
	 * */
	
	public static float restarNumeros(float num1 , float num2) {
		return num1 - num2 ;
	}
	
	/**
	 * Multiplica dos numeros
	 * 
	 *@param num1 El primer número
	 *@param num2 El segundo número 
	 *@return  El producto de dos numeros
	 * 
	 * */
	
	public static float	multiplicarNumeros(float num1, float num2) {
		return num1 * num2 ;
	}

	/**
	 * Multiplica dos numeros
	 * 
	 *@param num1 El dividendo
	 *@param num2 El divisor (distinto de cero) 
	 *@return  El cociente de los dos numeros
	 *@throws IllegalArgumentException Si el divisor es cero.
	 * 
	 * */
	
	public static float dividirNumeros(float num1 , float num2) {
		if	(num2 == 0) {
			throw new IllegalArgumentException ("No se puede dividir por cero");
		}
		return num1 / num2;	
	}
}
