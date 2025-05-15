package ej5BalanceoParentesis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class DelimiterBalancer {

    // Usamos tu LinkedStack con DelimiterInfo
    private Stack<DelimiterInfo> stack;

    public DelimiterBalancer() {
        // Inicializamos la pila que vamos a usar.
        // Asegúrate de que tu ej1StackPerformance.LinkedStack esté accesible.
        this.stack = new LinkedStack<>();
    }

    /**
     * Verifica el balanceo de delimitadores en el archivo especificado.
     * @param filePath Ruta al archivo a verificar.
     * @return Un String indicando si el archivo está balanceado o el mensaje de error con la línea.
     */
    public String checkBalance(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String lineContent;
            int currentLineNumber = 0;

            while ((lineContent = reader.readLine()) != null) {
                currentLineNumber++;
                for (int i = 0; i < lineContent.length(); i++) {
                    char ch = lineContent.charAt(i);

                    if (isOpeningDelimiter(ch)) {
                        stack.push(new DelimiterInfo(ch, currentLineNumber));
                    } else if (isClosingDelimiter(ch)) {
                        if (stack.isEmpty()) {
                            return "Error en línea " + currentLineNumber + ": Se encontró delimitador de cierre '" + ch + "' pero no había uno de apertura correspondiente.";
                        }
                        
                        DelimiterInfo topDelimiter = stack.pop();
                        if (!isMatchingPair(topDelimiter.getCharacter(), ch)) {
                            return "Error en línea " + currentLineNumber + ": Se encontró delimitador de cierre '" + ch + "' pero se esperaba cierre para '" + topDelimiter.getCharacter() + "' abierto en la línea " + topDelimiter.getLineNumber() + ".";
                        }
                    }
                }
            }

            // Al final del archivo
            if (!stack.isEmpty()) {
                DelimiterInfo lastOpenDelimiter = stack.top(); // El último que quedó abierto
                return "Error: Al final del archivo, el delimitador '" + lastOpenDelimiter.getCharacter() + "' abierto en la línea " + lastOpenDelimiter.getLineNumber() + " no fue cerrado.";
            }

            return "El archivo está correctamente balanceado.";

        } catch (IOException e) {
            return "Error al leer el archivo '" + filePath + "': " + e.getMessage();
        }
    }

    private boolean isOpeningDelimiter(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    private boolean isClosingDelimiter(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}