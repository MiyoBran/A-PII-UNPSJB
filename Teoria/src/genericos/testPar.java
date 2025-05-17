package genericos;


public class testPar {

	public static void main(String[] args) {
		// prueba la clase Pair
		Par<String,Double> bid0,bid1;
		Par<String,Double>[ ] cartera;
		//bid = new Pair<>("ORCL", 32.07);
		//bid = new Pair<String,Double>("ORCL", 32.07);
		bid0 = new Par("ORCL", 32.07); // classic style
		bid1 = new Par<String,Double>("MYSQL", 49.02); // classic style
		String gestor = bid0.getFirst( );
		double porcentaje = bid0.getSecond( );
		System.out.printf("%s %f\n",gestor,porcentaje);
//		holdings = new Par<String,Double>[25]; // illegal; compile error
		cartera = new Par[25]; // correct, but warning about unchecked cast
		cartera[0]= bid0;       // valid element assignment
		cartera[1]= bid1;
		System.out.printf("%s %f\n",cartera[0].first,cartera[0].second);
		System.out.printf("%s %f\n",bid1.getFirst(),bid1.getSecond());
		

	}

}
