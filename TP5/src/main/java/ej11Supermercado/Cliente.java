// En ej11Supermercado/Cliente.java
package ej11Supermercado;

import java.util.concurrent.atomic.AtomicInteger; // Para generar IDs únicos de forma simple

public class Cliente {
    private static final AtomicInteger contadorIds = new AtomicInteger(0); // Para generar IDs únicos

    private final int idCliente;
    private final int numeroProductos;
    private final int tiempoLlegadaASistema; // Momento en que el cliente está listo para ir a una caja
    
    private int tiempoServicioCalculado; // Tiempo total que tomará atender a este cliente
    private int tiempoInicioAtencion;
    private int tiempoFinAtencion;
    @SuppressWarnings("unused")
	private int tiempoEsperaEnCola; // Se calculará como tiempoInicioAtencion - tiempoLlegadaASistema

    public Cliente(int numeroProductos, int tiempoLlegadaASistema, 
                   int factorTiempoPorProducto, int tiempoFijoPago) {
        this.idCliente = contadorIds.incrementAndGet();
        this.numeroProductos = numeroProductos;
        this.tiempoLlegadaASistema = tiempoLlegadaASistema;
        this.tiempoServicioCalculado = calcularTiempoServicio(factorTiempoPorProducto, tiempoFijoPago);
        
        // Estos se establecerán más adelante
        this.tiempoInicioAtencion = -1; 
        this.tiempoFinAtencion = -1;
        this.tiempoEsperaEnCola = -1;
    }

    private int calcularTiempoServicio(int factorTiempoPorProducto, int tiempoFijoPago) {
        return (this.numeroProductos * factorTiempoPorProducto) + tiempoFijoPago;
    }

    // Getters
    public int getIdCliente() {
        return idCliente;
    }

    public int getNumeroProductos() {
        return numeroProductos;
    }

    public int getTiempoLlegadaASistema() {
        return tiempoLlegadaASistema;
    }

    public int getTiempoServicioCalculado() {
        return tiempoServicioCalculado;
    }

    public int getTiempoInicioAtencion() {
        return tiempoInicioAtencion;
    }

    public int getTiempoFinAtencion() {
        return tiempoFinAtencion;
    }

    public int getTiempoEsperaEnCola() {
        if (tiempoInicioAtencion != -1 && tiempoLlegadaASistema != -1) {
            return tiempoInicioAtencion - tiempoLlegadaASistema;
        }
        return 0; // O -1 si aún no ha sido atendido
    }

    // Setters para tiempos que se actualizan durante la simulación
    public void setTiempoInicioAtencion(int tiempoInicioAtencion) {
        this.tiempoInicioAtencion = tiempoInicioAtencion;
        // Calculamos el tiempo de espera una vez que inicia la atención
        this.tiempoEsperaEnCola = this.tiempoInicioAtencion - this.tiempoLlegadaASistema;
    }

    public void setTiempoFinAtencion(int tiempoFinAtencion) {
        this.tiempoFinAtencion = tiempoFinAtencion;
    }

    @Override
    public String toString() {
        return "Cliente ID: " + idCliente + 
               ", Productos: " + numeroProductos +
               ", T.Llegada: " + tiempoLlegadaASistema +
               ", T.Servicio: " + tiempoServicioCalculado;
    }
}