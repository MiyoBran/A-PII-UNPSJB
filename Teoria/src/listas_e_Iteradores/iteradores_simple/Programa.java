package listas_e_Iteradores.iteradores_simple;

import java.util.Iterator;

/* Ejemplo Clase e Interfaz Iterable */
public class Programa {
	public static void main(String arg[]) {
		Coordenada c1 = new Coordenada(1, 2);
		Coordenada c2 = new Coordenada(3, 4);
		Coordenada c3 = new Coordenada(5, 6);
		Coordenada[] crdnds = { c1, c2, c3 };
		ConjuntoCoordenadas cc = new ConjuntoCoordenadas(crdnds);
		System.out.println("\nRealizado con for extendido o for-each");
		for (Coordenada c : cc) // Esto es un for extendido o for-each
		{
			System.out.println("Coordenada: (" + c.absisa + ","+c.ordenada+")");
		}

		System.out.println("\nRealizado con referencia a interfase Iterator");
        Iterator<Coordenada> it1 = cc.iterator();
        while (it1.hasNext()){
        	Coordenada tmp = it1.next();
            System.out.println("Coordenada: (" + tmp.absisa + ","+tmp.ordenada+")");
        }
	}
}