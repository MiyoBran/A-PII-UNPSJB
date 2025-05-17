package ejemplos_TP01.numero;



import java.util.Scanner;

public class Numero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numero;
		int maximo;
		int minimo;
		
		int MAX_NUMERO = 5;

		Scanner input = new Scanner(System.in);

		int i = 0;
		
		System.out.println("Ingresar el n�mero: " + (i + 1));
		numero = input.nextInt();
		maximo = numero;
		minimo = numero;

		for (i = 1; i < MAX_NUMERO; i++) {
			System.out.println("Ingresar el n�mero: " + (i + 1));
			numero = input.nextInt();
			if (numero < minimo)
				minimo = numero;
			if (numero > maximo)
				maximo = numero;
		}

		System.out.println("El m�ximo es: " + maximo);
		System.out.println("El m�nimo es: " + minimo);
	}

}
