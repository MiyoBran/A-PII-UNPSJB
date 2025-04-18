package numberAnalizer;

import java.util.Scanner;


/**
 * Tp1 EJ9 Test class to interact with NumberAnalyzer. Reads 10 numbers from the
 * user and prints the smallest and largest.
 * 
 * @author MiyenBrandolino
 * @version 1.0
 */
public class NumberAnalyzerTest {

	public static void main (String[] args) {
		final int LIMIT = 10 ; // constant to define the number of inputs
		int number; // to store user input

		Scanner userInput = new Scanner(System.in);		
		NumberAnalyzer numberAnalyzer = new NumberAnalyzer();
		
		
	  // Loop to get 10 numbers from the user
		for (int i = 0 ; i < LIMIT ; i++) {
			System.out.print("Enter a number to analyze: ");
			
			// validate input
			while (!userInput.hasNextInt()) {
				System.out.print("Invalid input. Please enter a valid integer: ");
				userInput.next(); // discard invalid input
			}
			number = userInput.nextInt();
			numberAnalyzer.addNumber(number);
		} // end of for
		
		userInput.close(); // close scanner to prevent memory leak
		
		// Print Results
		System.out.println(numberAnalyzer.toString());
		
	}// end of main method

}// end of test class.
