package clases_genericas_y_excepciones.codigos_ejemplo;


public class TestException {
	private static final int DEFAULT = 1;

	public static void main(String[] args) {
		int n = DEFAULT;
		try {
			n = Integer.parseInt(args[0]);
			if (n <= 0) {
				System.out.println("n debe ser positivo. Usando default.");
				n = DEFAULT;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Sin argumentos. Usando default.");
		} catch (NumberFormatException e) {
			System.out.println("Entero inv�lido. Usando default.");
		}
		finally { 
			System.out.println("Siempre se ejecuta");// Actividades que siempre ocurren  
		     } 
		System.out.printf("Usando el argumento ingresado %d\n",n);
	}
}
