
public class Alquiler {

	private Vehiculo vehiculo;
	private Cliente cliente;	
	private int cantDias;
	private int cantKms;
	
	public Alquiler(Vehiculo vehiculo, Cliente cliente, int cantDias,
			int cantKms) {
		super();
		this.vehiculo = vehiculo;
		this.cliente = cliente;
		this.cantDias = cantDias;
		this.cantKms = cantKms;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}

	public int getCantKms() {
		return cantKms;
	}

	public void setCantKms(int cantKms) {
		this.cantKms = cantKms;
	}
	
	
}
