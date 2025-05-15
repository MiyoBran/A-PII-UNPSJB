package ej1StackPerformance;

public class PruebaClonArrayStack {
	// --- Método main de ejemplo para probar clone() ---
	public static void main(String[] args) {
		ArrayStack<String> originalStack = new ArrayStack<>(5);
		originalStack.push("Primero");
		originalStack.push("Segundo");
		originalStack.push("Tercero");

		System.out.println("Pila Original (antes de clonar):");
		System.out.println("Tamaño: " + originalStack.size());
		System.out.println("Tope: " + originalStack.top());
		System.out.println("Contenido (pop):");
		// Para ver el contenido sin modificarla para la prueba de clon, podríamos
		// iterar una copia temporal.
		// Pero para simplicidad, mostraremos el estado.

		ArrayStack<String> clonedStack = originalStack.clone();

		System.out.println("\nPila Clonada:");
		System.out.println("Tamaño: " + clonedStack.size());
		System.out.println("Tope: " + clonedStack.top());

		// Modificar la pila clonada
		clonedStack.push("Cuarto");
		clonedStack.pop(); // Quita "Cuarto"
		clonedStack.pop(); // Quita "Tercero"

		System.out.println("\nPila Clonada (después de modificarla):");
		System.out.println("Tamaño: " + clonedStack.size()); // Debería ser 2
		System.out.println("Tope: " + clonedStack.top());

		System.out.println("\nPila Original (después de modificar la clonada):");
		System.out.println("Tamaño: " + originalStack.size()); // Debería seguir siendo 3
		System.out.println("Tope: " + originalStack.top()); 

		// Verificación de que los arreglos 'data' son instancias diferentes
		System.out.println("\n¿Los arreglos 'data' son la misma instancia? ");

		System.out.println("\nPila Clonada (después de modificarla):");
		System.out.println("Tamaño: " + clonedStack.size()); 
		System.out.println("Tope: " + clonedStack.top()); // Debería ser el elemento esperado después de las mods

		System.out.println("\nPila Original (después de modificar la clonada):");
		System.out.println("Tamaño: " + originalStack.size()); // Debería seguir siendo el tamaño original
		System.out.println("Tope: " + originalStack.top()); // Debería seguir siendo el tope original

		// Verificación de que los elementos (si son el mismo objeto) son el mismo
		// inicialmente
		if (!originalStack.isEmpty() && !clonedStack.isEmpty()) {
			// Si clonamos "data", las referencias a los Strings dentro son copiadas.
			// Como String es inmutable, esto es seguro.
			System.out.println("¿El elemento tope es la misma instancia de String (antes de modificar clon)? "
					+ (originalStack.top() == clonedStack.top()));
			//Comentando las modificaciones, devuelve True

		}
	}

}
