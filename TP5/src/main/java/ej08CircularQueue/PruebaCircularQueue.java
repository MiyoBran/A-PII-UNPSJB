package ej08CircularQueue;

import net.datastructures.CircularQueue;

/**
 * Clase de prueba para verificar la implementación de ArrayCircularQueue.
 * Demuestra todas las operaciones importantes y muestra el estado de la cola
 * después de cada operación.
 */
public class PruebaCircularQueue {
    
    public static void main(String[] args) {
        // Crear una cola circular con capacidad inicial de 5
        CircularQueue<String> queue = new ArrayCircularQueue<>(5);
        
        System.out.println("========== PRUEBA DE ARRAYCIRCULARQUEUE ==========");
        
        // Probar enqueue
        testEnqueue(queue);
        
        // Probar first
        testFirst(queue);
        
        // Probar rotate
        testRotate(queue);
        
        // Probar dequeue
        testDequeue(queue);
        
        // Probar el redimensionamiento (crecimiento)
        testResizeGrow(queue);
        
        // Probar el redimensionamiento (reducción)
        testResizeShrink(queue);
        
        // Probar casos límite
        testEdgeCases();
        
        // Prueba de rendimiento
        testPerformance();
    }
    
    
    /**
     * Prueba la operación enqueue.
     */
    private static void testEnqueue(CircularQueue<String> queue) {
        System.out.println("\n----- Prueba de enqueue -----");
        System.out.println("Estado inicial: " + queueToString(queue));
        
        queue.enqueue("A");
        System.out.println("Después de enqueue(\"A\"): " + queueToString(queue));
        
        queue.enqueue("B");
        System.out.println("Después de enqueue(\"B\"): " + queueToString(queue));
        
        queue.enqueue("C");
        System.out.println("Después de enqueue(\"C\"): " + queueToString(queue));
        
        queue.enqueue("D");
        System.out.println("Después de enqueue(\"D\"): " + queueToString(queue));
        
        queue.enqueue("E");
        System.out.println("Después de enqueue(\"E\"): " + queueToString(queue));
    }
    
    /**
     * Prueba la operación first.
     */
    private static void testFirst(CircularQueue<String> queue) {
        System.out.println("\n----- Prueba de first -----");
        System.out.println("Estado actual: " + queueToString(queue));
        System.out.println("Primer elemento (first): " + queue.first());
        System.out.println("La cola no cambia: " + queueToString(queue));
    }
    
    /**
     * Prueba la operación rotate.
     */
    private static void testRotate(CircularQueue<String> queue) {
        System.out.println("\n----- Prueba de rotate -----");
        System.out.println("Estado antes de rotate: " + queueToString(queue));
        
        queue.rotate();
        System.out.println("Después de 1 rotate: " + queueToString(queue));
        
        queue.rotate();
        System.out.println("Después de 2 rotates: " + queueToString(queue));
        
        queue.rotate();
        System.out.println("Después de 3 rotates: " + queueToString(queue));
    }
    
    /**
     * Prueba la operación dequeue.
     */
    private static void testDequeue(CircularQueue<String> queue) {
        System.out.println("\n----- Prueba de dequeue -----");
        System.out.println("Estado inicial: " + queueToString(queue));
        
        String removed1 = queue.dequeue();
        System.out.println("dequeue(): " + removed1 + " - Cola: " + queueToString(queue));
        
        String removed2 = queue.dequeue();
        System.out.println("dequeue(): " + removed2 + " - Cola: " + queueToString(queue));
    }
    
    /**
     * Prueba el redimensionamiento (crecimiento) de la cola.
     */
    private static void testResizeGrow(CircularQueue<String> queue) {
        System.out.println("\n----- Prueba de redimensionamiento (crecimiento) -----");
        System.out.println("Estado inicial: " + queueToString(queue));
        
        // Llenar la cola para provocar un redimensionamiento
        for (char ch = 'F'; ch <= 'K'; ch++) {
            queue.enqueue(String.valueOf(ch));
            System.out.println("Después de enqueue(\"" + ch + "\"): " + queueToString(queue));
        }
    }
    
    /**
     * Prueba el redimensionamiento (reducción) de la cola.
     */
    private static void testResizeShrink(CircularQueue<String> queue) {
        System.out.println("\n----- Prueba de redimensionamiento (reducción) -----");
        System.out.println("Estado inicial: " + queueToString(queue));
        
        // Remover elementos para provocar una reducción
        System.out.println("Eliminando elementos para provocar reducción:");
        while (queue.size() > 2) {
            String removed = queue.dequeue();
            System.out.println("dequeue(): " + removed + " - Cola: " + queueToString(queue));
        }
    }
    
    /**
     * Prueba casos límite como cola vacía.
     */
    private static void testEdgeCases() {
        System.out.println("\n----- Prueba de casos límite -----");
        
        CircularQueue<Integer> emptyQueue = new ArrayCircularQueue<>();
        System.out.println("Cola vacía: " + queueToString(emptyQueue));
        
        System.out.println("first() en cola vacía: " + emptyQueue.first());
        System.out.println("dequeue() en cola vacía: " + emptyQueue.dequeue());
        
        System.out.println("Haciendo rotate() en cola vacía...");
        emptyQueue.rotate();
        System.out.println("Después de rotate(): " + queueToString(emptyQueue));
        
        System.out.println("\nProbando una secuencia de operaciones:");
        emptyQueue.enqueue(100);
        System.out.println("Después de enqueue(100): " + queueToString(emptyQueue));
        
        emptyQueue.dequeue();
        System.out.println("Después de dequeue(): " + queueToString(emptyQueue));
        
        emptyQueue.enqueue(200);
        emptyQueue.enqueue(300);
        System.out.println("Después de enqueue(200) y enqueue(300): " + queueToString(emptyQueue));
        
        emptyQueue.rotate();
        System.out.println("Después de rotate(): " + queueToString(emptyQueue));
    }
    
    /**
     * Prueba de rendimiento para la cola circular.
     */
    private static void testPerformance() {
        System.out.println("\n----- Prueba de rendimiento -----");
        
        int n = 1000000;
        CircularQueue<Integer> queue = new ArrayCircularQueue<>();
        
        System.out.println("Realizando " + n + " operaciones enqueue...");
        long startEnqueue = System.nanoTime();
        for (int i = 0; i < n; i++) {
            queue.enqueue(i);
        }
        long endEnqueue = System.nanoTime();
        System.out.println("Tiempo para " + n + " enqueues: " + 
                          ((endEnqueue - startEnqueue) / 1000000.0) + " ms");
        
        System.out.println("\nRealizando " + n + " operaciones rotate...");
        long startRotate = System.nanoTime();
        for (int i = 0; i < n; i++) {
            queue.rotate();
        }
        long endRotate = System.nanoTime();
        System.out.println("Tiempo para " + n + " rotates: " + 
                          ((endRotate - startRotate) / 1000000.0) + " ms");
        
        System.out.println("\nRealizando " + n + " operaciones dequeue...");
        long startDequeue = System.nanoTime();
        for (int i = 0; i < n; i++) {
            queue.dequeue();
        }
        long endDequeue = System.nanoTime();
        System.out.println("Tiempo para " + n + " dequeues: " + 
                          ((endDequeue - startDequeue) / 1000000.0) + " ms");
    }
    
    /**
     * Método auxiliar para convertir una cola a una representación de cadena.
     * Este método preserva el estado original de la cola.
     */
    private static <E> String queueToString(CircularQueue<E> queue) {
        if (queue.isEmpty()) {
            return "Cola[vacía], tamaño = 0";
        }
        
        StringBuilder sb = new StringBuilder("Cola[");
        
        // Crear una copia temporal para no modificar la cola original
        CircularQueue<E> temp = new ArrayCircularQueue<>(queue.size());
        StringBuilder elements = new StringBuilder();
        int originalSize = queue.size();
        
        // Extraer elementos, mostrarlos y guardarlos en la cola temporal
        for (int i = 0; i < originalSize; i++) {
            E element = queue.dequeue();
            if (i > 0) elements.append(", ");
            elements.append(element);
            temp.enqueue(element);
        }
        
        // Restaurar la cola original
        for (int i = 0; i < originalSize; i++) {
            queue.enqueue(temp.dequeue());
        }
        
        sb.append(elements).append("], tamaño = ").append(originalSize);
        return sb.toString();
    }
}