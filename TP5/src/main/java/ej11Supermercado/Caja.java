// En ej11Supermercado/Caja.java
package ej11Supermercado;

// Importa tu DoublyLinkedDeque y la interfaz Deque de net.datastructures
import ej10DoublyLInkedDeque.DoublyLinkedDeque; // O la ruta/paquete donde esté tu implementación
import net.datastructures.Deque;

import java.util.List; // Para el parámetro clientesCompletados

public class Caja {
    private final int idCaja;
    // Cambiamos de java.util.Queue a net.datastructures.Deque, usando tu implementación
    private Deque<Cliente> colaClientes; 
    private Cliente clienteActual; // Cliente siendo atendido
    private int tiempoRestanteServicioClienteActual;

    // Para estadísticas
    private int totalClientesAtendidos;
    private int tiempoTotalOcio; 
    private int tiempoTotalServicio; 

    public Caja(int idCaja) {
        this.idCaja = idCaja;
        // Instanciamos tu DoublyLinkedDeque
        this.colaClientes = new DoublyLinkedDeque<>(); 
        this.clienteActual = null;
        this.tiempoRestanteServicioClienteActual = 0;
        this.totalClientesAtendidos = 0;
        this.tiempoTotalOcio = 0;
        this.tiempoTotalServicio = 0;
    }

    /**
     * Añade un cliente al final de la cola de esta caja (enqueue).
     */
    public void agregarClienteACola(Cliente cliente) {
        this.colaClientes.addLast(cliente); // Usamos addLast para encolar
    }

    /**
     * Devuelve el número de clientes esperando en la cola (sin contar el actual).
     */
    public int getLongitudCola() {
        return this.colaClientes.size();
    }
    
    /**
     * Devuelve el número total de personas en la caja (en cola + siendo atendido).
     */
    public int getTotalPersonasEnCaja() {
        return this.colaClientes.size() + (clienteActual != null ? 1 : 0);
    }

    /**
     * Procesa un "tick" de tiempo para esta caja.
     * @param tiempoActual El tiempo actual de la simulación.
     * @param clientesCompletados Una lista donde se añadirán los clientes que terminan su servicio.
     */
    public void procesarTick(int tiempoActual, List<Cliente> clientesCompletados) {
        if (clienteActual != null) {
            tiempoRestanteServicioClienteActual--;
            if (tiempoRestanteServicioClienteActual <= 0) {
                clienteActual.setTiempoFinAtencion(tiempoActual);
                clientesCompletados.add(clienteActual); 
                clienteActual = null;
                totalClientesAtendidos++;
            }
        }

        // Si la caja está libre y hay clientes esperando
        if (clienteActual == null && !colaClientes.isEmpty()) {
            clienteActual = colaClientes.removeFirst(); // Usamos removeFirst para desencoar
            if (clienteActual != null) { // removeFirst puede devolver null si la cola está vacía (aunque ya verificamos isEmpty)
                clienteActual.setTiempoInicioAtencion(tiempoActual);
                tiempoRestanteServicioClienteActual = clienteActual.getTiempoServicioCalculado();
                tiempoTotalServicio += clienteActual.getTiempoServicioCalculado();
            }
        }

        // Si la caja está libre (sin cliente actual) y no hay nadie en cola
        if (clienteActual == null && colaClientes.isEmpty()) {
            tiempoTotalOcio++;
        }
    }

    // Getters para estadísticas
    public int getIdCaja() {
        return idCaja;
    }

    public int getTotalClientesAtendidos() {
        return totalClientesAtendidos;
    }

    public int getTiempoTotalOcio() {
        return tiempoTotalOcio;
    }

    public int getTiempoTotalServicio() {
        return tiempoTotalServicio;
    }
}