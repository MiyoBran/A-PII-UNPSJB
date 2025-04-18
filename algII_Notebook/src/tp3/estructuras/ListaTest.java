package tp3.estructuras;

/**
 * Clase para probar el funcionamiento de la implementación de Lista.
 * Verifica cada uno de los métodos que provee la clase Lista.
 * 
 * @author Estudiante
 * @version 1.0
 */
public class ListaTest {
    
    /**
     * Método principal que realiza pruebas de todas las funcionalidades
     * de la clase Lista.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        System.out.println("Prueba de la clase Lista\n");
        
        // Crear una lista con capacidad para 5 elementos
        Lista<String> lista = new Lista<>(5);
        System.out.println("Lista creada con capacidad 5");
        System.out.println("Lista vacía: " + lista.isEmpty());
        System.out.println("Tamaño inicial: " + lista.size());
        System.out.println("Contenido inicial: " + lista);
        
        // Prueba de add(E e)
        System.out.println("\nPrueba de add(E e):");
        lista.add("A");
        lista.add("B");
        lista.add("C");
        System.out.println("Después de agregar A, B, C: " + lista);
        System.out.println("Tamaño: " + lista.size());
        System.out.println("¿Está vacía? " + lista.isEmpty());
        
        // Prueba de add(int p, E e)
        System.out.println("\nPrueba de add(int p, E e):");
        lista.add(1, "X");
        System.out.println("Después de agregar X en posición 1: " + lista);
        lista.add(0, "Y");
        System.out.println("Después de agregar Y en posición 0: " + lista);
        
        // Prueba de get(int p)
        System.out.println("\nPrueba de get(int p):");
        System.out.println("Elemento en posición 0: " + lista.get(0));
        System.out.println("Elemento en posición 2: " + lista.get(2));
        System.out.println("Elemento en posición 4: " + lista.get(4));
        
        // Prueba de remove(E e)
        System.out.println("\nPrueba de remove(E e):");
        String removido1 = lista.remove("X");
        System.out.println("Elemento removido: " + removido1);
        System.out.println("Lista después de remover X: " + lista);
        
        String removido2 = lista.remove("Z");
        System.out.println("Intentar remover elemento inexistente Z: " + removido2);
        System.out.println("Lista sin cambios: " + lista);
        
        // Prueba de remove(int p)
        System.out.println("\nPrueba de remove(int p):");
        String removido3 = lista.remove(0);
        System.out.println("Elemento removido de posición 0: " + removido3);
        System.out.println("Lista después de remover elemento en posición 0: " + lista);
        
        // Prueba de límites y excepciones
        System.out.println("\nPrueba de límites y excepciones:");
        try {
            lista.add("D");
            lista.add("E");
            System.out.println("Lista llena: " + lista);
            
            System.out.println("Intentando agregar un elemento más...");
            lista.add("F"); // Debería lanzar excepción
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Excepción capturada al intentar agregar a lista llena: " + e.getMessage());
        }
        
        try {
            System.out.println("Intentando acceder a una posición inválida...");
            lista.get(10); // Debería lanzar excepción
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Excepción capturada al acceder a posición inválida: " + e.getMessage());
        }
        
        try {
            System.out.println("Intentando insertar en una posición inválida...");
            lista.add(-1, "Z"); // Debería lanzar excepción
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Excepción capturada al insertar en posición inválida: " + e.getMessage());
        }
        
        try {
            System.out.println("Intentando eliminar de una posición inválida...");
            lista.remove(10); // Debería lanzar excepción
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Excepción capturada al eliminar de posición inválida: " + e.getMessage());
        }
        
        // Estado final
        System.out.println("\nEstado final de la lista:");
        System.out.println("Contenido: " + lista);
        System.out.println("Tamaño: " + lista.size());
    }
}