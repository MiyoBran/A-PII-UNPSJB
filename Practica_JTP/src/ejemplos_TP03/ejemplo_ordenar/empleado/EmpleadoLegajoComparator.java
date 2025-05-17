package ejemplos_TP03.ejemplo_ordenar.empleado;
import java.util.Comparator;


public class EmpleadoLegajoComparator implements Comparator<Empleado>{

	@Override
	public int compare(Empleado o1, Empleado o2) {
		
		return o1.getLegajo()-o2.getLegajo();
	}

}
