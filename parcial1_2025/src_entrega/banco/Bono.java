package banco;

import java.time.LocalDate; // Necesitamos importar LocalDate
import java.util.Objects;

/**
 * Representa un título de tipo Bono, que hereda de Título.
 * @author MiyenBrandolino
 */
public class Bono extends Titulo {

    // --- Atributos Específicos ---
    private LocalDate fechaVencimiento; // Fecha de vencimiento del bono

    /**
     * Impuesto específico para la compra de bonos (ej. 1%).
     * Usamos 'static final' como patrón.
     */
    public static final double IMPUESTO_BONO = 0.01; // 1%

    // --- Constructor ---
    /**
     * Constructor para crear un Bono.
     * @param simbolo Símbolo del bono (ej. "AL30").
     * @param descripcion Descripción del bono (ej. "Bono AL 30").
     * @param precio Precio actual del bono.
     * @param fechaVencimiento Fecha de vencimiento del bono.
     */
    public Bono(String simbolo, String descripcion, double precio, LocalDate fechaVencimiento) {
        // Llama al constructor de la clase padre (Titulo)
        super(simbolo, descripcion, precio);
        this.fechaVencimiento = fechaVencimiento;
    }

    // --- Getter Específico ---
    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    // --- Implementación del Método Abstracto ---
    /**
     * Calcula el impuesto específico para la compra de bonos.
     * Fórmula: cantidad * precio * IMPUESTO_BONO
     * @param cantidad Cantidad de bonos comprados.
     * @return El impuesto calculado.
     */
    @Override
    public double calcularImpuesto(int cantidad) {
        return cantidad * this.getPrecio() * IMPUESTO_BONO;
    }

    // --- equals, hashCode, toString (Complementando los de Titulo) ---

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        // Llama al equals de la clase padre
        if (!super.equals(obj)) return false;
        // Compara el atributo propio
        if (getClass() != obj.getClass()) return false; // Asegura que sea Bono
        Bono bono = (Bono) obj;
        return Objects.equals(fechaVencimiento, bono.fechaVencimiento);
    }

    @Override
    public int hashCode() {
        // Combina el hashCode padre con el del atributo propio
        return Objects.hash(super.hashCode(), fechaVencimiento);
    }

    @Override
    public String toString() {
        // Reutiliza el toString padre y añade info específica
        return "Bono [" + super.toString() + ", fechaVencimiento=" + fechaVencimiento + "]";
    }
}