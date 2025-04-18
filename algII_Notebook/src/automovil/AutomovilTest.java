package automovil;
import java.util.Date;

public class AutomovilTest {

    public static void main(String[] args) {
        
        Automovil chevroletPersonal = new Automovil("General Motors","Onix");
        Automovil chevroletPersonalCopia = new Automovil("General Motors","Onix");
        Automovil chevroletTrabajo = new Automovil("General Motors","Cruze", Color.ROJO);
        Automovil peugeot = new Automovil("Stellantis","Expert", Color.NEGRO);
        
        Date fecha = new Date();
        
        System.out.println(chevroletPersonal.toString());
        System.out.println();
        System.out.println(chevroletTrabajo.toString());
        System.out.println();
        System.out.println(peugeot.toString());
        
        System.out.println("\nNuevo color de automovil peugeot");
        peugeot.setColor(Color.AZUL);
        System.out.println(peugeot.toString());
        
        // ---------- comparar objetos ------------
        
        System.out.println();
        // compara por referencia
        // cada objeto que se crea se guarda en memoria, en algún puntero, referencia distinta.
        // Independientemente si tiene los mismos datos o no.
        System.out.println("¿Son iguales por referencia? " + (chevroletPersonal == chevroletTrabajo)); 
        // compara por valor (fabricante y modelo)
        System.out.println("¿Son iguales por valor con equal? " + chevroletPersonal.equals(chevroletTrabajo));
        System.out.println("¿Son iguales por valor con equal? " + chevroletPersonal.equals(chevroletPersonalCopia));
        
        System.out.println("¿Son del mismo tipo (Automovil y Date)? " + chevroletPersonal.equals(fecha));
        System.out.println("¿Son del mismo tipo (Automovil y String)? " + chevroletPersonal.equals(new String("hola")));
        
    }

    
}
