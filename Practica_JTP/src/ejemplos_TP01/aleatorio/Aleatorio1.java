package ejemplos_TP01.aleatorio;


import java.util.Random;

public class Aleatorio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();

		int valor = r.nextInt(6) + 1;

		System.out.println(valor);

	}

}
