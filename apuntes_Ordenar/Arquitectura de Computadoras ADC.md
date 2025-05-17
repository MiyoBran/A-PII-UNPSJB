**** NOTEBOOK = PENDIENTES DE APUNTE - TRABAJOS PRACTICOS
EL sumador es un circuito que realiza un OR

=>



tp1
Universidad Nacional de la Patagonia San Juan Bosco
Facultad de Ingeniería. Sede Puerto Madryn
Arquitectura de Computadoras
Práctico 1: Aritmética
Representación de Números en Signo y Magnitud
1.​ Representar los siguientes números utilizando el convenio Signo y Magnitud:
●​ 12
●​ -15
●​ 9
●​ 14
●​ 27
●​ -19
Sumas en Complemento a 2 (8 bits)
2.​ Realizar las siguientes sumas. Cada número debe representarse en complemento a 2 con 8 bits
antes de efectuar la operación. Verificar si hay desbordamiento (overflow).
●​ 12 + 9
●​ (-7) + (-13)
●​ 27 + (-15)
●​ 23 + 10
●​ 14 + (-19)
●​ (-20) + (-13)
Multiplicaciones en Signo y Magnitud
3.​ Realizar las siguientes multiplicaciones de números binarios representados en Signo y Magnitud (4
bits de magnitud y 1 bit de signo).
a.​ 9 × (-7)
b.​ -12 × (-8)
c.​ -4 × (12)
●​ Describir las operaciones paso a paso con resultados parciales, en base al esquema que sigue:
ACCIÓN
REG. ACUMUL.
REG Q.
REG D.
CONTADOR
●​ Describir cómo se determina el signo del resultado. Realizar la tabla de verdad del dispositivo. ¿A
qué función corresponde?
La imagen representa el dispositivo para realizar la multiplicación
AdC - 2025​
​
​
​
​
​
​
​
​
​
​
pág. 1Universidad Nacional de la Patagonia San Juan Bosco
Facultad de Ingeniería. Sede Puerto Madryn
Arquitectura de Computadoras
El dispositivo utilizado tiene los siguientes registros:
●​ Contador: Se carga con el número de bits del multiplicador.
●​ Acumulador: Se pone a 0 inicialmente. Queda al final la parte más significativa del producto.
●​ Q: Se carga con el multiplicador. Queda la parte menos significativa del producto.
●​ D: Se carga con el multiplicando.
Instrucciones para la multiplicación en signo y magnitud
Verificar el bit menos significativo del registro Q (multiplicador):
●​ Si es 0, desplazar todo el contenido del registro acumulador y el registro Q una posición a la
derecha, insertando un 0 en el bit más significativo del acumulador.
●​ Si es 1, sumar el registro D (multiplicando) al acumulador, luego desplazar todo el contenido
del acumulador y el registro Q una posición a la derecha, insertando un 0 en el bit más
significativo del acumulador.
Actualizar el contador:
●​ Restar 1 al contador después de cada operación.
Condición de finalización:
●​ La multiplicación termina cuando el contador llega a 0.
El producto (resultado) es el número formado por los bits del registro acumulador que carga los bits
de mayor peso y en el registro Q, se almacenan los de menor peso.
Ejemplo de resolución
8 x (-6)
8= 01000 (multiplicando)​
-6 = 10110 (multiplicador)
●​ Contador: Se carga con el número de bits del multiplicador. En este caso 4
●​ Acumulador: Se pone a 0 inicialmente. Los bits más significativos del producto quedan almacenados en
el registro acumulador.
●​ Q: Se carga con el multiplicador. En este caso 0110. Los bits menos significativos del producto quedan
en el registro Q..
●​ D: Se carga con el multiplicando. En este caso 1000
ACCIÓNREG. ACUMUL.REG Q.REG D.CONTADOR
carga0000011010004
→000000113
sumo Reg.
Acum + Reg. D+1000
1000
01000011
0011
00012
+1000
1100
01100001
0001
00001
001100000
→
sumo Reg.
Acum + Reg. D
→
→
Resultado
AdC - 2025​
​
00110000
​
​
​
​
​
​
​
​
​
pág. 2Universidad Nacional de la Patagonia San Juan Bosco
Facultad de Ingeniería. Sede Puerto Madryn
Arquitectura de Computadoras
Sumador Binario y Verificación de Resultados
4.​ La figura representa el circuito de un sumador binario de 4 bits. Los Ai y Bi son los sumandos; los Si
son los resultados; Ci son los acarreos y OVF es el rebalse (overflow).
​
Utilizando las tablas de verdad del medio sumador y del sumador total y para la representación de
los números en el sistema de Complemento a 2 realizar las siguientes sumas y verificar los
resultados. S = A+B
a.​ A=3 B=3
b.​ A=5 B=-7
c.​ A=-8 B=2
d.​ A=7 B=6
e.​ A=-5 B=-5
​
​
ABSumaCarry outABCinSCout
000000000
011000110
101001010
110101101
10010
10101
11001
11111
Tabla de verdad semisumador​
Tabla de verdad Sumador Total
AdC - 2025​
​
​
​
​
​
​
​
​
​
​
pág. 3Universidad Nacional de la Patagonia San Juan Bosco
Facultad de Ingeniería. Sede Puerto Madryn
Arquitectura de Computadoras
Ejemplo de resolución:
A=5 0101​
B=3 0011
CinABSCout
-1101
10101
11001
10010
OVF
RESULTADO DE LA SUMA: 1000 = 8
1
5.​ Analizar el siguiente circuito y explicar qué función realiza.
Para poder explicar su función, realizar las siguientes operaciones utilizando los valores
correspondientes a cada una:
A3
A2
A1
A0
B3
B2
B1
B0
SEL
Operación 1
0
1
0
1
0
0
1
0
0
Operación 2010101001
Operación 3111000101
Operación 4101111010
6.​ Considerando los siguientes tipos de sumadores, ¿Cuál considera que es más rápido o eficiente?
¿Por qué?
a.​ Un sumador secuencial con célula sumadora de 1 bit para realizar una suma de n bits.
b.​ Un sumador de acarreo serie (ripple adder).
c.​ Un sumador de generación de acarreo adelantado.
AdC - 2025​
​
​
​
​
​
​
​
​
​
​
pág. 4Universidad Nacional de la Patagonia San Juan Bosco
Facultad de Ingeniería. Sede Puerto Madryn
Arquitectura de Computadoras
7.​ Una ALU de 16 bits está formada de 16 ALU de 1 bit y cada una tiene un tiempo de suma de 100
ns. Si para la propagación de una ALU a la siguiente existe una demora adicional de 10 ns. ¿Cuánto
tiempo tardará en aparecer el resultado de una suma de 16 bits?
8.​ Se tiene una CPU en la cual la representación numérica es por medio del sistema de complemento
a 2. ¿Cómo puede hacerse para utilizar el multiplicador anterior (signo, magnitud)? ¿Cuál es el
costo que debe pagarse?
Algoritmo de Booth para Multiplicaciones en Complemento a 2
9.​ El algoritmo de Booth permite hacer multiplicaciones en Complemento a 2. Realizar las siguientes
multiplicaciones. En cada una, definir cuántos bits debe tener la palabra para poder hacer la
operación.
a.​ 9 × (-7)
d.​ 12 × 10
b.​ -12 × (-8)
e.​ 19 × 27
c.​ -4 × (12)
f.​ 6 × 15
Algoritmo de Booth – Reglas
(Considerando el bit de arrastre Q−1, que inicia en 0)
1.​ Analizar los dos últimos bits (bit menos significativo del registro Q y Q−1):
○​ Si cambia de 0 a 1 → Restar el multiplicando (sumar su complemento a 2) al registro
A y luego desplazar todo a la derecha.
○​ Si cambia de 1 a 1 → Solo desplazar todo a la derecha.
○​ Si cambia de 0 a 0 → Solo desplazar todo a la derecha.
○​ Si cambia de 1 a 0 → Sumar el multiplicando al registro A y luego desplazar todo a la
derecha.
2.​ Manejo del signo en el desplazamiento:
○​ Si el resultado es negativo (bit más significativo de A = 1), antes de desplazar, insertar
un 1 en el bit más significativo para mantener el signo.
○​ Si el resultado es positivo (bit más significativo de A = 0), antes de desplazar, insertar
un 0 en el bit más significativo.
3.​ Actualizar el contador:
○​ Restar 1 al contador después de cada operación.
4.​ Finalización:
○​ El proceso se repite hasta que el contador llegue a 0.
5.​ Resultado final:
○​ El producto queda en el registro A (bits más significativos) y en el registro Q (bits
menos significativos).
Resumen: Leyes o Reglas: (Considerando el bit de arrastre Q -1 que inicia en 0)
Cambio
Acción / operación
0a1Reg. A + C2 (M) (multiplicando) y desplazar a la derecha →
1a1desplazar a la derecha →
0a0desplazar a la derecha →
1a0Reg. A + M (multiplicando) y desplazar a la derecha →
si el resultado es negativo (1 adelante) antes de desplazar introducir un 1 en el bit
de mayor peso y luego desplazar (así se mantiene el signo), si no, introducir un 0
AdC - 2025​
​
​
​
​
​
​
​
​
​
​
pág. 5Universidad Nacional de la Patagonia San Juan Bosco
Facultad de Ingeniería. Sede Puerto Madryn
Arquitectura de Computadoras
Ejemplo de resolución:
6= 00110​
x -9= 10111
Acción
Reg A
Reg Q.
Q -1 (bit de
arrastre inicia en 0)
Contador
Carga inicial00000101110a1
Reg. A + C2 (M)+11010
1101010111
10111→111010101114
1a1
→111101010113
1a1
→111110101012
1a0
Reg. A + M
(multiplicando)+00110
0110101010
01010000111010101
+11010
1110010101
10101
Como el resultado es
negativo mantener el signo
0
M
00110
C2
=11010
5
Como el resultado es
negativo mantener el signo
Como el resultado es
negativo mantener el signo
→
0a1
Reg. A + C2 (M)
11110
→
Como el resultado es
negativo mantener el signo
01010
0
Resultado 1111001010 = -54 (0000110110 = 54)
Divisiones en Signo y Magnitud
10.​ La división para el sistema Signo y Magnitud puede implementarse en forma similar a la
multiplicación usando un par de registros ACC-Q, un registro D, un contador y un sustractor.
La función de cada registro es:
●​ Contador: Se carga con el número de bits del divisor y lleva la cuenta de los
desplazamientos realizados.
●​ Acumulador: Se carga con la parte más significativa del dividendo. Va almacenando los
resultados.
●​ Q: Se carga con la parte menos significativa del dividendo. Al finalizar el algoritmo queda
almacenado el cociente.
●​ D: Se carga con el divisor. (es el sustraendo de la resta).
AdC - 2025​
​
​
​
​
​
​
​
​
​
​
pág. 6Universidad Nacional de la Patagonia San Juan Bosco
Facultad de Ingeniería. Sede Puerto Madryn
Arquitectura de Computadoras
Procedimiento para la división en Signo y Magnitud
1.​ Preparación inicial:
○​ Antes de comenzar las operaciones, desplazar todo el contenido del registro acumulador y el
registro Q, una posición a la izquierda.
2.​ Realizar la resta:
○​ Restar el divisor (Registro D) del registro acumulador. Alternativamente, esto se puede hacer
sumando el complemento a 2 del divisor.
3.​ Evaluar el resultado:
○​ Si el resultado es positivo
■​ Colocar un 1 en el bit menos significativo del registro Q (Q0).
■​ Desplazar todo el contenido del registro acumulador y el registro Q una posición a la
izquierda.
○​ Si el resultado es negativo
■​ Restaurar el valor del registro acumulador sumando el divisor (D) nuevamente.
■​ Colocar un 0 en el bit menos significativo de Q (Q0).
■​ Desplazar todo el contenido del registro acumulador y el registro Q una posición a la
izquierda.
4.​ Repetir el proceso hasta que se haya realizado el número de iteraciones correspondiente al tamaño
del divisor (cantidad de bits).
5.​ Interpretación del resultado:
○​ El cociente se almacena en el registro Q.
○​ El resto queda en el registro acumulador.
1.​
2.​
3.​
4.​
5.​
6.​
Resumen Simplificado:
Desplazar a la izquierda antes de operar.
Restar el divisor (D) del acumulador.
Si el resultado es positivo, poner 1 en Q0 y desplazar.
Si el resultado es negativo, restaurar el acumulador, poner 0 en Q0 y desplazar.
Repetir hasta completar todas las iteraciones.
El cociente queda en Q, el resto en el acumulado
AdC - 2025​
​
​
​
​
​
​
​
​
​
​
pág. 7Universidad Nacional de la Patagonia San Juan Bosco
Facultad de Ingeniería. Sede Puerto Madryn
Arquitectura de Computadoras
Realizar las siguientes divisiones (en magnitud y signo)
a.​ 100101101 ÷ 01010 = (-45) ÷ 10
b.​ 001100100 ÷ 10111 = 100 ÷ (-7)
c.​ 12 ÷ 3
d.​ 15 ÷ 2
Describir las operaciones paso a paso con los resultados parciales en forma análoga a la que se
hizo con la multiplicación.
Ejemplo de resolución:
12/3 ​ 12: 01100​
3: 00011​
-3: 11101
En las divisiones hay que dividir un número de 2n bits, con otro de n bits, siendo el resultado y el resto
de n bits.
ACCIÓN
REG. ACUMUL.REG Q.REG D.CONTADOR
00000
0000001100
110000001115
11101
1110111000
1100000011
00000
00001
11101
1111011000
11000
10000
100004
00011
0000110000
100002
←
resto D
(sumo el C2 (D))00011
11101
0000000000
00000
000011
←
resto D
(sumo el C2 (D))
es <0
restauro sumo
D
←00000
11101
1110100010
0001000011
00000
0000000010
←
desplazo
resto D
(sumo el C2 (D))
es <0
restauro sumo
D
←
resto D
(sumo el C2 (D))
es <0
restauro sumo
D
3
0
00100
11.​ Se tiene una CPU en la cual la representación numérica es por medio del sistema de complemento
a 2. ¿Cómo puede hacerse para utilizar el divisor anterior (signo, magnitud)? ¿Cuál es el costo que
debe pagarse?
AdC - 2025​
​
​
​
​
​
​
​
​
​
​
pág. 8Universidad Nacional de la Patagonia San Juan Bosco
Facultad de Ingeniería. Sede Puerto Madryn
Arquitectura de Computadoras
Representación IEEE 754 y Cálculo de Errores
12.​ Usando notación científica (n = m×rE, con r=10 y m= 2 dígitos) hacer la suma:
0,10 + 3,8 + 9,9 + 15,2 + 39,6 + 65,3
a.​ de menor a mayor
b.​ de mayor a menor
Analizar en cada caso el error que se comente. ¿La suma es asociativa?
13.​ Representar usando la normalización IEEE en simple precisión los siguientes números. Verificar
usando la PC. Conversor IEEE 754
a.​ 1,3
b.​ -72,5
c.​ 0,125
Calcular el error porcentual cometido en la transformación.
Ejemplo de Resolución:
F.4​
​
→ 1111.01
Normalización: 1.11101 x 23
Signo: +
Exp= 3+127 = 130
Mantisa normalizada: 1.11101 (no escribimos el 1 antes de la coma porque es el bit implícito)
0 1 0 0 0 0 0 1 0 1 1 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
Cómo calcular el error:
1° pasamos el número obtenido a decimal
(1+ 1x2-1+ 1x2-2+ 1x2-3+ 1x2-5) x 23 = 15.25
Error relativo= |Valor obtenido - Valor real|= |15,25 - 15,25|= 0
14.​ Encontrar los números representados usando la normalización IEEE en simple precisión. Verificar
usando la PC.
a.​ BFA66666
b.​ 00008B61
15.​ Realizar las siguientes operaciones con números en punto flotante en el formato IEEE 754 (en las
que las partes significativas se truncan a cuatro dígitos decimales). Indique los resultados en forma
normalizada).
a.​ C30C0000 + C1500000
b.​ 3B370000 + 39F68000
16.​ Realizar las siguientes operaciones en IEEE 754 de simple precisión. Utilizar cuando sea necesario
el modo de redondeo al más cercano:
a.​ 1,5 +2 -22
b.​ 1,0-(1,5 +2-22)
c.​ 210 / (2-2-22)
d.​ 8,04 21 + 6.3318
e.​ 5.4 -16 / 2.89 7
AdC - 2025​
​
​
​
​
​
​
​
​
​
​
pág. 9Universidad Nacional de la Patagonia San Juan Bosco
Facultad de Ingeniería. Sede Puerto Madryn
Arquitectura de Computadoras
f.​ 65.5812 x 44.87928
17.​ En algunas máquinas se aprovecha que en un número en punto flotante normalizado a fracción
pura el primer bit es “1”. Entonces no es necesario su almacenamiento en memoria. Se utiliza la
idea de bit implícito. ¿Qué ventajas y desventajas trae?
18.​ En el formato de representación IEEE se usa una técnica para mejorar la precisión de los números
muy cercanos a cero. ¿En qué consiste? ¿Qué complicación implica?¿Qué inconveniente
encontramos en la representación de números reales en punto fijo?
19.​ Suponer que necesita trabajar con una precisión de 50 dígitos decimales en una PC convencional.
¿Existe algún problema? ¿En ese caso cómo lo solucionaría?
20.​ Considerar las siguientes representaciones en coma flotante:
i.​
ii.​
32 bits, que emplea 10 bits para el exponente y 21 para la mantisa
16 bits, que emplea 5 bits para el exponente y 10 para la mantisa.
Indicar:​
a)​ El menor y el mayor número no normalizado representable.
b)​ El menor y el mayor normalizado representable.
c)​ Sacar conclusiones
AdC - 2025​
​
​
​
​
​
​
​
​
​
​
pág. 10
--- RESOLUCION
Arquitectura de Computadoras - TP1 : AritmeticaRepresentación de Números en Signo y Magnitud
1. Representar los siguientes números utilizando el convenio Signo y Magnitud:
●12 0000 1100
● 9 : 0000 1001
● 27: 0001 1011
● -15: 1000 1111
● 14: 0000 1110
● -19: 1001 0011

Sumas en Complemento a 2 (8 bits)
2. Realizar las siguientes sumas. Cada número debe representarse en complemento a 2 con 8 bits
antes de efectuar la operación. Verificar si hay desbordamiento (overflow).
● 12 + 9
12:	0000	1100
9:		0000 1001
=		0001	0101 = 21

● 27 + (-15)
27	0001	1011
-15	1111	0001 
=		0000	1100 = 12 // Carry de Salida (se descarta es por el signo)

● 14 + (-19)
14:	0000	1110
-19	1110	1011			-128+19= 109
=
● (-7) + (-13)
-7		1111	1001
-13	111	0		13=0000	1101
=
● 23 + 10
23
10
=
● (-20) + (-13)
-20
-13
=
-----------------------------------------------------------------------
Multiplicaciones en Signo y Magnitud
3. Realizar las siguientes multiplicaciones de números binarios representados en Signo y Magnitud (4
bits de magnitud y 1 bit de signo).
a. 9 × (-7)
9	0000	1001
-7	1000	0111
=	
No usamos el signo mientras se esta haciendo la operaciones

b. -12 × (-8)
Asignamos a reg Q y reg D , sin contemplar el bit de Signo  / al contador va la cantidad de bits que se usan para representar el numero mas grande en este caso 4
Q = -12 = 1100
D = -8 = 	1000

ACCIÓN 		ACUMUL. 	REG Q. 		REG D. 		CONTADOR
Carga			0000				1100				1000			4 (hay 4 bits)
---
->					0000				0110								3
----
->					0000													2
---
SUmo			1000
->					0100				0001								1
---
Sumo			1100
->					0110				0000								0

---Resultado = 0110 0000 = 96 012*8
el signo es con un XOR entre 1 y 1 = resultado = 0

c. -4 × (12)
Asignamos a reg Q y reg D , sin contemplar el bit de Signo  / al contador va la cantidad de bits que se usan para representar el numero mas grande en este caso 4
Q = 12 = 1100
D = -4 = 	0100

ACCIÓN 		ACUMUL. 	REG Q. 		REG D. 		CONTADOR
Carga			0000				1100				1000			4 (hay 4 bits)
--
->					0000				0110								3
---
->					0000				0011								2
---
Sumo			1000				0011								-
->					0100				0001								1
---
Sumo			1100				0001								-
->					0110				0000								0   = 48

----
El signo es un XOR entre 1 y 0 ---> = Resulta 1 = negativo
Resultado 					




-----------------------------------------------------------------------

● Describir las operaciones paso a paso con resultados parciales, en base al esquema que sigue:
Registro Q: si el bit menos significativo es 1=> sumo registro D al acumulador+ desplazamiento introduciendo el 0
Si registro Q termina con 0--> desplazamiento con 0 a la izquierda
ACCIÓN 		REG.ACUMUL. 	REG Q. 		REG D. 		CONTADOR
Carga			0000						0111				1001				4 (hay 4 bits)
SUmo D		1001
Dezplazo		0100						1011									3
---
Sumo D		1101
Dezplazo		0110						1101									2
-----
Sumo D		1111		
Desplazo		0111						1110									1
------
Desplazo		0011						1111									0

--- El resultado Final  es 63--> ko cual es correcto. Para el Signo y MAgnitud se Hace la operacion XOR , al bit de signo




● Describir cómo se determina el signo del resultado. Realizar la tabla de verdad del dispositivo. ¿A
qué función corresponde?


Sumador Binario y Verificación de Resultados

Carry in en la primera operacion esta en 0, construimos posicionandonos en el bit menos significativo arriba (o sea escribimos el numero en columna)
A=5 = 0101
B=3= 0011

SEMI Sumador

Cin 	A 	B 	S 	Cout 	OVF
-		1	1	0	1
1		0	1	0	1
1		1	0	0	1
1		0	0	1	0			


A=4	0100
B=3	0011
Cin 	A 	B 	S 	Cout 	OVF
-		0	1	1	0
0		0	1	1	0
0		1	0	1	0| ->XOR
0		0	0	0	0|	-> = 0 => se puede representar con esta cantidad de bits en C2  = 0111 ->7

		
Vamos haciendo la suma de cada fila segun la tabla, en el 
OR para la suma
AND para el carry

COn el carry de salida de la anteultima operacion y la ultima---> REALIZO XOR , si nos queda 1, significa que el resultado no se puede representar

SUMADOR COMPLETO : Utiliza mas compuertas para sumar numeros de 4 Bits
OR para suma A+B
AND para el Carry
OR extra para el resultado de A+B ----> Si (solucion)
AND Extra, entre el resultado de A+B

Algoritmo de Booth – Reglas

Para determinar que regla usamos, se lee bit de arrastre -> a registro Q
--> Recordar que resta es SUma del opuesto(es util tener el C2 del opuesto , si tengo 6 , me anoto el C2 de -6
Algoritmo de Booth – Reglas
(Considerando el bit de arrastre Q₋₁, que inicia en 0)
1. Analizar los dos últimos bits (bit menos significativo del registro Q y Q₋₁):
○ Si cambia de 0 a 1 → Restar el multiplicando (sumar su complemento a 2) al registro
A y luego desplazar todo a la derecha.
○ Si cambia de 1 a 1 → Solo desplazar todo a la derecha.
○ Si cambia de 0 a 0 → Solo desplazar todo a la derecha.
○ Si cambia de 1 a 0 → Sumar el multiplicando al registro A y luego desplazar todo a la
derecha.
2. Manejo del signo en el desplazamiento:
○ Si el resultado es negativo (bit más significativo de A = 1), antes de desplazar, insertar
un 1 en el bit más significativo para mantener el signo.
○ Si el resultado es positivo (bit más significativo de A = 0), antes de desplazar, insertar
un 0 en el bit más significativo.
3. Actualizar el contador:
○ Restar 1 al contador después de cada operación.
4. Finalización:
○ El proceso se repite hasta que el contador llegue a 0.
5. Resultado final:
○ El producto queda en el r



------------------------------------------
TP2->