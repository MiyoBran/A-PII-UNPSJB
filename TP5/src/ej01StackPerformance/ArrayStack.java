package ej01StackPerformance;

import java.util.Arrays;

import net.datastructures.Stack;

public class ArrayStack<E> implements Stack<E>, Cloneable { // PASO 1: Implementar Cloneable
	public static final int CAPACITY = 256; // Capacidad por defecto
	private E[] data; // Arreglo para almacenar elementos
	private int t = -1; // Índice para el tope de la pila
	private int capacity; // Capacidad máxima actual

	public ArrayStack() {
		this(CAPACITY);
	} // Constructor con capacidad por defecto

	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		this.capacity = capacity;
		data = (E[]) new Object[capacity];// Crear el arreglo con la capacidad dada
	}

	@Override
	public int size() {
		return t + 1;
	}

	@Override
	public boolean isEmpty() {
		return t == -1;
	}

	@Override
	public void push(E e) {
		if (size() == capacity) {
			resize(2 * capacity); // Duplicar tamaño si está lleno
		}
		data[++t] = e;
	}

	@Override
	public E top() {
		if (isEmpty())
			return null;
		return data[t];
	}

	@Override
	public E pop() {
		if (isEmpty())
			return null;
		E answer = data[t];
		data[t] = null; // Para ayudar al garbage collector
		t--;
		return answer;
	}

	// Método auxiliar para redimensionar el arreglo
	private void resize(int newCapacity) {
		data = Arrays.copyOf(data, newCapacity);
		capacity = newCapacity;
	}

	// PASO 2: Sobrescribir el método clone()
	@Override
	@SuppressWarnings("unchecked") // Para el cast de super.clone() y para data.clone()
	public ArrayStack<E> clone() {
		try {
			// PASO 3: Llamar a super.clone() para la copia superficial
			ArrayStack<E> clonedStack = (ArrayStack<E>) super.clone();

			// PASO 4: Realizar la copia profunda del arreglo 'data'
			// El arreglo 'data' en clonedStack debe ser una nueva instancia,
			// no una referencia al mismo arreglo que la pila original.
			// El método clone() de un arreglo crea una copia del arreglo.
			// Los elementos E dentro del arreglo serán las mismas referencias que en el
			// original
			// (esto es una copia superficial de los elementos E, pero profunda de la
			// estructura del arreglo).
			if (this.data != null) { // Comprobación por si data fuera null (aunque no debería con el constructor)
				clonedStack.data = this.data.clone();
			}
			// Los campos 't' y 'capacity' son de tipo primitivo (int),
			// por lo que super.clone() ya los ha copiado correctamente por valor.

			return clonedStack;
		} catch (CloneNotSupportedException e) {
			// PASO 5: Manejar CloneNotSupportedException
			// Esto no debería suceder si la clase implementa Cloneable
			// y no hay clases padres que no la soporten y anulen clone() de forma extraña.
			throw new AssertionError("La clonación no está soportada para ArrayStack, pero Cloneable está implementada",
					e);
		}
	}

}