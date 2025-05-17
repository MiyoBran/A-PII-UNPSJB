package ejemplos_TP01.aleatorio;


public class Aleatorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero;
		int n = 6;
		
		numero = (int) (Math.random() * n) + 1;
		
		System.out.println(numero);
	}

}
