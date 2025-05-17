package test;

import java.time.LocalDate;

import inversion.Accion;
import inversion.Bono;
import inversion.Cliente;
import inversion.Titulo;

public class PruebaInversion {

	public static void main(String[] args) {
		Accion a1 = new Accion("ALUA", "Aluar", 750, false);
		Accion a2 = new Accion("YPF", "YPF", 36100, true);
		Bono b1 = new Bono("AL30", "Bono AL 30", 73500, LocalDate.of(2030, 6, 30));
		Bono b2 = new Bono("GD35", "Bono GD 35", 74100, LocalDate.of(2035, 9, 30));

		Cliente c1 = new Cliente("Juan", "juan@gmail.com");
		Cliente c2 = new Cliente("Ana", "ana@gmail.com");

		c1.comprarActivo(a1, 1200);
		c1.comprarActivo(b1, 12);

		c2.comprarActivo(a2, 150);
		c2.comprarActivo(b2, 45);

		c1.comprarActivo(a1, 1500);
		c2.comprarActivo(b2, 35);

		System.out.println(c1.getNombre() + " - Total Activo: " + c1.totalActivo());
		System.out.println(c2.getNombre() + " - Total Activo: " + c2.totalActivo());

		Titulo titulos[] = new Titulo[4];

		titulos[0] = a1;
		titulos[1] = a2;
		titulos[2] = b1;
		titulos[3] = b2;

		for (Titulo t : titulos) {
			System.out.println("T�tulo: " + t.getSimbolo());
			System.out.println("Comisi�n: " + t.calcularComision(100));
			System.out.println("Impuesto: " + t.calcularImpuesto(100));
			System.out.println("Precio: " + t.calcularPrecio(100));
		}

	}

}
