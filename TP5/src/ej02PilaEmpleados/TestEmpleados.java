package ej02PilaEmpleados;

import java.util.ArrayList;
/*
 * ✔ Crea una lista de empleados con diferentes tipos.
 * ✔ Usa polimorfismo (ArrayList<Empleado>).
 * ✔ Detecta EmpleadoBaseMasComision y aplica un 10% extra.
 * 
 */
public class TestEmpleados {
    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();

        empleados.add(new EmpleadoAsalariado("Juan Pérez", "12345678", 2000));
        empleados.add(new EmpleadoPorHora("Ana López", "87654321", 20, 160));
        empleados.add(new EmpleadoPorComision("Carlos Gómez", "45678912", 5, 10000));
        empleados.add(new EmpleadoBaseMasComision("María Díaz", "78912345", 8000, 4, 1500));

        System.out.println("Lista de empleados y salarios:");
        for (Empleado e : empleados) {
            System.out.println(e);
        }

        System.out.println("\nAplicando 10% de incremento a EmpleadoBaseMasComision...");
        for (Empleado e : empleados) {
            if (e instanceof EmpleadoBaseMasComision) {
                double nuevoSalario = e.calcularSalario() * 1.10;
                System.out.println(e + ", Nuevo Salario: $" + nuevoSalario);
            }
        }
    }
}
