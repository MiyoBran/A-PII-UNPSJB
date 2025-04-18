package posNegCount;
import java.util.Scanner; // import Scanner to read user imput
/**
 * Tp1.08 Class to print amount of positive, negative and zero numbers
 * after evaluating 10 user-given numbers. It also stores the numbers.
 * @author MiyenBrandolino
 * @version 1.0
 */
public class PosNegCountTest {

	/**
	 * Main method that asks for numbers from the user, evaluate them
	 * prints the amounts of each type, and stores the numbers in  an array.
	 * 
	 * @param args Command line arguments(not used)
	 */
	public static void main(String[] args){
		final int SIZE = 10; //use a constant for the array size
		float[] numbers = new float[SIZE];// array to store the input numbers
		
		Scanner input = new Scanner(System.in); // instantiated scanner
		
		PosNegCount counter = new PosNegCount(); // instantiated Counter
		
		//Iterate to ask the user for all numbers
		for (int i = 0 ; i < SIZE ; i++) {
			System.out.print("Enter Number " + (i+1) + ": ");
			numbers[i] = input.nextFloat();
			counter.countNumber(numbers[i]);
		}// end of for
		
		//Prints the results
		System.out.println("Negative Numbers: " + counter.getNegativeCount());
		System.out.println("Positive Numbers: " + counter.getPositiveCount());
		System.out.println("Zeros: " + counter.getZeroCount());
		
		//close the Scanner to avoid resources leak
		input.close();
	}

}
