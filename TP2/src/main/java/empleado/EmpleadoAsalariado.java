package empleado;

public class EmpleadoAsalariado extends Empleado {
    private double salarioMensual;

    public EmpleadoAsalariado(String nombre, String numeroDocumento, double salarioMensual) {
        super(nombre, numeroDocumento);
        this.salarioMensual = salarioMensual;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salario Mensual: $" + salarioMensual;
    }
}
