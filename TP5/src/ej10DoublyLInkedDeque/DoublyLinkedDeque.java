package ej10DoublyLInkedDeque;

import net.datastructures.Deque;
import net.datastructures.DoublyLinkedList;

/**
 *  Trabajo Práctico N°5 - Algorítmica y Programación II (UNPSJB)
 *  Una implementacion de un deque utilizando una lista doblemente enlazada.
 * 
 *  @author ArispeClaudio (crapz0190@gmail.com)
 *  @author BrandolinoCarlos (miyenbran@gmail.com)
 *  @author ColipanAxel (maurocolipannn@gmail.com)
 *  @author MarinoLizandro (lizandro.e.marino@gmail.com)
 *  @version 1.0
 */

public class DoublyLinkedDeque<E> implements Deque<E> {
    // instance variables
    /** The doubly linked list used to store elements as a double-ended queue */
    private DoublyLinkedList<E> dequeue = new DoublyLinkedList<>();

    // constructor
    /**
    * Constructs an empty DoublyLinkedDeque.
    */
    public DoublyLinkedDeque() {}

    /** 
    * methods
    * @see DoublyLinkedList for the specifics of each method called
    /**
    * Returns the number of elements in the deque.
    * @return number of elements in the deque
    */
    @Override
    public int size() {
        return dequeue.size();
    }

    /**
    * Checks whether the deque is empty.
    * @return true if the deque is empty, false otherwise
    */
    @Override
    public boolean isEmpty() {
        return dequeue.isEmpty();
    }

    /**
    * Returns (but does not remove) the first element of the deque.
    * @return the first element, or null if the deque is empty
    */
    @Override
    public E first() {
        return dequeue.first();
    }

    /**
    * Returns (but does not remove) the last element of the deque.
    * @return the last element, or null if the deque is empty
    */
    @Override
    public E last() {
        return dequeue.last();
    }

    /**
    * Inserts an element at the front of the deque.
    * @param e the element to insert
    */
    @Override
    public void addFirst(E e) {
        dequeue.addFirst(e);
    }

    /**
    * Inserts an element at the back of the deque.
    * @param e the element to insert
    */
    @Override
    public void addLast(E e) {
        dequeue.addLast(e);
    }

    /**
    * Removes and returns the first element of the deque.
    * @return the removed element, or null if the deque is empty
    */
    @Override
    public E removeFirst() {
        return dequeue.removeFirst();
    }

    /**
    * Removes and returns the last element of the deque.
    * @return the removed element, or null if the deque is empty
    */
    @Override
    public E removeLast() {
        return dequeue.removeLast();
    }
    
    /**
    * Returns a string representation of the deque's contents.
    * @return string representation of the deque
    */
    @Override
    public String toString() {
        return dequeue.toString();
    }
}
