package tp1;
import java.util.Scanner; // Import Scanner to read user input

/**
 * Tp1.06 UserNameTest
 * This program asks the user for their first and last name
 * and displays a message with the full name.
 * 
 * @author MiyenBrandolino
 * @version 1.0
 */
public class UserNameTest {

    /** 
     * Main method that asks the user for their first and last name 
     * and displays a message with the full name.
     * 
     * @param args Command-line arguments (not used)
     */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Ask for the user's first name
		System.out.print("Ingrese su nombre: ");
		String firstName = input.nextLine(); // read the first name

		// Ask for the user's last name
		System.out.print("Ingrese su Apellido: ");
		String lastName = input.nextLine(); // read the last name
		
		// Create a UserName object with user input
		UserName user = new UserName(firstName, lastName);
		
		// Show full name using getFullName
		System.out.println("Nombre completo: " + user.getFullName());
		
		// Call method displayMessage
		user.displayMessage();
		
		// Close the Scanner to avoid resource leaks
		input.close();
		
	}

}
