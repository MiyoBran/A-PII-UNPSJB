# **Instrucciones de Formato para Código Java (Eclipse, Linux Mint)**

## **Convenciones de Nombres:**
* **Clases:** Comienzan con mayúscula (Ej.: `Ej2Circulo`).
* **Métodos:** Comienzan con minúscula (Ej.: `calcularDiametro`).
* **Atributos/Variables/Argumentos:** Comienzan con minúscula (Ej.: `radio`).
* **Constantes:** Todo en mayúsculas con palabras separadas por guion bajo (Ej.: `PI`, `VALOR_MAXIMO`).
* **Paquetes:** Todo en minúscula (Ej.: `tp1`).
* Usar nombres descriptivos y en español (o inglés consistente). Evitar abreviaturas poco claras, nombres genéricos (Ej.: `Clase`, `Main`) y nombres que indiquen versión.
* No usar acentos ni caracteres especiales.
* Para colecciones, usar plurales (Ej.: `empleados`, `items`).

## **Estructura del Código:**
* **Orden en la clase:** 
  1. Declaración de paquete
  2. Importaciones
  3. Comentario JavaDoc de la clase
  4. Declaración de la clase
  5. Constantes estáticas
  6. Atributos
  7. Constructores
  8. Métodos
  9. Clases internas
* Un atributo por línea.
* **Alcance de atributos:** `private` por defecto. Usar getters/setters para acceso/modificación (excepto para atributos internos).
* Validar datos en constructores y setters.
* Implementar método `toString()` para representar objetos.
* Clases para cálculos separadas de las clases de prueba (con `main()`).
* Si hay diagrama UML, seguirlo estrictamente (nombres, tipos, alcances, relaciones).

## **Formato y Estilo:**
* **Indentación:** Usar la función "Source / Format" de Eclipse (Ctrl+Shift+F).
* **Llaves:** Abrir en la misma línea de la declaración, cerrar en una línea separada.
* **Espaciado:** Un espacio después de palabras clave, un espacio alrededor de operadores.
* Eliminar código comentado innecesario, archivos no relacionados y warnings de Eclipse.
* No usar `System.out.println()` en clases de lógica de la aplicación.
* Inicializar variables constantes con `static final`.
* Una sentencia por línea.
* Líneas no más largas de 100 caracteres.

## **Estructura JavaDoc:**
* **Formato para clases:**
  ```java
  /**
   * [Descripción breve de la clase].
   *
   * [Descripción detallada si es necesaria].
   *
   * @author [Nombre del autor]
   * @version [Número de versión]
   */
  ```

* **Formato para métodos:**
  ```java
  /**
   * [Descripción del método].
   *
   * @param [nombreParam] [Descripción del parámetro]
   * @return [Descripción del valor retornado]
   * @throws [Tipo de excepción] [Condiciones bajo las que se lanza]
   */
  ```

* **Formato para constructores:**
  ```java
  /**
   * Constructor para la clase [NombreClase].
   *
   * @param [nombreParam] [Descripción del parámetro]
   * @throws [Tipo de excepción] [Condiciones bajo las que se lanza]
   */
  ```

## **Manejo de Excepciones:**
* Documentar todas las excepciones que puede lanzar un método.
* Usar excepciones estándar de Java cuando sea posible (Ej.: `IllegalArgumentException` para argumentos inválidos).
* No capturar excepciones sin manejarlas adecuadamente.
* No usar excepciones para controlar el flujo normal del programa.

## **Importaciones:**
* Importar clases específicas en lugar de paquetes completos (Ej.: `import java.util.ArrayList` en lugar de `import java.util.*`).
* Organizar importaciones usando Eclipse (Ctrl+Shift+O).
* Eliminar importaciones no utilizadas.

## **Pruebas Unitarias:**
* Nombrar las clases de prueba con el sufijo "Test" (Ej.: `Ej1CalculadoraTest`).
* Cada método de prueba debe probar un único aspecto de la funcionalidad.
* Incluir pruebas para casos normales y casos límite.
* Para clases de prueba con método `main()`, documentar claramente el propósito y funcionamiento.

## **Buenas Prácticas:**
* El código debe funcionar y cumplir con las especificaciones.
* Lógica clara y eficiente, sin código repetido ni comparaciones innecesarias.
* Código bien documentado (JavaDoc).
* Evitar "números mágicos" (usar constantes).
* Verificar archivos subidos al Campus (solo los necesarios, sin errores sintácticos).
* Métodos estáticos deben llamarse a través de la clase, no de una instancia.

## **Ejemplo de Clase:**
```java
/**
 * Esta clase proporciona métodos para realizar operaciones aritméticas básicas.
 *
 * @author NombreAutor
 * @version 1.0
 */
package tp1;

public class Ej1Calculadora {
    /**
     * Suma dos numeros.
     * 
     * @param num1 El primer número
     * @param num2 El segundo número 
     * @return La suma de dos numeros
     */
    public static float sumarNumeros(float num1, float num2) {
        return num1 + num2;        
    }
    
    // Otros métodos...
}
```

## **Ejemplo de Clase de Prueba:**
```java
/**
 * Esta clase proporciona los métodos para verificar el funcionamiento de Ej1Calculadora.
 *
 * @author NombreAutor
 * @version 1.0
 */
package tp1;

import java.util.Scanner;

public class Ej1CalculadoraTest {
    /**
     * Método principal que permite al usuario ingresar dos números
     * y probar las operaciones aritméticas de la clase Ej1Calculadora.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Código de prueba...
    }
}
```
