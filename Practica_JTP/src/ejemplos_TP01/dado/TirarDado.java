package ejemplos_TP01.dado;

// Fig. 7.7: TirarDado.java
// Tira un dado de seis lados 6000 veces.
import java.util.Random;

public class TirarDado {
	public static void main(String args[]) {
		Random numerosAleatorios = new Random(); // generador de n�meros aleatorios
		int frecuencia[] = new int[7]; // arreglo de contadores de frecuencia

		// tira el dado 6000 veces; usa el valor del dado como �ndice de frecuencia
		for (int tiro = 1; tiro <= 6000; tiro++)
			++frecuencia[1 + numerosAleatorios.nextInt(6)];

		System.out.printf("%s%10s\n", "Cara", "Frecuencia");

		// imprime el valor de cada elemento del arreglo
		for (int cara = 1; cara < frecuencia.length; cara++)
			System.out.printf("%4d%10d\n", cara, frecuencia[cara]);
	} // fin de main
} // fin de la clase TirarDado