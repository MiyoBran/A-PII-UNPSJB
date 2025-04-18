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
package listas;

/**
 * A basic singly linked list implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 
 * Trabajo Práctico N°3 - Algorítmica y Programación II (UNPSJB)
 * 
 * @author ArispeClaudio (crapz0190@gmail.com)
 * @author BrandolinoCarlos (miyenbran@gmail.com)
 * @author ColipanAxel (maurocolipannn@gmail.com)
 * @author MarinoLizandro (lizandro.e.marino@gmail.com)
 * @version 2.0
 */
public class SinglyLinkedList<E> implements Cloneable {
  //---------------- nested Node class ----------------
  /**
   * Node of a singly linked list, which stores a reference to its
   * element and to the subsequent node in the list (or null if this
   * is the last node).
   */
  private static class Node<E> {

    /** The element stored at this node */
    private E element;            // reference to the element stored at this node

    /** A reference to the subsequent node in the list */
    private Node<E> next;         // reference to the subsequent node in the list

    /**
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param n  reference to a node that should follow the new node
     */
    public Node(E e, Node<E> n) {
      element = e;
      next = n;
    }

    // Accessor methods
    /**
     * Returns the element stored at the node.
     * @return the element stored at the node
     */
    public E getElement() { return element; }

    /**
     * Returns the node that follows this one (or null if no such node).
     * @return the following node
     */
    public Node<E> getNext() { return next; }

    // Modifier methods
    /**
     * Sets the node's next reference to point to Node n.
     * @param n    the node that should follow this one
     */
    public void setNext(Node<E> n) { next = n; }
  } //----------- end of nested Node class -----------

  // instance variables of the SinglyLinkedList
  /** The head node of the list */
  private Node<E> head = null;               // head node of the list (or null if empty)

  /** The last node of the list */
  private Node<E> tail = null;               // last node of the list (or null if empty)

  /** Number of nodes in the list */
  private int size = 0;                      // number of nodes in the list

  /** Constructs an initially empty list. */
  public SinglyLinkedList() { }              // constructs an initially empty list

  // access methods
  /**
   * Returns the number of elements in the linked list.
   * @return number of elements in the linked list
   */
  public int size() { return size; }

  /**
   * Tests whether the linked list is empty.
   * @return true if the linked list is empty, false otherwise
   */
  public boolean isEmpty() { return size == 0; }

  /**
   * Returns (but does not remove) the first element of the list
   * @return element at the front of the list (or null if empty)
   */
  public E first() {             // returns (but does not remove) the first element
    if (isEmpty()) return null;
    return head.getElement();
  }

  /**
   * Returns (but does not remove) the last element of the list.
   * @return element at the end of the list (or null if empty)
   */
  public E last() {              // returns (but does not remove) the last element
    if (isEmpty()) return null;
    return tail.getElement();
  }

  // update methods
  /**
   * Adds an element to the front of the list.
   * @param e  the new element to add
   */
  public void addFirst(E e) {                // adds element e to the front of the list
    head = new Node<>(e, head);              // create and link a new node
    if (size == 0)
      tail = head;                           // special case: new node becomes tail also
    size++;
  }

  /**
   * Adds an element to the end of the list.
   * @param e  the new element to add
   */
  public void addLast(E e) {                 // adds element e to the end of the list
    Node<E> newest = new Node<>(e, null);    // node will eventually be the tail
    if (isEmpty())
      head = newest;                         // special case: previously empty list
    else
      tail.setNext(newest);                  // new node after existing tail
    tail = newest;                           // new node becomes the tail
    size++;
  }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * Adds an element at the specified position in the list.
 * 
 * This method inserts the provided element at the specified position in the list.
 * If the position is 0, the element is added to the front of the list.
 * If the position is equal to the size of the list, the element is added at the end.
 * 
 * The method updates the size of the list and manages the tail reference
 * if the new element is added at the end.
 * 
 * @param data     the element to be added to the list
 * @param position the position where the element should be inserted (0-based index)
 * @throws IndexOutOfBoundsException if the position is negative or greater than the size of the list
 */
public void addPos(E data, int position) throws IndexOutOfBoundsException {
  if (position < 0 || position > size) {
    throw new IndexOutOfBoundsException("Position out of range");
  }
  Node<E> newest = new Node<>(data, null);

  if (position == 0) {
    addFirst(data);
  } else {
    Node<E> currentNode = head;
    Node<E> previousNode = null;

    for (int i = 0; i < position; i++) {
      previousNode = currentNode;
      currentNode = currentNode.getNext();
    }
    previousNode.setNext(newest);
    newest.setNext(currentNode);
    size++;
  }

  if (newest.getNext() == null) {
    tail = newest;
  }
}

/**
 * Removes and returns the element at the specified position in the list.
 * 
 * This method removes the element at the specified position from the list
 * and returns the removed element. If the position is 0, the first element
 * is removed using the {@code removeFirst()} method.
 * 
 * The method updates the size of the list after removal.
 * 
 * @param position the position of the element to be removed (0-based index)
 * @return the element that was removed from the list
 * @throws IndexOutOfBoundsException if the position is negative or greater than or equal to the size of the list
 */
public E removePos(int position) throws IndexOutOfBoundsException {
  if (position < 0 || position >= size) {
    throw new IndexOutOfBoundsException("Position out of range");
  }
  Node<E> currentNode = this.head;
  Node<E> previousNode = null;
  E deletedElement = null;

  if (position == 0) {
    return removeFirst();
  } else {
    for (int i = 0; i < position; i++) {
      previousNode = currentNode;
      currentNode = currentNode.getNext();
    }
    deletedElement = currentNode.getElement();
    previousNode.setNext(currentNode.getNext());
  }

  this.size--;
  return deletedElement;
}

/**
 * Removes and returns the first occurrence of the specified element from the list.
 * 
 * This method searches for the specified element in the list and removes its
 * first occurrence. If the element is the head of the list, the {@code removeFirst()}
 * method is used. The method properly updates the tail reference if the removed
 * element is at the end of the list.
 * 
 * The size of the list is decreased by one if the element is found and removed.
 * 
 * @param data the element to be removed from the list
 * @return the removed element if found, or null if the element was not in the list
 */
public E removeElement(E data) {
  if (isEmpty()) {
    return null;
  }

  E deletedElement = null;
  Node<E> currentNode = head;
  Node<E> previousNode = null;

  if (head.getElement().equals(data)) {
    return removeFirst();
  }
  while (currentNode != null) {
    if (currentNode.getElement().equals(data)) {
      deletedElement = currentNode.getElement();
      previousNode.setNext(currentNode.getNext());
      if (currentNode == tail) {
        tail = previousNode;
      }
      size--;
      break;
    }
    previousNode = currentNode;
    currentNode = currentNode.getNext();
  }

  return deletedElement;
}

/**
 * Searches for the specified element in the list.
 * 
 * This method traverses the list looking for an element that equals
 * the provided data. If found, it returns the element.
 * 
 * @param data the element to search for in the list
 * @return the found element if it exists in the list, or null if not found
 */
public E search(E data) {
  if (isEmpty()) {
    return null;
  }
  E elementFound = null;
  Node<E> currentNode = head;
  while (currentNode != null) {
    if (currentNode.getElement().equals(data)) {
      elementFound = currentNode.getElement();
      break;
    }
    currentNode = currentNode.getNext();
  }
  return elementFound;
}

/**
 * Concatenates another list to the end of this list.
 * 
 * This method appends all elements from the provided list to the end of 
 * this list. If this list is empty, it becomes equivalent to the provided list.
 * If the provided list is empty, this list remains unchanged.
 * 
 * The operation updates the tail reference and size of this list accordingly.
 * 
 * @param list2 the list to be appended to the end of this list
 */
public void concatenate(SinglyLinkedList<E> list2) {
  if (list2.isEmpty()) {
    return;
  }
  if (this.isEmpty()) {
    this.head = list2.head;
    this.tail = list2.tail;
  } else {
    this.tail.setNext(list2.head);
    this.tail = list2.tail;
  }

  this.size += list2.size;
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


  /**
   * Removes and returns the first element of the list.
   * @return the removed element (or null if empty)
   */
  public E removeFirst() {                   // removes and returns the first element
    if (isEmpty()) return null;              // nothing to remove
    E answer = head.getElement();
    head = head.getNext();                   // will become null if list had only one node
    size--;
    if (size == 0)
      tail = null;                           // special case as list is now empty
    return answer;
  }

  @SuppressWarnings({"unchecked"})
  public boolean equals(Object o) {
    if (o == null) return false;
    if (getClass() != o.getClass()) return false;
    SinglyLinkedList other = (SinglyLinkedList) o;   // use nonparameterized type
    if (size != other.size) return false;
    Node walkA = head;                               // traverse the primary list
    Node walkB = other.head;                         // traverse the secondary list
    while (walkA != null) {
      if (!walkA.getElement().equals(walkB.getElement())) return false; //mismatch
      walkA = walkA.getNext();
      walkB = walkB.getNext();
    }
    return true;   // if we reach this, everything matched successfully
  }

  @SuppressWarnings({"unchecked"})
  public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
    // always use inherited Object.clone() to create the initial copy
    SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone(); // safe cast
    if (size > 0) {                    // we need independent chain of nodes
      other.head = new Node<>(head.getElement(), null);
      Node<E> walk = head.getNext();      // walk through remainder of original list
      Node<E> otherTail = other.head;     // remember most recently created node
      while (walk != null) {              // make a new node storing same element
        Node<E> newest = new Node<>(walk.getElement(), null);
        otherTail.setNext(newest);     // link previous node to this one
        otherTail = newest;
        walk = walk.getNext();
      }
    }
    return other;
  }

  public int hashCode() {
    int h = 0;
    for (Node walk=head; walk != null; walk = walk.getNext()) {
      h ^= walk.getElement().hashCode();      // bitwise exclusive-or with element's code
      h = (h << 5) | (h >>> 27);              // 5-bit cyclic shift of composite code
    }
    return h;
  }

  /**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
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
}
