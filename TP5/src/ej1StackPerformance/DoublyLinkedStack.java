package ej1StackPerformance;

import net.datastructures.DoublyLinkedList;

import net.datastructures.Stack;


public class DoublyLinkedStack<E> implements Stack<E>, Cloneable  {

    private DoublyLinkedList<E> list;
	

	public DoublyLinkedStack() {
		list = new DoublyLinkedList<>();
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
	
	// Implemento clon() en la clase DoublyLinkedStack<E>
    @Override
    @SuppressWarnings("unchecked") // Para el cast de super.clone()
    public DoublyLinkedStack<E> clone() {
        DoublyLinkedStack<E> clonedStack;
        try {
            // 1. Realiza una copia superficial de DoublyLinkedStack.
            //    Los campos primitivos se copian. El campo 'list' en clonedStack
            //    inicialmente apuntará a la misma instancia que this.list.
            clonedStack = (DoublyLinkedStack<E>) super.clone();
        } catch (CloneNotSupportedException e) {
            // Esto no debería ocurrir porque DoublyLinkedStack implementa Cloneable.
            throw new AssertionError("Cloning no está soportado para DoublyLinkedStack, pero Cloneable está implementada", e);
        }

        // 2. Realiza una "copia profunda" de la lista interna 'list'.
        //    Dado que DoublyLinkedList (según el código provisto) no tiene su propio
        //    método clone() ni es Iterable de forma estándar, debemos hacerlo manualmente.
        clonedStack.list = new DoublyLinkedList<>(); // El clon obtiene su propia instancia de lista.

        if (this.list != null && !this.list.isEmpty()) {
            // Estrategia para copiar los elementos:
            // a. Extraer todos los elementos de this.list y almacenarlos temporalmente.
            //    Como la pila opera sobre el final de la lista (addLast, removeLast),
            //    extraeremos los elementos desde el tope de la pila (final de la lista)
            //    para mantener el orden lógico de la pila.
            // b. this.list quedará vacía temporalmente.
            // c. Reconstruir this.list original y construir clonedStack.list
            //    añadiendo los elementos en el orden correcto (base primero, tope al final).

            java.util.ArrayList<E> elementsInStackOrder = new java.util.ArrayList<>(this.list.size());

            // a. Extraer elementos de this.list desde el tope (final de la lista)
            //    y guardarlos en 'elementsInStackOrder'.
            //    Si la pila original era (base) A, B, C (tope),
            //    elementsInStackOrder contendrá [C, B, A].
            while (!this.list.isEmpty()) {
                elementsInStackOrder.add(this.list.removeLast());
            }

            // b. Ahora this.list está vacía.
            //    elementsInStackOrder tiene los elementos en orden: [tope, ..., base].

            // c. Reconstruir this.list y construir clonedStack.list.
            //    Iteramos 'elementsInStackOrder' en orden inverso para obtener
            //    los elementos en el orden original de inserción (base primero).
            //    Ej: Si elementsInStackOrder es [C, B, A], este bucle procesará A, luego B, luego C.
            for (int i = elementsInStackOrder.size() - 1; i >= 0; i--) {
                E element = elementsInStackOrder.get(i);
                this.list.addLast(element);          // Restaura el elemento en la lista original.
                clonedStack.list.addLast(element);   // Añade el elemento a la lista del clon.
            }
            // Al final, this.list se restaura a su estado original (A, B, C).
            // clonedStack.list es una nueva lista con el mismo contenido (A, B, C).
        }
        // Si this.list era null o estaba vacía, clonedStack.list ya es una nueva lista vacía,
        // lo cual es correcto.

        return clonedStack;
    }
}
