// En src/main/java/com/CIOTech/TestPersistencia.java
package com.CIOTech;

import com.CIOTech.MVP.model.Producto;
import com.CIOTech.MVP.dao.ProductoDao;
import com.CIOTech.MVP.util.JpaUtil;
import java.math.BigDecimal;
import java.util.List;

public class TestPersistencia {
    public static void main(String[] args) {
        System.out.println("Iniciando TestPersistencia.main()...");
        ProductoDao productoDao = new ProductoDao();

        System.out.println("Intentando guardar un nuevo producto...");
        Producto p1 = new Producto("Mouse Inalámbrico", "Mouse ergonómico", new BigDecimal("25.99"), 75);
        productoDao.guardar(p1);
        if (p1.getId() != null) {
            System.out.println("Producto guardado con ID: " + p1.getId() + " Nombre: " + p1.getNombre());
        } else {
            System.err.println("Error: El ID del producto p1 es nulo después de guardar.");
        }

        Producto p2 = new Producto("Monitor Curvo 27\"", "Monitor LED curvo", new BigDecimal("299.50"), 20);
        productoDao.guardar(p2);
        if (p2.getId() != null) {
            System.out.println("Producto guardado con ID: " + p2.getId() + " Nombre: " + p2.getNombre());
        } else {
            System.err.println("Error: El ID del producto p2 es nulo después de guardar.");
        }

        System.out.println("Listando todos los productos DESPUÉS de guardar:");
        List<Producto> todos = productoDao.obtenerTodos();
        if (todos.isEmpty()) {
            System.out.println("No se encontraron productos.");
        } else {
            for (Producto p : todos) {
                System.out.println("- " + p.getNombre() + " (ID: " + p.getId() + ", Precio: " + p.getPrecio() + ")");
            }
        }

        JpaUtil.shutdown();
        System.out.println("TestPersistencia.main() finalizado.");
    }
}