package singly_linked_list;

/**
 * TestSinglyLinkedList
 * 
 * Clase de pruebas unitarias básicas para SinglyLinkedList. Verifica la
 * funcionalidad general de la estructura.
 * 
 * Trabajo Práctico N°3 - Algorítmica y Programación II (UNPSJB)
 * 
 * @author ALGII
 */
public class TestSinglyLinkedList {
	/** Simple main method for testing the Caesar cipher */
	public static void main(String[] args) {
		SinglyLinkedList<String> Lista1 = new SinglyLinkedList<String>();
		System.out.println("Lista vacia?: " + Lista1.isEmpty());
		Lista1.addLast("abc");
		System.out.println("Lista vacia?: " + Lista1.isEmpty());
		System.out.println("Cardinalidad Lista: " + Lista1.size());
		System.out.println("Lista primero: " + Lista1.first());
		System.out.println("Lista ultimo: " + Lista1.last());
		Lista1.addLast("xyz");
		System.out.println("Lista vacia?: " + Lista1.isEmpty());
		System.out.println("Cardinalidad Lista: " + Lista1.size());
		System.out.println("Lista primero: " + Lista1.first());
		System.out.println("Lista ultimo: " + Lista1.last());
		Lista1.addFirst("lmn");
		System.out.println("Lista vacia?: " + Lista1.isEmpty());
		System.out.println("Cardinalidad Lista: " + Lista1.size());
		System.out.println("Lista primero: " + Lista1.first());
		System.out.println("Lista ultimo: " + Lista1.last());
		System.out.println("Listado de la lista:" + Lista1);

	}
}
