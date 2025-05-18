package esMultiplo;

import java.util.Scanner;

/**
 * Esta clase proporciona los métodos necesarios para verificar el funcionamiento de EsMutiplo
 * 
 * @author MiyenBrandolino
 * @version 1.0
 * 
 */
public class EsMultiploTest {

	/**
	 * Método principal  que permite al usuario ingresar dos números 
	 * y muestra si el primero es mpultiplo del segundo.
	 * 
	 * @param args Argumentos de la linea de comandos (No utilizado)
	 */
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Ingrese el primer número:");
		int num1 = userInput.nextInt();
		
		System.out.println("Ingrese el segundo número:");
		int num2 = userInput.nextInt();
		
		
		try {
			//Obtener y mostrar el resultado
			String resultado = EsMultiplo.verificarMultiplo(num1, num2);
			System.out.println(resultado);			
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		userInput.close();

	}

}
