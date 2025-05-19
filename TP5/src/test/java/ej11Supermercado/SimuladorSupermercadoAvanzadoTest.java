// En ej11Supermercado/SimuladorSupermercadoAvanzadoTest.java
package ej11Supermercado;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SimuladorSupermercadoAvanzadoTest {

    // Usaremos una semilla diferente para estas pruebas avanzadas
    // para no interferir con los resultados predecibles de las pruebas simples si se ejecutan juntas.
    private static final long SEMILLA_PRUEBA_AVANZADA = 67890L;

    @Test
    @DisplayName("Simulación con múltiples cajas y un flujo de clientes, verificando consistencia general y rangos de estadísticas")
    void testSimulacionCargaMediaConMultiplesCajas() {
        // Parámetros para la simulación
        int numCajas = 3;
        int tiempoMaxLlegada = 50;     // Ticks durante los cuales pueden llegar clientes
        double probLlegada = 0.7;      // 70% de probabilidad de llegada por tick
        int minProd = 5;
        int maxProd = 25;              // Rango de productos
        int tiempoPorProd = 1;         // 1 tick por producto
        int tiempoPago = 10;           // 10 ticks fijos para pago
        // Tiempo de servicio por cliente estará entre (5*1+10)=15 y (25*1+10)=35 ticks

        SimuladorSupermercado simulador = new SimuladorSupermercado(
                numCajas, tiempoMaxLlegada, probLlegada,
                minProd, maxProd, tiempoPorProd, tiempoPago,
                SEMILLA_PRUEBA_AVANZADA // Semilla fija para predictibilidad
        );

        // Ejecutar la simulación
        // Damos un margen amplio para que todos los clientes terminen
        int maxTicksEstimados = tiempoMaxLlegada + (maxProd * tiempoPorProd + tiempoPago) * (10 + maxProd / numCajas) ; // Estimación muy generosa
        int ticksEjecutados = 0;
        while (!simulador.simulacionTerminada() && ticksEjecutados < maxTicksEstimados + 500) { // Límite para evitar bucle infinito
            simulador.ejecutarTick();
            ticksEjecutados++;
        }

        assertTrue(simulador.simulacionTerminada(), "La simulación debería haber terminado dentro del límite de ticks.");
        
        List<Cliente> clientesCompletados = simulador.getClientesCompletados();
        int totalClientesGenerados = simulador.getClientesGeneradosTotal();
        List<Caja> cajas = simulador.getCajas();

        // --- Verificaciones Generales de Consistencia ---
        assertTrue(totalClientesGenerados > 0, "Se deberían haber generado clientes con esta configuración.");
        assertEquals(totalClientesGenerados, clientesCompletados.size(), "Todos los clientes generados deberían haber sido atendidos.");

        // --- Verificaciones de Estadísticas por Caja ---
        long sumaClientesAtendidosPorTodasLasCajas = 0;
        for (Caja caja : cajas) {
            sumaClientesAtendidosPorTodasLasCajas += caja.getTotalClientesAtendidos();
            assertTrue(caja.getTiempoTotalOcio() >= 0, 
                       "Tiempo de ocio de Caja " + caja.getIdCaja() + " debe ser no negativo.");
            assertTrue(caja.getTiempoTotalServicio() >= 0, 
                       "Tiempo de servicio de Caja " + caja.getIdCaja() + " debe ser no negativo.");

            // Si una caja atendió clientes, su tiempo promedio de servicio debe estar en el rango esperado
            if (caja.getTotalClientesAtendidos() > 0) {
                double tiempoPromedioServicioCaja = (double) caja.getTiempoTotalServicio() / caja.getTotalClientesAtendidos();
                assertTrue(tiempoPromedioServicioCaja >= (minProd * tiempoPorProd + tiempoPago),
                           "Tiempo promedio de servicio en Caja " + caja.getIdCaja() + " (" + tiempoPromedioServicioCaja + ") es demasiado bajo.");
                assertTrue(tiempoPromedioServicioCaja <= (maxProd * tiempoPorProd + tiempoPago),
                           "Tiempo promedio de servicio en Caja " + caja.getIdCaja() + " (" + tiempoPromedioServicioCaja + ") es demasiado alto.");
            }
        }
        assertEquals(totalClientesGenerados, sumaClientesAtendidosPorTodasLasCajas, 
                     "La suma de clientes atendidos por cada caja debe ser igual al total de clientes atendidos globalmente.");

        // --- Verificaciones de Estadísticas Globales de Clientes ---
        if (!clientesCompletados.isEmpty()) {
            long sumatoriaTiemposEspera = 0;
            int maxTiempoEsperaEncontrado = 0;
            long sumatoriaNumeroProductos = 0;

            for (Cliente cliente : clientesCompletados) {
                assertTrue(cliente.getTiempoEsperaEnCola() >= 0, 
                           "Tiempo de espera del Cliente " + cliente.getIdCliente() + " no puede ser negativo.");
                sumatoriaTiemposEspera += cliente.getTiempoEsperaEnCola();
                if (cliente.getTiempoEsperaEnCola() > maxTiempoEsperaEncontrado) {
                    maxTiempoEsperaEncontrado = cliente.getTiempoEsperaEnCola();
                }
                sumatoriaNumeroProductos += cliente.getNumeroProductos();
                assertTrue(cliente.getNumeroProductos() >= minProd && cliente.getNumeroProductos() <= maxProd,
                           "Número de productos del Cliente " + cliente.getIdCliente() + " fuera de rango.");
            }

            double promedioTiempoEspera = (double) sumatoriaTiemposEspera / clientesCompletados.size();
            double promedioProductos = (double) sumatoriaNumeroProductos / clientesCompletados.size();

            assertTrue(promedioTiempoEspera >= 0, "Promedio de tiempo de espera debe ser no negativo.");
            assertTrue(maxTiempoEsperaEncontrado >= 0, "Máximo tiempo de espera debe ser no negativo.");
            assertTrue(promedioProductos >= minProd && promedioProductos <= maxProd, 
                       "Promedio de productos (" + promedioProductos + ") fuera del rango esperado [" + minProd + "-" + maxProd + "].");

            // Para "fijar" valores esperados con una semilla, ejecuta la prueba una vez,
            // anota los valores generados (que se imprimen abajo), verifica que son lógicos,
            // y luego descomenta y rellena los assertEquals.
            System.out.println("\n[INFO TEST CargaMedia] Para SEMILLA_PRUEBA_AVANZADA (" + SEMILLA_PRUEBA_AVANZADA + ") con los parámetros actuales:");
            System.out.println("  Clientes Generados/Atendidos: " + totalClientesGenerados);
            System.out.println("  Tiempo Total Simulación: " + simulador.getTiempoSimulacionFinal() + " ticks.");
            System.out.println("  Max Tiempo Espera: " + maxTiempoEsperaEncontrado + " ticks.");
            System.out.println("  Promedio Productos: " + String.format("%.2f", promedioProductos));
            System.out.println("  Promedio Tiempo Espera: " + String.format("%.2f", promedioTiempoEspera) + " ticks.");
         // Aserciones basadas en TUS resultados para la semilla 67890L y los parámetros de esta prueba:
            assertEquals(36, totalClientesGenerados, 
                         "Número esperado de clientes generados/atendidos con semilla y parámetros fijos.");
            assertEquals(337, simulador.getTiempoSimulacionFinal(), 
                         "Tiempo total de simulación esperado con semilla y parámetros fijos.");
            assertEquals(268, maxTiempoEsperaEncontrado, 
                         "Máximo tiempo de espera esperado con semilla y parámetros fijos.");
            
            // Para los doubles, es importante usar un "delta" (tercer argumento) para manejar pequeñas
            // imprecisiones de punto flotante. Un delta de 0.01 es razonable para dos decimales.
            assertEquals(16.61, promedioProductos, 0.01, 
                         "Promedio de productos esperado con semilla y parámetros fijos.");
            assertEquals(126.11, promedioTiempoEspera, 0.01, 
                         "Promedio de tiempo de espera esperado con semilla y parámetros fijos.");

        } else {
            // Si no se completaron clientes pero se generaron, algo podría estar mal,
            // o los parámetros fueron tales que no se generó ninguno.
            assertEquals(0, totalClientesGenerados, "Si no hay clientes completados, no deberían haberse generado con esta configuración.");
        }
    }

    @Test
    @DisplayName("Simulación sin llegada de clientes debe terminar rápido y sin actividad")
    void testSimulacionSinLlegadaDeClientes() {
        SimuladorSupermercado simulador = new SimuladorSupermercado(
                2,    // numCajas
                10,   // tiempoMaxLlegada (la simulación correrá al menos estos ticks + 1)
                0.0,  // probabilidadLlegadaCliente = 0%
                1, 10, 1, 5, // minProd, maxProd, tPorProd, tPago (irrelevantes si no hay clientes)
                SEMILLA_PRUEBA_AVANZADA
        );

        int ticksEjecutados = 0;
        // Debería terminar justo después de que pase el tiempoMaxLlegada
        while (!simulador.simulacionTerminada() && ticksEjecutados < (10 + 5)) { // Límite pequeño
            simulador.ejecutarTick();
            ticksEjecutados++;
        }

        assertTrue(simulador.simulacionTerminada(), "La simulación sin clientes debería terminar.");
        assertEquals(0, simulador.getClientesGeneradosTotal(), "No se deberían generar clientes.");
        assertEquals(0, simulador.getClientesCompletados().size(), "No se deberían atender clientes.");

        // El tiempo de simulación debería ser tiempoMaxLlegada + 1
        // (el tick después de que se supera tiempoMaxLlegada y se confirma que no hay nadie)
        assertEquals(10 + 1, simulador.getTiempoSimulacionFinal(), "Tiempo de simulación incorrecto para 0 llegadas.");

        for (Caja caja : simulador.getCajas()) {
            assertEquals(0, caja.getTotalClientesAtendidos(), "Caja " + caja.getIdCaja() + " no debería haber atendido clientes.");
            // El tiempo de ocio debería ser igual al tiempo total de simulación
            assertEquals(simulador.getTiempoSimulacionFinal(), caja.getTiempoTotalOcio(),
                         "Tiempo de ocio de Caja " + caja.getIdCaja() + " debería ser igual al tiempo total de simulación.");
        }
    }
}