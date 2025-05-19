// En ej11Supermercado/SimuladorSupermercado.java
package ej11Supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SimuladorSupermercado {

    // --- Parámetros de Configuración de la Simulación ---
    // (Sin cambios aquí)
    private final int NUMERO_DE_CAJAS;
    private final int TIEMPO_MAX_LLEGADA_CLIENTES;
    private final double PROBABILIDAD_LLEGADA_CLIENTE_POR_TICK;
    private final int MAX_PRODUCTOS_POR_CLIENTE;
    private final int MIN_PRODUCTOS_POR_CLIENTE;
    private final int TIEMPO_POR_PRODUCTO;
    private final int TIEMPO_FIJO_PAGO;

    // --- Estado de la Simulación ---
    // (Sin cambios aquí, pero nos aseguraremos de que sean accesibles a través de getters)
    private List<Caja> cajas;
    private List<Cliente> clientesEnEsperaParaAsignarCaja;
    private List<Cliente> clientesCompletados;
    private int tiempoSimulacionActual;
    private int clientesGeneradosTotal;
    private Random randomGenerator;

    // Constructor original (podemos mantenerlo para uso normal de la app)
    public SimuladorSupermercado(
            int numeroDeCajas,
            int tiempoMaxLlegadaClientes,
            double probabilidadLlegadaCliente,
            int minProductos,
            int maxProductos,
            int tiempoPorProducto,
            int tiempoFijoPago) {
        // Llama al nuevo constructor con una semilla basada en el tiempo actual
        // para un comportamiento aleatorio diferente en cada ejecución normal.
        this(numeroDeCajas, tiempoMaxLlegadaClientes, probabilidadLlegadaCliente,
             minProductos, maxProductos, tiempoPorProducto, tiempoFijoPago,
             System.currentTimeMillis()); // Usa el tiempo actual como semilla por defecto
    }

    // NUEVO constructor que acepta una semilla para Random (para las pruebas)
    public SimuladorSupermercado(
            int numeroDeCajas,
            int tiempoMaxLlegadaClientes,
            double probabilidadLlegadaCliente,
            int minProductos,
            int maxProductos,
            int tiempoPorProducto,
            int tiempoFijoPago,
            long seed) { // Parámetro para la semilla

        this.NUMERO_DE_CAJAS = Math.max(1, numeroDeCajas);
        this.TIEMPO_MAX_LLEGADA_CLIENTES = tiempoMaxLlegadaClientes;
        this.PROBABILIDAD_LLEGADA_CLIENTE_POR_TICK = probabilidadLlegadaCliente;
        this.MIN_PRODUCTOS_POR_CLIENTE = Math.max(1, minProductos);
        this.MAX_PRODUCTOS_POR_CLIENTE = Math.max(this.MIN_PRODUCTOS_POR_CLIENTE, maxProductos);
        this.TIEMPO_POR_PRODUCTO = tiempoPorProducto;
        this.TIEMPO_FIJO_PAGO = tiempoFijoPago;

        this.randomGenerator = new Random(seed); // ¡Importante! Usa la semilla proporcionada

        this.cajas = new ArrayList<>();
        for (int i = 0; i < this.NUMERO_DE_CAJAS; i++) {
            cajas.add(new Caja(i + 1));
        }

        this.clientesEnEsperaParaAsignarCaja = new ArrayList<>();
        this.clientesCompletados = new ArrayList<>();
        this.tiempoSimulacionActual = 0;
        this.clientesGeneradosTotal = 0;
    }

    public void ejecutarTick() {
        // (Método ejecutarTick() sin cambios)
        tiempoSimulacionActual++;

        if (tiempoSimulacionActual <= TIEMPO_MAX_LLEGADA_CLIENTES) {
            if (randomGenerator.nextDouble() < PROBABILIDAD_LLEGADA_CLIENTE_POR_TICK) {
                int numProductos = randomGenerator.nextInt(MAX_PRODUCTOS_POR_CLIENTE - MIN_PRODUCTOS_POR_CLIENTE + 1) + MIN_PRODUCTOS_POR_CLIENTE;
                Cliente nuevoCliente = new Cliente(numProductos, tiempoSimulacionActual, TIEMPO_POR_PRODUCTO, TIEMPO_FIJO_PAGO);
                clientesEnEsperaParaAsignarCaja.add(nuevoCliente);
                clientesGeneradosTotal++;
            }
        }

        if (!clientesEnEsperaParaAsignarCaja.isEmpty()) {
            List<Cliente> clientesAsignadosEsteTick = new ArrayList<>();
            for (Cliente cliente : clientesEnEsperaParaAsignarCaja) {
                Caja cajaElegida = seleccionarCajaMasCorta();
                cajaElegida.agregarClienteACola(cliente);
                clientesAsignadosEsteTick.add(cliente);
            }
            clientesEnEsperaParaAsignarCaja.removeAll(clientesAsignadosEsteTick);
        }

        for (Caja caja : cajas) {
            caja.procesarTick(tiempoSimulacionActual, clientesCompletados);
        }
    }

    private Caja seleccionarCajaMasCorta() {
        // (Método seleccionarCajaMasCorta() sin cambios)
        if (cajas.isEmpty()) {
            throw new IllegalStateException("No hay cajas configuradas en el supermercado.");
        }
        Caja elegida = cajas.get(0);
        int minPersonas = elegida.getTotalPersonasEnCaja();

        for (int i = 1; i < cajas.size(); i++) {
            Caja actual = cajas.get(i);
            if (actual.getTotalPersonasEnCaja() < minPersonas) {
                minPersonas = actual.getTotalPersonasEnCaja();
                elegida = actual;
            }
        }
        return elegida;
    }

    public boolean simulacionTerminada() {
        // (Método simulacionTerminada() sin cambios)
         if (tiempoSimulacionActual > TIEMPO_MAX_LLEGADA_CLIENTES && clientesEnEsperaParaAsignarCaja.isEmpty()) {
            for (Caja caja : cajas) {
                if (caja.getTotalPersonasEnCaja() > 0) { 
                    return false; 
                }
            }
            return true; 
        }
        return false; 
    }


    public int getTiempoSimulacionFinal() {
        return this.tiempoSimulacionActual;
    }

    public int getClientesGeneradosTotal() {
        return this.clientesGeneradosTotal;
    }

    /**
     * Devuelve una copia de la lista de clientes completados para evitar modificaciones externas.
     */
    public List<Cliente> getClientesCompletados() {
        return new ArrayList<>(this.clientesCompletados); // Devuelve una copia
    }

    /**
     * Devuelve una copia de la lista de cajas para evitar modificaciones externas.
     */
    public List<Caja> getCajas() {
        return new ArrayList<>(this.cajas); // Devuelve una copia
    }
}