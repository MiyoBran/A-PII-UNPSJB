// En ej11Supermercado/GeneradorReporteSimulacion.java
package ej11Supermercado;

import java.util.List;

public class GeneradorReporteSimulacion {

    /**
     * Genera y muestra el reporte final de la simulación en la consola.
     * @param tiempoFinalSimulacion El tiempo total que duró la simulación.
     * @param totalClientesGenerados El número total de clientes que se crearon.
     * @param clientesCompletados La lista de clientes que completaron su atención.
     * @param cajas La lista de todas las cajas del supermercado.
     */
    public static void generar(
            int tiempoFinalSimulacion,
            int totalClientesGenerados,
            List<Cliente> clientesCompletados,
            List<Caja> cajas) {

        System.out.println("\n--- Reporte Final de la Simulación ---");
        System.out.println("Tiempo Total de Simulación: " + tiempoFinalSimulacion + " ticks.");
        System.out.println("Total de Clientes Generados: " + totalClientesGenerados);
        System.out.println("Total de Clientes Atendidos: " + clientesCompletados.size());

        System.out.println("\nEstadísticas por Caja:");
        if (cajas == null || cajas.isEmpty()) {
            System.out.println("  No hay información de cajas disponible.");
        } else {
            for (Caja caja : cajas) {
                System.out.println("  Caja ID: " + caja.getIdCaja());
                System.out.println("    Clientes Atendidos: " + caja.getTotalClientesAtendidos());
                System.out.println("    Tiempo Total de Ocio: " + caja.getTiempoTotalOcio() + " ticks.");
                double tiempoPromedioServicioPorClienteEnCaja = 0;
                if (caja.getTotalClientesAtendidos() > 0) {
                    tiempoPromedioServicioPorClienteEnCaja = (double) caja.getTiempoTotalServicio() / caja.getTotalClientesAtendidos();
                }
                System.out.println("    Tiempo Promedio de Servicio por Cliente en esta Caja: " + String.format("%.2f", tiempoPromedioServicioPorClienteEnCaja) + " ticks.");
            }
        }

        System.out.println("\nEstadísticas Globales de Clientes Atendidos:");
        if (clientesCompletados.isEmpty()) {
            System.out.println("  No se atendieron clientes.");
        } else {
            long sumatoriaTiemposEspera = 0;
            int maxTiempoEspera = 0;
            long sumatoriaNumeroProductos = 0;
            long sumatoriaTiemposServicio = 0;

            for (Cliente cliente : clientesCompletados) {
                sumatoriaTiemposEspera += cliente.getTiempoEsperaEnCola();
                if (cliente.getTiempoEsperaEnCola() > maxTiempoEspera) {
                    maxTiempoEspera = cliente.getTiempoEsperaEnCola();
                }
                sumatoriaNumeroProductos += cliente.getNumeroProductos();
                sumatoriaTiemposServicio += cliente.getTiempoServicioCalculado();
            }

            double promedioTiempoEspera = (double) sumatoriaTiemposEspera / clientesCompletados.size();
            double promedioProductos = (double) sumatoriaNumeroProductos / clientesCompletados.size();
            double promedioTiempoServicio = (double) sumatoriaTiemposServicio / clientesCompletados.size();

            System.out.println("  Tiempo Promedio de Espera en Cola por Cliente: " + String.format("%.2f", promedioTiempoEspera) + " ticks.");
            System.out.println("  Tiempo Máximo de Espera en Cola por un Cliente: " + maxTiempoEspera + " ticks.");
            System.out.println("  Promedio de Productos Comprados por Cliente: " + String.format("%.2f", promedioProductos));
            System.out.println("  Tiempo Promedio de Servicio por Cliente (global): " + String.format("%.2f", promedioTiempoServicio) + " ticks.");
        }
        System.out.println("--------------------------------------");
    }
}