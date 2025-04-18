package lista_array;
/**
 * Esta clase crea un empleado con nombre y legajo
 * 
 * @author Catedra ALGII
 * @author ArispeClaudio (crapz0190@gmail.com)
 * @author BrandolinoCarlos (miyenbran@gmail.com)
 * @author ColipanAxel (maurocolipannn@gmail.com)
 * @author MarinoLizandro (lizandro.e.marino@gmail.com)
 * @version 1.0
 * 
 */
public class Empleado {

	private int legajo;
	private String nombre;

	public Empleado(int legajo, String nombre) {
		this.legajo = legajo;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Empleado [legajo=" + legajo + ", nombre=" + nombre + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (legajo != other.legajo)
			return false;
		return true;
	}

}
