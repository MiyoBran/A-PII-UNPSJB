package ej01StackPerformance;

import net.datastructures.Stack;

public class StackPerformanceTest {
    
    public static void main(String[] args) {
        // Crear las tres implementaciones de pilas
        Stack<Integer> arrayStack = new ArrayStack<>();
        Stack<Integer> linkedStack = new LinkedStack<>();
        Stack<Integer> doublyLinkedStack = new DoublyLinkedStack<>();
        
        System.out.println("Midiendo rendimiento para operaciones de pila en diferentes implementaciones");
        System.out.println("========================================================================");
        
        // Número de operaciones para realizar las pruebas
        int numOperations = 1000000;
        
        // Prueba para ArrayStack
        long startTime = System.nanoTime();
        testStackOperations(arrayStack, numOperations);
        long endTime = System.nanoTime();
        System.out.println("Tiempo para ArrayStack: " + (endTime - startTime) / 1000000.0 + " ms");
        
        // Prueba para LinkedStack
        startTime = System.nanoTime();
        testStackOperations(linkedStack, numOperations);
        endTime = System.nanoTime();
        System.out.println("Tiempo para LinkedStack: " + (endTime - startTime) / 1000000.0 + " ms");
        
        // Prueba para DoublyLinkedStack
        startTime = System.nanoTime();
        testStackOperations(doublyLinkedStack, numOperations);
        endTime = System.nanoTime();
        System.out.println("Tiempo para DoublyLinkedStack: " + (endTime - startTime) / 1000000.0 + " ms");
        
        // Prueba más detallada para cada operación
        System.out.println("\nMidiendo cada operación por separado:");
        System.out.println("=====================================");
        
        measurePushOperation(arrayStack, linkedStack, doublyLinkedStack, numOperations/10);
        measureTopOperation(arrayStack, linkedStack, doublyLinkedStack, numOperations/10);
        measurePopOperation(arrayStack, linkedStack, doublyLinkedStack, numOperations/10);
    }
    
    private static void testStackOperations(Stack<Integer> stack, int n) {
        // Primero hacemos push de n elementos
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        
        // Luego consultamos el tope n veces
        for (int i = 0; i < n; i++) {
            stack.top();
        }
        
        // Finalmente, hacemos pop de todos los elementos
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
    }
    
    private static void measurePushOperation(Stack<Integer> arrayStack, Stack<Integer> linkedStack, 
                                           Stack<Integer> doublyLinkedStack, int n) {
        System.out.println("\nOperación PUSH (" + n + " operaciones):");
        
        // Limpiar pilas primero
        while (!arrayStack.isEmpty()) arrayStack.pop();
        while (!linkedStack.isEmpty()) linkedStack.pop();
        while (!doublyLinkedStack.isEmpty()) doublyLinkedStack.pop();
        
        // Medir ArrayStack push
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayStack.push(i);
        }
        long endTime = System.nanoTime();
        System.out.println("  ArrayStack: " + (endTime - startTime) / 1000000.0 + " ms");
        
        // Medir LinkedStack push
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedStack.push(i);
        }
        endTime = System.nanoTime();
        System.out.println("  LinkedStack: " + (endTime - startTime) / 1000000.0 + " ms");
        
        // Medir DoublyLinkedStack push
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            doublyLinkedStack.push(i);
        }
        endTime = System.nanoTime();
        System.out.println("  DoublyLinkedStack: " + (endTime - startTime) / 1000000.0 + " ms");
    }
    
    private static void measureTopOperation(Stack<Integer> arrayStack, Stack<Integer> linkedStack, 
                                          Stack<Integer> doublyLinkedStack, int n) {
        System.out.println("\nOperación TOP (" + n + " operaciones):");
        
        // Medir ArrayStack top
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayStack.top();
        }
        long endTime = System.nanoTime();
        System.out.println("  ArrayStack: " + (endTime - startTime) / 1000000.0 + " ms");
        
        // Medir LinkedStack top
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedStack.top();
        }
        endTime = System.nanoTime();
        System.out.println("  LinkedStack: " + (endTime - startTime) / 1000000.0 + " ms");
        
        // Medir DoublyLinkedStack top
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            doublyLinkedStack.top();
        }
        endTime = System.nanoTime();
        System.out.println("  DoublyLinkedStack: " + (endTime - startTime) / 1000000.0 + " ms");
    }
    
    private static void measurePopOperation(Stack<Integer> arrayStack, Stack<Integer> linkedStack, 
                                          Stack<Integer> doublyLinkedStack, int n) {
        System.out.println("\nOperación POP (" + n + " operaciones):");
        
        // Asegurarse de que hay suficientes elementos para hacer pop
        for (int i = 0; i < n; i++) {
            arrayStack.push(i);
            linkedStack.push(i);
            doublyLinkedStack.push(i);
        }
        
        // Medir ArrayStack pop
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayStack.pop();
        }
        long endTime = System.nanoTime();
        System.out.println("  ArrayStack: " + (endTime - startTime) / 1000000.0 + " ms");
        
        // Medir LinkedStack pop
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedStack.pop();
        }
        endTime = System.nanoTime();
        System.out.println("  LinkedStack: " + (endTime - startTime) / 1000000.0 + " ms");
        
        // Medir DoublyLinkedStack pop
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            doublyLinkedStack.pop();
        }
        endTime = System.nanoTime();
        System.out.println("  DoublyLinkedStack: " + (endTime - startTime) / 1000000.0 + " ms");
    }
}