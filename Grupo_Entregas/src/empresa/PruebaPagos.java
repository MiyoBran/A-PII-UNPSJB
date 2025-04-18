package empresa;

/**
 * Prueba las clases Factura y Empleado, almacenándolos en un arreglo de tipo
 * PorPagar. Se crean instancias de empleados y facturas, se asignan al
 * arreglo y se muestra el importe a pagar de cada elemento.
 * 
 * @author catedra
 * @author ArispeClaudio crapz0190@gmail.com
 * @author BrandolinoCarlos miyenbran@gmail.com
 * @author ColipanAxel maurocolipannn@gmail.com
 * @author MarinoLizandro lizandro.e.marino@gmail.com
 * @version 1.5
 */
public class PruebaPagos {

    public static void main(String[] args) {
        
        // Empiezo a instanciar los objetos de clase Facturas y Empleados
        PorPagar pagos[] = new PorPagar[10];

        // Cargar cinco empleados y cinco facturas
        Empleado e1 = new Empleado(1234, "Nombre1", null, 8, 5000);
        Empleado e2 = new Empleado(42345, "Nombre2", e1, 5, 12000);
        Empleado e3 = new Empleado(64567, "Nombre3", e2, 12, 6500);
        Empleado e4 = new Empleado(86754, "Nombre4", e3, 5, 23000);
        Empleado e5 = new Empleado(6425, "Nombre5", e4, 4, 50000);
        
        Factura f1 = new Factura("Proveedor1", 24544, "2025-03-02");
        Factura f2 = new Factura("Proveedor2", 65425, "2025-02-22");
        Factura f3 = new Factura("Proveedor3", 67243, "2025-04-01");
        Factura f4 = new Factura("Proveedor4", 23465, "2025-03-12");
        Factura f5 = new Factura("Proveedor5", 45635, "2025-01-15");

        f1.agregarItem("descripcion1", 6, 1905);
        f1.agregarItem("descripcion2", 3, 5905);
        f1.agregarItem("descripcion3", 1, 9045);
        f2.agregarItem("descripcion2.1", 3, 3453);
        f2.agregarItem("descripcion2.2", 6, 7644);
        f2.agregarItem("descripcion2.4", 2, 2300);
        f3.agregarItem("descripcion3.1", 1, 34870);
        f3.agregarItem("descripcion3.34", 1, 23450);
        f4.agregarItem("descripcion4", 8, 40540);
        f5.agregarItem("descripcion5.4", 4, 6756);
        f5.agregarItem("descripcion5.7", 1, 1246);
        f5.agregarItem("descripcion5.8", 6, 7756);
        f5.agregarItem("descripcion5.12", 12, 4546);

        // Asignar los objetos creados a un lugar del arreglo 'pagos'
        pagos[0] = e1;
        pagos[1] = e2;
        pagos[2] = e3;
        pagos[3] = e4;
        pagos[4] = e5;
        pagos[5] = f1;
        pagos[6] = f2;
        pagos[7] = f3;
        pagos[8] = f4;
        pagos[9] = f5;

        // Escribir el resultado que tienen que pagar cada uno
        for (int i = 0; i < pagos.length; i++) {
            System.out.printf("Importes a pagar: $ %,.02f\n", pagos[i].obtenerPago());
        }
    }
}
