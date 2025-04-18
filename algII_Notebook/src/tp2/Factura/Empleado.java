package tp2.Factura;

import tp2.Factura.PorPagar;

/**
 * Representa un empleado con un legajo, nombre, cantidad de horas trabajadas y
 * el valor por hora. Puede tener un supervisor, que es otro objeto de tipo
 * Empleado, o ser nulo si no tiene supervisor.
 * 
 * Implementa la interfaz PorPagar, permitiendo calcular el salario del empleado
 * según las horas trabajadas y el valor de cada hora.
 * 
 * @author MiyenBrandolino
 * @version 1.1
 */
public class Empleado implements PorPagar {
	private int legajo;
	private String nombre;
	private int horasTrabajadas;
	private double valorHora;
	private Empleado supervisor; // Puede ser null si no tiene supervisor

	public Empleado(int legajo, String nombre, Empleado supervisor, int horasTrabajadas, double valorHora) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.supervisor = supervisor;
		this.horasTrabajadas = horasTrabajadas;
		this.valorHora = valorHora;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public Empleado getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Empleado supervisor) {
		this.supervisor = supervisor;
	}

	// Implementación de PorPagar: el pago es el producto de horas trabajadas por el
	// valor de la hora.
	@Override
	public double obtenerPago() {
		return valorHora * horasTrabajadas;
	}

	@Override
	public String toString() {
		String supervisorInfo = (supervisor != null) ? supervisor.getNombre() : "Sin supervisor";
		return "Empleado [Legajo: " + legajo + ", Nombre: " + nombre + ", Horas Trabajadas: " + horasTrabajadas
				+ ", Valor Hora: $" + valorHora + ", Supervisor: " + supervisorInfo + ", Pago: $" + obtenerPago() + "]";
	}
}