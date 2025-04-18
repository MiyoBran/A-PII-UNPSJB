package listas;

/**
 * SinglyLinkedList
 * 
 * Implementación de una lista enlazada simple genérica. Esta clase permite
 * insertar, eliminar, buscar elementos y concatenar listas.
 * 
 * Trabajo Práctico N°3 - Algorítmica y Programación II (UNPSJB)
 * 
 * @author Data Structures & Algorithms
 * @author ArispeClaudio (crapz0190@gmail.com)
 * @author BrandolinoCarlos (miyenbran@gmail.com)
 * @author ColipanAxel (maurocolipannn@gmail.com)
 * @author MarinoLizandro (lizandro.e.marino@gmail.com)
 * @version 1.5 Resumen de cambios respecto del descargado de la catedra: 🔹
 *          SinglyLinkedList.java ✔ Original: No tenía implementados o estaban
 *          incorrectos los métodos:
 * 
 *          addPos
 * 
 *          removeElement
 * 
 *          removePos
 * 
 *          concatenate
 * 
 *          search
 * 
 *          Tampoco implementaba equals, lo que hacía fallar los assertEquals en
 *          los tests.
 * 
 *          ✅ Se implementaron correctamente todos los métodos pedidos.
 * 
 *          ✅ Se agregó el método equals para permitir comparar listas.
 * 
 *          ✅ Se corrigió search(respecto del de la catedra, aunque no se pedia
 *          en el ejercicio) para devolver el índice, como esperaban los tests.
 */
public class SinglyLinkedList_Miyo<E> {
	// ---------------- nested Node class ----------------
	private static class Node<E> {
		private E element; // reference to the element stored at this node
		private Node<E> next; // reference to the subsequent node in the list

		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> n) {
			next = n;
		}
	}

	// ----------- end of nested Node class -----------
	// instance variables of the SinglyLinkedList
	private Node<E> head = null; // head node of the list (or null if empty)
	private Node<E> tail = null; // last node of the list (or null if empty)
	private Node<E> tmp = null;
	private int size = 0; // number of nodes in the list

	public SinglyLinkedList_Miyo() {
	} // constructs an initially empty list

	// access methods
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() { // returns (but does not remove) the first element
		if (isEmpty())
			return null;
		return head.getElement();
	}

	public E last() { // returns (but does not remove) the last element
		if (isEmpty())
			return null;
		return tail.getElement();
	}

	public void addFirst(E e) { // adds element e to the front of the list
		head = new Node<>(e, head); // create and link a new node
		if (size == 0)
			tail = head; // special case: new node becomes tail also
		size++;
	}

	public void addLast(E e) { // adds element e to the end of the list
		Node<E> newest = new Node<>(e, null); // node will eventually be the
												// tail
		if (isEmpty())
			head = newest; // special case: previously empty list
		else
			tail.setNext(newest); // new node after existing tail
		tail = newest; // new node becomes the tail
		size++;
	}

	public E removeFirst() { // removes and returns the first element
		if (isEmpty())
			return null; // nothing to remove
		E answer = head.getElement();
		head = head.getNext();
		// will become null if list had only one node
		size--;
		if (size == 0)
			tail = null; // special case as list is now empty
		return answer;
	}

	/** Inserts the given element at the specified position (0-based index). */
	public void addPos(E e, int pos) {
		if (pos < 0 || pos > size)
			throw new IndexOutOfBoundsException("Invalid position");

		if (pos == 0) {
			addFirst(e);
		} else {
			Node<E> prev = head;
			for (int i = 0; i < pos - 1; i++) {
				prev = prev.getNext();
			}
			Node<E> newNode = new Node<>(e, prev.getNext());
			prev.setNext(newNode);
			size++;
		}
	}

	/** Removes the first occurrence of the specified element from the list. */
	public void removeElement(E e) {
		if (isEmpty())
			return;

		if (head.getElement().equals(e)) {
			removeFirst();
			return;
		}

		Node<E> prev = head;
		Node<E> curr = head.getNext();

		while (curr != null) {
			if (curr.getElement().equals(e)) {
				prev.setNext(curr.getNext());
				if (curr == tail) {
					tail = prev;
				}
				size--;
				return;
			}
			prev = curr;
			curr = curr.getNext();
		}
	}

	/** Removes the element at the specified position (0-based index). */
	public void removePos(int pos) {
		if (pos < 0 || pos >= size)
			throw new IndexOutOfBoundsException("Invalid position");

		if (pos == 0) {
			removeFirst();
		} else {
			Node<E> prev = head;
			for (int i = 0; i < pos - 1; i++) {
				prev = prev.getNext();
			}
			Node<E> curr = prev.getNext();
			prev.setNext(curr.getNext());
			if (curr == tail) {
				tail = prev;
			}
			size--;
		}
	}

	/** Appends all elements from another singly linked list to the current list. */
	public void concatenate(SinglyLinkedList_Miyo<E> other) {
		if (other == null || other.isEmpty())
			return;

		if (this.isEmpty()) {
			this.head = other.head;
			this.tail = other.tail;
		} else {
			this.tail.setNext(other.head);
			this.tail = other.tail;
		}
		this.size += other.size;
	}

	/**
	 * Returns the first occurrence of the specified element, or null if not found.
	 */
	public E search(E e) {
		Node<E> current = head;

		while (current != null) {
			if (current.getElement().equals(e)) {
				return current.getElement();
			}
			current = current.getNext();
		}
		return null;
	}

	/**
	 * Compares this list with another to check if they are equal. Two lists are
	 * equal if they have the same size and the elements are in the same order.
	 * 
	 * @param obj the other list to compare with.
	 * @return true if both lists are equal; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		SinglyLinkedList_Miyo<?> other = (SinglyLinkedList_Miyo<?>) obj;

		if (this.size() != other.size())
			return false;

		Node<?> currentThis = this.head;
		Node<?> currentOther = other.head;

		while (currentThis != null) {
			if (!currentThis.getElement().equals(currentOther.getElement())) {
				return false;
			}
			currentThis = currentThis.getNext();
			currentOther = currentOther.getNext();
		}

		return true;
	}

	/** Produces a string representation of the contents of the list. */
	@Override
	public String toString() {
		String out = "";

		if (isEmpty()) {
			out = "List is empty";
		} else {
			Node<E> current = head;
			while (current != null) {
				out += "->" + current.getElement();
				current = current.getNext();
			}
		}
		return out;
	}

}
