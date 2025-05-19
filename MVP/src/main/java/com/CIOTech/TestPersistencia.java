// En src/main/java/com/CIOTech/TestPersistencia.java (o un subpaquete)
package com.CIOTech; // o com.CIOTech.test.manual

import com.CIOTech.MVP.model.Producto;
import com.CIOTech.MVP.dao.ProductoDao;
import com.CIOTech.MVP.util.JpaUtil;
import java.math.BigDecimal;
import java.util.List;

public class TestPersistencia {

    public static void main(String[] args) {
        // --- Inicio de Prueba Rápida de Persistencia ---
        System.out.println("Iniciando prueba de persistencia...");

        ProductoDao productoDao = new ProductoDao();

        // Crear un nuevo producto
        Producto nuevoProducto = new Producto("Laptop Pro X", "Laptop super potente", new BigDecimal("1250.75"), 15);
        System.out.println("Guardando producto: " + nuevoProducto.getNombre());
        productoDao.guardar(nuevoProducto);
        System.out.println("Producto guardado con ID: " + nuevoProducto.getId());

        // Buscar el producto
        if (nuevoProducto.getId() != null) {
            Producto productoEncontrado = productoDao.buscarPorId(nuevoProducto.getId());
            if (productoEncontrado != null) {
                System.out.println("Producto encontrado: " + productoEncontrado.getNombre() + ", Precio: " + productoEncontrado.getPrecio());
            } else {
                System.err.println("Error: No se encontró el producto con ID: " + nuevoProducto.getId());
            }
        }

        // Listar todos los productos
        System.out.println("Listando todos los productos:");
        List<Producto> todosLosProductos = productoDao.obtenerTodos();
        for (Producto p : todosLosProductos) {
            System.out.println("- " + p.getNombre() + " (ID: " + p.getId() + ")");
        }

        System.out.println("Cerrando EntityManagerFactory...");
        JpaUtil.shutdown();
        System.out.println("Prueba de persistencia finalizada.");
        // --- Fin de Prueba Rápida de Persistencia ---
    }
}