package ejemplos_TP01.factorial;

public class Factorial {

	public static int factorial(int n) {
		if (n == 0 || n == 1)
			return 1;
		int f = 1;
		for (int i = 2; i <= n; i++)
			f = f * i;
		return f;
	}
}
