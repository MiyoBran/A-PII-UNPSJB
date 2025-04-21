package club;

public class TestClub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Socio.setValorCuota(1000);

		Actividad act1 = new Actividad(10, "Futbol", 500);
		Actividad act2 = new Actividad(20, "Basquet", 700);
		Actividad act3 = new Actividad(30, "Natación", 1500);

		Socio s1 = new SocioActivo(10, "Juan");;
		Socio s2 = new SocioActivo(20, "Ana");
		Socio s3 = new SocioTemporario(30, "Pedro");
		
		try {			
			s1.agregarActividad(act1);
			s1.agregarActividad(act2);
			s1.agregarActividad(act3);
			
			s2.agregarActividad(act3);

			s3.agregarActividad(act1);
			
		} catch(IndexOutOfBoundsException e) {
			System.out.println(e);		
		}
			
		Socio[] socios = {s1, s2, s3};
		
		double total = 0;
		for (Socio s : socios) {
			System.out.println("Nombre: " + s.getNombre() + " Cuota: " + s.calcularCuota());
			total += s.calcularCuota();
		}
		System.out.println("Total: " + total);

	}

}
