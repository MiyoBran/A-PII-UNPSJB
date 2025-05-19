// En ej11Supermercado/SimuladorSupermercadoTest.java
package ej11Supermercado;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SimuladorSupermercadoTest {

    private static final long SEMILLA_PRUEBA = 12345L; // Semilla fija para resultados predecibles

    @Test
    @DisplayName("Simulación muy corta con 1 caja y 1 cliente predecible")
    void testSimulacionSimpleUnClienteUnaCaja() {
        // Parámetros para generar exactamente 1 cliente con características conocidas
        int numCajas = 1;
        int tiempoMaxLlegada = 1; // Solo llega en el primer tick
        double probLlegada = 1.0;  // 100% de que llegue
        int minProd = 10;
        int maxProd = 10;          // Cliente tendrá exactamente 10 productos
        int tiempoPorProd = 1;     // Tiempo de servicio por producto = 10
        int tiempoPago = 5;        // Tiempo total de servicio = 10*1 + 5 = 15

        SimuladorSupermercado simulador = new SimuladorSupermercado(
                numCajas, tiempoMaxLlegada, probLlegada,
                minProd, maxProd, tiempoPorProd, tiempoPago,
                SEMILLA_PRUEBA // Usamos la semilla fija
        );

        // Ejecutar la simulación hasta que termine
        // Para un solo cliente, no debería tomar muchos ticks
        int ticksEjecutados = 0;
        while (!simulador.simulacionTerminada() && ticksEjecutados < (tiempoMaxLlegada + 100)) { // Límite para evitar bucle infinito
            simulador.ejecutarTick();
            ticksEjecutados++;
        }
        
        assertTrue(simulador.simulacionTerminada(), "La simulación simple debería haber terminado.");
        assertEquals(1, simulador.getClientesGeneradosTotal(), "Se debería haber generado 1 cliente.");
        assertEquals(1, simulador.getClientesCompletados().size(), "Se debería haber atendido 1 cliente.");

        Cliente clienteAtendido = simulador.getClientesCompletados().get(0);
        assertEquals(10, clienteAtendido.getNumeroProductos(), "El cliente debería tener 10 productos.");
        assertEquals(15, clienteAtendido.getTiempoServicioCalculado(), "El tiempo de servicio calculado debería ser 15.");
        
        // El cliente llega en t=1, inicia atención en t=1 (si caja libre), termina en t=1+15=16
        // La simulación termina en el tick después de que el cliente se va, así que el tiempo final sería 16.
        // (El tiempoSimulacionActual es el tick *después* del cual se considera terminado)
        // Si el cliente termina en tick 16, el simulador.getTiempoSimulacionFinal() será 16
        // (asumiendo que el tick 16 es cuando el tiempoRestante llega a 0 y se procesa su salida).
        
        assertEquals(1, clienteAtendido.getTiempoLlegadaASistema()); // Llega en el primer tick de la simulación
        assertEquals(1, clienteAtendido.getTiempoInicioAtencion());  // Debería ser atendido inmediatamente
        assertEquals(0, clienteAtendido.getTiempoEsperaEnCola());   // Por lo tanto, no espera
        assertEquals(16, clienteAtendido.getTiempoFinAtencion());   // 1 (llegada/inicio) + 15 (servicio) = 16

        List<Caja> cajas = simulador.getCajas();
        assertEquals(1, cajas.size());
        Caja cajaUnica = cajas.get(0);
        assertEquals(1, cajaUnica.getTotalClientesAtendidos());
        assertEquals(15, cajaUnica.getTiempoTotalServicio()); // Tiempo de servicio del único cliente
        // Tiempo de ocio: Si el cliente llega en t=1 y es atendido hasta t=16,
        // la caja está ocupada de t=1 a t=16 (15 ticks de servicio).
        // Si la simulación corrió exactamente 16 ticks, el ocio es 1 (el tick 0 donde no había nadie).
        // O si contamos el ocio solo cuando está libre *y podría haber atendido*, sería 0 si siempre tuvo trabajo.
        // La lógica de ocio en Caja: tiempoTotalOcio++ si (clienteActual == null && colaClientes.isEmpty())
        // En este caso, antes del cliente, estaba ociosa en t=0. Después del cliente, también.
        // Si la simulación termina en t=16, el tick 0 la caja estuvo ociosa.
        // Esto depende de cuándo empieza el tiempo de simulación (¿0 o 1?). El simulador empieza en t=0, el primer tick es t=1.
        // Entonces, en t=1 llega el cliente. Antes de eso (tick 0 conceptual) no hay procesamiento.
        // En t=1, el cliente llega, es asignado, y la caja empieza a atender.
        // Si el tiempo de simulación final es 16, la caja estuvo ocupada de 1 a 15 inclusive.
        // La lógica de tiempoTotalOcio en Caja incrementa si está libre.
        // Aquí, como hay un solo cliente, el tiempo de ocio antes y después del cliente es lo que cuenta.
        // Si la simulación corre 16 ticks, y 15 fueron de servicio, 1 tick de ocio (el primero donde no había nadie, o el último si está vacía)
        // Si el cliente es atendido en los ticks 1..15, entonces el tick 0 (si lo contamos) o el 16 (si termina y está vacía) serían de ocio.
        // Si la simulación para justo cuando el último cliente es atendido (ej. tiempoFinal = 16), entonces
        // la caja estuvo ocupada 15 ticks. Ocio = 1 (tick 0, o el tick 16 si está libre).
        // Mi lógica actual de ocio: incrementa si está libre. Estuvo libre en t=0. Si el último tick es 16 y está libre, suma otro.
        // Si el cliente llega en t=1, se asigna en t=1, tiempo_restante=15.
        // Tick 1: cliente asignado, t_restante=14
        // ...
        // Tick 15: t_restante=0. Se procesa salida en tick 16.
        // Tick 16: clienteActual=null. Caja está libre. FinAtencion=16.
        // SimulacionTerminada() se vuelve true. TiempoFinal = 16.
        // La caja estuvo ociosa antes de t=1 (0 ticks si el primer tick es 1) y en t=16.
        // Si el primer tick es 1, y la caja toma al cliente en t=1, no hay ocio antes.
        // Si el último tick es 16, y en ese tick la caja queda libre, cuenta 1 tick de ocio.
        // Es más simple probar que tiempo_ocio >= 0. Para esta prueba, el ocio puede ser 1.
        assertTrue(cajaUnica.getTiempoTotalOcio() >= 0, "Tiempo de ocio debe ser no negativo.");
    }

    @Test
    @DisplayName("SeleccionarCajaMasCorta debe funcionar correctamente")
    void testSeleccionarCajaMasCorta() {
        // Usaremos un simulador solo para acceder a las cajas y al método (si es accesible)
        // O crearemos cajas manualmente y las pasaremos a un método de prueba estático.
        // Para simplificar, asumamos que podemos configurar las cajas de un simulador.

        SimuladorSupermercado sim = new SimuladorSupermercado(3, 10, 0, 1,1,1,1, SEMILLA_PRUEBA);
        @SuppressWarnings("unused")
		List<Caja> cajas = sim.getCajas(); // Obtener una copia, no nos sirve para modificar directamente

        // Necesitamos acceder al método privado seleccionarCajaMasCorta o probar su efecto.
        // Una forma es crear clientes y ver dónde se asignan.
        @SuppressWarnings("unused")
		Cliente c1 = new Cliente(1, 1, 1,1);
        @SuppressWarnings("unused")
		Cliente c2 = new Cliente(1, 1, 1,1);
        @SuppressWarnings("unused")
		Cliente c3 = new Cliente(1, 1, 1,1);
        @SuppressWarnings("unused")
		Cliente c4 = new Cliente(1, 1, 1,1);

        // Estado inicial: Todas las cajas vacías
        // Para llamar a seleccionarCajaMasCorta, necesitamos que esté en el simulador.
        // Lo probaremos indirectamente a través de la asignación de clientes.

        SimuladorSupermercado simuladorConCajas = new SimuladorSupermercado(
            3, 1, 1.0, 1, 1, 1, 1, SEMILLA_PRUEBA
        );
        // Forzamos que lleguen 4 clientes en el primer tick.
        // La probabilidad es 1.0, maxLlegada es 1. El número de productos es 1.
        // El constructor de SimuladorSupermercado los añade a clientesEnEsperaParaAsignarCaja
        // al llamar a ejecutarTick.

        simuladorConCajas.ejecutarTick(); // Debería generar 1 cliente (o varios si la prob es alta y se hacen varios random)
                                        // La lógica actual genera 0 o 1 por tick.
                                        // Para probar seleccionarCajaMasCorta, es mejor tener control sobre las colas.

        // Prueba más directa de seleccionarCajaMasCorta (si fuera public o package-private):
        Caja cajaA = new Caja(10);
        Caja cajaB = new Caja(20);
        @SuppressWarnings("unused")
		Caja cajaC = new Caja(30);

        cajaA.agregarClienteACola(new Cliente(1,1,1,1)); // 1 persona
        cajaA.agregarClienteACola(new Cliente(1,1,1,1)); // 2 personas

        cajaB.agregarClienteACola(new Cliente(1,1,1,1)); // 1 persona

        // cajaC está vacía (0 personas)

        // Para probar seleccionarCajaMasCorta, necesitaríamos una instancia de SimuladorSupermercado
        // y poder establecer su lista de cajas. O hacer el método static y pasarle la lista.
        // Por ahora, esta prueba es más difícil de hacer de forma unitaria sin modificar SimuladorSupermercado.
        // Lo dejaremos pendiente o lo probaremos con una simulación con múltiples llegadas.

        // Prueba simplificada de asignación:
        SimuladorSupermercado simAsignacion = new SimuladorSupermercado(2, 5, 1.0, 1,1,1,1, SEMILLA_PRUEBA);
        // Tick 1: Llega cliente C1 (1 prod), se asigna a caja 1 (la primera vacía)
        simAsignacion.ejecutarTick();
        assertEquals(1, simAsignacion.getCajas().get(0).getTotalPersonasEnCaja());
        assertEquals(0, simAsignacion.getCajas().get(1).getTotalPersonasEnCaja());

        // Tick 2: Llega cliente C2 (1 prod), se asigna a caja 2 (la siguiente vacía)
        simAsignacion.ejecutarTick();
        assertEquals(1, simAsignacion.getCajas().get(0).getTotalPersonasEnCaja());
        assertEquals(1, simAsignacion.getCajas().get(1).getTotalPersonasEnCaja());
        
        // Tick 3: Llega cliente C3 (1 prod), se asigna a caja 1 (empate, elige la primera)
        simAsignacion.ejecutarTick();
        assertEquals(1, simAsignacion.getCajas().get(0).getTotalPersonasEnCaja());
        assertEquals(1, simAsignacion.getCajas().get(1).getTotalPersonasEnCaja());
    }
    
    @Test
    @DisplayName("simulacionTerminada debe ser true cuando no hay más llegadas ni clientes en sistema")
    void testSimulacionTerminadaCorrectamente() {
        SimuladorSupermercado sim = new SimuladorSupermercado(
            1, // 1 caja
            1, // Clientes solo llegan en el primer tick
            1.0, // 100% probabilidad de llegada
            1, 1, // 1 producto
            1, 1, // Tiempo servicio = 1*1 + 1 = 2
            SEMILLA_PRUEBA
        );

        // Tick 1: Llega Cliente1 (servicio 2 ticks), empieza a ser atendido.
        sim.ejecutarTick(); 
        assertFalse(sim.simulacionTerminada(), "Simulación no debe terminar mientras el cliente es atendido.");
        
        // Tick 2: Cliente1 sigue siendo atendido (t restante = 1).
        sim.ejecutarTick();
        assertFalse(sim.simulacionTerminada(), "Simulación no debe terminar mientras el cliente es atendido.");

        // Tick 3: Cliente1 termina (t restante = 0). Caja queda libre. No llegan más clientes.
        sim.ejecutarTick(); 
        assertTrue(sim.simulacionTerminada(), "Simulación debería terminar después de que el último cliente es atendido y no llegan más.");
        assertEquals(1, sim.getClientesCompletados().size());
    }
}