package com.CIOTech.MVP.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Clase utilitaria para gestionar la creación del EntityManagerFactory de JPA.
 * Implementa el patrón Singleton para asegurar una única instancia de EntityManagerFactory.
 *
 * @author MiyoBran // O tu nombre
 * @version 1.0
 */
public class JpaUtil {

    // El nombre de la unidad de persistencia definido en persistence.xml
    private static final String PERSISTENCE_UNIT_NAME = "MVPPersistenceUnit";
    private static EntityManagerFactory factory;

    /**
     * Obtiene la instancia del EntityManagerFactory.
     * La crea si aún no existe (lazy initialization).
     *
     * @return La instancia del EntityManagerFactory.
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            // Se crea el EntityManagerFactory usando el nombre de la unidad de persistencia.
            // Esto leerá el archivo persistence.xml.
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    /**
     * Cierra el EntityManagerFactory.
     * Debe llamarse cuando la aplicación se cierra para liberar recursos.
     */
    public static void shutdown() {
        if (factory != null) {
            factory.close();
            factory = null; // Para permitir recreación si es necesario (raro en apps típicas)
        }
    }
}