package ejemplos_TP03.ejemplo_ordenar.empleado;
import java.util.Comparator;


public class EmpleadoNombreComparator implements Comparator<Empleado> {

	@Override
	public int compare(Empleado arg0, Empleado arg1) {
		
		return arg0.getNombre().compareTo(arg1.getNombre());
	}

}
