package test;

import hospital.*;

public class Prueba {

	public static void main(String[] args) {
		
		Medico m1 = new Medico(10, "Ana",2);
		Medico m2 = new Medico(20, "Pablo",4);
		Enfermero f1 = new Enfermero(30, "Carmen",3);
		Enfermero f2 = new Enfermero(30, "Carmen",3);
	
		Personal personal[] = new Personal[4];
		personal[0] = m1;
		personal[1] = m2;
		personal[2] = f1;
		personal[3] = f2;
				
		Turno turnos[] = new Turno[4];
		turnos[0] = new Turno("2018-05-10", "09:00", m1,new Paciente("Juan", "11111111"));
		turnos[1] = new Turno("2018-05-10", "10:00", m1,new Paciente("Pedro", "22222222"));
		turnos[2] = new Turno("2018-05-10", "11:00", m2,new Paciente("Ana", "12121212"));
		turnos[3] = new Turno("2018-05-10", "12:00", m2,new Paciente("Nicolas", "15151515"));

		System.out.println("Sueldos:");
		for (Personal p : personal)
			System.out.println(p.getNombre()+" Sueldo:"+p.calcularSueldo());
		
		System.out.println();
		System.out.println("Pacientes médico: "+m1.getNombre());
		
		for (Turno t : turnos)
			if (t.getMedico().equals(m1))
				System.out.println(t.getPaciente().getNombre());
		
		/*for (Turno t : turnos)
			if (t.getMedico().equals(new Medico(10,null,0)))
				System.out.println(t.getPaciente().getNombre());
		*/		
	}

}
