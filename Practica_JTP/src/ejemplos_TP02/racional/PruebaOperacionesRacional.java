package ejemplos_TP02.racional;



class PruebaOperacionesRacional {

	public static void main(String[] args) {

		// https://www.superprof.es/apuntes/escolar/matematicas/aritmetica/racionales/numeros-racionales-2.html#tema_suma-y-resta-de-numeros-racionales
					
		// Crear dos números racionales
		Racional r1 = new Racional(5, 4);
		Racional r2 = new Racional(1, 6);
		
		// Realizar operaciones con racionales
		Racional suma = r1.sumar(r2);          // 5/4 + 1/6 = 17/12
		Racional resta = r1.restar(r2);        // 5/4 - 1/6 = 13/12
		Racional producto = r1.multiplicar(r2);// 5/4 * 1/6 = 5/24
		Racional division = r1.dividir(r2);    // 5/4 / 1/6 = 15/2
		Racional potencia = Racional.potencia(r1, 2);  // (5/4)^2 = 25/16


		// Mostrar resultados
		System.out.println(r1 + " + " + r2 + " = " + suma);
		System.out.println(r1 + " - " + r2 + " = " + resta);
		System.out.println(r1 + " * " + r2 + " = " + producto);
		System.out.println(r1 + " / " + r2 + " = " + division);
		System.out.println(r1 + "^2 = " + potencia);
	}

}
