package tp1;

/**
 * Tp1.06
 * Class to concatenate first and last name and display the full name with a space.
 * Printing the result.
 * 
 * @author MiyenBrandolino
 * @version 1.0
 */
public class UserName { 
    private String fullName; // Full user name
    
    // Constructor: initializes fullName with strings supplied as arguments
    public UserName(String firstName, String lastName) {
        this.fullName = firstName + " " + lastName;
    } // end constructor
    
    // Method to set the user's full name
    public void setFullName(String firstName, String lastName) {
        this.fullName = firstName + " " + lastName;
    } // end method setFullName
    
    // Method to retrieve the user's full name
    public String getFullName() {
        return this.fullName;
    } // end method getFullName
    
    // Method to display a welcome message with the full name
    public void displayMessage() {
        // Calls getFullName to get the full name this UserName represents
        System.out.printf("Welcome %s\n", getFullName());
    } // end method displayMessage
}
