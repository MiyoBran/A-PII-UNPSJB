package empresa;

public class PruebaDepartamento {

	public static void main(String[] args) {
		Departamento d1 = new Departamento(10, "Ventas");
		Departamento d2 = d1;

		Departamento d3 = new Departamento(10, "");

		// System.out.println(d1.equals(d2));
		System.out.println(d1.equals(d3));

		if (d1 == d3)
			System.out.println("Son iguales");
		else
			System.out.println("No son iguales");

	}
}
