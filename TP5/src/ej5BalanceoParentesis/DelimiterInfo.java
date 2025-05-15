// Puedes poner esto en un archivo DelimiterInfo.java
// o como una clase interna (static nested class) dentro de DelimiterBalancer.
package ej5BalanceoParentesis;

public class DelimiterInfo {
    char character;
    int lineNumber;
    // Podríamos añadir `columnNumber` para más precisión, pero la línea es el requisito.

    public DelimiterInfo(char character, int lineNumber) {
        this.character = character;
        this.lineNumber = lineNumber;
    }

    public char getCharacter() {
        return character;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public String toString() {
        return "'" + character + "' en línea " + lineNumber;
    }
}