package facturaAxel;

import java.util.*;

// Interface PorPagar
interface PorPagar {
    double obtenerPago();
}

// Clase Factura implementando PorPagar
class Factura implements PorPagar {
    private String proveedor;
    private String numeroFactura;
    private String fechaCompra;
    private List<Item> items;

    public Factura(String proveedor, String numeroFactura, String fechaCompra) {
        this.proveedor = proveedor;
        this.numeroFactura = numeroFactura;
        this.fechaCompra = fechaCompra;
        this.items = new ArrayList<>();
    }

    public void agregarItem(String descripcion, double precioUnitario, int cantidad) {
        items.add(new Item(descripcion, precioUnitario, cantidad));
    }

    @Override
    public double obtenerPago() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrecioUnitario() * item.getCantidad();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Factura de " + proveedor + " (" + numeroFactura + ") - Fecha: " + fechaCompra + " - Total: $" + obtenerPago();
    }

    // Clase interna Item
    private static class Item {
        private String descripcion;
        private double precioUnitario;
        private int cantidad;

        public Item(String descripcion, double precioUnitario, int cantidad) {
            this.descripcion = descripcion;
            this.precioUnitario = precioUnitario;
            this.cantidad = cantidad;
        }

        public double getPrecioUnitario() {
            return precioUnitario;
        }

        public int getCantidad() {
            return cantidad;
        }
    }
}

// Clase Empleado implementando PorPagar
class Empleado implements PorPagar {
    private String nombre;
    private double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    @Override
    public double obtenerPago() {
        return salario;
    }

    @Override
    public String toString() {
        return "Empleado: " + nombre + " - Salario: $" + salario;
    }
}