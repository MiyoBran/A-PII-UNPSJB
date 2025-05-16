package ej09ArrayCirucular_Deque;

import net.datastructures.Deque;

/**
 * Trabajo Práctico N°5 - Algorítmica y Programación II (UNPSJB) Una
 * implementacion de un deque utilizando un arreglo circular.
 * 
 * @author ArispeClaudio (crapz0190@gmail.com)
 * @author BrandolinoCarlos (miyenbran@gmail.com)
 * @author ColipanAxel (maurocolipannn@gmail.com)
 * @author MarinoLizandro (lizandro.e.marino@gmail.com)
 * @version 1.0
 */

public class ArrayCircularDeque<E> implements Deque<E> {
	// instance variables
	/** Default array capacity. */
	public static final int CAPACITY = 1000;

	/** Generic array used for storage of queue elements. */
	private E data[];

	/** Index of the top element of the queue in the array. */
	private int front = 0;

	/** Current number of elements in the queue. */
	private int size = 0;

	// constructors
	/**
	 * Default constructor that creates a deque with the default capacity
	 */
	public ArrayCircularDeque() {
		this(CAPACITY);
	}

	/**
	 * Constructs and empty queue with the given array capacity or the default one.
	 * 
	 * @param capacity length of the array
	 */
	@SuppressWarnings("unchecked")
	public ArrayCircularDeque(int capacity) {
		if (capacity <= 0) {
			data = (E[]) new Object[CAPACITY];
		} else {
			data = (E[]) new Object[capacity];
		}
	}

	// methods
	/**
	 * Returns the number of elements in the deque.
	 * 
	 * @return the number of elements in the deque
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Checks if the deque is empty.
	 * 
	 * @return true if the deque is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns the first element of the deque without removing it.
	 * 
	 * @return the first element, or null if the deque is empty
	 */
	@Override
	public E first() {
		if (isEmpty() == true) {
			return null;
		}
		return data[front];
	}

	/**
	 * Returns the last element of the deque without removing it.
	 * 
	 * @return the last element, or null if the deque is empty
	 */
	@Override
	public E last() {
		if (isEmpty() == true) {
			return null;
		}
		// Línea original comentada:
		// int rear = (front - 1 + data.length) % data.length;
		// Línea corregida:
		int rear = (front + size - 1 + data.length) % data.length;
		return data[rear];
	}

	/**
	 * Adds an element to the front of the deque.
	 * 
	 * @param e the element to be added
	 * @throws IllegalStateException if the deque is full
	 */
	@Override
	public void addFirst(E e) throws IllegalStateException {
		if (size == data.length) {
			throw new IllegalStateException("Queue is full");
		}
		front = (front - 1 + data.length) % data.length;
		data[front] = e;
		size++;
	}

	/**
	 * Adds an element to the end of the deque.
	 * 
	 * @param e the element to be added
	 * @throws IllegalStateException if the deque is full (cambiado para
	 *                               consistencia)
	 */
	@Override
	public void addLast(E e) throws IllegalStateException { // Añadir throws IllegalStateException a la firma
		// Comportamiento original comentado:
		// if (size == data.length) {
		// return; // Retornaba silenciosamente
		// }
		// Comportamiento corregido (consistente con addFirst):
		if (size == data.length) {
			throw new IllegalStateException("Deque is full");
		}
		int rear = (front + size) % data.length; // El cálculo del índice para inserción estaba bien
		data[rear] = e;
		size++;
	}

	/**
	 * Removes and returns the first element of the deque.
	 * 
	 * @return the removed element, or null if the deque is empty
	 */
	@Override
	public E removeFirst() {
		if (isEmpty() == true) {
			return null;
		}
		E removedItem = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		size--;
		return removedItem;
	}

	/**
	 * Removes and returns the last element of the deque.
	 *
	 * @return the removed element, or null if the deque is empty
	 */
	@Override
	public E removeLast() {
		if (isEmpty() == true) {
			return null;
		}
		// Línea original comentada:
		// int rear = (front - 1 + size) % data.length;
		// Línea corregida:
		int rear = (front + size - 1 + data.length) % data.length;
		E removedItem = data[rear];
		data[rear] = null; // Ayuda al recolector de basura
		size--;

		return removedItem;
	}

	/**
	 * Returns a string representation of the deque.
	 * 
	 * @return a string representation of the deque
	 */
	@Override
	public String toString() {
		StringBuilder stringReturn = new StringBuilder();

		for (int i = 0; i < size; i++) {
			int index = (front + i) % data.length;
			stringReturn.append(data[index]);
			if (i < size - 1) {
				stringReturn.append(", ");
			}
		}
		return stringReturn.toString();
	}
}
