package ej02PilaEmpleados;
/*
 * ✔ Define estructura común y un método abstracto calcularSalario().
 */
public abstract class Empleado {
    private String nombre;
    private String numeroDocumento;

    public Empleado(String nombre, String numeroDocumento) {
        this.nombre = nombre;
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    
    // método abstracto que heredan las subclases.
    public abstract double calcularSalario();
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Documento: " + numeroDocumento;
    }
}
