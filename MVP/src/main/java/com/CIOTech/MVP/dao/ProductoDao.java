package com.CIOTech.MVP.dao;

import com.CIOTech.MVP.model.Producto; // Importa tu entidad Producto
import com.CIOTech.MVP.util.JpaUtil;   // Importa la utilidad JPA
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery; // Para consultas tipadas
import java.util.List;

/**
 * DAO para la entidad Producto. Proporciona métodos CRUD.
 *
 * @author MiyoBran // O tu nombre
 * @version 1.0
 */
public class ProductoDao {

    /**
     * Guarda un nuevo producto en la base de datos o actualiza uno existente.
     *
     * @param producto El producto a guardar o actualizar.
     */
    public void guardar(Producto producto) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            if (producto.getId() == null) {
                em.persist(producto); // Guarda un nuevo producto
            } else {
                em.merge(producto);   // Actualiza un producto existente
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace(); // Manejo básico de excepciones, considera un logging más robusto
            // Podrías relanzar una excepción personalizada aquí
        } finally {
            em.close();
        }
    }

    /**
     * Busca un producto por su ID.
     *
     * @param id El ID del producto a buscar.
     * @return El producto encontrado, o null si no se encuentra.
     */
    public Producto buscarPorId(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene todos los productos de la base de datos.
     *
     * @return Una lista de todos los productos.
     */
    public List<Producto> obtenerTodos() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            // JPQL (Java Persistence Query Language) para seleccionar todos los productos
            TypedQuery<Producto> query = em.createQuery("SELECT p FROM Producto p", Producto.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Elimina un producto de la base de datos.
     *
     * @param id El ID del producto a eliminar.
     */
    public void eliminar(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            Producto producto = em.find(Producto.class, id);
            if (producto != null) {
                em.remove(producto);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}