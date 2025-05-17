package municipalidad;

public class TestImpuesto {

	public static void main(String[] args) {
		
		Titular t1 = new Titular("Juan", "20-20245127-7");
		Titular t2 = new Titular("Ana", "27-38245741-4");

		Inmueble i1 = new Inmueble("2020-04-05", t1, "12-111-22", 4245124.25, false);
		Vehiculo v1 = new Vehiculo("2022-06-01", t1, "AF-123-BC", "Ford", 2022, 1125321.78);

		Inmueble i2 = new Inmueble("1985-07-02", t2, "32-121-11", 945124.25, true);
		Vehiculo v2 = new Vehiculo("2022-06-01", t2, "DCA-123", "Peugeot", 2001, 325321.78);

		Bien bienes[] = new Bien[4];

		bienes[0] = i1;
		bienes[1] = v1;
		bienes[2] = i2;
		bienes[3] = v2;

		Inmueble.setAlicuotaBaldio(0.006);
		Inmueble.setAlicuotaEdificado(0.002);
		Vehiculo.setAlicuotaVehiculo(0.004);
				
		double impuesto;
		double total = 0;
		for (int i = 0; i < bienes.length; i++) {
			impuesto = bienes[i].calcularImpuesto();
			System.out.println(bienes[i] + " " + impuesto);
			total += impuesto;
		}
		System.out.println("Total Impuesto: " + total);

		for (int i = 0; i < bienes.length; i++) {
			if (bienes[i].getTitular().equals(t1)) {
				impuesto = bienes[i].calcularImpuesto();
				System.out.println(bienes[i] + " " + impuesto);
				total += impuesto;
			}
		}
		System.out.println("Total Impuesto de " + t1 + " -> " + total);

	}

}
