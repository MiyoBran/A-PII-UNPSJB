package tp1;

/**
 * Tp1.07 SquareAndCubeTest This program print a table whit squares and cubes of
 * number from 0 to 10
 * 
 * @author MiyenBrandolino
 * @version 1.0
 * 
 */
public class SquareAndCubeTest {

	/**
	 * Main Method that print as table squares and numbers
	 * using getSquare and getCube methods
	 * 
	 * @param args Command line arguments (not used).
	 */
	public static void main(String[] args) {
		int start = 0; // first number to show and calculate
		int finish = 10 ; // max number to show
		
		// Constructor instanced SquareAndCube class
		SquareAndCube number = new SquareAndCube(0);  
		
		//Print table header
		System.out.println("Número\tCuadrado\tCubo");
		System.out.println("---------------------------");
		
		// Loop through start to finish 
		for(int i = start ; i <= finish ; i++) {
			number.setNumber(i);
			int square = number.getSquare();
			int cube = number.getCube();
			System.out.printf("%5d\t%5d\t%10d%n", i , square , cube);
		}// end for

	}// end main

}// end class
