package ejemplos_TP02.generico;

public class TestPortfolio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Portfolio<String> p1 = new Portfolio<String>(6);

		p1.set(0, "Juan");
		p1.set(1, "Ana");
		p1.set(2, "Pedro");
		p1.set(3, "Pablo");
		p1.set(4, "Mariela");
		p1.set(5, "Julia");

		System.out.println(p1);
		p1.reverse();
		System.out.println(p1);

		Portfolio<Integer> p2 = new Portfolio<Integer>(6);

		p2.set(0, 10);
		p2.set(1, 20);
		p2.set(2, 30);
		p2.set(3, 40);
		p2.set(4, 50);
		p2.set(5, 60);

		System.out.println(p2);
		p2.reverse();
		System.out.println(p2);

		Portfolio<Alumno> p3 = new Portfolio<Alumno>(6);
		p3.set(0, new Alumno(10, "Juan"));
		p3.set(1, new Alumno(20, "Ana"));
		p3.set(2, new Alumno(30, "Pedro"));
		p3.set(3, new Alumno(40, "Pablo"));
		p3.set(4, new Alumno(50, "Mariela"));
		p3.set(5, new Alumno(60, "Julia"));
		
		System.out.println(p3);
		p3.reverse();
		System.out.println(p3);
		
	}
	
	

}
