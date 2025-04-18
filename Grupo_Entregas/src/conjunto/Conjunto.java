package conjunto;

public class Conjunto<T> {
    private T[] data;
    private int p;

    public Conjunto(int capacidad) {
        data = (T[]) new Object[capacidad]; // Legal, aunque da advertencia de compilador
        p = 0;
    }

    /**
     * Inserta un elemento al conjunto si no está presente.
     * Lanza excepción si se supera la capacidad del arreglo.
     */
    public void insertarElemento(T elemento) {
        if (!contiene(elemento)) {
            if (p < data.length)
                data[p++] = elemento;
            else
                throw new ArrayIndexOutOfBoundsException("Conjunto lleno (capacidad máxima alcanzada)");
        }
    }

    /**
     * Devuelve la cantidad de elementos insertados en el conjunto.
     */
    public int cardinalidad() {
        return p;
    }

    /**
     * Devuelve un nuevo conjunto con la unión del conjunto actual y otro conjunto c.
     */
    public Conjunto<T> union(Conjunto<T> c) {
        Conjunto<T> resultado = new Conjunto<>(this.cardinalidad() + c.cardinalidad());

        for (int i = 0; i < this.p; i++) {
            resultado.insertarElemento(this.data[i]);
        }

        for (int i = 0; i < c.p; i++) {
            resultado.insertarElemento(c.data[i]);
        }

        return resultado;
    }

    /**
     * Devuelve un nuevo conjunto con la intersección entre el conjunto actual y el conjunto c.
     */
    public Conjunto<T> interseccion(Conjunto<T> c) {
        Conjunto<T> resultado = new Conjunto<>(Math.min(this.cardinalidad(), c.cardinalidad()));

        for (int i = 0; i < this.p; i++) {
            if (c.contiene(this.data[i])) {
                resultado.insertarElemento(this.data[i]);
            }
        }

        return resultado;
    }

    /**
     * Verifica si dos conjuntos tienen los mismos elementos.
     * El orden no importa.
     */
    public boolean iguales(Conjunto<T> c) {
        if (this.cardinalidad() != c.cardinalidad()) {
            return false;
        }

        for (int i = 0; i < this.p; i++) {
            if (!c.contiene(this.data[i])) {
                return false;
            }
        }

        return true;
    }

    /**
     * Verifica si un elemento está presente en el conjunto.
     */
    private boolean contiene(T valor) {
        for (int i = 0; i < p; i++) {
            if (data[i] != null && data[i].equals(valor)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Devuelve una representación en texto del conjunto.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Conjunto: {");
        for (int i = 0; i < p; i++) {
            sb.append(data[i]);
            if (i < p - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}