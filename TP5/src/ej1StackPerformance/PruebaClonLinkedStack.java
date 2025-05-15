package ej1StackPerformance;


public class PruebaClonLinkedStack {

    public static void main(String[] args) {
        System.out.println("=== Iniciando Pruebas de Clonación para LinkedStack ===");

        // Test 1: Clonar una pila con múltiples elementos
        //--------------------------------------------------
        System.out.println("\n--- Test 1: Pila con múltiples elementos ---");
        LinkedStack<String> originalStack = new LinkedStack<>();
        originalStack.push("Manzana");
        originalStack.push("Banana");
        originalStack.push("Cereza"); // Tope actual: Cereza

        System.out.println("Pila Original (Antes de clonar):");
        System.out.println("  Tamaño: " + originalStack.size() + ", Tope: " + originalStack.top());

        LinkedStack<String> clonedStack = null;
        try {
            // Llama al método clone()
            clonedStack = originalStack.clone();
            System.out.println("Clonación realizada exitosamente.");
        } catch (Exception e) { // Aunque nuestro clone() no declara CloneNotSupportedException directamente
            System.err.println("ERROR: Falló la clonación: " + e.getMessage());
            e.printStackTrace();
            return; // Salir si la clonación fundamental falla
        }

        // Verificación 1.1: Original y Clon son instancias diferentes
        System.out.println("-> ¿Original y Clon son la misma instancia de objeto? " + (originalStack == clonedStack)); // Esperado: false

        // Verificación 1.2: Clon tiene el mismo estado inicial
        System.out.println("\nPila Clonada (Inmediatamente después de clonar):");
        System.out.println("  Tamaño: " + clonedStack.size() + ", Tope: " + clonedStack.top());
        // Comparamos contenido del tope si no está vacía
        boolean topElementsEqual = (originalStack.isEmpty() && clonedStack.isEmpty()) ||
                                   (!originalStack.isEmpty() && !clonedStack.isEmpty() && originalStack.top().equals(clonedStack.top()));
        System.out.println("-> ¿Tamaño igual y topes iguales (si existen)? " + (originalStack.size() == clonedStack.size() && topElementsEqual)); // Esperado: true


        // Verificación 1.3: Modificar el Clon NO afecta al Original
        System.out.println("\nModificando Pila Clonada...");
        String poppedFromCloned = clonedStack.pop(); // Quita "Cereza" del clon
        clonedStack.push("Dátil");                  // Añade "Dátil" al clon. Tope del clon: "Dátil"

        System.out.println("  Elemento desapilado del Clon: " + poppedFromCloned);
        System.out.println("Pila Clonada (Después de su modificación):");
        System.out.println("  Tamaño: " + clonedStack.size() + ", Tope: " + clonedStack.top());

        System.out.println("Pila Original (Después de modificar el Clon):"); // Debería estar sin cambios
        System.out.println("  Tamaño: " + originalStack.size() + ", Tope: " + originalStack.top());
        System.out.println("-> ¿Pila Original sin cambios? " + (originalStack.size() == 3 && originalStack.top().equals("Cereza"))); // Esperado: true


        // Verificación 1.4: Modificar el Original NO afecta al Clon
        System.out.println("\nModificando Pila Original...");
        String poppedFromOriginal = originalStack.pop(); // Quita "Cereza" del original
        originalStack.push("Frambuesa");                // Añade "Frambuesa" al original. Tope del original: "Frambuesa"

        System.out.println("  Elemento desapilado del Original: " + poppedFromOriginal);
        System.out.println("Pila Original (Después de su modificación):");
        System.out.println("  Tamaño: " + originalStack.size() + ", Tope: " + originalStack.top());

        System.out.println("Pila Clonada (Después de modificar el Original):"); // Debería estar sin cambios por esta acción
        System.out.println("  Tamaño: " + clonedStack.size() + ", Tope: " + clonedStack.top());
        System.out.println("-> ¿Pila Clonada sin cambios (respecto a su último estado)? " + (clonedStack.size() == 3 && clonedStack.top().equals("Dátil"))); // Esperado: true


        // Test 2: Clonar una pila vacía
        //--------------------------------------------------
        System.out.println("\n--- Test 2: Pila vacía ---");
        LinkedStack<Integer> emptyOriginal = new LinkedStack<>();
        System.out.println("Pila Vacía Original (Antes de clonar): ¿Está vacía? " + emptyOriginal.isEmpty());

        LinkedStack<Integer> clonedEmpty = emptyOriginal.clone();
        System.out.println("Clonación de pila vacía realizada.");

        System.out.println("-> ¿Original Vacía y Clon Vacía son la misma instancia? " + (emptyOriginal == clonedEmpty)); // Esperado: false
        System.out.println("Pila Vacía Clonada (Después de clonar): ¿Está vacía? " + clonedEmpty.isEmpty()); // Esperado: true

        // Modificar el clon vacío
        clonedEmpty.push(100);
        System.out.println("Pila Clonada Vacía (Después de push(100)): Tamaño: " + clonedEmpty.size() + ", Tope: " + clonedEmpty.top());
        System.out.println("Pila Vacía Original (Después de modificar su clon): ¿Está vacía? " + emptyOriginal.isEmpty()); // Esperado: true


        // Test 3: Clonar una pila con un solo elemento
        //--------------------------------------------------
        System.out.println("\n--- Test 3: Pila con un solo elemento ---");
        LinkedStack<Double> singleOriginal = new LinkedStack<>();
        singleOriginal.push(3.14159);
        System.out.println("Pila Único Elemento Original (Antes de clonar): Tamaño: " + singleOriginal.size() + ", Tope: " + singleOriginal.top());

        LinkedStack<Double> clonedSingle = singleOriginal.clone();
        System.out.println("Clonación de pila con un solo elemento realizada.");

        System.out.println("-> ¿Original Único y Clon Único son la misma instancia? " + (singleOriginal == clonedSingle)); // Esperado: false
        System.out.println("Pila Clonada Único (Después de clonar): Tamaño: " + clonedSingle.size() + ", Tope: " + clonedSingle.top());

        // Modificar el original
        singleOriginal.pop(); // Original ahora está vacía
        singleOriginal.push(2.71828);
        System.out.println("Pila Original Único (Después de pop() y push(2.71828)): Tamaño: " + singleOriginal.size() + ", Tope: " + singleOriginal.top());

        System.out.println("Pila Clonada Único (Después de modificar el original):"); // No debe cambiar por la mod del original
        System.out.println("  Tamaño: " + clonedSingle.size() + ", Tope: " + clonedSingle.top());
        System.out.println("-> ¿Pila Clonada Único sin cambios? " + (clonedSingle.size() == 1 && clonedSingle.top().equals(3.14159))); // Esperado: true


        System.out.println("\n=== Pruebas de Clonación para LinkedStack Completadas ===");
    }
}