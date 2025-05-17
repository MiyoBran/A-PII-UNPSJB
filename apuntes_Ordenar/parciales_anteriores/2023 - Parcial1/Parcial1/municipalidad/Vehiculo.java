package municipalidad;

import java.time.LocalDate;

public class Vehiculo extends Bien {

	private String patente;
	private String marca;
	private int modelo;
	private double valuacionFiscal;
	private static double alicuotaVehiculo;
	private static final int ANTIGUEDAD = 20;

	public Vehiculo(String fechaAlta, Titular titular, String patente, String marca, int modelo,
			double valuacionFiscal) {
		super(fechaAlta, titular);
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.valuacionFiscal = valuacionFiscal;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public double getValuacionFiscal() {
		return valuacionFiscal;
	}

	public void setValuacionFiscal(double valuacionFiscal) {
		this.valuacionFiscal = valuacionFiscal;
	}

	public static double getAlicuotaVehiculo() {
		return alicuotaVehiculo;
	}

	public static void setAlicuotaVehiculo(double alicuotaVehiculo) {
		Vehiculo.alicuotaVehiculo = alicuotaVehiculo;
	}

	@Override
	public String toString() {
		return "Vehiculo [patente=" + patente + ", marca=" + marca + ", modelo=" + modelo + ", valuacionFiscal="
				+ valuacionFiscal + ", getFechaAlta()=" + getFechaAlta() + ", getTitular()=" + getTitular() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patente == null) ? 0 : patente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (patente == null) {
			if (other.patente != null)
				return false;
		} else if (!patente.equals(other.patente))
			return false;
		return true;
	}

	@Override
	public double calcularImpuesto() {
		int actual = LocalDate.now().getYear();

		if (actual - modelo < ANTIGUEDAD)
			return valuacionFiscal * alicuotaVehiculo;
		return 0.0;
	}

}
