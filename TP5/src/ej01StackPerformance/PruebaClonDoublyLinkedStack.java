package ej01StackPerformance; // Mismo paquete que DoublyLinkedStack

// No es necesario importar DoublyLinkedStack si está en el mismo paquete
// y es accesible (no es una clase interna privada de otro archivo, por ejemplo).

public class PruebaClonDoublyLinkedStack {

    public static void main(String[] args) {
        System.out.println("=== Iniciando Pruebas de Clonación para DoublyLinkedStack ===");

        // Test 1: Clonar una pila con múltiples elementos
        //--------------------------------------------------
        System.out.println("\n--- Test 1: Pila con múltiples elementos ---");
        DoublyLinkedStack<String> originalStack = new DoublyLinkedStack<>();
        originalStack.push("Java");
        originalStack.push("Python");
        originalStack.push("JavaScript"); // Tope actual: JavaScript

        System.out.println("Pila Original (Antes de clonar):");
        System.out.println("  Tamaño: " + originalStack.size() + ", Tope: " + originalStack.top());

        DoublyLinkedStack<String> clonedStack = null;
        try {
            // Llama al método clone()
            clonedStack = originalStack.clone();
            System.out.println("Clonación realizada exitosamente.");
        } catch (Exception e) {
            System.err.println("ERROR: Falló la clonación: " + e.getMessage());
            e.printStackTrace();
            return; // Salir si la clonación fundamental falla
        }

        // Verificación 1.1: Original y Clon son instancias diferentes
        System.out.println("-> ¿Original y Clon son la misma instancia de objeto? " + (originalStack == clonedStack)); // Esperado: false

        // Verificación 1.2: Clon tiene el mismo estado inicial
        System.out.println("\nPila Clonada (Inmediatamente después de clonar):");
        System.out.println("  Tamaño: " + clonedStack.size() + ", Tope: " + clonedStack.top());
        boolean topElementsEqualTest1 = (originalStack.isEmpty() && clonedStack.isEmpty()) ||
                                   (!originalStack.isEmpty() && !clonedStack.isEmpty() && originalStack.top().equals(clonedStack.top()));
        System.out.println("-> ¿Tamaño igual y topes iguales (si existen)? " + (originalStack.size() == clonedStack.size() && topElementsEqualTest1)); // Esperado: true


        // Verificación 1.3: Modificar el Clon NO afecta al Original
        System.out.println("\nModificando Pila Clonada...");
        String poppedFromCloned = clonedStack.pop(); // Quita "JavaScript" del clon
        clonedStack.push("C++");                  // Añade "C++" al clon. Tope del clon: "C++"

        System.out.println("  Elemento desapilado del Clon: " + poppedFromCloned);
        System.out.println("Pila Clonada (Después de su modificación):");
        System.out.println("  Tamaño: " + clonedStack.size() + ", Tope: " + clonedStack.top());

        System.out.println("Pila Original (Después de modificar el Clon):"); // Debería estar sin cambios
        System.out.println("  Tamaño: " + originalStack.size() + ", Tope: " + originalStack.top());
        System.out.println("-> ¿Pila Original sin cambios? " + (originalStack.size() == 3 && originalStack.top().equals("JavaScript"))); // Esperado: true


        // Verificación 1.4: Modificar el Original NO afecta al Clon
        System.out.println("\nModificando Pila Original...");
        String poppedFromOriginal = originalStack.pop(); // Quita "JavaScript" del original
        originalStack.push("Ruby");                // Añade "Ruby" al original. Tope del original: "Ruby"

        System.out.println("  Elemento desapilado del Original: " + poppedFromOriginal);
        System.out.println("Pila Original (Después de su modificación):");
        System.out.println("  Tamaño: " + originalStack.size() + ", Tope: " + originalStack.top());

        System.out.println("Pila Clonada (Después de modificar el Original):"); // Debería estar sin cambios por esta acción
        System.out.println("  Tamaño: " + clonedStack.size() + ", Tope: " + clonedStack.top());
        System.out.println("-> ¿Pila Clonada sin cambios (respecto a su último estado)? " + (clonedStack.size() == 3 && clonedStack.top().equals("C++"))); // Esperado: true


        // Test 2: Clonar una pila vacía
        //--------------------------------------------------
        System.out.println("\n--- Test 2: Pila vacía ---");
        DoublyLinkedStack<Integer> emptyOriginal = new DoublyLinkedStack<>();
        System.out.println("Pila Vacía Original (Antes de clonar): ¿Está vacía? " + emptyOriginal.isEmpty());

        DoublyLinkedStack<Integer> clonedEmpty = emptyOriginal.clone();
        System.out.println("Clonación de pila vacía realizada.");

        System.out.println("-> ¿Original Vacía y Clon Vacía son la misma instancia? " + (emptyOriginal == clonedEmpty)); // Esperado: false
        System.out.println("Pila Vacía Clonada (Después de clonar): ¿Está vacía? " + clonedEmpty.isEmpty()); // Esperado: true

        // Modificar el clon vacío
        clonedEmpty.push(2024);
        System.out.println("Pila Clonada (antes vacía, después de push(2024)): Tamaño: " + clonedEmpty.size() + ", Tope: " + clonedEmpty.top());
        System.out.println("Pila Vacía Original (Después de modificar su clon): ¿Está vacía? " + emptyOriginal.isEmpty()); // Esperado: true


        // Test 3: Clonar una pila con un solo elemento
        //--------------------------------------------------
        System.out.println("\n--- Test 3: Pila con un solo elemento ---");
        DoublyLinkedStack<Character> singleOriginal = new DoublyLinkedStack<>();
        singleOriginal.push('X');
        System.out.println("Pila Único Elemento Original (Antes de clonar): Tamaño: " + singleOriginal.size() + ", Tope: " + singleOriginal.top());

        DoublyLinkedStack<Character> clonedSingle = singleOriginal.clone();
        System.out.println("Clonación de pila con un solo elemento realizada.");

        System.out.println("-> ¿Original Único y Clon Único son la misma instancia? " + (singleOriginal == clonedSingle)); // Esperado: false
        System.out.println("Pila Clonada Único (Después de clonar): Tamaño: " + clonedSingle.size() + ", Tope: " + clonedSingle.top());
        boolean topElementsEqualTest3 = (singleOriginal.isEmpty() && clonedSingle.isEmpty()) ||
                                   (!singleOriginal.isEmpty() && !clonedSingle.isEmpty() && singleOriginal.top().equals(clonedSingle.top()));
        System.out.println("-> ¿Tamaño igual y topes iguales (si existen)? " + (singleOriginal.size() == clonedSingle.size() && topElementsEqualTest3)); // Esperado: true


        // Modificar el original
        singleOriginal.pop(); // Original ahora está vacía
        singleOriginal.push('Y');
        System.out.println("Pila Original Único (Después de pop() y push('Y')): Tamaño: " + singleOriginal.size() + ", Tope: " + singleOriginal.top());

        System.out.println("Pila Clonada Único (Después de modificar el original):"); // No debe cambiar por la mod del original
        System.out.println("  Tamaño: " + clonedSingle.size() + ", Tope: " + clonedSingle.top());
        System.out.println("-> ¿Pila Clonada Único sin cambios? " + (clonedSingle.size() == 1 && clonedSingle.top().equals('X'))); // Esperado: true


        System.out.println("\n=== Pruebas de Clonación para DoublyLinkedStack Completadas ===");
    }
}