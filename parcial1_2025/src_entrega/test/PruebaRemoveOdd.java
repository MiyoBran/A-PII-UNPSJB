package test; // O el paquete que estés usando para las pruebas

// Asegúrate de que el paquete coincida con donde está tu SinglyLinkedList
import net.datastructures.SinglyLinkedList;

/**
 * Prueba el método removeOdd() de la clase SinglyLinkedList.
 */
public class PruebaRemoveOdd {

    public static void main(String[] args) {
        System.out.println("--- Pruebas para removeOdd() ---");
        prueba1(); // {A, B, C, D}
        prueba2(); // {A, B, C}
        prueba3(); // {A, B}
        prueba4(); // {A}
        prueba5(); // {}
    }

    // Helper para crear y probar una lista
    private static void probarCasoRemoveOdd(String[] elementosIniciales) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        for (String s : elementosIniciales) {
            list.addLast(s);
        }
        System.out.print("Original: " + list);

        SinglyLinkedList<String> removed = list.removeOdd();

        System.out.println(" -> Retorno: " + list);
        System.out.println("-------------------------------------");
    }

    public static void prueba1() {
        System.out.println("Caso 1:");
        probarCasoRemoveOdd(new String[]{"A", "B", "C", "D"});
        // Esperado: Modificada: (A, C) (Size: 2), Eliminados: (B, D) (Size: 2)
    }

    public static void prueba2() {
        System.out.println("Caso 2:");
        probarCasoRemoveOdd(new String[]{"A", "B", "C"});
        // Esperado: Modificada: (A, C) (Size: 2), Eliminados: (B) (Size: 1)
    }

    public static void prueba3() {
        System.out.println("Caso 3:");
        probarCasoRemoveOdd(new String[]{"A", "B"});
        // Esperado: Modificada: (A) (Size: 1), Eliminados: (B) (Size: 1)
    }

    public static void prueba4() {
        System.out.println("Caso 4:");
        probarCasoRemoveOdd(new String[]{"A"});
        // Esperado: Modificada: (A) (Size: 1), Eliminados: () (Size: 0)
    }

    public static void prueba5() {
        System.out.println("Caso 5: {}");
        probarCasoRemoveOdd(new String[]{});
        // Esperado: Modificada: () (Size: 0), Eliminados: () (Size: 0)
    }
}