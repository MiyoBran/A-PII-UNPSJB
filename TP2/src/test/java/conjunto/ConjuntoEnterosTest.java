package conjunto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para la clase {@link ConjuntoEnteros}.
 * Verifica el constructor, inserción, eliminación, operaciones de conjunto (unión, intersección, diferencia),
 * y los métodos equals y toSetString.
 *
 * @author MiyoBran // O tu nombre de autor
 * @version 1.0
 */
public class ConjuntoEnterosTest {

    private ConjuntoEnteros conjuntoA;
    private ConjuntoEnteros conjuntoB;
    private ConjuntoEnteros conjuntoVacio;

    /**
     * Prepara instancias frescas de ConjuntoEnteros antes de cada prueba.
     */
    @BeforeEach
    public void setUp() {
        conjuntoA = new ConjuntoEnteros();
        conjuntoB = new ConjuntoEnteros();
        conjuntoVacio = new ConjuntoEnteros(); // Un conjunto que siempre permanecerá vacío para algunas pruebas
    }

    /**
     * Prueba el constructor {@link ConjuntoEnteros#ConjuntoEnteros()}.
     * Verifica que un conjunto recién creado esté vacío.
     */
    @Test
    @DisplayName("Constructor crea un conjunto vacío")
    public void testConjuntoEnteros() {
        assertEquals("{ Conjunto Vacio }", conjuntoA.toSetString(), "Un nuevo conjunto debería estar vacío.");
        // También podemos verificar la igualdad con otro conjunto vacío creado
        ConjuntoEnteros otroConjuntoVacio = new ConjuntoEnteros();
        assertEquals(otroConjuntoVacio, conjuntoA, "Dos conjuntos vacíos recién creados deben ser iguales.");
    }

    /**
     * Prueba el método {@link ConjuntoEnteros#insertarElemento(int)}.
     * Cubre inserción de elementos válidos, duplicados y fuera de rango.
     */
    @Test
    @DisplayName("Insertar elementos en el conjunto")
    public void testInsertarElemento() {
        conjuntoA.insertarElemento(5);
        assertEquals("{ 5 }", conjuntoA.toSetString(), "Debería contener el 5.");

        conjuntoA.insertarElemento(10);
        assertEquals("{ 5 10 }", conjuntoA.toSetString(), "Debería contener 5 y 10.");

        conjuntoA.insertarElemento(5); // Insertar duplicado
        assertEquals("{ 5 10 }", conjuntoA.toSetString(), "Insertar un duplicado no debería cambiar el conjunto.");

        conjuntoA.insertarElemento(0);
        assertEquals("{ 0 5 10 }", conjuntoA.toSetString(), "Debería contener 0, 5 y 10.");

        conjuntoA.insertarElemento(100);
        assertEquals("{ 0 5 10 100 }", conjuntoA.toSetString(), "Debería contener 0, 5, 10 y 100.");

        // Pruebas de límites (no deberían modificar el conjunto ni lanzar excepción según la implementación actual)
        String estadoPrevio = conjuntoA.toSetString();
        conjuntoA.insertarElemento(-1);
        assertEquals(estadoPrevio, conjuntoA.toSetString(), "Insertar -1 no debería cambiar el conjunto.");
        conjuntoA.insertarElemento(101);
        assertEquals(estadoPrevio, conjuntoA.toSetString(), "Insertar 101 no debería cambiar el conjunto.");
    }

    /**
     * Prueba el método {@link ConjuntoEnteros#eliminarElemento(int)}.
     * Cubre eliminación de elementos existentes, no existentes y fuera de rango.
     */
    @Test
    @DisplayName("Eliminar elementos del conjunto")
    public void testEliminarElemento() {
        conjuntoA.insertarElemento(5);
        conjuntoA.insertarElemento(10);
        conjuntoA.insertarElemento(15);
        assertEquals("{ 5 10 15 }", conjuntoA.toSetString());

        conjuntoA.eliminarElemento(10);
        assertEquals("{ 5 15 }", conjuntoA.toSetString(), "Eliminar 10 debería quitarlo del conjunto.");

        conjuntoA.eliminarElemento(20); // Eliminar elemento no existente
        assertEquals("{ 5 15 }", conjuntoA.toSetString(), "Eliminar un no existente no debería cambiar el conjunto.");

        conjuntoA.eliminarElemento(5);
        conjuntoA.eliminarElemento(15);
        assertEquals("{ Conjunto Vacio }", conjuntoA.toSetString(), "Eliminar todos los elementos debería resultar en vacío.");

        // Pruebas de límites (no deberían modificar el conjunto ni lanzar excepción)
        conjuntoA.insertarElemento(50);
        String estadoPrevio = conjuntoA.toSetString();
        conjuntoA.eliminarElemento(-1);
        assertEquals(estadoPrevio, conjuntoA.toSetString(), "Eliminar -1 no debería cambiar el conjunto.");
        conjuntoA.eliminarElemento(101);
        assertEquals(estadoPrevio, conjuntoA.toSetString(), "Eliminar 101 no debería cambiar el conjunto.");
    }

    /**
     * Prueba el método {@link ConjuntoEnteros#union(ConjuntoEnteros)}.
     */
    @Test
    @DisplayName("Unión de conjuntos")
    public void testUnion() {
        conjuntoA.insertarElemento(1);
        conjuntoA.insertarElemento(2); // A = {1, 2}

        conjuntoB.insertarElemento(2);
        conjuntoB.insertarElemento(3); // B = {2, 3}

        ConjuntoEnteros unionAB = conjuntoA.union(conjuntoB);
        assertEquals("{ 1 2 3 }", unionAB.toSetString(), "Unión de {1,2} y {2,3} debería ser {1,2,3}.");

        ConjuntoEnteros unionAConVacio = conjuntoA.union(conjuntoVacio);
        assertEquals(conjuntoA, unionAConVacio, "Unión de A con vacío debería ser A.");
        assertEquals("{ 1 2 }", unionAConVacio.toSetString());


        ConjuntoEnteros unionVacioConB = conjuntoVacio.union(conjuntoB);
        assertEquals(conjuntoB, unionVacioConB, "Unión de vacío con B debería ser B.");
        assertEquals("{ 2 3 }", unionVacioConB.toSetString());

        ConjuntoEnteros unionDosVacios = conjuntoVacio.union(new ConjuntoEnteros());
        assertEquals(conjuntoVacio, unionDosVacios, "Unión de dos vacíos debería ser vacío.");
        assertEquals("{ Conjunto Vacio }", unionDosVacios.toSetString());
    }

    /**
     * Prueba el método {@link ConjuntoEnteros#interseccion(ConjuntoEnteros)}.
     */
    @Test
    @DisplayName("Intersección de conjuntos")
    public void testInterseccion() {
        conjuntoA.insertarElemento(1);
        conjuntoA.insertarElemento(2);
        conjuntoA.insertarElemento(3); // A = {1, 2, 3}

        conjuntoB.insertarElemento(2);
        conjuntoB.insertarElemento(3);
        conjuntoB.insertarElemento(4); // B = {2, 3, 4}

        ConjuntoEnteros interseccionAB = conjuntoA.interseccion(conjuntoB);
        assertEquals("{ 2 3 }", interseccionAB.toSetString(), "Intersección de {1,2,3} y {2,3,4} debería ser {2,3}.");

        ConjuntoEnteros interseccionAConVacio = conjuntoA.interseccion(conjuntoVacio);
        assertEquals(conjuntoVacio, interseccionAConVacio, "Intersección de A con vacío debería ser vacío.");
        assertEquals("{ Conjunto Vacio }", interseccionAConVacio.toSetString());

        ConjuntoEnteros conjuntoC = new ConjuntoEnteros(); // C = {5, 6}
        conjuntoC.insertarElemento(5);
        conjuntoC.insertarElemento(6);
        ConjuntoEnteros interseccionAC = conjuntoA.interseccion(conjuntoC); // A={1,2,3}, C={5,6}
        assertEquals(conjuntoVacio, interseccionAC, "Intersección de conjuntos disjuntos debería ser vacío.");
    }

    /**
     * Prueba el método {@link ConjuntoEnteros#diferencia(ConjuntoEnteros)}.
     */
    @Test
    @DisplayName("Diferencia de conjuntos (A - B)")
    public void testDiferencia() {
        conjuntoA.insertarElemento(1);
        conjuntoA.insertarElemento(2);
        conjuntoA.insertarElemento(3); // A = {1, 2, 3}

        conjuntoB.insertarElemento(2);
        conjuntoB.insertarElemento(3);
        conjuntoB.insertarElemento(4); // B = {2, 3, 4}

        ConjuntoEnteros diferenciaAB = conjuntoA.diferencia(conjuntoB); // A - B
        assertEquals("{ 1 }", diferenciaAB.toSetString(), "Diferencia {1,2,3} - {2,3,4} debería ser {1}.");

        ConjuntoEnteros diferenciaBA = conjuntoB.diferencia(conjuntoA); // B - A
        assertEquals("{ 4 }", diferenciaBA.toSetString(), "Diferencia {2,3,4} - {1,2,3} debería ser {4}.");
        
        ConjuntoEnteros diferenciaAConVacio = conjuntoA.diferencia(conjuntoVacio);
        assertEquals(conjuntoA, diferenciaAConVacio, "Diferencia de A con vacío debería ser A.");
        assertEquals("{ 1 2 3 }", diferenciaAConVacio.toSetString());

        ConjuntoEnteros diferenciaVacioConA = conjuntoVacio.diferencia(conjuntoA);
        assertEquals(conjuntoVacio, diferenciaVacioConA, "Diferencia de vacío con A debería ser vacío.");
    }

    /**
     * Prueba el método {@link ConjuntoEnteros#equals(Object)}.
     * También prueba implícitamente {@link ConjuntoEnteros#hashCode()} por el contrato equals-hashCode.
     */
    @Test
    @DisplayName("Igualdad entre conjuntos (equals y hashCode)")
    public void testEqualsObject() {
        conjuntoA.insertarElemento(10);
        conjuntoA.insertarElemento(20);

        conjuntoB.insertarElemento(20);
        conjuntoB.insertarElemento(10);

        ConjuntoEnteros conjuntoC = new ConjuntoEnteros();
        conjuntoC.insertarElemento(10);
        conjuntoC.insertarElemento(30);

        // Reflexividad
        assertTrue(conjuntoA.equals(conjuntoA), "Un conjunto debe ser igual a sí mismo.");

        // Simetría y contenido igual
        assertTrue(conjuntoA.equals(conjuntoB), "conjuntoA debería ser igual a conjuntoB.");
        assertTrue(conjuntoB.equals(conjuntoA), "conjuntoB debería ser igual a conjuntoA si A es igual a B.");
        assertEquals(conjuntoA.hashCode(), conjuntoB.hashCode(), "HashCodes deberían ser iguales para conjuntos iguales.");

        // Contenido diferente
        assertFalse(conjuntoA.equals(conjuntoC), "conjuntoA no debería ser igual a conjuntoC.");
        // No es obligatorio que los hashCodes sean diferentes si los objetos no son iguales, pero es deseable.
        // if (!conjuntoA.equals(conjuntoC)) { // No podemos asumir que serán diferentes.
        //     assertNotEquals(conjuntoA.hashCode(), conjuntoC.hashCode());
        // }


        // Comparación con nulo
        assertFalse(conjuntoA.equals(null), "Un conjunto no debe ser igual a null.");

        // Comparación con tipo diferente
        assertFalse(conjuntoA.equals(new String("test")), "Un conjunto no debe ser igual a un objeto de tipo diferente.");
    
        // Comparación con conjunto vacío
        assertFalse(conjuntoA.equals(conjuntoVacio), "Un conjunto no vacío no debe ser igual a uno vacío.");
        assertTrue(conjuntoVacio.equals(new ConjuntoEnteros()), "Dos conjuntos vacíos deben ser iguales.");
    }

    /**
     * Prueba el método {@link ConjuntoEnteros#toSetString()}.
     */
    @Test
    @DisplayName("Representación en String del conjunto")
    public void testToSetString() {
        assertEquals("{ Conjunto Vacio }", conjuntoVacio.toSetString(), "String de conjunto vacío.");

        conjuntoA.insertarElemento(7);
        assertEquals("{ 7 }", conjuntoA.toSetString(), "String con un elemento.");

        conjuntoA.insertarElemento(3);
        conjuntoA.insertarElemento(100);
        assertEquals("{ 3 7 100 }", conjuntoA.toSetString(), "String con múltiples elementos (deberían estar ordenados).");
    }
}