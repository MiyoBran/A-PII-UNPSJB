package tp5.Ej8;

import net.datastructures.CircularQueue;

/**
 * Trabajo Práctico N°5 - Algorítmica y Programación II (UNPSJB)
 * Implementación de una cola circular utilizando un arreglo.
 * Esta implementación mantiene dos índices: 
 * - front: indica dónde está el primer elemento de la cola
 * - rear: indica dónde se insertará el próximo elemento
 * 
 * La estructura utiliza un arreglo circular para aprovechar eficientemente el espacio
 * y permitir operaciones de enqueue, dequeue y rotate en tiempo O(1).
 * 
 *  @author ArispeClaudio (crapz0190@gmail.com)
 *  @author BrandolinoCarlos (miyenbran@gmail.com)
 *  @author ColipanAxel (maurocolipannn@gmail.com)
 *  @author MarinoLizandro (lizandro.e.marino@gmail.com)
 *  @version 1.0
 */
public class ArrayCircularQueue<E> implements CircularQueue<E> {
    
    // Capacidad por defecto del arreglo
    private static final int DEFAULT_CAPACITY = 10;
    
    // Arreglo para almacenar los elementos
    private E[] data;
    
    // Índice del elemento frontal (primero) de la cola
    private int front = 0;
    
    // Tamaño actual de la cola
    private int size = 0;
    
    // Capacidad máxima actual
    private int capacity;
    
    /**
     * Constructor con la capacidad por defecto.
     */
    public ArrayCircularQueue() {
        this(DEFAULT_CAPACITY);
    }
    
    /**
     * Constructor con una capacidad específica.
     * 
     * @param capacity la capacidad inicial del arreglo
     */
    @SuppressWarnings("unchecked")
    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
    }

    /**
     * Devuelve el número de elementos en la cola.
     * 
     * @return número de elementos en la cola
     */
    @Override
    public int size() {
        return size;
    }
    
    
    /**
     * Verifica si la cola está vacía.
     * 
     * @return true si la cola está vacía, false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Inserta un elemento al final de la cola.
     * Si la cola está llena, la capacidad se duplica.
     * 
     * @param e el elemento a insertar
     */
    @Override
    public void enqueue(E e) {
        if (size == capacity) {
            resize(2 * capacity); // Duplicar el tamaño cuando está lleno
        }
        
        int availableIndex = (front + size) % capacity;
        data[availableIndex] = e;
        size++;
    }

    /**
     * Devuelve, pero no elimina, el primer elemento de la cola.
     * 
     * @return el primer elemento de la cola, o null si está vacía
     */
    @Override
    public E first() {
        if (isEmpty()) return null;
        return data[front];
    }

    /**
     * Elimina y devuelve el primer elemento de la cola.
     * Si la cola queda con un cuarto de su capacidad o menos, 
     * se reduce el tamaño a la mitad para ahorrar espacio.
     * 
     * @return el elemento eliminado, o null si la cola está vacía
     */
    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        
        E answer = data[front];
        data[front] = null; // Ayuda al garbage collector
        
        front = (front + 1) % capacity;
        size--;
        
        // Reducir el tamaño del arreglo si es necesario
        if (size > 0 && size <= capacity / 4) {
            resize(capacity / 2);
        }
        
        return answer;
    }
    /**
     * Rota el elemento frontal de la cola al final.
     * Esta operación no hace nada si la cola está vacía.
     */
    @Override
    public void rotate() {
        if (isEmpty()) return;
        
        // Implementación eficiente aprovechando la estructura circular
        E temp = data[front];
        data[front] = null; // Ayuda al garbage collector
        
        front = (front + 1) % capacity;
        
        // Calcular el índice donde se insertará el elemento (al final)
        int rear = (front + size - 1) % capacity;
        data[rear] = temp;
    }
    
    /**
     * Método auxiliar para redimensionar el arreglo.
     * Crea un nuevo arreglo con la capacidad especificada y copia los elementos.
     * 
     * @param newCapacity la nueva capacidad del arreglo
     */
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] temp = (E[]) new Object[newCapacity];
        
        for (int i = 0; i < size; i++) {
            temp[i] = data[(front + i) % capacity];
        }
        
        data = temp;
        front = 0; // Reiniciar el índice frontal
        capacity = newCapacity;
    }

}
