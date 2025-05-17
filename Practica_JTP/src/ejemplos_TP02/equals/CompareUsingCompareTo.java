package ejemplos_TP02.equals;

/**
 * A Java program to compare strings using compareTo() and compareToIgnoreCase()
 * method.
 * 
 * compareTo() compare strings lexicograpgically.
 * 
 * @author Gaurav Kukade at coderolls.com
 */

public class CompareUsingCompareTo {

	public static void main(String[] args) {

		String firstString = "java";
		String secondString = "coderolls";
		String thirdString = "sql";
		String fourthString = "CodeRolls";

		System.out.println("Comparing strings using compareTo() and compareToIgnoreCase() method\n");

		// Using compareTo() method
		System.out.print("firstString.compareTo(secondString) : ");
		System.out.println(firstString.compareTo(secondString));

		System.out.print("firstString.compareTo(thirdString) : ");
		System.out.println(firstString.compareTo(thirdString));

		/*
		 * Using compareToIgnoreCase() method to ignore case consideration (i.e. Capital
		 * or small) of both the strings.
		 */

		System.out.print("secondString.compareToIgnoreCase(fourthString) : ");
		System.out.println(secondString.compareToIgnoreCase(fourthString));
	}
}