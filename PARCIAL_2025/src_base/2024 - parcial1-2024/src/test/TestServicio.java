package test;

import servicio.Cliente;
import servicio.Empresa;
import servicio.Persona;
import servicio.Plan;
import servicio.Servicio;
import servicio.TipoServicio;

public class TestServicio {

	public static void main(String[] args) {

		TipoServicio b = new TipoServicio(1, "Básico");
		TipoServicio p = new TipoServicio(2, "Premium");

		Servicio s25 = new Servicio(1, "25Mbps Fibra Optica");
		Servicio s50 = new Servicio(2, "50Mbps Fibra Optica");
		Servicio s100 = new Servicio(3, "100Mbps Fibra Optica");

		Plan p1 = new Plan(b, s25, 18500);
		Plan p2 = new Plan(b, s50, 21700);
		Plan p3 = new Plan(p, s50, 37100);
		Plan p4 = new Plan(p, s100, 54500);

		Persona pe1 = new Persona(100, "Gales 916", p1, "Juan");
		Persona pe2 = new Persona(120, "Roca 241", p2, "Ana");
		Empresa em1 = new Empresa(140, "Aluar", p4, "Pedro", false);
		Empresa em2 = new Empresa(150, "Club", p2, "Andrea", true);

		Cliente clientes[] = new Cliente[4];
		clientes[0] = pe1;
		clientes[1] = pe2;
		clientes[2] = em1;
		clientes[3] = em2;

		double total = 0;
		double factura;
		for (Cliente c : clientes) {
			factura = c.calcularFactura();
			System.out.println(c.getId() + " -> " + factura);
			total += factura;
		}
		System.out.println("Total " + total);

		total = 0;
		for (Cliente c : clientes)
			if (c.getPlan().getServicio().equals(s50)) {
				factura = c.calcularFactura();
				System.out.println(c.getId() + " -> " + factura);
				total += factura;
			}
		System.out.println(s50 + " Total " + total);
	}
}
