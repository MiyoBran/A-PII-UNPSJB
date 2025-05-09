// Ahora implementamos la pila basada en lista enlazada simple
package Ej1;

import net.datastructures.SinglyLinkedList;
import net.datastructures.Stack;

public class LinkedStack<E> implements Stack<E> {
    private SinglyLinkedList<E> list ;
    
 // Constructor explícito
    public LinkedStack() {
        list = new SinglyLinkedList<>();
    }

    @Override
    public int size() { return list.size(); }

    @Override
    public boolean isEmpty() { return list.isEmpty(); }

    @Override
    public void push(E e) { list.addFirst(e); }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return list.first();
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        return list.removeFirst();
    }
}