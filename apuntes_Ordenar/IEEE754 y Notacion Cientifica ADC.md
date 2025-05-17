# Repaso: Notación Científica y Coma Flotante IEEE 754 (Simple Precisión)

## Notación Científica

* **Propósito:** Una manera concisa de representar números muy grandes o muy pequeños.
* **Formato General:** ± M × B<sup>E</sup>
    * **M (Mantisa o Significando):** La parte significativa del número, generalmente con un solo dígito no nulo a la izquierda del punto decimal.
    * **B (Base):** La base del sistema numérico (10 para la notación científica decimal).
    * **E (Exponente):** Un entero que indica la potencia a la que se eleva la base. Un exponente positivo indica un número grande, y un exponente negativo indica un número pequeño.

**Ejemplos (Decimal):**

* 6,022 × 10<sup>23</sup> (Número de Avogadro)
* 1,6 × 10<sup>-19</sup> (Carga elemental)

## Representación en Coma Flotante (Floating-Point)

* **Propósito:** Representar números reales (con parte fraccionaria) en sistemas digitales con un tamaño de palabra finito.
* **Estándar IEEE 754:** El estándar más ampliamente utilizado para la representación de coma flotante. Define formatos para diferentes precisiones (simple, doble, extendida, etc.).

### Formato de Simple Precisión (32 bits)

El formato de simple precisión IEEE 754 utiliza 32 bits divididos en tres campos:

1.  **Signo (1 bit):**
    * 0: Positivo
    * 1: Negativo

2.  **Exponente (8 bits):**
    * Representado con un **sesgo (bias)** de 127. El valor del exponente almacenado es el exponente real más el sesgo.
    * Rango del exponente almacenado: 0 a 255.
    * Rango del exponente real: -126 a +127.
    * Valores reservados del exponente:
        * 0: Indica cero o números desnormalizados.
        * 255: Indica infinito o NaN (Not a Number).

3.  **Mantisa (23 bits):**
    * Representa la parte fraccionaria del significando.
    * **Normalización Implícita:** Para números normalizados (la mayoría), se asume un '1' implícito a la izquierda del punto binario. Por lo tanto, la mantisa realmente representa `1.mantisa_almacenada` en binario. Esto proporciona un bit extra de precisión.

**Valor Representado (Número Normalizado):**

$$ (-1)^{signo} \times 1.mantisa_{binaria} \times 2^{(exponente_{almacenado} - 127)} $$

## Conversión de Binario a Coma Flotante IEEE (Simple Precisión)

Pasos para convertir un número binario (con parte entera y fraccionaria) a su representación en coma flotante de simple precisión:

1.  **Convertir a Binario Normalizado:** Mueve el punto binario hasta que haya un solo '1' a la izquierda del punto. Cuenta el número de posiciones que moviste el punto.
    * Ejemplo: `101.101` (binario) se normaliza a `1.01101 × 2^2`.
    * Ejemplo: `0.001101` (binario) se normaliza a `1.101 × 2^-3`.

2.  **Determinar el Bit de Signo:**
    * Si el número original es positivo, el bit de signo es 0.
    * Si el número original es negativo, el bit de signo es 1.

3.  **Calcular el Exponente Sesgado:**
    * Toma el exponente obtenido en el paso 1 y súmale el sesgo (127 para simple precisión).
    * Convierte este resultado a su representación binaria de 8 bits.
    * Ejemplo (para `2^2`): Exponente real = 2. Exponente sesgado = 2 + 127 = 129. Binario de 129: `10000001`.
    * Ejemplo (para `2^-3`): Exponente real = -3. Exponente sesgado = -3 + 127 = 124. Binario de 124: `01111100`.

4.  **Determinar la Mantisa:**
    * Toma la parte fraccionaria del número binario normalizado (los bits a la derecha del punto).
    * Si hay menos de 23 bits, rellena con ceros a la derecha.
    * Ejemplo (`1.01101 × 2^2`): Mantisa = `01101000000000000000000`.
    * Ejemplo (`1.101 × 2^-3`): Mantisa = `10100000000000000000000`.

5.  **Ensamblar la Representación:** Concatena el bit de signo, el exponente sesgado (8 bits) y la mantisa (23 bits) en ese orden para obtener la representación de 32 bits en coma flotante IEEE 754 de simple precisión.

**Ejemplo Completo (Convertir 6.5 decimal a IEEE 754 simple precisión):**

1.  **Binario:** 6.5<sub>10</sub> = 110.1<sub>2</sub>
2.  **Normalizado:** 1.101 × 2<sup>2</sup>
3.  **Signo:** Positivo -> 0
4.  **Exponente Sesgado:** Exponente real = 2. Sesgo = 127. Exponente sesgado = 129 = 10000001<sub>2</sub>
5.  **Mantisa:** Parte fraccionaria = 101. Rellenar con ceros -> 10100000000000000000000<sub>2</sub>
6.  **Representación IEEE 754:** `0 10000001 10100000000000000000000`

**Otras consideraciones que faltan agregar.}
# Repaso: Notación Científica y Coma Flotante IEEE 754 (Simple y Doble Precisión)

## Notación Científica

* **Propósito:** Representar números muy grandes o muy pequeños de forma concisa.
* **Formato General:** ± M × B<sup>E</sup>
    * **M (Mantisa o Significando):** Parte significativa, generalmente con un solo dígito no nulo a la izquierda del punto decimal.
    * **B (Base):** Base del sistema numérico (10 para notación científica decimal).
    * **E (Exponente):** Entero que indica la potencia de la base.

## Representación en Coma Flotante (Floating-Point) - Estándar IEEE 754

* **Propósito:** Representar números reales en sistemas digitales con precisión finita.
* **Estándar IEEE 754:** Define formatos para diferentes precisiones.

### 1. El Sesgo del Exponente en Coma Flotante

* El exponente se almacena con un **sesgo (bias)** para simplificar comparaciones.
* **Simple Precisión (32 bits):**
    * Exponente: 8 bits (valores 0-255)
    * Sesgo: 127
    * Exponente Real = Exponente Almacenado - 127
    * Rango Exponente Real (normalizado): -126 a +127
* **Doble Precisión (64 bits):**
    * Exponente: 11 bits (valores 0-2047)
    * Sesgo: 1023
    * Exponente Real = Exponente Almacenado - 1023
    * Rango Exponente Real (normalizado): -1022 a +1023

### 2. IEEE Diseñados para Hacer Comparaciones Simples

El uso del exponente sesgado asegura que para números del mismo signo, su representación binaria pueda compararse directamente como enteros para determinar su magnitud relativa.

### 3. Desbordamiento (Overflow) y Subdesbordamiento (Underflow)

* **Overflow:** Ocurre cuando la magnitud de un número excede el rango representable.
    * En simple precisión: Mayor a aproximadamente ± 2.0 × 10<sup>38</sup> (exponente > 127). Se representa como **Infinito** (±∞).
* **Underflow:** Ocurre cuando la magnitud de un número es menor que el valor representable más pequeño distinto de cero.
    * En simple precisión: Menor a aproximadamente ± 2.0 × 10<sup>-38</sup> (exponente < -126). Se aproxima a **cero** o se representa como un **número desnormalizado**.

**Recta Numérica Conceptual:**
-∞ ... Overflow (-) ... Representables (-) ... Underflow (-) ... CERO ... Underflow (+) ... Representables (+) ... Overflow (+) ... +∞


**Doble Precisión para Reducir Overflow/Underflow:**

* **Formato:** 1 bit (signo), 11 bits (exponente), 52 bits (mantisa).
* **Ventajas:**
    * **Mayor Rango:** Exponente máximo de aproximadamente ± 10<sup>308</sup>.
    * **Mayor Precisión:** 52 bits para la mantisa, lo que proporciona mucha mayor exactitud.
* **Desventajas:**
    * **Mayor Tamaño en Memoria:** 64 bits por número (doble de float).
    * **Mayor Consumo de Recursos:** Operaciones pueden ser más costosas en términos de tiempo y energía.
* **Números Desnormalizados (en simple y doble precisión):**
    * Se utilizan cuando el exponente almacenado es 0.
    * El bit implícito se considera **0** en lugar de 1.
    * Permiten representar números aún más cercanos a cero, aunque con menor precisión (se pierden bits significativos).

### 4. Redondeo

Debido a la cantidad finita de bits, la representación de números reales a menudo requiere **redondeo**. El estándar IEEE 754 define varios modos de redondeo:

* **Al más cercano (par o al más cercano):** Redondea al valor representable más cercano. Si hay un empate, redondea al número cuya mantisa termina en 0 (bit menos significativo es par).
* **Hacia +∞ (arriba):** Redondea hacia el siguiente valor representable mayor.
* **Hacia -∞ (abajo):** Redondea hacia el siguiente valor representable menor.
* **Hacia cero (truncamiento):** Redondea hacia cero (elimina la parte fraccionaria).

**Error Absoluto:** La diferencia entre el valor real y su representación en coma flotante. Ejemplo: `0.1 + 0.2` puede no ser exactamente `0.3` debido al redondeo.

### 5. Suma de Números Decimales en Notación Científica (Analogía para Coma Flotante)

Ejemplo: 7 × 10³ + 4 × 10²

Pasos:

1.  **Comparar Exponentes:** Si son diferentes, ajustar el número con el exponente menor para que coincida con el mayor.
    * 4 × 10² = 0.4 × 10³
2.  **Sumar las Mantisas:**
    * 7 + 0.4 = 7.4
3.  **Mantener el Exponente Común:**
    * Resultado intermedio: 7.4 × 10³
4.  **Normalizar el Resultado (si es necesario):** Asegurar que la mantisa tenga un solo dígito no nulo a la izquierda del punto decimal. En este caso, ya está normalizado.
5.  **Verificar Overflow/Underflow:** Si el exponente resultante está fuera del rango representable. Generar una excepción si ocurre.
6.  **Redondear (si es necesario):** Si la suma produjo más bits de los que la mantisa puede almacenar.
7.  **Normalizar el Resultado Final:** Asegurar el formato estándar.

**Circuito de Aritmética de Coma Flotante (Unidad FPU - Floating-Point Unit):**

El circuito para sumar números en coma flotante es significativamente más complejo que un sumador de enteros debido a los pasos involucrados:

* **Diferencia de Exponentes:** Se calcula la diferencia entre los exponentes de los dos operandos (usando una ALU y posiblemente un XOR para determinar la dirección del ajuste).
* **Alineación de Mantisas (Desplazamiento):** La mantisa del número con el exponente menor se desplaza a la derecha por la cantidad de la diferencia de los exponentes (usando un desplazador).
* **Suma de Mantisas:** Las mantisas alineadas se suman (usando un sumador binario).
* **Normalización del Resultado:** El resultado de la suma puede necesitar ser normalizado (desplazamiento a la izquierda o derecha de la mantisa y ajuste del exponente).
* **Redondeo:** Se aplica el modo de redondeo seleccionado si es necesario.
* **Manejo de Casos Especiales:** Detección y manejo de overflow, underflow, cero, infinito y NaN.

**Costo de Sumar Flotantes vs. Enteros:** La suma de números en coma flotante es mucho más "cara" en términos de circuitería y tiempo de procesamiento que la suma de enteros debido a la necesidad de alinear mantisas, normalizar resultados y manejar los diferentes componentes del formato de coma flotante (signo, exponente, mantisa).

### 6. Multiplicación de Números Flotantes

1.  **Sumar los Exponentes:** Sumar los exponentes de los dos números y **restar el sesgo una vez**. Esto se debe a que cada exponente ya tiene el sesgo sumado, por lo que al sumarlos, el sesgo se duplica.
    * *Posible verificación de overflow/underflow del exponente en este paso.*
2.  **Multiplicar las Mantisas:** Realizar la multiplicación bit a bit de las mantisas (esto implica una serie de sumas y desplazamientos, similar al algoritmo de multiplicación de enteros).
3.  **Normalizar el Resultado:** Ajustar la mantisa del producto para que tenga un solo '1' a la izquierda del punto binario, ajustando el exponente si es necesario.
4.  **Determinar el Signo:** Realizar una operación XOR entre los bits de signo de los dos operandos.
5.  **Verificar Overflow/Underflow:** Verificar si el exponente del resultado está dentro del rango representable. Si no, generar infinito o cero según corresponda.
6.  **Redondear (si es necesario):** Redondear la mantisa del producto si excede el número de bits disponibles.
7.  **Normalizar el Resultado Final:** Asegurar el formato estándar.


1.		l Sesgo del Exponente en Coma Flotante
El exponente en la representación de coma flotante IEEE 754 se almacena utilizando una técnica llamada exponente sesgado (biased exponent). En lugar de utilizar una representación estándar con signo (como complemento a dos) para el exponente, se le suma un valor constante llamado sesgo (bias).

¿Por qué se utiliza un sesgo?

La principal razón para utilizar un exponente sesgado es simplificar la comparación de números en coma flotante. Si los números tienen el mismo signo, su orden lexicográfico (como si fueran cadenas de bits) coincidirá con su orden numérico si el exponente está sesgado. Esto facilita la implementación de comparaciones en hardware, ya que se pueden realizar comparaciones enteras directamente sobre la representación binaria.

¿Cómo funciona el sesgo en simple precisión?

El campo del exponente tiene 8 bits, lo que permite representar 2<sup>8</sup> = 256 valores diferentes (de 0 a 255).

Para la simple precisión, el sesgo es 127. y en double 1023

Para obtener el exponente real, se resta el sesgo del valor del exponente almacenado:

$$ Exponente_{real} = Exponente_{almacenado} - Sesgo $$   ---> E - 127

Rango de Exponentes:

El valor mínimo almacenado para un exponente normalizado es 1. Esto corresponde a un exponente real de 1 - 127 = -126.
El valor máximo almacenado para un exponente normalizado es 254. Esto corresponde a un exponente real de 254 - 127 = +127.
Los valores del exponente almacenado 0 y 255 están reservados para casos especiales (cero, números desnormalizados, infinito y NaN).
2.		IEEE Diseñados para hacer comparaciones simples
3..	Si el numero excede el Rango posible a repsentar se almacena como infinito , 
	*Overflow!		->	cuando es mayor a 2.0 x 10^38  , en binario el rango del exponente es 2^127
	*Underflow! 	->	cuando es menor a  2.0 * 10^-38, en bianrio el rango del exponente es 2^(-126)
	* pensado como una recta numerica: del - inf  al + inifnito pasamos por NUmeros OVERFLOW - , Numeros Representables (-) , Num Underflow (-) , CERO , Underflow + , Representables , Overflow -->+infinito
	*Como reducir las chances de que ocurra overflow o underflow? -> Se define la representacion en doble precisiones
	*Ademas del numero mas pequeño que se puede representar, tambien hay posibilidad de aumentarlo un poco mas en cada caso, si tenemos el numero desnormalizado (no usamos el bit implicito? , o hacemos el implicito 0?)
		-> 1=signo , 11 = Exponente , 52= Mantisa
		-> ventaja : exponente maximo 10 ^ 308 - RANGO AUMENTADO
		-> Ventaja: tiene mas precision (52 contra 23 bits para darle mucha mas exactitud de representacion)
		-> Desventaja es el tamaño que ocupa en memoria. 1 arreglo de 1 millon de elementos , ocupa 64 millones de byts , cuando si fuera Float ocuparia 32 millones. Es conveniente no usar DOUBLE si no es necesario para el calculo que tenemos que hacer
		-> Aumento de recursos necesarios para operar y/o representar sitauciones especiales, ej:  1-Normalizado, 2- Desnormalizado,3-Cero, 4-Infinito , 5- Nand (no numero)
4. REDONDEO: al mas cercano, hacia + inf, hacia -inf , hacia 0. --> debido a la cantidad finita de bits que hay para almacenar numeros surgen estos problemas, por ejemplo podria pasar que 0.1 +0.2 = 0.3000004  o algo similar <-Error ABSOLUTO
5.	Suma de numero decimal en notacion cientifica: ejemplo 7x10³ + 4x10²  ( no se pueden sumar directamente) => se Renormaliza para que tengan el mismo exponente (el mayor) -> 4*10² +10 = 0.4*10³  y ahora se hace la suma , pasos(explicar mejor):
	*Comparamos exponentes si hay diferencia *10 hasta que coincidan 
	*Realizamos la suma bit a bit
	*Normalizamos la suma ya sea a la derecha decrementando el exponente o a la izquierda aumentandolo
	*Si hay Overflow o Underflow, produce una excepcion que hay que atrapar en el programa
	*Si no produce , redondeamos
	*Normlizamos el resultado, para repsentar con 1 solo digito 
	* HACER ESQUEMA O RESUMEN DEL CIRCUITO DE ARITMETICA DE COMA Flotante -- ALU para determinar diferencia de exponentes, Se determina que exponente se incrementa o decrementa con un XOR , luego a un incrementador o decrementador,  , redondeo, normalizacion, suma y desplazamiento
	*para poder figurarnos la diferenciaque hay con un circuito sumador de enteros, sobre todo resaltando lo "caro" que resulta sumar flotantes vs sumar enteros
6. Multiplicaicon de numeros flotantes:
	*Sumamos el exponente de ambos numeros, restando el exceso 1 vez (ya que cada exponente tiene el exceso, nosotros tendriamos doble exceso sin este paso)y ya lo tenemos para colocar en el formato. (es posible en este momento determinar si el resultado excede nuestra capacidad de representacion ????)
	*Realizamos normalizacion para que quede con 1 solo digito
	*XOR con los signos cuando este normalizado el numero
	*Realizamos la multiplicacion bit a bit (que es una suma bit a bit???)
	*Si hay overflow o underflow de la suma Se normaliza el resultado, para esto hay que modificar nuevamente el exponente