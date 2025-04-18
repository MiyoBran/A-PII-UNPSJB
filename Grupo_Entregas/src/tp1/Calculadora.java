package tp1;

public class Calculadora {

    // Método para sumar dos números
    public double sumar(double num1, double num2) {
        return num1 + num2;
    }

    // Método para multiplicar dos números
    public double multiplicar(double num1, double num2) {
        return num1 * num2;
    }

    // Método para restar dos números
    public double restar(double num1, double num2) {
        return num1 - num2;
    }

    // Método para dividir dos números
    public double dividir(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            System.out.println("Error: División por cero no permitida.");
            return Double.NaN;  // Retorna "Not a Number" en caso de error
        }
    }
}
