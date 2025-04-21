package empresa;

public class Contratado extends Personal{

	private double valorHora;
	private double cantHoras;
	
	public Contratado(String nombre, String dni, Departamento departamento,
			double valorHora, double cantHoras) {
		super(nombre, dni, departamento);
		this.valorHora = valorHora;
		this.cantHoras = cantHoras;
	}

	@Override
	public double calcularSueldo() {
		// TODO Auto-generated method stub
		return valorHora * cantHoras;
	}
		
}
