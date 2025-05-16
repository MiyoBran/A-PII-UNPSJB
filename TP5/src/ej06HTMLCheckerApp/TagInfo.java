// Preferiblemente en ej6HTMLCheckerApp/TagInfo.java
package ej06HTMLCheckerApp;

public class TagInfo {
    String tagName;
    int lineNumber;
    int columnNumber; // Columna donde inicia el tag (posición del '<')

    public TagInfo(String tagName, int lineNumber, int columnNumber) {
        // HTML tags son case-insensitive, así que los normalizamos a minúsculas.
        this.tagName = tagName.toLowerCase();
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

    public String getTagName() {
        return tagName;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    @Override
    public String toString() {
        return "Tag '" + tagName + "' en línea " + lineNumber + ", columna " + columnNumber;
    }
}