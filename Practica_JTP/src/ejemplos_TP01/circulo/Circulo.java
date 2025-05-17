package ejemplos_TP01.circulo;


public class Circulo {

	public static double diametro(double radio) {
		return radio * 2;
	}

	public static double circunferencia(double radio) {
		return 2 * Math.PI * radio;
	}

	public static double area(double radio) {
		return Math.PI * Math.pow(radio, 2);
	}
}
