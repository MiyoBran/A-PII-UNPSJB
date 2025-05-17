package banco;

import java.util.Objects;

/**
 * Representa un título de tipo Acción, que hereda de Título.
 * @author MiyenBrandolino
 */
public class Accion extends Titulo {

    // --- Atributos Específicos ---
    private boolean pagaDividendo; // Indica si la acción paga dividendos

    /**
     * Impuesto específico para la compra de acciones (ej. 20%).
     * Usamos 'static final' como patrón.
     */
    public static final double IMPUESTO_ACCION = 0.2;

    // --- Constructor ---
    /**
     * Constructor para crear una Acción.
     * @param simbolo Símbolo de la acción (ej. "YPF").
     * @param descripcion Nombre de la empresa (ej. "YPF").
     * @param precio Precio actual de la acción.
     * @param pagaDividendo Si paga o no dividendos.
     */
    public Accion(String simbolo, String descripcion, double precio, boolean pagaDividendo) {
        super(simbolo, descripcion, precio);
        this.pagaDividendo = pagaDividendo;
    }

    // --- Getter Específico ---
    public boolean isPagaDividendo() {
        return pagaDividendo;
    }

    // --- Implementación del Método Abstracto ---
    /**
     * Calcula el impuesto específico para la compra de acciones.
     * Fórmula: cantidad * precio * IMPUESTO_ACCION
     * @param cantidad Cantidad de acciones compradas.
     * @return El impuesto calculado.
     */
    @Override
    public double calcularImpuesto(int cantidad) {
        return cantidad * this.getPrecio() * IMPUESTO_ACCION;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        // Llama al equals de la clase padre para comparar simbolo, desc, precio
        if (!super.equals(obj)) return false;
         // Si lo anterior es igual, compara el atributo propio de Accion
        if (getClass() != obj.getClass()) return false; // Asegura que sea exactamente una Accion
        Accion accion = (Accion) obj;
        return pagaDividendo == accion.pagaDividendo;
    }

    @Override
    public int hashCode() {
        // Combina el hashCode de la clase padre con el del atributo propio
        return Objects.hash(super.hashCode(), pagaDividendo);
    }

    @Override
    public String toString() {
        // Reutiliza el toString de la clase padre y añade la información específica
        return "Accion [" + super.toString() + ", pagaDividendo=" + pagaDividendo + "]";
    }
}