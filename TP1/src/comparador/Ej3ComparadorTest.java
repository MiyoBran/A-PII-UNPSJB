/**
 * Esta clase proporciona métodos para verificar  el funcionamiento de Ej3Comparador
 * 
 * @author MiyoBran
 * @version 1.0
 * 
 */


package comparador;

import java.util.Scanner;

public class Ej3ComparadorTest {
	/**
	 * Método principal que permite al usuario ingresar dos numeros
	 * y muestra el resultado de la comparación.
	 * 
	 * @param args  Argumentos de linea de comandos (no utilizados).
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Ingrese el primer número: ");
		float num1 = userInput.nextFloat();
		
		System.out.print("Ingrese el segundo número: ");
		float num2 = userInput.nextFloat();
		
		// Obtener y mostrar el resultado
		String resultado = Ej3Comparador.compararNumeros(num1, num2);
		System.out.println(resultado);
		
		userInput.close();
	}

}
