package conjunto;

import java.util.Arrays;

/**
 * Representa un conjunto de enteros de 0 a 100 utilizando un arreglo de
 * boolean. Proporciona operaciones como inserción, eliminación, unión,
 * intersección y diferencia.
 *
 * @author ArispeClaudio crapz0190@gmail.com
 * @author BrandolinoCarlos miyenbran@gmail.com
 * @author ColipanAxel maurocolipannn@gmail.com
 * @author MarinoLizandro lizandro.e.marino@gmail.com
 * 
 * @version 2.0
 */
public class ConjuntoEntero {

	private static final int MAX = 101;
	private boolean conjunto[];

	/**
	 * Construye un conjunto vacío (todos los valores en false).
	 */
	public ConjuntoEntero() {
		conjunto = new boolean[MAX];
	}

	/**
	 * Inserta un entero en el conjunto.
	 *
	 * @param k El entero a insertar (0-100).
	 */
	public void insertarElemento(int k) {
		if (k >= 0 && k < MAX) {
			conjunto[k] = true;
		}
	}

	/**
	 * Elimina un entero del conjunto.
	 *
	 * @param k El entero a eliminar (0-100).
	 */
	public void eliminarElemento(int k) {
		if (k >= 0 && k < MAX) {
			conjunto[k] = false;
		}
	}

	/**
	 * Devuelve la unión de este conjunto con otro conjunto. Operacion logica OR.
	 * Operador Bitwise |
	 *
	 * @param otro El otro conjunto.
	 * @return Un nuevo conjunto que contiene la unión de ambos conjuntos.
	 */
	public ConjuntoEntero union(ConjuntoEntero otro) {
		ConjuntoEntero resultado = new ConjuntoEntero();
		for (int i = 0; i < MAX; i++) {
			resultado.conjunto[i] = this.conjunto[i] | otro.conjunto[i];
		}
		return resultado;
	}

	/**
	 * Devuelve la intersección de este conjunto con otro conjunto. Operacion Logica
	 * AND . Operador Bitwise &
	 *
	 * @param otro El otro conjunto.
	 * @return Un nuevo conjunto que contiene la intersección de ambos conjuntos.
	 */
	public ConjuntoEntero interseccion(ConjuntoEntero otro) {
		ConjuntoEntero resultado = new ConjuntoEntero();
		for (int i = 0; i < MAX; i++) {
			resultado.conjunto[i] = this.conjunto[i] & otro.conjunto[i];
		}
		return resultado;
	}

	/**
	 * Devuelve la diferencia entre este conjunto y otro conjunto. Operacion logica
	 * NOT AND.
	 *
	 * @param otro El otro conjunto.
	 * @return Un nuevo conjunto que contiene elementos que están en este conjunto
	 *         pero no en el otro.
	 */
	public ConjuntoEntero diferencia(ConjuntoEntero otro) {
		ConjuntoEntero resultado = new ConjuntoEntero();
		for (int i = 0; i < MAX; i++) {
			resultado.conjunto[i] = this.conjunto[i] & !otro.conjunto[i];
		}
		return resultado;
	}

	/**
	 * Devuelve una representación en cadena del conjunto.
	 *
	 * @return Una cadena que lista los elementos en el conjunto.
	 */
	public String toString() {
		String fullSet = "{ ";
		boolean isEmpty = true;
		for (int i = 0; i < this.conjunto.length; i++) {
			if (this.conjunto[i]) {
				fullSet += i + " ";
				isEmpty = false;
			}
		}

		if (isEmpty) {
			fullSet += "Conjunto Vacio }";
		} else {
			fullSet += "}";
		}
		return fullSet;
	}

	/**
	 * Calcula el código hash para este conjunto.
	 *
	 * @return El valor del código hash para este conjunto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(conjunto);
		return result;
	}

	/**
	 * Determina si este conjunto es igual a otro (objeto).
	 *
	 * @param obj El objeto para comparar.
	 * @return true si ambos conjuntos son iguales, false en caso contrario.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) // comprueba si es el mismo objeto
			return true;
		if (obj == null) // comprueba si el objeto es null
			return false;
		if (getClass() != obj.getClass()) // Comprueba si son de la misma clase
			return false;
		ConjuntoEntero other = (ConjuntoEntero) obj; // Casting
		if (!Arrays.equals(conjunto, other.conjunto)) // Compara los arrays
			return false;
		return true; // Si pasa todas las comprobaciones, devuelve true
	}

}
