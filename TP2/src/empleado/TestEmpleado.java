package empleado;

public class TestEmpleado {
    public static void main(String[] args) {
        EmpleadoAsalariado emp1 = new EmpleadoAsalariado("Juan Perez", "12345678", 250000);
        EmpleadoPorHora emp2 = new EmpleadoPorHora("Maria Lopez", "87654321", 5000, 40);
        EmpleadoPorComision emp3 = new EmpleadoPorComision("Carlos Gomez", "11223344", 10, 150000);
        EmpleadoBaseMasComision emp4 = new EmpleadoBaseMasComision("Ana Martinez", "44332211", 5, 200000, 50000);

        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);
        System.out.println(emp4);
    }
}
