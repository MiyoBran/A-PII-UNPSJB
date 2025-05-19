package com.CIOTech.MVP.dao;

import com.CIOTech.MVP.model.Producto;
import com.CIOTech.MVP.util.JpaUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase {@link ProductoDao}.
 * Estas pruebas verifican las operaciones CRUD básicas para la entidad Producto.
 *
 * @author MiyoBran // O tu nombre
 * @version 1.0
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Opcional: para ejecutar tests en un orden específico si es necesario
public class ProductoDaoTest {

    private static ProductoDao productoDao;

    /**
     * Se ejecuta una vez antes de todas las pruebas de esta clase.
     * Inicializa el EntityManagerFactory.
     */
    @BeforeAll
    public static void setUpClass() {
        // Inicializa el EntityManagerFactory. Esto leerá persistence.xml
        // y preparará Hibernate. Si hbm2ddl.auto es 'update', aquí podría
        // crearse o actualizarse el esquema de la BD.
        JpaUtil.getEntityManagerFactory(); 
        productoDao = new ProductoDao();
        System.out.println("ProductoDaoTest: EntityManagerFactory inicializado.");
    }

    /**
     * Se ejecuta una vez después de todas las pruebas de esta clase.
     * Cierra el EntityManagerFactory para liberar recursos.
     */
    @AfterAll
    public static void tearDownClass() {
        JpaUtil.shutdown();
        System.out.println("ProductoDaoTest: EntityManagerFactory cerrado.");
    }
    
    /**
     * Limpia la tabla de productos antes de cada prueba para asegurar aislamiento,
     * especialmente útil si las pruebas insertan datos que no deben interferir.
     * Con hbm2ddl.auto="update", los datos persisten entre ejecuciones de la aplicación/tests.
     * Una alternativa es usar hbm2ddl.auto="create-drop" para un persistence unit de test.
     */
    @BeforeEach
    public void setUp() {
        // Opcional: Limpiar datos antes de cada test para asegurar un estado conocido.
        // Esto es una forma simple. Para bases de datos más complejas, se usan herramientas como DBUnit
        // o se reinicia la BD a un estado conocido.
        List<Producto> productos = productoDao.obtenerTodos();
        for (Producto p : productos) {
            productoDao.eliminar(p.getId());
        }
        System.out.println("ProductoDaoTest: Tabla de productos limpiada para el test.");
    }


    @Test
    @Order(1) // Opcional: si quieres un orden específico
    @DisplayName("Guardar y luego buscar un producto por ID")
    public void testGuardarYBuscarPorId() {
        Producto nuevoProducto = new Producto("Teclado Mecánico RGB", "Teclado para gaming", new BigDecimal("75.50"), 50);
        
        productoDao.guardar(nuevoProducto);
        assertNotNull(nuevoProducto.getId(), "El ID del producto no debería ser nulo después de guardar.");

        Producto productoEncontrado = productoDao.buscarPorId(nuevoProducto.getId());
        assertNotNull(productoEncontrado, "Se debería encontrar un producto con el ID guardado.");
        assertEquals(nuevoProducto.getNombre(), productoEncontrado.getNombre(), "El nombre del producto no coincide.");
        // Compara usando compareTo para BigDecimal, ya que assertEquals(double, double) puede tener problemas de precisión
        assertEquals(0, nuevoProducto.getPrecio().compareTo(productoEncontrado.getPrecio()), "El precio del producto no coincide.");
        assertEquals(nuevoProducto.getStock(), productoEncontrado.getStock(), "El stock del producto no coincide.");
    }

    @Test
    @Order(2)
    @DisplayName("Obtener todos los productos")
    public void testObtenerTodos() {
        Producto producto1 = new Producto("Mouse Gamer", "Mouse óptico con luces", new BigDecimal("45.00"), 30);
        Producto producto2 = new Producto("Monitor 24 pulgadas", "Monitor Full HD", new BigDecimal("180.00"), 15);

        productoDao.guardar(producto1);
        productoDao.guardar(producto2);

        List<Producto> todosLosProductos = productoDao.obtenerTodos();
        assertNotNull(todosLosProductos, "La lista de productos no debería ser nula.");
        assertEquals(2, todosLosProductos.size(), "Debería haber 2 productos en la lista.");
    }

    @Test
    @Order(3)
    @DisplayName("Actualizar un producto existente")
    public void testActualizarProducto() {
        Producto productoOriginal = new Producto("Webcam HD", "Cámara web Full HD", new BigDecimal("60.00"), 25);
        productoDao.guardar(productoOriginal);
        assertNotNull(productoOriginal.getId());

        Long idOriginal = productoOriginal.getId();
        Producto productoParaActualizar = productoDao.buscarPorId(idOriginal);
        assertNotNull(productoParaActualizar);

        productoParaActualizar.setNombre("Webcam 4K Pro");
        productoParaActualizar.setPrecio(new BigDecimal("95.99"));
        productoDao.guardar(productoParaActualizar); // El método guardar usa merge si el ID existe

        Producto productoActualizado = productoDao.buscarPorId(idOriginal);
        assertNotNull(productoActualizado);
        assertEquals("Webcam 4K Pro", productoActualizado.getNombre());
        assertEquals(0, new BigDecimal("95.99").compareTo(productoActualizado.getPrecio()));
    }

    @Test
    @Order(4)
    @DisplayName("Eliminar un producto")
    public void testEliminarProducto() {
        Producto productoAEliminar = new Producto("Auriculares Bluetooth", "Con cancelación de ruido", new BigDecimal("99.90"), 40);
        productoDao.guardar(productoAEliminar);
        assertNotNull(productoAEliminar.getId(), "El producto a eliminar debe tener un ID.");

        Long idProducto = productoAEliminar.getId();
        productoDao.eliminar(idProducto);

        Producto productoEliminado = productoDao.buscarPorId(idProducto);
        assertNull(productoEliminado, "El producto debería haber sido eliminado de la base de datos.");
    }
}