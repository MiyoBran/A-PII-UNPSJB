package ej2PilaEmpleados;
//	✔ Calcula el salario basado en las ventas y el porcentaje de comisión.
public class EmpleadoPorComision extends Empleado {
    private double porcentajeComision;
    private double ventasBrutas;

    public EmpleadoPorComision(String nombre, String numeroDocumento, double porcentajeComision, double ventasBrutas) {
        super(nombre, numeroDocumento);
        this.porcentajeComision = porcentajeComision;
        this.ventasBrutas = ventasBrutas;
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public double getVentasBrutas() {
        return ventasBrutas;
    }

    public void setVentasBrutas(double ventasBrutas) {
        this.ventasBrutas = ventasBrutas;
    }

    @Override
    public double calcularSalario() {
        return (porcentajeComision / 100) * ventasBrutas;
    }

    @Override
    public String toString() {
        return super.toString() + ", Ventas Brutas: $" + ventasBrutas + ", Comisión: " + porcentajeComision + "%" +
               ", Salario Total: $" + calcularSalario();
    }
}
