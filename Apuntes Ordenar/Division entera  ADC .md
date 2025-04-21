 --------------------
 # Clase 26/03/2025
# Continuación: Aritmética de la División Entera

## Introducción a la División Entera

La división entera busca obtener dos resultados principales: el **cociente** (cuántas veces cabe el divisor en el dividendo) y el **resto** (la cantidad que sobra después de realizar la división).

Tal como mencionaste, la división se puede conceptualizar como una serie de **restas sucesivas**. Cuando una porción del dividendo (de igual o mayor magnitud que el divisor) lo permite, podemos restar el divisor repetidamente hasta que el residuo sea menor que el divisor.

## Algoritmo de División con Restauración

Este algoritmo se caracteriza por **siempre realizar una resta** inicial, incluso en los casos donde la porción del dividendo es menor que el divisor. Si la resta resulta en un valor negativo, se realiza una **restauración** sumando nuevamente el divisor.

**Componentes y Inicialización:**

* **Registro M (Divisor):** Almacena el valor del divisor.
* **Registro Q (Cociente):** Inicialmente almacena el dividendo. Al final del algoritmo, contendrá el cociente.
* **Registro A (Acumulador):** Inicialmente se establece en **0**. Durante el proceso, contendrá la parte superior del dividendo que se está considerando y, finalmente, el **resto** de la división.
* **Contador (C):** Se inicializa con la cantidad de bits del dividendo.

**Conexiones:**

* El registro **Q** (inicialmente con el dividendo) se conecta lógicamente al extremo derecho del registro **A**, formando una unidad **AQ** que representa el dividendo extendido.
* El registro **A** y el registro **M** (divisor) están conectados a una unidad **Sumador/Restador**.

**Proceso (Iterativo):**

1.  **Inicialización:**
    * Establecer el valor del dividendo en **Q**.
    * Establecer el valor del divisor en **M**.
    * Inicializar el **Acumulador (A)** en **0**.
    * Inicializar el **Contador (C)** con el número de bits del dividendo.

2.  **Iteración (mientras el Contador > 0):**
    * **Desplazamiento a la Izquierda:** Desplazar el contenido del registro combinado **AQ** un bit hacia la izquierda.
    * **Resta:** Restar el contenido del registro **M** (divisor) del contenido del registro **A**: `A <- A - M`.
    * **Verificación del Signo de A:**
        * **Si A < 0 (resultado negativo):** La resta fue incorrecta. Se debe **restaurar** el valor de **A** sumando nuevamente el divisor: `A <- A + M`. Además, el bit menos significativo de **Q** se establece en **0**.
        * **Si A ≥ 0 (resultado no negativo):** La resta fue válida. El bit menos significativo de **Q** se establece en **1**.
    * **Decremento del Contador:** Decrementar el contador: `C <- C - 1`.

3.  **Finalización:** Cuando el **Contador** llega a **0**, el proceso termina.
    * El **registro Q** contendrá el **cociente** de la división.
    * El **registro A** contendrá el **resto** de la división.

**Ejemplo (8 / 3):**

* Dividendo = 8 (1000 en binario)
* Divisor (M) = 3 (0011 en binario)
* Número de bits = 4
* Inicialización: A = 0000, Q = 1000, C = 4

| Iteración | Operación        | A     | Q     | C    |
| :-------- | :--------------- | :---- | :---- | :--- |
| Inicial   |                  | 0000  | 1000  | 0100 |
| 1         | Desplazamiento AQ | 0001  | 000_  | 0011 |
|           | A = A - M        | 1110  |       |      |
|           | A < 0 -> A = A + M | 0001  |       |      |
|           | Q[0] = 0         |       | 0000  |      |
| 2         | Desplazamiento AQ | 0010  | 0000_ | 0010 |
|           | A = A - M        | 1111  |       |      |
|           | A < 0 -> A = A + M | 0010  |       |      |
|           | Q[0] = 0         |       | 0000  |      |
| 3         | Desplazamiento AQ | 0100  | 0000_ | 0001 |
|           | A = A - M        | 0001  |       |      |
|           | A ≥ 0 -> Q[0] = 1 |       | 0001  |      |
| 4         | Desplazamiento AQ | 0010  | 0001_ | 0000 |
|           | A = A - M        | 1111  |       |      |
|           | A < 0 -> A = A + M | 0010  |       |      |
|           | Q[0] = 0         |       | 0001  |      |

**Resultado:** Resto (en A) = 0010 (2), Cociente (en Q) = 0010 (2). (8 / 3 = 2 con resto 2)
-----------------------------------------------------
## Problema del Algoritmo con Restauración

La principal ineficiencia de este método radica en que, en el peor de los casos, se realizan **dos operaciones aritméticas** por cada bit del dividendo: una resta y una suma (restauración). Esto incrementa el tiempo de ejecución del algoritmo.

## Algoritmo de División Sin Restauración

Este algoritmo busca optimizar el proceso evitando la operación de restauración explícita. En su lugar, decide si realizar una suma o una resta del divisor basándose en el signo del residuo parcial obtenido en el paso anterior.

**Componentes e Inicialización:**

Son los mismos que en la división con restauración: registros A, Q, M y un contador C inicializado con el número de bits del dividendo **menos 1**.

**Proceso (Iterativo):**

1.  **Inicialización:**
    * Establecer el valor del dividendo en **Q**.
    * Establecer el valor del divisor en **M**.
    * Inicializar el **Acumulador (A)** en **0**.
    * Inicializar el **Contador (C)** con el número de bits del dividendo **- 1**.

2.  **Desplazamiento Inicial:** Desplazar el registro combinado **AQ** un bit hacia la izquierda.

3.  **Resta Inicial:** Realizar la primera resta: `A <- A - M`. El bit menos significativo de **Q** se actualiza según el signo de **A**: si **A ≥ 0**, Q\[0] = 1; si **A < 0**, Q\[0] = 0.

4.  **Iteración (mientras el Contador > 0):**
    * **Desplazamiento a la Izquierda:** Desplazar el registro combinado **AQ** un bit hacia la izquierda.
    * **Decisión de Operación (basada en el signo de A del paso anterior):**
        * **Si el residuo parcial anterior (en A) fue positivo o cero (A ≥ 0):** Realizar una **resta**: `A <- A - M`.
        * **Si el residuo parcial anterior (en A) fue negativo (A < 0):** Realizar una **suma**: `A <- A + M`.
    * **Actualización del Cociente (Q):** El bit menos significativo de **Q** se establece según el signo del **nuevo** valor de **A**: si **A ≥ 0**, Q\[0] = 1; si **A < 0**, Q\[0] = 0.
    * **Decremento del Contador:** Decrementar el contador: `C <- C - 1`.

5.  **Ajuste Final (si es necesario):** Después de que el contador llega a 0, si el residuo en **A** es negativo, se debe **sumar el divisor** para obtener el resto correcto (positivo): `Si A < 0 entonces A <- A + M`.

6.  **Finalización:**
    * El **registro Q** contendrá el **cociente** de la división.
    * El **registro A** contendrá el **resto** de la división.

**Puntos Clave de la División Sin Restauración:**

* La decisión de sumar o restar el divisor se toma **antes** de actualizar el bit del cociente en la iteración, basándose en el signo del residuo parcial **anterior**.
* Se realiza un desplazamiento **antes** de la decisión de la operación en cada iteración (después de la inicial).
* Se requiere un posible ajuste final sumando el divisor si el resto resulta negativo al final de las iteraciones.