package tp2.Conjunto;

import java.util.Scanner;

/**
 * Clase de prueba para TP2 EJ6 que interactúa con ConjuntoEnteros.
 * Permite al usuario insertar, eliminar y comparar conjuntos.
 *
 * @author MiyenBrandolino
 * @version 2.0
 */
public class PruebaConjuntoEnteros {
    public static void main(String[] args) {
        Scanner entradaUsuario = new Scanner(System.in);
        ConjuntoEnteros conjunto1 = new ConjuntoEnteros();
        ConjuntoEnteros conjunto2 = new ConjuntoEnteros();

        // Agregar elementos al Conjunto 1
        System.out.println("Ingrese números entre 0 y 100 para agregar al conjunto 1 (-1 para terminar):");
        while (true) {
            System.out.print("Ingrese un número: ");
            while (!entradaUsuario.hasNextInt()) {
                System.out.print("Entrada inválida. Por favor ingrese un entero: ");
                entradaUsuario.next();
            }
            int num = entradaUsuario.nextInt();
            if (num == -1) break; // Condición de parada
            if (num >= 0 && num <= 100) {
                conjunto1.insertarElemento(num);
            } else {
                System.out.println("Número fuera de rango. Por favor ingrese un número entre 0 y 100.");
            }
        }

        // Mostrar conjunto actual
        System.out.println("\nConjunto 1 Actual: " + conjunto1.toSetString());

        // Bloque de eliminación de elementos para Conjunto 1
        System.out.print("¿Desea eliminar números del conjunto 1? (si/no): ");
        String respuesta = entradaUsuario.next();
        if (respuesta.equalsIgnoreCase("si")) {
            System.out.println("Ingrese números a eliminar (-1 para terminar):");
            while (true) {
                System.out.print("Ingrese un número: ");
                while (!entradaUsuario.hasNextInt()) {
                    System.out.print("Entrada inválida. Por favor ingrese un entero: ");
                    entradaUsuario.next();
                }
                int numEliminar = entradaUsuario.nextInt();
                if (numEliminar == -1) break; // Condición de parada
                
                if (numEliminar >= 0 && numEliminar <= 100) {
                    // Verificar si el número está en el conjunto
                    boolean estaEnConjunto = false;
                    for (int i = 0; i <= 100; i++) {
                        if (i == numEliminar && conjunto1.toSetString().contains(Integer.toString(i))) {
                            estaEnConjunto = true;
                            break;
                        }
                    }
                    
                    if (estaEnConjunto) {
                        conjunto1.eliminarElemento(numEliminar);
                        System.out.println("El número " + numEliminar + " ha sido eliminado del conjunto.");
                    } else {
                        System.out.println("El número " + numEliminar + " no está en el conjunto.");
                    }
                } else {
                    System.out.println("Número fuera de rango. Por favor ingrese un número entre 0 y 100.");
                }
            }
            
            // Mostrar conjunto actualizado
            System.out.println("\nConjunto 1 Actualizado: " + conjunto1.toSetString());
        }

        // Agregar elementos al Conjunto 2
        System.out.println("\nAgregando elementos al Conjunto 2. Ingrese números entre 0 y 100 (-1 para terminar):");
        while (true) {
            System.out.print("Ingrese un número: ");
            while (!entradaUsuario.hasNextInt()) {
                System.out.print("Entrada inválida. Por favor ingrese un entero: ");
                entradaUsuario.next();
            }
            int num = entradaUsuario.nextInt();
            if (num == -1) break; // Condición de parada
            if (num >= 0 && num <= 100) {
                conjunto2.insertarElemento(num);
            } else {
                System.out.println("Número fuera de rango. Por favor ingrese un número entre 0 y 100.");
            }
        }
        
        // Mostrar conjunto 2 actual
        System.out.println("\nConjunto 2 Actual: " + conjunto2.toSetString());
        
        // Bloque de eliminación de elementos para Conjunto 2
        System.out.print("¿Desea eliminar números del conjunto 2? (si/no): ");
        respuesta = entradaUsuario.next();
        if (respuesta.equalsIgnoreCase("si")) {
            System.out.println("Ingrese números a eliminar (-1 para terminar):");
            while (true) {
                System.out.print("Ingrese un número: ");
                while (!entradaUsuario.hasNextInt()) {
                    System.out.print("Entrada inválida. Por favor ingrese un entero: ");
                    entradaUsuario.next();
                }
                int numEliminar = entradaUsuario.nextInt();
                if (numEliminar == -1) break; // Condición de parada
                
                if (numEliminar >= 0 && numEliminar <= 100) {
                    // Verificar si el número está en el conjunto
                    boolean estaEnConjunto = false;
                    for (int i = 0; i <= 100; i++) {
                        if (i == numEliminar && conjunto2.toSetString().contains(Integer.toString(i))) {
                            estaEnConjunto = true;
                            break;
                        }
                    }
                    
                    if (estaEnConjunto) {
                        conjunto2.eliminarElemento(numEliminar);
                        System.out.println("El número " + numEliminar + " ha sido eliminado del conjunto.");
                    } else {
                        System.out.println("El número " + numEliminar + " no está en el conjunto.");
                    }
                } else {
                    System.out.println("Número fuera de rango. Por favor ingrese un número entre 0 y 100.");
                }
            }
            
            // Mostrar conjunto actualizado
            System.out.println("\nConjunto 2 Actualizado: " + conjunto2.toSetString());
        }

        // Mostrar resultados finales
        System.out.println("\n=== Resultados Finales ===");
        System.out.println("Conjunto 1: " + conjunto1.toSetString());
        System.out.println("Conjunto 2: " + conjunto2.toSetString());
        System.out.println("Unión de Conjunto 1 y Conjunto 2: " + conjunto1.union(conjunto2).toSetString());
        System.out.println("Intersección de Conjunto 1 y Conjunto 2: " + conjunto1.interseccion(conjunto2).toSetString());
        System.out.println("Diferencia (Conjunto1 - Conjunto2): " + conjunto1.diferencia(conjunto2).toSetString());
        System.out.println("¿Son ambos conjuntos iguales? " + conjunto1.equals(conjunto2));

        entradaUsuario.close();
    }
}