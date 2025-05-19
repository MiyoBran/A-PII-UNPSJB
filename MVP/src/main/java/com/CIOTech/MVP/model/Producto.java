package com.CIOTech.MVP.model; // Asegúrate de que el paquete sea el correcto

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal; // Recomendado para manejar dinero/precios

/**
 * Representa un producto en el sistema.
 * Esta clase es una entidad JPA mapeada a la tabla "productos" en la base de datos.
 *
 * @author MiyoBran // O tu nombre
 * @version 1.0
 */
@Entity // Le dice a JPA que esta clase es una entidad y debe ser mapeada a una tabla.
@Table(name = "productos") // Especifica el nombre de la tabla en la base de datos.
public class Producto {

    @Id // Marca este campo como la clave primaria de la tabla.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura la generación automática del ID.
                                                        // Para PostgreSQL, IDENTITY suele ser una buena estrategia,
                                                        // ya que puede mapear a tipos SERIAL o BIGSERIAL.
    @Column(name = "id_producto") // Especifica el nombre de la columna en la BD (opcional si coincide con el nombre del campo).
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100) // nullable=false significa que no puede ser nulo.
                                                             // length define el tamaño máximo del string.
    private String nombre;

    @Column(name = "descripcion", length = 255) // La descripción es opcional y más larga.
    private String descripcion;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2) // precision=total de dígitos, scale=dígitos después del punto decimal.
    private BigDecimal precio; // Usar BigDecimal es la mejor práctica para valores monetarios para evitar problemas de precisión.

    @Column(name = "stock")
    private int stock;

    /**
     * Constructor por defecto requerido por JPA.
     * No debe ser usado directamente en la mayoría de los casos.
     */
    public Producto() {
    }

    /**
     * Constructor para crear un nuevo producto con sus atributos iniciales.
     * El ID es generado por la base de datos, por lo que no se incluye aquí.
     *
     * @param nombre El nombre del producto.
     * @param descripcion La descripción del producto.
     * @param precio El precio del producto.
     * @param stock La cantidad en stock del producto.
     */
    public Producto(String nombre, String descripcion, BigDecimal precio, int stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    // --- Getters y Setters ---

    public Long getId() {
        return id;
    }

    // Generalmente no se proporciona un setId() para IDs generados automáticamente.
    // public void setId(Long id) {
    //     this.id = id;
    // }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // --- (Opcional) Métodos toString, equals, hashCode ---
    // Puedes generarlos si los necesitas (Eclipse: Source > Generate ...)

    @Override
    public String toString() {
        return "Producto{" +
               "id=" + id +
               ", nombre='" + nombre + '\'' +
               ", precio=" + precio +
               ", stock=" + stock +
               '}';
    }
}