package tp1;

/**
 * Tp1 EJ9 .  NumberAnalyzer class to determine  the smallest and  largest number 
 * from a set of inputs
 * 
 * @author MiyenBrandolino
 * @version 1.0
 * 
 */
public class NumberAnalyzer {
	private int smallest;
	private int largest;
	private int count;

	/**
	 * Constructor that initializes the smallest and largest numbers
	 */
	public NumberAnalyzer() {
		this.smallest = Integer.MAX_VALUE;
		this.largest = Integer.MIN_VALUE;
		this.count = 0;
		
	}

	/**
	 * Adds a number that updates the smallest and largest values.
	 * 
	 * @param number The number to be analyzed.
	 */
	public void addNumber(int number) {
		if (count == 0) { // first number case
			smallest = number;
			largest = number;
		} else {
			if (number < smallest) {
				smallest = number;
			}
			if (number > largest) {
				largest = number;
			}
		} // end if-else
		count++;

	}// end method addNumber

	/**
	 * Returns the smallest  number in the dataset.
	 * 
	 * @return The smallest number or Integer.MAX_VALUE  if no numbers were added.
	 * @throws IllegalStateException If no numbers have been added.
	 * 
	 */
	public int getSmallest() {
		if(count == 0) {
			throw new IllegalStateException("No numbers have been added yet.");
		}
		return smallest;
	}

	/**
	 * Returns the largest number in the dataset
	 * 
	 * @return The largest number or Integer.MIN_VALUE if no numbers were added
	 * @throws IllegalStateException If no numbers have been added.
	 * 
	 */
	public int getLargest() {
		if (count == 0) {
			throw new IllegalStateException("No numbers have been added yet.");
		}
		return largest;
	}
	
	/**
	 * Returns the count of number analyzed. 
	 * @return Counter of numbers analyzed by addNumber method
	 */
	public int getCount() {
		return count;
	}
	

	@Override
	public String toString() {
		if (count == 0) {
			return "No numbers have been added yet.";
		}
		return String.format("Smallest: %d, Largest: %d, Numbers added: %d", smallest, largest, count );
	}

}
