package tp1;

/**
 * tp1.07 Class to calculate square and cube of a given number
 * 
 * @author MiyenBrandolino
 * @version 1.0
 * 
 */
public class SquareAndCube {
	private int number; // the number that we use in the current instance of the class
	
	/**
	 * Constructor of the SquareAndCube class
	 * @param num Number to calculate square and cube
	 */
	public SquareAndCube(int num){
		this.number = num; // assign num passed as parameter
	}
	
	/**
	 * Sets the number
	 * @param num Number to set in the current instance
	 */
	public void setNumber(int num) {
		this.number = num;
	}
	
	/**
	 * Method to get de square of the number
	 * @return Square of number
	 */
	public int getSquare() {
		return number * number;
	}
	
	/**
	 * Method to get the cube of the number
	 * @return Cube of number
	 */
	public int getCube() {
		return number * number * number;
	}

}
