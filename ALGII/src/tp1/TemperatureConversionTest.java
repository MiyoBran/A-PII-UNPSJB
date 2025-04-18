package tp1;

//This class was made to test the TemperatureConversion class
import java.util.Scanner;

/**
 * Test class for temperature conversion. Allows the user to input a temperature
 * and convert it between Fahrenheit and Celsius.
 * 
 * @author ArispeClaudio crapz0190@gmail.com
 * @author BrandolinoCarlos miyenbran@gmail.com
 * @author ColipanAxel maurocolipannn@gmail.com
 * @author MarinoLizandro lizandro.e.marino@gmail.com
 * @version 1.0
 */
public class TemperatureConversionTest {

	/**
	 * Main method that runs the temperature conversion program.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String args[]) {
		Scanner userInput = new Scanner(System.in);
		float userTemperature;
		float convertedTemperature;
		int temperatureType;

		System.out.println("Welcome to the temperature conversion program!");
		System.out.println("Would you like to:");
		System.out.println("1- Convert °F to °C.");
		System.out.println("2- Convert °C to °F.");

		// Controls user input for the option
		do {
			temperatureType = userInput.nextInt();
			if (temperatureType < 1 || temperatureType > 2) {
				System.out.print("\nOption not available. Choose again: ");
			}
		} while (temperatureType < 1 || temperatureType > 2);

		System.out.print("\nWrite the temperature to convert: ");
		while (!userInput.hasNextFloat()) {
			System.out.println("Invalid input. Please enter a numerical temperature:");
			userInput.next();
		}
		userTemperature = userInput.nextFloat();

		if (temperatureType == 1) {
			// Fahrenheit to Celsius
			convertedTemperature = TemperatureConversion.fahrToCent(userTemperature);
			System.out.printf("Your temperature %.1f°F is equal to %.1f°C\n", userTemperature, convertedTemperature);
		} else {
			// Celsius to Fahrenheit
			convertedTemperature = TemperatureConversion.centToFahr(userTemperature);
			System.out.printf("Your temperature %.1f°C is equal to %.1f°F", userTemperature, convertedTemperature);
		}
		userInput.close();
	}
}
