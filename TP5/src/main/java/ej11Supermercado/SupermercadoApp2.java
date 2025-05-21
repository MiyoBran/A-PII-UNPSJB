// En ej11Supermercado/SupermercadoApp.java
package ej11Supermercado;

import java.io.IOException;


public class SupermercadoApp2 {
    public static void main(String[] args) {
        // --- CONFIGURACIÓN DE LA SIMULACIÓN ---
        int numeroDeCajas = 3;
        int tiempoMaxLlegadaClientes = 200; 
        double probabilidadLlegadaCliente = 0.4; 
        int minProductos = 1;
        int maxProductos = 50;
        int tiempoPorProducto = 1;  
        int tiempoFijoPago = 5;     

        System.out.println("--- Iniciando Simulación de Supermercado ---");
        System.out.println("Parámetros:");
        System.out.println("  Número de Cajas: " + numeroDeCajas);
        System.out.println("  Tiempo Máximo de Llegada de Clientes: " + tiempoMaxLlegadaClientes + " ticks");
        System.out.println("  Probabilidad de Llegada de Cliente por Tick: " + (probabilidadLlegadaCliente * 100) + "%");
        System.out.println("  Productos por Cliente (min-max): " + minProductos + "-" + maxProductos);
        System.out.println("  Tiempo por Producto: " + tiempoPorProducto + " ticks");
        System.out.println("  Tiempo Fijo por Pago: " + tiempoFijoPago + " ticks");
        System.out.println("---------------------------------------------");

        SimuladorSupermercado simulador = new SimuladorSupermercado(
                numeroDeCajas,
                tiempoMaxLlegadaClientes,
                probabilidadLlegadaCliente,
                minProductos,
                maxProductos,
                tiempoPorProducto,
                tiempoFijoPago
        );

        // Bucle principal de la simulación
        while (!simulador.simulacionTerminada()) {
            simulador.ejecutarTick();
        }

        System.out.println("\n--- Simulación Finalizada ---");
        
        // Llamar al nuevo generador de reportes
        GeneradorReporteSimulacion.generar(
                simulador.getTiempoSimulacionFinal(), 
                simulador.getClientesGeneradosTotal(), 
                simulador.getClientesCompletados(), 
                simulador.getCajas()
        );
    }
}