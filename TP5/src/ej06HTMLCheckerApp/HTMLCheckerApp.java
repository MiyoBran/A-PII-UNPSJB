// En ej6HTMLCheckerApp/HTMLCheckerApp.java
package ej06HTMLCheckerApp;

public class HTMLCheckerApp {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Uso: java ej6HTMLCheckerApp.HTMLCheckerApp <ruta_al_archivo_html>");
            return;
        }
        String filePath = args[0];
        HTMLTagBalancer balancer = new HTMLTagBalancer();
        String result = balancer.checkBalance(filePath);
        System.out.println(result);
    }
}