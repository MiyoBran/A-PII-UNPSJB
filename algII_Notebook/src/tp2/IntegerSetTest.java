package tp2;

import java.util.Scanner;

/**
 * TP2 EJ6 Test class to interact with IntegerSet.
 * Allows user to insert, remove, and compare sets.
 * 
 * @author MiyenBrandolino
 * @version 1.1
 */
public class IntegerSetTest {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        
        
        /////////////////// SET 1 : quiza hacerlo mas simple como quedo el SET 2
        System.out.println("Enter numbers between 0 and 100 to add to the set (-1 to stop):");
        while (true) {
            System.out.print("Enter a number: ");
            while (!userInput.hasNextInt()) {
                System.out.print("Invalid input. Please enter an integer: ");
                userInput.next();
            }
            int num = userInput.nextInt();
            if (num == -1) break; // Stop condition
            if (num >= 0 && num <= 100) {
                set1.insertElement(num);
            } else {
                System.out.println("Number out of range. Please enter a number between 0 and 100.");
            }
        }
        
        // Display current set
        System.out.println("\nCurrent Set: " + set1.toString());
        
        // Ask user if they want to remove an element
        System.out.print("Do you want to remove a number from the set? (yes/no): ");
        String response = userInput.next();
        if (response.equalsIgnoreCase("yes")) {
            System.out.print("Enter the number to remove: ");
            while (!userInput.hasNextInt()) {
                System.out.print("Invalid input. Please enter an integer: ");
                userInput.next();
            }
            int removeNum = userInput.nextInt();
            set1.deleteElement(removeNum);
            
            // Show updated set
            System.out.println("\nUpdated Set: " + set1.toString());
        }
        
        
        /////////////////////////// SET 2 : 
        System.out.println("Adding elements to Set 2. Enter numbers between 0 and 100 (-1 to stop):");
        while (true) {
            int num = userInput.nextInt();
            if (num == -1) break;
            set2.insertElement(num);
        }
        
        System.out.println("Set 1: " + set1.toSetString());
        System.out.println("Set 2: " + set2.toSetString());
        
        System.out.println("Union of Set 1 and Set 2: " + set1.union(set2).toSetString());
        System.out.println("Intersection of Set 1 and Set 2: " + set1.intersection(set2).toSetString());
        System.out.println("Difference (Set1 - Set2): " + set1.difference(set2).toSetString());
        
        System.out.println("Are both sets equal? " + set1.equals(set2));
        
        userInput.close();
    }
}
