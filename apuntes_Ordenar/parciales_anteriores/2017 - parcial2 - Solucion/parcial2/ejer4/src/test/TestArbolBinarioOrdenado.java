package test;

import net.datastructures.TreeMap;
import escuela.Alumno;

public class TestArbolBinarioOrdenado {
	public static void main(String[] args) {

		Alumno a1 = new Alumno(80, "Juan");
		Alumno a2 = new Alumno(40, "Ana");
		Alumno a3 = new Alumno(60, "Pedro");
		Alumno a4 = new Alumno(100, "Pablo");
		Alumno a5 = new Alumno(120, "Maria");
		Alumno a6 = new Alumno(140, "Jorge");

		TreeMap<Integer, Alumno> alumnos = new TreeMap<>();
		alumnos.put(a1.getLegajo(), a1);
		alumnos.put(a2.getLegajo(), a2);
		alumnos.put(a3.getLegajo(), a3);
		alumnos.put(a4.getLegajo(), a4);
		alumnos.put(a5.getLegajo(), a5);
		alumnos.put(a6.getLegajo(), a6);

		TreeMap<String, Alumno> alumnosNom = new TreeMap<>();

		for (Alumno pos : alumnos.values())
			alumnosNom.put(pos.getNombre(), pos);
	}
}
