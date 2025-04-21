package figura;

public class PruebaFigura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Figura figura[] = new Figura[3];
		
		Circulo c1 = new Circulo("Circulo", 20);
		Rectangulo r1 = new Rectangulo("Rectangulo", 10, 40);

		FiguraCompuesta fc1 = new FiguraCompuesta("Auto");

		fc1.agregarFigura(r1);
		fc1.agregarFigura(c1);
		
		figura[0] = c1;		
		figura[1] = r1;
		figura[2] = fc1;
		
		for (int i=0; i<figura.length; i++){
			System.out.println("Figura: "+figura[i]);
			System.out.println("Area: "+figura[i].area());
			System.out.println("Perímetro: "+figura[i].perimetro());
		}
	}

}
