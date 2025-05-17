package listas_e_Iteradores.iteradores_simple;

import java.util.Iterator;

/* Ejemplo interface Iterable  */
public class ConjuntoCoordenadas implements Iterable<Coordenada> {
	
	public Coordenada[] conjuntoCoordenadas; // Atributo de la clase

	public ConjuntoCoordenadas(Coordenada[] c) { // Constructor de la clase
		conjuntoCoordenadas = c;
	}

	public Iterator<Coordenada> iterator() {
		Iterator<Coordenada> it = new MiIteratorCoordenada();
		return it;
	}

	protected class MiIteratorCoordenada implements Iterator<Coordenada> {
		protected int posicionarray;

		public MiIteratorCoordenada() {
			posicionarray = 0;
		}

		public boolean hasNext() {
			boolean result;
			if (posicionarray < conjuntoCoordenadas.length) {
				result = true;
			} else {
				result = false;
			}
			return result;
		}

		public Coordenada next() {
			posicionarray++;
			return conjuntoCoordenadas[posicionarray - 1];
		}

		public void remove() {
			throw new UnsupportedOperationException("No soportado.");
		}
	}
}
