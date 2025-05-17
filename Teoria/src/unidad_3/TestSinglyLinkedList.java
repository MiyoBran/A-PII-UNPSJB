package unidad_3;


public class TestSinglyLinkedList {
	  /** Simple main method for testing the Caesar cipher */
	  public static void main(String[] args) {
	    SinglyLinkedList<String> Lista1 = new SinglyLinkedList<String>();
	    System.out.println("Lista vac�a?: " + Lista1.isEmpty());
	    Lista1.addLast("abc");
	    System.out.println("Lista vac�a?: " + Lista1.isEmpty());
	    System.out.println("Cardinalidad Lista: " + Lista1.size());
	    System.out.println("Lista primero: " + Lista1.first());
	    System.out.println("Lista �ltimo: " + Lista1.last());
	    Lista1.addLast("xyz");
	    System.out.println("Lista vac�a?: " + Lista1.isEmpty());
	    System.out.println("Cardinalidad Lista: " + Lista1.size());
	    System.out.println("Lista primero: " + Lista1.first());
	    System.out.println("Lista �ltimo: " + Lista1.last());
	    Lista1.addFirst("lmn");
	    System.out.println("Lista vac�a?: " + Lista1.isEmpty());
	    System.out.println("Cardinalidad Lista: " + Lista1.size());
	    System.out.println("Lista primero: " + Lista1.first());
	    System.out.println("Lista �ltimo: " + Lista1.last());
	    System.out.println("Listado de la lista:"+Lista1);

	  }
}
