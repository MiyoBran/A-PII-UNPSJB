// En ej6HTMLCheckerApp/HTMLTagBalancer.java
package ej6HTMLCheckerApp;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLTagBalancer {

    private Stack<TagInfo> stack; // La variable 'stack' es de tipo Stack<TagInfo>

    public HTMLTagBalancer() {
        // Intenta especificar el tipo explícitamente aquí:
        this.stack = new DoublyLinkedStack<TagInfo>(); // Cambio aquí
    }

    public String checkBalance(String filePath) {
        // Esta es la parte más compleja que desarrollaremos
        // Deberá leer el archivo, parsear los tags, y usar la pila.
        // Por ahora, un placeholder:
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;
            // ... lógica de parsing ...

            // Lógica preliminar de lectura y búsqueda de tags
            // Se necesitará un parsing más robusto.
            // Patrón simple para encontrar cualquier cosa que parezca un tag: <...>
            // Este patrón es muy básico y necesitará refinamiento.
            Pattern tagPattern = Pattern.compile("<(/?)(\\w+)([^>]*)>");
            // Grupo 1: Opcional "/" (para tags de cierre)
            // Grupo 2: Nombre del tag (\w+ significa uno o más caracteres de palabra)
            // Grupo 3: Atributos o " /" para autocierre (cualquier cosa que no sea '>')

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                Matcher matcher = tagPattern.matcher(line);
                int lineOffset = 0; // Para ajustar la columna dentro de la línea

                while (matcher.find(lineOffset)) {
                    int column = matcher.start() + 1; // Columna basada en 1
                    boolean isClosingTag = !matcher.group(1).isEmpty(); // Es true si "/" está presente
                    String tagName = matcher.group(2).toLowerCase();
                    String attributesAndRest = matcher.group(3); // Contiene atributos o " /"

                    // Ignorar comentarios HTML y DOCTYPE por ahora para simplificar
                    // Un parser real necesitaría manejarlos explícitamente y mejor.
                    if (tagName.startsWith("!--") || tagName.equalsIgnoreCase("!doctype")) {
                        lineOffset = matcher.end();
                        continue;
                    }
                    
                    boolean isSelfClosing = attributesAndRest.trim().endsWith("/");

                    if (isClosingTag) {
                        // Lógica para tag de cierre </tag>
                        if (stack.isEmpty()) {
                            return "Error: Tag de cierre '" + tagName + "' encontrado en línea " + lineNumber + ", columna " + column + " sin tag de apertura correspondiente.";
                        }
                        TagInfo openTag = stack.pop();
                        if (!openTag.getTagName().equals(tagName)) {
                            return "Error: Tag de cierre inesperado '" + tagName + "' en línea " + lineNumber + ", columna " + column + ". Se esperaba cierre para '" + openTag.getTagName() + "' (abierto en línea " + openTag.getLineNumber() + ", columna " + openTag.getColumnNumber() + ").";
                        }
                    } else if (isSelfClosing) {
                        // Tag de autocierre <tag /> , no hacer nada con la pila
                        // System.out.println("Tag autocierre: " + tagName + " en L" + lineNumber + ":C" + column);
                    } else {
                        // Tag de apertura <tag> o <tag atributos>
                        stack.push(new TagInfo(tagName, lineNumber, column));
                    }
                    lineOffset = matcher.end(); // Avanzar para la próxima búsqueda en la línea
                }
            }

            if (!stack.isEmpty()) {
                TagInfo openTag = stack.top(); // El último que quedó abierto
                return "Error: Al final del archivo, el tag '" + openTag.getTagName() + "' abierto en línea " + openTag.getLineNumber() + ", columna " + openTag.getColumnNumber() + " no fue cerrado.";
            }

            return "El archivo HTML parece estar correctamente balanceado.";

        } catch (IOException e) {
            return "Error al leer el archivo '" + filePath + "': " + e.getMessage();
        }
    }
}