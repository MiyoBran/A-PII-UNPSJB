package tp2.EmpleadoEj10;
/*
 * ✔ Hereda de EmpleadoPorComision y suma un salario base.
 */
public class EmpleadoBaseMasComision extends EmpleadoPorComision {
    private double salarioBase;

    public EmpleadoBaseMasComision(String nombre, String numeroDocumento, double porcentajeComision, double ventasBrutas, double salarioBase) {
        super(nombre, numeroDocumento, porcentajeComision, ventasBrutas);
        this.salarioBase = salarioBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + salarioBase;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salario Base: $" + salarioBase + ", Salario Total: $" + calcularSalario();
    }
}
