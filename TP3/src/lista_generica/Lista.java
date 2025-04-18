package lista_generica;

/**
 * Implementación de una lista genérica utilizando un arreglo.
 * Almacena elementos de tipo E con capacidad fija definida en la creación.
 * 
 * @author Estudiante
 * @version 1.0
 * @param <E> tipo de elementos que almacena la lista
 */
public class Lista<E> {
    private E[] elementos;
    private int tamanio;
    private int capacidad;
    
    /**
     * Constructor que inicializa la lista con la capacidad especificada.
     * 
     * @param capacidad cantidad máxima de elementos que puede almacenar la lista
     * @throws IllegalArgumentException si la capacidad es negativa o cero
     */
    @SuppressWarnings("unchecked")
    public Lista(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que cero");
        }
        
        this.capacidad = capacidad;
        this.elementos = (E[]) new Object[capacidad];
        this.tamanio = 0;
    }
    
    /**
     * Agrega un elemento al final de la lista.
     * 
     * @param e elemento a agregar
     * @throws IndexOutOfBoundsException si la lista está llena
     */
    public void add(E e) throws IndexOutOfBoundsException {
        if (tamanio == capacidad) {
            throw new IndexOutOfBoundsException("La lista está llena");
        }
        
        elementos[tamanio] = e;
        tamanio++;
    }
    
    /**
     * Agrega un elemento a la lista en la posición especificada.
     * 
     * @param p posición donde se agregará el elemento (0 <= p <= tamanio)
     * @param e elemento a agregar
     * @throws IndexOutOfBoundsException si la posición es inválida o la lista está llena
     */
    public void add(int p, E e) throws IndexOutOfBoundsException {
        if (tamanio == capacidad) {
            throw new IndexOutOfBoundsException("La lista está llena");
        }
        
        if (p < 0 || p > tamanio) {
            throw new IndexOutOfBoundsException("Posición inválida: " + p);
        }
        
        // Desplazar elementos para hacer espacio
        for (int i = tamanio; i > p; i--) {
            elementos[i] = elementos[i - 1];
        }
        
        elementos[p] = e;
        tamanio++;
    }
    
    /**
     * Retorna el elemento que se encuentra en la posición especificada.
     * 
     * @param p posición del elemento a retornar (0 <= p < tamanio)
     * @return elemento en la posición p
     * @throws IndexOutOfBoundsException si la posición es inválida
     */
    public E get(int p) throws IndexOutOfBoundsException {
        if (p < 0 || p >= tamanio) {
            throw new IndexOutOfBoundsException("Posición inválida: " + p);
        }
        
        return elementos[p];
    }
    
    /**
     * Remueve la primera ocurrencia del elemento especificado de la lista.
     * 
     * @param e elemento a remover
     * @return el elemento removido, o null si no se encuentra
     */
    public E remove(E e) {
        for (int i = 0; i < tamanio; i++) {
            if (elementos[i] == null && e == null || elementos[i] != null && elementos[i].equals(e)) {
                return remove(i);
            }
        }
        
        return null;
    }
    
    /**
     * Remueve el elemento que se encuentra en la posición especificada.
     * 
     * @param p posición del elemento a remover (0 <= p < tamanio)
     * @return elemento removido
     * @throws IndexOutOfBoundsException si la posición es inválida
     */
    public E remove(int p) throws IndexOutOfBoundsException {
        if (p < 0 || p >= tamanio) {
            throw new IndexOutOfBoundsException("Posición inválida: " + p);
        }
        
        E elementoRemovido = elementos[p];
        
        // Desplazar elementos para eliminar el hueco
        for (int i = p; i < tamanio - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        
        elementos[tamanio - 1] = null;
        tamanio--;
        
        return elementoRemovido;
    }
    
    /**
     * Retorna la cantidad actual de elementos en la lista.
     * 
     * @return cantidad de elementos
     */
    public int size() {
        return tamanio;
    }
    
    /**
     * Retorna true si la lista está vacía, false en caso contrario.
     * 
     * @return true si está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        return tamanio == 0;
    }
    
    /**
     * Retorna una representación en formato String de la lista.
     * 
     * @return cadena con los elementos de la lista
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        
        for (int i = 0; i < tamanio; i++) {
            sb.append(elementos[i]);
            if (i < tamanio - 1) {
                sb.append(", ");
            }
        }
        
        sb.append("]");
        return sb.toString();
    }
}