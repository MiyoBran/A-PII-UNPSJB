package posNegCount;

/** Tp1.08 Class to count positive, negative and zero numbers.
 * @author MiyenBrandolino
 * @version 1.0 * 
 */

public class PosNegCount {
	private int positiveCount;
	private int negativeCount;
	private int zeroCount;

	/**
	 * Constructor of the PosNegCount class. Initialize all counters
	 */
	public PosNegCount() {
		this.positiveCount = 0;
		this.negativeCount = 0;
		this.zeroCount = 0;
	}

	/**
	 * Evaluate the number and increase the proper counter
	 * 
	 * @param number Number to evaluate
	 */
	public void countNumber(float number) {
		if (number > 0) {
			this.positiveCount++;
		} else if (number < 0) {
			this.negativeCount++;
		} else {
			this.zeroCount++;
		}
	}// end of countNumber

	/**
	 * Gets the positive count.
	 * 
	 * @return Positive count.
	 */
	public int getPositiveCount() {
		return positiveCount;
	}// end of getPositiveCount

	/**
	 * Gets the negative count.
	 * 
	 * @return Negative count.
	 */
	public int getNegativeCount() {
		return negativeCount;
	}//end of getNegativeCount

	/**
	 * Gets the zero count.
	 * 
	 * @return Zero count.
	 */
	public int getZeroCount() {
		return zeroCount;
	}//end of getZeroCount
}
