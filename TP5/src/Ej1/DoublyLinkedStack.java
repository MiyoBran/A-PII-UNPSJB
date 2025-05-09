package Ej1;

import net.datastructures.DoublyLinkedList;

import net.datastructures.Stack;


public class DoublyLinkedStack<E> implements Stack<E>  {

    private DoublyLinkedList<E> list;
	
	@SuppressWarnings("unchecked")
	public DoublyLinkedStack() {
		list = new DoublyLinkedList();
	}

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
		// TODO Auto-generated method stub
		if (isEmpty()) return null;
		return list.last();
	}

	@Override
	public E pop() {
		if (isEmpty()) return null;
		return list.removeLast();
	}
	
}
