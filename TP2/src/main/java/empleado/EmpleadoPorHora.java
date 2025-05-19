package empleado;

public class EmpleadoPorHora extends Empleado {
    private double valorHora;
    private int horasTrabajadas;

    public EmpleadoPorHora(String nombre, String numeroDocumento, double valorHora, int horasTrabajadas) {
        super(nombre, numeroDocumento);
        this.valorHora = valorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double calcularSalario() {
        return valorHora * horasTrabajadas;
    }

    @Override
    public String toString() {
        return super.toString() + ", Valor Hora: $" + valorHora + ", Horas Trabajadas: " + horasTrabajadas + 
               ", Salario Total: $" + calcularSalario();
    }
}
