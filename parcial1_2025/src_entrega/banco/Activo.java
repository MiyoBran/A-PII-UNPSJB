package banco;

import java.util.Objects;

/**
 * Representa la tenencia de una cantidad específica de un Título
 * dentro del portafolio de un cliente.
 * @author MiyenBrandolino
 */
public class Activo {

    // --- Atributos ---
    private Titulo titulo; // El título financiero (puede ser Accion o Bono)
    private int cantidad; // La cantidad de este título que posee el cliente

    // --- Constructor ---
    /**
     * Crea una nueva tenencia de activo.
     * @param titulo El Título que se posee.
     * @param cantidad La cantidad inicial poseída.
     */
    public Activo(Titulo titulo, int cantidad) {
        if (titulo == null) {
            throw new IllegalArgumentException("El título no puede ser nulo.");
        }
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        this.titulo = titulo;
        this.cantidad = cantidad;
    }

    // --- Getters ---
    public Titulo getTitulo() {
        return titulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    // --- Setter ---
    /**
     * Establece (o actualiza) la cantidad de este activo.
     * @param cantidad La nueva cantidad.
     */
    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        this.cantidad = cantidad;
    }

    // --- equals, hashCode, toString ---

    /**
     * Dos objetos Activo son iguales si representan el mismo Título
     * (independientemente de la cantidad).
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Activo activo = (Activo) obj;
        // Comparamos solo por el título asociado
        return Objects.equals(titulo, activo.titulo);
    }

    /**
     * El hashCode se basa únicamente en el título asociado.
     */
    @Override
    public int hashCode() {
        // Usamos el hashCode del título
        return Objects.hash(titulo);
    }

    @Override
    public String toString() {
        // Llama al toString() del título para obtener sus detalles
        return "Activo [titulo=" + titulo.toString() + ", cantidad=" + cantidad + "]";
    }
}