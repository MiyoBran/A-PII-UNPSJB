package ejemplos_TP01.circulo;



import java.util.Scanner;

public class TestCirculo {

	public static void main(String args[]) {
	
		Scanner input = new Scanner(System.in);

		double radio;
		
		System.out.print("Ingresar el radio: ");
		radio = input.nextDouble();
		
		System.out.printf("Di�metro: %4.2f\n", Circulo.diametro(radio));
		System.out.printf("Circunferencia: %4.2f\n", Circulo.circunferencia(radio));
		System.out.printf("Area: %4.2f\n", Circulo.area(radio));

	}
}
