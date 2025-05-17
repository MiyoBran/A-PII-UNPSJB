package ejemplos_TP02.equals;

/**
 * 
 * A Java program to compare strings using == operator.
 * 
 * 
 * 
 * == operator ckecks whether both the strings referring
 * 
 * to the same String Object.
 * 
 * 
 * 
 * @author Gaurav Kukade at coderolls.com
 * 
 */

public class CompareUsingEqualsToOperator {

	public static void main(String[] args) {

		String firstString = "coderolls";
		String secondString = "javablog";
		String thirdString = "coderolls";

		// creating new String object with the same value as firstString or thirdString
		String fourthString = new String("coderolls");
		System.out.println("Comparing strings using == operator \n");
		
		System.out.print("firstString == secondString : ");
		System.out.println(firstString == secondString);

		/*
		 * 
		 * Here firstString and thirdString is referring to the same String object
		 * 
		 * hence it will print 'true'.
		 * 
		 */

		System.out.print("firstString == thirdString : ");
		System.out.println(firstString == thirdString);

		/*
		 * 
		 * Here firstString and fourthString have same value
		 * 
		 * but they are referring to the different String object.
		 * 
		 * 
		 * 
		 * hence it will print 'false'
		 * 
		 */

		System.out.print("firstString == fourthString : ");
		System.out.println(firstString == fourthString);

	}

}
