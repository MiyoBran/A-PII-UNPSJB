package servicio;

public class Persona extends Cliente {

	private String nombre;
	
	public Persona(int id, String direccion, Plan plan, String nombre) {
		super(id, direccion, plan);
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", getId()=" + getId() + ", getDireccion()=" + getDireccion()
				+ ", getPlan()=" + getPlan() + "]";
	}

	@Override
	public double calcularFactura() {
		double total = super.getPlan().getTarifa();

		total += total * Empresa.getIVA() / 100;
		return total;
	}
		
}
