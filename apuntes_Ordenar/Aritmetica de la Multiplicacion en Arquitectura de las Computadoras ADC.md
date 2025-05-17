# Aritmética de la Multiplicación en Arquitectura de Computadoras

## Suma y Resta para la Multiplicación y el Signo

La forma más básica de entender la multiplicación es como una serie de **sumas repetidas**. Multiplicar A por B es equivalente a sumar A, B veces.

**Consideraciones del Signo:**

* **Multiplicando y Multiplicador Positivos:** El resultado es positivo.
* **Multiplicando Positivo y Multiplicador Negativo:** El resultado es negativo (se puede obtener sumando el multiplicando la cantidad de veces indicada por el valor absoluto del multiplicador y luego negando el resultado, o realizando restas repetidas).
* **Multiplicando Negativo y Multiplicador Positivo:** El resultado es negativo (similar al caso anterior, sumas repetidas del multiplicando y luego negación).
* **Multiplicando y Multiplicador Negativos:** El resultado es positivo (la doble negación se cancela).

**Implementación Directa (Conceptual):**

1.  Determinar el signo del resultado observando los signos del multiplicando y el multiplicador.
2.  Tomar el valor absoluto del multiplicando y el multiplicador.
3.  Inicializar un acumulador en 0.
4.  Repetir (valor absoluto del multiplicador) veces: sumar el valor absoluto del multiplicando al acumulador.
5.  Aplicar el signo determinado en el paso 1 al resultado del acumulador.

**Limitaciones:** Este método es ineficiente, especialmente para multiplicadores grandes, ya que requiere muchas sumas.

## Multiplicación en Magnitud y Signo

Este enfoque separa el manejo de la magnitud del número y su signo.

**Algoritmo:**

1.  **Determinar el Signo del Resultado:** Realizar una operación XOR entre el bit de signo del multiplicando y el bit de signo del multiplicador. Un resultado de 1 indica que el producto será negativo, y 0 indica que será positivo.
2.  **Calcular la Magnitud del Producto:**
    * Tomar el valor absoluto del multiplicando y el multiplicador.
    * Utilizar un algoritmo de multiplicación para números sin signo (como la suma y desplazamiento) para multiplicar las magnitudes.

**Algoritmo para Multiplicación de Magnitudes (Suma y Desplazamiento):**

* **Registros:**
    * **M (Multiplicando):** Almacena el valor absoluto del multiplicando.
    * **Q (Multiplicador):** Almacena el valor absoluto del multiplicador.
    * **A (Acumulador):** Inicialmente 0. Almacenará la parte alta del producto.
    * **Contador (C):** Inicializado con el número de bits del multiplicador.

* **Proceso (Iterativo):**
    1.  Mientras el Contador > 0:
        * Si el bit menos significativo de Q es 1:
            * Sumar M a A: `A <- A + M`.
        * Desplazar el registro AQ un bit a la derecha. El bit menos significativo de A pasa al bit más significativo de Q, y el bit menos significativo de Q se descarta (o se guarda en un posible bit de "acarreo hacia la derecha" para análisis más detallados).
        * Decrementar el Contador: `C <- C - 1`.

* **Resultado:** La magnitud del producto se encuentra en la concatenación de los registros A (parte alta) y Q (parte baja).

3.  **Aplicar el Signo:** Si el signo determinado en el paso 1 es negativo, negar el resultado obtenido en el paso 2.

**Ventajas:** Simplifica el manejo del signo y utiliza un algoritmo más eficiente para la multiplicación de magnitudes que la simple suma repetida.

## Multiplicación Usando el Algoritmo de Booth

El algoritmo de Booth es una técnica más eficiente para la multiplicación de números con signo (en complemento a dos) directamente, sin necesidad de un manejo separado de la magnitud y el signo. Maneja de manera eficiente tanto multiplicadores positivos como negativos, e incluso secuencias de unos o ceros en el multiplicador.

**Registros:**

* **M (Multiplicando):** Almacena el multiplicando (con signo).
* **Q (Multiplicador):** Almacena el multiplicador (con signo).
* **A (Acumulador):** Inicialmente 0. Almacenará la parte alta del producto.
* **Q\_1 (Bit Auxiliar):** Inicialmente 0. Almacena el bit menos significativo de Q en la iteración anterior.
* **Contador (C):** Inicializado con el número de bits del multiplicador.

**Proceso (Iterativo):**

1.  **Inicialización:** Establecer los valores iniciales de M, Q, A, Q\_1 y C.

2.  **Iteración (mientras el Contador > 0):**
    * Observar los bits menos significativos de Q (Q\_0) y el valor de Q\_1:
        * **Si Q\_0 = 0 y Q\_1 = 0:** No hacer nada, solo desplazar.
        * **Si Q\_0 = 1 y Q\_1 = 0:** Restar el multiplicando del acumulador: `A <- A - M`.
        * **Si Q\_0 = 0 y Q\_1 = 1:** Sumar el multiplicando al acumulador: `A <- A + M`.
        * **Si Q\_0 = 1 y Q\_1 = 1:** No hacer nada, solo desplazar.
    * Realizar un **desplazamiento aritmético a la derecha** del registro A y Q (tratados como una unidad AQ), y el bit Q\_1. El bit de signo de A se propaga hacia la derecha. El bit menos significativo de Q se desplaza a Q\_1.
    * Decrementar el Contador: `C <- C - 1`.

3.  **Resultado:** El producto se encuentra en la concatenación de los registros A (parte alta) y Q (parte baja).

**Ventajas del Algoritmo de Booth:**

* Maneja directamente números con signo en complemento a dos.
* Puede ser más rápido que los algoritmos básicos de suma y desplazamiento, especialmente cuando el multiplicador tiene bloques largos de 0s o 1s. Reduce el número de sumas/restas necesarias.
* Es fundamental en muchas implementaciones de hardware para la multiplicación.

Este apunte te proporciona una visión general de los métodos de multiplicación que mencionaste. Recuerda que cada algoritmo tiene sus propias implicaciones en términos de complejidad, eficiencia y manejo de números con signo.