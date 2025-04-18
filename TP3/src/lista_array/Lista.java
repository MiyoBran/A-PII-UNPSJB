package lista_array;

/**
 * Clase genérica que representa una lista simple basada en arreglos.
 * 
 * @author Catedra ALGII
 * @author ArispeClaudio (crapz0190@gmail.com)
 * @author BrandolinoCarlos (miyenbran@gmail.com)
 * @author ColipanAxel (maurocolipannn@gmail.com)
 * @author MarinoLizandro (lizandro.e.marino@gmail.com)
 * 
 * @version 1.1
 */
public class Lista<E> {

	private E lista[];
	private int indice;
	private final int MAXELEM;

	/**
	 * Crea una lista con capacidad máxima especificada.
	 * 
	 * @param n capacidad máxima de la lista
	 */
	@SuppressWarnings("unchecked")
	public Lista(int n) {
		lista = (E[]) new Object[n];
		MAXELEM = n;
		indice = 0;
	}

	/**
	 * Agrega un elemento al final de la lista.
	 * 
	 * @param e el elemento a agregar
	 * @throws IndexOutOfBoundsException si la lista está llena
	 */
	public void add(E e) throws IndexOutOfBoundsException {
		if (indice == MAXELEM)
			throw new IndexOutOfBoundsException("Lista llena");
		lista[indice++] = e;
	}

	/**
	 * Agrega un elemento en una posición específica de la lista.
	 * 
	 * @param p posición donde insertar el elemento
	 * @param e elemento a insertar
	 * @throws IndexOutOfBoundsException si la posición es inválida o la lista está
	 *                                   llena
	 */
	public void add(int p, E e) throws IndexOutOfBoundsException {
		if (p > MAXELEM || p < 0 || p > indice) {
			throw new IndexOutOfBoundsException("Numero fuera de rango");
		}
		if (indice == MAXELEM) {
			throw new IndexOutOfBoundsException("Lista llena");
		}

		for (int i = indice - 1; i >= p; i--) { // Shift de elementos a la derecha
			lista[i + 1] = lista[i];
		}

		lista[p] = e; // Se añade el elemento e en la posicion p
		indice++;
	}

	/**
	 * Retorna el elemento en la posición dada.
	 * 
	 * @param p la posición del elemento
	 * @return el elemento en la posición especificada
	 * @throws IndexOutOfBoundsException si el índice es inválido
	 */
	public E get(int p) throws IndexOutOfBoundsException {
		if (p < 0 || p >= indice)
			throw new IndexOutOfBoundsException("Indice invalido: " + p);
		return lista[p];
	}

	/**
	 * Remueve el primer elemento que sea igual al proporcionado.
	 * 
	 * @param e el elemento a remover
	 * @return el elemento removido o null si no se encontró
	 */
	public E remove(E e) {
		boolean encontrado = false;
		int i;
		for (i = 0; i < indice && !encontrado; i++)
			if (lista[i].equals(e))
				encontrado = true;
		if (!encontrado)
			return null;
		return remove(i - 1);
	}

	/**
	 * Remueve el elemento en la posición especificada.
	 * 
	 * @param p la posición del elemento a remover
	 * @return el elemento removido
	 * @throws IndexOutOfBoundsException si el índice está fuera de rango
	 */
	public E remove(int p) throws IndexOutOfBoundsException {
		if (p < 0 || p >= indice) {
			throw new IndexOutOfBoundsException("Índice inválido");
		}

		E eliminado = lista[p];

		// Desplazar elementos hacia la izquierda
		for (int i = p; i < indice - 1; i++) {
			lista[i] = lista[i + 1];
		}

		lista[indice - 1] = null;
		indice--;

		return eliminado;
	}

	/**
	 * Compara esta lista con otra, considerando los elementos sin importar su
	 * orden.
	 * 
	 * @param objeto el objeto a comparar
	 * @return true si ambas listas contienen los mismos elementos, sin importar el
	 *         orden
	 */
	@Override
	public boolean equals(Object objeto) {
		if (this == objeto) {
			return true;
		}
		if (objeto == null || this.getClass() != objeto.getClass()) {
			return false;
		}

		Lista<?> newLista = (Lista<?>) objeto;
		boolean sonIguales = false;

		if (this.indice != newLista.indice) {
			return false;
		}

		for (int i = 0; i < this.indice; i++) {
			sonIguales = false;
			for (int j = 0; j < newLista.indice; j++) {
				if (this.lista[i].equals(newLista.lista[j])) {
					sonIguales = true;
					break;
				}
			}
			if (!sonIguales) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Retorna una representación en cadena de la lista.
	 * 
	 * @return los elementos de la lista como una cadena
	 */
	public String toString() {
		String s = "";
		for (int i = 0; i < indice; i++)
			s += lista[i] + "\n";
		return s;
	}
}
