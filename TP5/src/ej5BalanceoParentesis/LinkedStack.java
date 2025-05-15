// Ahora implementamos la pila basada en lista enlazada simple
package ej5BalanceoParentesis;




public class LinkedStack<E> implements Stack<E>, Cloneable { // Implemento Cloneable
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
    

    // --- Método clone corregido ---
    @Override
    @SuppressWarnings("unchecked") // Para el cast de super.clone()
    public LinkedStack<E> clone() {
        LinkedStack<E> clonedStack;
        try {
            // 1. Llama a super.clone() para obtener una copia superficial de LinkedStack.
            //    Los campos primitivos se copian. El campo 'list' en clonedStack
            //    inicialmente apuntará a la misma instancia que this.list.
            clonedStack = (LinkedStack<E>) super.clone();

            // 2. Clona la lista interna.
            //    Ahora que sabemos que SinglyLinkedList tiene su propio método clone(), lo usamos.
            //    Esto reemplazará la referencia en clonedStack.list con una referencia
            //    a una instancia completamente nueva de SinglyLinkedList, que a su vez
            //    contiene una nueva cadena de nodos, pero con referencias a los mismos elementos E.
            if (this.list != null) { // Buena práctica verificar, aunque el constructor la inicializa.
                clonedStack.list = this.list.clone();
            } else {
                clonedStack.list = new SinglyLinkedList<>(); // En caso de que this.list fuera null
            }

        } catch (CloneNotSupportedException e) {
            // Esta excepción podría ser lanzada teóricamente por super.clone()
            // o por this.list.clone(), si alguna de las clases no fuera Cloneable.
            // Dado que ambas lo son, esto no debería suceder en la práctica.
            throw new AssertionError("Clonación no soportada inesperadamente.", e);
        }
        return clonedStack;
    }
}