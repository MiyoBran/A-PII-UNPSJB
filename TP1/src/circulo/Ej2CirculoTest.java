/**
 * Esta clase permite probar  los metodos de Ej2Circulo
 * solicitando al usuario un radio e imprimiendo los resultados.
 * 
 * @author MiyoBran
 * @version 1.0
 * 
 */

package circulo;

import java.util.Scanner;

public class Ej2CirculoTest {
	
	/**
	 * Metodo principal que solicita al usuario el radio de un circulo
	 * y muestra los calculos del diamentro, la circunferencia y el area.
	 * 
	 * @param args Argumentos de  linea de comandos (no utilizados).
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// Solicita al usuario el radio
		System.out.print("Ingrese el radio del círculo: ");
		float radio = scanner.nextFloat();
		
		// Validacion de  entrada
		if (radio <= 0) {
			System.out.println("Error: El radio debe ser un valor positivo");
			scanner.close();
			return;
		}
		
		// Calcular los resultados
		System.out.println("Para un circulo  de radio " + radio + ":");
		System.out.println("Diametro: " + Ej2Circulo.calcularDiametro(radio));
		System.out.println("Circunferencia: " + Ej2Circulo.calcularCircunferencia(radio));
		System.out.println("Área: " + Ej2Circulo.calcularAreaCirculo(radio));
		
		scanner.close();
	}

}
