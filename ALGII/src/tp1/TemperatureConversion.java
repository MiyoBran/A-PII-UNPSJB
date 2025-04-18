package tp1;

/**
 * This class provides static methods for converting temperatures between
 * Fahrenheit and Celsius.
 * 
 * @author ArispeClaudio crapz0190@gmail.com
 * @author BrandolinoCarlos miyenbran@gmail.com
 * @author ColipanAxel maurocolipannn@gmail.com
 * @author MarinoLizandro lizandro.e.marino@gmail.com
 * @version 1.0
 */
public class TemperatureConversion {
	/**
	 * Converts a temperature from Fahrenheit to Celsius.
	 *
	 * @param fahrTemp Temperature in degrees Fahrenheit.
	 * @return Equivalent temperature in degrees Celsius.
	 */
	public static float fahrToCent(float fahrTemp) { // (n­°F - 32) 5/9 = m°C
		return (fahrTemp - 32) * 5.0f / 9; // the f in the dividend is to force the division to return a float result
	}

	/**
	 * Converts a temperature from Celsius to Fahrenheit.
	 *
	 * @param centTemp Temperature in degrees Celsius.
	 * @return Equivalent temperature in degrees Fahrenheit.
	 */
	public static float centToFahr(float centTemp) { // (m°C * 9/5) + 32 = n°F
		return (centTemp * 9.0f / 5) + 32; // the f in the dividend is to force the division to return a float result
	}
}
