package empresa;

public class PruebaEmpresa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Empresa empresa = new Empresa("Empresa");
		
		Departamento d1 = new Departamento (10,"Producción");
		Departamento d2 = new Departamento (20,"Compras");
				
		empresa.agregarEmpleado("Juan", "22222222", d1, 5000);
		empresa.agregarEmpleado("Ana", "12345678", d2, 7000);		
		empresa.agregarContratado("Pedro", "12312312", d2, 50,200);
		
		System.out.println("Total sueldos: "+empresa.calcularSueldo());
		
		System.out.println("Total sueldos "+d2+ " "+empresa.calcularSueldo(d2));
		
		
		
		
	}
}
