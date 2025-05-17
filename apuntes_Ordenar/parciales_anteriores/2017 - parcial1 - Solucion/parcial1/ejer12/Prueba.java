

public class Prueba {

	public static void main(String[] args) {
		

		
		Moto m1 = new Moto("AAA-111", "Honda",2015, 200);
		Coche c1 = new Coche("BBB-111", "Gol",2016, 15);
		TodoTerreno t1 = new TodoTerreno("CCC-111", "Hilux",2017, 150, 25);
		
		Alquiler alquiler[] = new Alquiler[3];
		
		alquiler[0] = new Alquiler(m1, new Cliente("Juan","11111111"), 5, 100);
		alquiler[1] = new Alquiler(c1, new Cliente("Ana","22222222"), 2, 350);
		alquiler[2] = new Alquiler(t1, new Cliente("Pedro","33333333"), 3, 50);
		
		for (Alquiler alq: alquiler){
			System.out.println(alq.getVehiculo()+" "+alq.getVehiculo().calcularAlquiler(alq.getCantDias(), alq.getCantKms()));
		}
		
		

	}

}
