package empresa;

/**
 * Representa un empleado con un legajo, nombre, cantidad de horas trabajadas y
 * el valor por hora. Puede tener un supervisor, que es otro objeto de tipo
 * Empleado, o ser nulo si no tiene supervisor.
 * 
 * Implementa la interfaz PorPagar, permitiendo calcular el salario del empleado
 * según las horas trabajadas y el valor de cada hora.
 * 
 * @author Catedra
 * @author ArispeClaudio crapz0190@gmail.com
 * @author BrandolinoCarlos miyenbran@gmail.com
 * @author ColipanAxel maurocolipannn@gmail.com
 * @author MarinoLizandro lizandro.e.marino@gmail.com
 * 
 * @version 1.5
 */
public class Empleado implements PorPagar {

	// Atributos
	private int legajo;
	private String nombre;
	private int horasTrabajadas;
	private double valorHora;

	private Empleado supervisor; // Puede ser null si no tiene supervisor

	// Constructor
	public Empleado(int legajo, String nombre, Empleado supervisor, int horas_Trabajadas, double valorHora) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.supervisor = supervisor;
		this.horasTrabajadas = horas_Trabajadas;
		this.valorHora = valorHora;
	}

	// Metodo empleado por la interfaz
	// Implementación de PorPagar: el pago es el producto de horas trabajadas por el
	// valor de la hora.
	public double obtenerPago() {
		return valorHora * horasTrabajadas;
	}
	
	//Getters and Setters
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

	public String getSupervisor() {
	    return (supervisor != null) ? supervisor.getNombre() : "Sin supervisor";
	}


	public void setSupervisor(Empleado supervisor) {
		this.supervisor = supervisor;
	}

	@Override
	public String toString() {
		if (supervisor == null)
			return "Empleado [legajo=" + legajo + ", nombre=" + nombre + ", horasTrabajadas=" + horasTrabajadas
					+ ", valorHora=" + valorHora + ", supervisor=" + supervisor + "]";
		return "Empleado [legajo=" + legajo + ", nombre=" + nombre + ", horasTrabajadas=" + horasTrabajadas
				+ ", valorHora=" + valorHora + "]";
	}

}
