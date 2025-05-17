package ejemplos_TP01.numero;



import java.util.Scanner;

public class Numero2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numero;
		int maximo = 0;
		int minimo = 0;

		int MAX_NUMERO = 5;

		Scanner input = new Scanner(System.in);

		for (int i = 0; i < MAX_NUMERO; i++) {
			System.out.println("Ingresar el n�mero: " + (i + 1));
			numero = input.nextInt();
			if (i == 0) {
				maximo = numero;
				minimo = numero;
			}
			if (numero < minimo)
				minimo = numero;
			if (numero > maximo)
				maximo = numero;
		}

		System.out.println("El m�ximo es: " + maximo);
		System.out.println("El m�nimo es: " + minimo);
	}

}
