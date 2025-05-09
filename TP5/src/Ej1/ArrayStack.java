package Ej1;

import java.util.Arrays;

import net.datastructures.Stack;

public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 256;  // Capacidad por defecto
    private E[] data;                        // Arreglo para almacenar elementos
    private int t = -1;                      // Índice para el tope de la pila
    private int capacity;                    // Capacidad máxima actual

    public ArrayStack() { this(CAPACITY); }  // Constructor con capacidad por defecto

    @SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() { return t + 1; }

    @Override
    public boolean isEmpty() { return t == -1; }

    @Override
    public void push(E e) {
        if (size() == capacity) {
            resize(2 * capacity);  // Duplicar tamaño si está lleno
        }
        data[++t] = e;
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E answer = data[t];
        data[t] = null;  // Para ayudar al garbage collector
        t--;
        return answer;
    }

    // Método auxiliar para redimensionar el arreglo
    private void resize(int newCapacity) {
        data = Arrays.copyOf(data, newCapacity);
        capacity = newCapacity;
    }
}