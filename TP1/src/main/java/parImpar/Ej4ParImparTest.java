/**
 * Esta clase proporciona métodos para verificar el funcionamiento de Ej4ParImpar
 * 
 * @author MiyoBran
 * @version 1.0
 * 
 */

package parImpar;

import java.util.Scanner;


public class Ej4ParImparTest {
	/**
	 * Método principal que permite al usuario ingresar un número
	 * y muestra si es par o impar
	 * @param args Argumentos de linea  de comandos, no utilizados.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Ingrese un numero entero: ");
		int entero = userInput.nextInt();
		
		// Obtener y mostrar el resultado
		String resultado = Ej4ParImpar.determinarParImpar(entero);
		System.out.println(resultado);
		
	userInput.close();
	}

}
	