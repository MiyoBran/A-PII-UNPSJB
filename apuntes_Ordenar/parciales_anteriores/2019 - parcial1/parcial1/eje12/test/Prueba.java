package test;

import empresa.Cliente;
import empresa.Empresa;
import empresa.Persona;
import empresa.Plan;

public class Prueba {

	public static void main(String[] args) {

		Plan basico = new Plan("Basico", 650);
		Plan hd = new Plan("HD", 950);
		Plan full = new Plan("Full", 1250);

		Empresa.setBaseEmpresa(500);

		Cliente clientes[] = new Cliente[5];

		clientes[0] = new Persona(10, "Juan", basico, false);
		clientes[1] = new Persona(20, "Ana", hd, false);
		clientes[2] = new Persona(30, "Pedro", hd, true);

		clientes[3] = new Empresa(100, "Empresa 1", full, 20);
		clientes[4] = new Empresa(100, "Empresa 2", basico, 50);

		for (int i = 0; i < clientes.length; i++)
			System.out.println(clientes[i].getNombre() + " --> "
					+ clientes[i].calcularFactura());

		for (int i = 0; i < clientes.length; i++)
			if (clientes[i].getPlan().equals(new Plan("HD", 0)))
				System.out.println(clientes[i].getNombre());

	}

}
