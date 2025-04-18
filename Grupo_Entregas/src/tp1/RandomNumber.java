package tp1;

import java.util.Random;
import java.util.Scanner;

/**
 * This class implements a number guessing game where the player 
 * must guess a randomly chosen number between 1 and 1000.
 * 
 * @author ArispeClaudio (crapz0190@gmail.com)
 * @author BrandolinoCarlos (miyenbran@gmail.com)
 * @author ColipanAxel (maurocolipannn@gmail.com)
 * @author MarinoLizandro (lizandro.e.marino@gmail.com)
 * @version 1.1
 */
public class RandomNumber {
    
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 1000;
    

	private enum Status {
		CONTINUE, WON
	};

	private final static int TOO_HIGH = 1;
	private final static int TOO_LOW = -1;
	private final static int EQUAL = 0;
	
	private final static String STR_YES = "y";
	private final static String STR_NO = "n";
	
	private static Random random = new Random();
	private static int count = 0;
	private static int randNumber;

    /**
     * Generates a random number between MIN_NUMBER and MAX_NUMBER.
     * 
     * @return A random integer between 1 and 1000.
     */
	private static int generateRandomNumber() {
        return MIN_NUMBER + random.nextInt(MAX_NUMBER);
    }
	
    /**
     * Starts the number guessing game.
     */
	public static void play() {
		Scanner userInput = new Scanner(System.in);
		Status gameStatus = Status.CONTINUE;

		// First random number before starting the game
		randNumber = generateRandomNumber();

		System.out.println("Welcome to the guessing game\n");
		while (gameStatus == Status.CONTINUE) {
			System.out.print("Choose a number between 1 and 1000: ");
			int numberEntered = userInput.nextInt();

			int result = compareNumbers(numberEntered);

			switch (result) {
			case TOO_HIGH:
				System.err.println("Too high");
				count++;
				break;
			case TOO_LOW:
				System.err.println("Too low");
				count++;
				break;
			case EQUAL:
				count++;
				System.out.printf("\nYou guessed it in %d attemps!\n", count);
				System.out.print("\nWould you like to play again? (y/n): ");
				String strInput = userInput.next();

				while (true) {
					if (strInput.equals(STR_NO) || strInput.equals(STR_YES)) {
						if (strInput.equals(STR_NO)) {
							System.out.println("End of the game!");
							gameStatus = Status.WON;
							break;
						} else {
							count = 0;
							randNumber = generateRandomNumber();
						}

						break;
					} else {
						System.err.println("Invalid input. Please enter 'y' or 'n'.");
						System.out.print("\nWould you like to play again? (y/n): ");
						strInput = userInput.next();
					}
				}

			}

		}

		userInput.close();
	}

    /**
     * Compares the player's guess with the randomly generated number.
     * 
     * @param numberEntered The number entered by the user.
     * @return TOO_HIGH, TOO_LOW , EQUAL.
     */
	public static int compareNumbers(int numberEntered) {
		if (numberEntered > randNumber) {
			return TOO_HIGH;
		} else if (numberEntered < randNumber) {
			return TOO_LOW;
		} else {
			return EQUAL;
		}
	}
}
