package conjunto;

public class TestConjunto {

    public static void main(String[] args) {
        try {
            // Prueba básica con conjuntos con algunos elementos en común
            Conjunto<Integer> c1 = new Conjunto<>(3);
            Conjunto<Integer> c2 = new Conjunto<>(4);

            c1.insertarElemento(10);
            c1.insertarElemento(20);
            c1.insertarElemento(30);

            c2.insertarElemento(20);
            c2.insertarElemento(30);
            c2.insertarElemento(40);
            c2.insertarElemento(10);

            System.out.println("Conjunto 1: " + c1);
            System.out.println("Conjunto 2: " + c2);

            System.out.println("Unión: " + c1.union(c2));
            System.out.println("Intersección: " + c1.interseccion(c2));

            if (c1.iguales(c2)) {
                System.out.println("Los conjuntos son equivalentes.");
            } else {
                System.out.println("Los conjuntos son distintos.");
            }

            // Prueba de duplicados
            System.out.println("\nIntentando insertar duplicado (20 en c1):");
            c1.insertarElemento(20);
            System.out.println("c1 luego del intento: " + c1);

            // Prueba de conjunto vacío
            Conjunto<Integer> vacio = new Conjunto<>(5);
            System.out.println("\nIntersección de c1 con conjunto vacío: " + c1.interseccion(vacio));
            System.out.println("Unión de c1 con conjunto vacío: " + c1.union(vacio));

            // Prueba de desbordamiento
            System.out.println("\nPrueba de desbordamiento:");
            Conjunto<Integer> limitado = new Conjunto<>(2);
            limitado.insertarElemento(1);
            limitado.insertarElemento(2);
            System.out.println("Insertando tercer elemento en conjunto de capacidad 2:");
            limitado.insertarElemento(3); // Esto lanza la excepción

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
