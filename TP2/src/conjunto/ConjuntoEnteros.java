package conjunto;

import java.util.Arrays;

/**
 * Representa un conjunto de enteros de 0 a 100 utilizando un arreglo de
 * boolean. Proporciona operaciones como inserción, eliminación, unión,
 * intersección y diferencia.
 *
 * @author MiyenBrandolino
 * @version 2.0
 */
public class ConjuntoEnteros {
	private static final int TAMANIO = 101;
	private boolean[] conjunto;

	/**
	 * Construye un conjunto vacío (todos los valores en false).
	 */
	public ConjuntoEnteros() {
		conjunto = new boolean[TAMANIO];
	}

	/**
	 * Inserta un entero en el conjunto.
	 *
	 * @param k El entero a insertar (0-100).
	 */
	public void insertarElemento(int k) {
		if (k >= 0 && k < TAMANIO) {
			conjunto[k] = true;
		}
	}

	/**
	 * Elimina un entero del conjunto.
	 *
	 * @param k El entero a eliminar (0-100).
	 */
	public void eliminarElemento(int k) {
		if (k >= 0 && k < TAMANIO) {
			conjunto[k] = false;
		}
	}

	/**
	 * Devuelve la unión de este conjunto con otro conjunto. Operacion logica OR
	 *
	 * @param otro El otro conjunto.
	 * @return Un nuevo conjunto que contiene la unión de ambos conjuntos.
	 */
	public ConjuntoEnteros union(ConjuntoEnteros otro) {
		ConjuntoEnteros resultado = new ConjuntoEnteros();
		for (int i = 0; i < TAMANIO; i++) {
			resultado.conjunto[i] = this.conjunto[i] || otro.conjunto[i];
		}
		return resultado;
	}

	/**
	 * Devuelve la intersección de este conjunto con otro conjunto. Operacion Logica
	 * AND
	 *
	 * @param otro El otro conjunto.
	 * @return Un nuevo conjunto que contiene la intersección de ambos conjuntos.
	 */
	public ConjuntoEnteros interseccion(ConjuntoEnteros otro) {
		ConjuntoEnteros resultado = new ConjuntoEnteros();
		for (int i = 0; i < TAMANIO; i++) {
			resultado.conjunto[i] = this.conjunto[i] && otro.conjunto[i];
		}
		return resultado;
	}

	/**
	 * Devuelve la diferencia entre este conjunto y otro conjunto. Operacion logica
	 * NOT AND
	 *
	 * @param otro El otro conjunto.
	 * @return Un nuevo conjunto que contiene elementos que están en este conjunto
	 *         pero no en el otro.
	 */
	public ConjuntoEnteros diferencia(ConjuntoEnteros otro) {
		ConjuntoEnteros resultado = new ConjuntoEnteros();
		for (int i = 0; i < TAMANIO; i++) {
			resultado.conjunto[i] = this.conjunto[i] && !otro.conjunto[i];
		}
		return resultado;
	}

	/**
	 * Calcula el código hash para este conjunto.
	 *
	 * @return El valor del código hash para este conjunto.
	 */
	@Override
	public int hashCode() {
		final int primo = 31;
		int resultado = 1;
		resultado = primo * resultado + Arrays.hashCode(conjunto);
		return resultado;
	}

	/**
	 * Determina si este conjunto es igual a otro (objeto).
	 *
	 * @param obj El objeto para comparar.
	 * @return true si ambos conjuntos son iguales, false en caso contrario.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		ConjuntoEnteros otro = (ConjuntoEnteros) obj;
		return Arrays.equals(conjunto, otro.conjunto);
	}


	/**
	 * Devuelve una representación en cadena del conjunto.
	 *
	 * @return Una cadena que lista los elementos en el conjunto.
	 */
	public String toSetString() {
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
}
