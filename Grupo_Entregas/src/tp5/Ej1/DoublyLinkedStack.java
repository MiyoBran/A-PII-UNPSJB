package tp5.Ej1;


import net.datastructures.*;

public class DoublyLinkedStack<E> implements Stack<E> {

    private DoublyLinkedList<E> list = new DoublyLinkedList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addLast(e);
    }

    @Override
    public E top() {
        return list.last();
    }

    @Override
    public E pop() {
        return list.removeLast();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
