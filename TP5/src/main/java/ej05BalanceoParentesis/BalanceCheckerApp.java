package ej05BalanceoParentesis;

public class BalanceCheckerApp {

    public static void main(String[] args) {
        // 1. Verificar si se proporcionó un nombre de archivo
        if (args.length < 1) {
            System.err.println("Error: Por favor, proporcione el nombre del archivo como argumento.");
            System.err.println("Uso: java ej1StackPerformance.BalanceCheckerApp <ruta_al_archivo>");
            return; // Salir si no hay argumento
        }

        String filePath = args[0]; // El primer argumento es la ruta del archivo

        // 2. Crear una instancia de DelimiterBalancer
        DelimiterBalancer balancer = new DelimiterBalancer();

        // 3. Llamar al método checkBalance y obtener el resultado
        String result = balancer.checkBalance(filePath);

        // 4. Imprimir el resultado
        System.out.println(result);
    }
}
