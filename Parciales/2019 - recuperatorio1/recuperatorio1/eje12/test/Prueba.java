package test;

import empresa.Cliente;
import empresa.Empresa;
import empresa.Persona;
import empresa.Plan;

public class Prueba {

	public static void main(String[] args) {

		Plan basico = new Plan("Basico", 650);
		Plan hd = new Plan("HD", 950);
		Plan deporte = new Plan("Deporte", 1250);
		Plan futbol = new Plan("Futbol", 550);

		Empresa.setPorcEmpleados(1);

		Cliente clientes[] = new Cliente[5];

		try {
			clientes[0] = new Persona(10, "Juan", basico);
			clientes[0].agregarPlan(futbol);
			clientes[1] = new Persona(20, "Ana", hd);
			clientes[2] = new Persona(30, "Pedro", hd);

			clientes[3] = new Empresa(100, "Empresa 1", deporte, 20);
			clientes[4] = new Empresa(100, "Empresa 2", basico, 50);
			clientes[4].agregarPlan(hd);

		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}

		for (int i = 0; i < clientes.length; i++)
			System.out.println(clientes[i].getNombre() + " --> "
					+ clientes[i].calcularFactura());

		Empresa.setPorcEmpleados(2);

		for (int i = 0; i < clientes.length; i++)
			System.out.println(clientes[i].getNombre() + " --> "
					+ clientes[i].calcularFactura());

		try {
			clientes[0].agregarPlan(hd);
			clientes[0].agregarPlan(deporte);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}

		
		try {
			clientes[1].agregarPlan(hd);			
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}

		
	}

}
