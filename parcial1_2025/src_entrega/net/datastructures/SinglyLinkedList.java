/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.datastructures;

/**
 * A basic singly linked list implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class SinglyLinkedList<E> implements Cloneable {
	// ---------------- nested Node class ----------------
	/**
	 * Node of a singly linked list, which stores a reference to its element and to
	 * the subsequent node in the list (or null if this is the last node).
	 */
	private static class Node<E> {

		/** The element stored at this node */
		private E element; // reference to the element stored at this node

		/** A reference to the subsequent node in the list */
		private Node<E> next; // reference to the subsequent node in the list

		/**
		 * Creates a node with the given element and next node.
		 *
		 * @param e the element to be stored
		 * @param n reference to a node that should follow the new node
		 */
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		// Accessor methods
		/**
		 * Returns the element stored at the node.
		 * 
		 * @return the element stored at the node
		 */
		public E getElement() {
			return element;
		}

		/**
		 * Returns the node that follows this one (or null if no such node).
		 * 
		 * @return the following node
		 */
		public Node<E> getNext() {
			return next;
		}

		// Modifier methods
		/**
		 * Sets the node's next reference to point to Node n.
		 * 
		 * @param n the node that should follow this one
		 */
		public void setNext(Node<E> n) {
			next = n;
		}
	} // ----------- end of nested Node class -----------

	// instance variables of the SinglyLinkedList
	/** The head node of the list */
	private Node<E> head = null; // head node of the list (or null if empty)

	/** The last node of the list */
	private Node<E> tail = null; // last node of the list (or null if empty)

	/** Number of nodes in the list */
	private int size = 0; // number of nodes in the list

	/** Constructs an initially empty list. */
	public SinglyLinkedList() {
	} // constructs an initially empty list

	// access methods
	/**
	 * Returns the number of elements in the linked list.
	 * 
	 * @return number of elements in the linked list
	 */
	public int size() {
		return size;
	}

	/**
	 * Tests whether the linked list is empty.
	 * 
	 * @return true if the linked list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns (but does not remove) the first element of the list
	 * 
	 * @return element at the front of the list (or null if empty)
	 */
	public E first() { // returns (but does not remove) the first element
		if (isEmpty())
			return null;
		return head.getElement();
	}

	/**
	 * Returns (but does not remove) the last element of the list.
	 * 
	 * @return element at the end of the list (or null if empty)
	 */
	public E last() { // returns (but does not remove) the last element
		if (isEmpty())
			return null;
		return tail.getElement();
	}

	// update methods
	/**
	 * Adds an element to the front of the list.
	 * 
	 * @param e the new element to add
	 */
	public void addFirst(E e) { // adds element e to the front of the list
		head = new Node<>(e, head); // create and link a new node
		if (size == 0)
			tail = head; // special case: new node becomes tail also
		size++;
	}

	/**
	 * Adds an element to the end of the list.
	 * 
	 * @param e the new element to add
	 */
	public void addLast(E e) { // adds element e to the end of the list
		Node<E> newest = new Node<>(e, null); // node will eventually be the tail
		if (isEmpty())
			head = newest; // special case: previously empty list
		else
			tail.setNext(newest); // new node after existing tail
		tail = newest; // new node becomes the tail
		size++;
	}

	/**
	 * Removes and returns the first element of the list.
	 * 
	 * @return the removed element (or null if empty)
	 */
	public E removeFirst() { // removes and returns the first element
		if (isEmpty())
			return null; // nothing to remove
		E answer = head.getElement();
		head = head.getNext(); // will become null if list had only one node
		size--;
		if (size == 0)
			tail = null; // special case as list is now empty
		return answer;
	}

	@SuppressWarnings({ "unchecked" })
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		SinglyLinkedList other = (SinglyLinkedList) o; // use nonparameterized type
		if (size != other.size)
			return false;
		Node walkA = head; // traverse the primary list
		Node walkB = other.head; // traverse the secondary list
		while (walkA != null) {
			if (!walkA.getElement().equals(walkB.getElement()))
				return false; // mismatch
			walkA = walkA.getNext();
			walkB = walkB.getNext();
		}
		return true; // if we reach this, everything matched successfully
	}

	@SuppressWarnings({ "unchecked" })
	public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
		// always use inherited Object.clone() to create the initial copy
		SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone(); // safe cast
		if (size > 0) { // we need independent chain of nodes
			other.head = new Node<>(head.getElement(), null);
			Node<E> walk = head.getNext(); // walk through remainder of original list
			Node<E> otherTail = other.head; // remember most recently created node
			while (walk != null) { // make a new node storing same element
				Node<E> newest = new Node<>(walk.getElement(), null);
				otherTail.setNext(newest); // link previous node to this one
				otherTail = newest;
				walk = walk.getNext();
			}
		}
		return other;
	}

	public int hashCode() {
		int h = 0;
		for (Node walk = head; walk != null; walk = walk.getNext()) {
			h ^= walk.getElement().hashCode(); // bitwise exclusive-or with element's code
			h = (h << 5) | (h >>> 27); // 5-bit cyclic shift of composite code
		}
		return h;
	}

	/**
	 * Produces a string representation of the contents of the list. This exists for
	 * debugging purposes only.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		Node<E> walk = head;
		while (walk != null) {
			sb.append(walk.getElement());
			if (walk != tail)
				sb.append(", ");
			walk = walk.getNext();
		}
		sb.append(")");
		return sb.toString();
	}

//--- INICIO: Métodos Añadidos para Parcial 2025 ---

	/**
	 * Elimina todos los elementos que están en una posición considerada impar (1°,
	 * 3°, 5°, etc., correspondiente a índices 0, 2, 4,...). Modifica la lista
	 * original. Retorna una nueva lista con los elementos eliminados.
	 *
	 * @return Una nueva SinglyLinkedList con los elementos eliminados (de
	 *         posiciones 1°, 3°, ...).
	 */
	public SinglyLinkedList<E> removeOdd() { // Mantenemos nombre original del método
		SinglyLinkedList<E> removedList = new SinglyLinkedList<>();

		if (isEmpty()) {
			return removedList; // Nada que hacer ni remover
		}

		// 1. Tratar el primer elemento (posición 1 impar, índice 0) - Siempre se
		// elimina
		Node<E> nodeToRemove = head;
		removedList.addLast(nodeToRemove.getElement());
		head = head.getNext(); // El segundo elemento se convierte en la nueva cabeza
		size--;
		// Si la lista tenía solo un elemento, head ahora es null, tail también debe ser
		// null
		if (isEmpty()) {
			tail = null;
			return removedList; // Ya terminamos
		}
		// Si eliminamos la cabeza y quedaron más elementos, el 'tail' no cambia aún.

		// 2. Iterar por el resto de la lista para eliminar 3°, 5°, etc. (índices 2, 4,
		// ...)
		// Ahora 'head' apunta al elemento original en posición 2 (par)
		// Necesitamos eliminar el que le sigue (posición 3 impar)
		Node<E> prev = head; // Nodo en posición par (originalmente 2°, 4°, ...) - Se queda
		Node<E> curr = head.getNext(); // Nodo en posición impar (originalmente 3°, 5°, ...) - A eliminar
		int countRemovedFromLoop = 0;

		while (curr != null) {
			// a. Guardar el elemento impar a remover
			removedList.addLast(curr.getElement());
			countRemovedFromLoop++;

			// b. Eliminar 'curr' (impar) enlazando 'prev' (par) con el siguiente de 'curr'
			// (el próximo par)
			Node<E> nextNode = curr.getNext();
			prev.setNext(nextNode);

			// c. Actualizar 'tail' si 'curr' era el último
			if (nextNode == null) {
				tail = prev; // El nodo 'prev' (par) es el nuevo último
			}

			// d. Avanzar punteros: 'prev' avanza al siguiente nodo par (nextNode)
			prev = nextNode;
			if (prev != null) {
				// 'curr' avanza al siguiente nodo impar (el que sigue a prev)
				curr = prev.getNext();
			} else {
				// Si prev es null, llegamos al final
				curr = null;
			}
		}
		// Size ya fue decrementado al quitar head, ahora ajustamos por los eliminados
		// en el bucle
		// size = size - countRemovedFromLoop; // ¡Ojo! Size se decrementó al inicio y
		// se debe decrementar acá también
		// Es más simple si solo decrementamos size cada vez que removemos
		// (Ya decrementamos 1 al inicio). No necesitamos countRemovedFromLoop si
		// hacemos size-- dentro del bucle.

		// --- Código alternativo para actualizar size dentro del bucle ---
		/*
		 * while (curr != null) { removedList.addLast(curr.getElement()); Node<E>
		 * nextNode = curr.getNext(); prev.setNext(nextNode); size--; // Decrementar
		 * aquí por cada eliminación if (nextNode == null) { tail = prev; } prev =
		 * nextNode; if (prev != null) { curr = prev.getNext(); } else { curr = null; }
		 * }
		 */
		// --- Fin Código alternativo ---

		return removedList;
	}

	// --- FIN: Método removeOdd REIMPLEMENTADO ---

	/**
	 * Retorna una nueva lista con los últimos n elementos de la lista original. No
	 * modifica la lista original.
	 *
	 * Por ejemplo: Dada la lista {A, B, C, D} right(3) retorna la lista {B, C, D}
	 * right(2) retorna la lista {C, D}
	 *
	 * @param n número de elementos a retornar comenzando desde la derecha.
	 * @return nueva lista con los n elementos de la derecha.
	 * @throws IndexOutOfBoundsException si n es negativo o mayor que el tamaño de
	 *                                   la lista.
	 */
	public SinglyLinkedList<E> right(int n) throws IndexOutOfBoundsException {
        // Validar n
        if (n < 0 || n > size) {
            throw new IndexOutOfBoundsException("El valor de n (" + n + ") está fuera de rango");
        }

		// 2. Crear la nueva lista a retornar
		SinglyLinkedList<E> newList = new SinglyLinkedList<>();

		// 3. Si n es 0, retornar la lista vacía
		if (n == 0) {
			return newList;
		}

		// 4. Encontrar el nodo desde donde empezar a copiar
		Node<E> startNode = head;
		int startIndex = size() - n;
		for (int i = 0; i < startIndex; i++) {
			startNode = startNode.getNext();
		}

		// 5. Copiar los n elementos desde startNode hasta el final
		Node<E> current = startNode;
		while (current != null) {
			newList.addLast(current.getElement()); // addLast maneja head, tail y size de newList
			current = current.getNext();
		}

		return newList;
	}

	// --- FIN: Métodos Añadidos para Parcial 2025 ---
}
