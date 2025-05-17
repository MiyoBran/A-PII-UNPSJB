package ejemplos_TP02.equals;

/**
 * A Java program to compare two strings using equsls()
 * and equalsIgnoreCase() method of the String.
 * 
 * @author Gaurav Kukade at coderolls.com
 */


public class CompareUsingEquals {

  public static void main(String[] args) {
    String firstString = "coderolls";
    String secondString = "javablog";
    String thirdString = "coderolls";
    String fourthString = "CodeRolls";

    System.out.println("Comparing strings using equals() and equalsIgnoreCase() method\n");
    // Using equals() method
    System.out.print("firstString.equals(secondString) : ");
    System.out.println(firstString.equals(secondString));

    System.out.print("firstString.equals(thirdString) : ");
    System.out.println(firstString.equals(thirdString));


    /*
     * Using equalsIgnoreCase() method to ignore
     * case consideration (i.e. Capital or small) of both the strings.
     */

    System.out.print("firstString.equalsIgnoreCase(fourthString) : ");
    System.out.println(firstString.equalsIgnoreCase(fourthString));

  }


}
