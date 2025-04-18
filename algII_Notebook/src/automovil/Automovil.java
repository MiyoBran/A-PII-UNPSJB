package automovil;

public class Automovil {

    // variables de instancia
    private int id;
    private String fabricante;
    private String modelo;
    //private String color = "Blanco";
    private Color color = Color.BLANCO; // cambia el tipo a Color
    
    // variables estaticas
    private static int ultimoId; // se mantiene estatico para todos los objetos
    
    // variables constantes
    //public static final String COLOR_ROJO = "Rojo";
    //public static final String COLOR_AZUL = "Azul";
    //public static final String COLOR_NEGRO = "Negro";    
    
    public Automovil(){
        this.id = ++ultimoId;
    }
    
    // Herencia y sobrecarga de constructores
    public Automovil(String fabricante, String modelo){
        this(); // se invoca el constructor sin parametro para que asigne el id
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public Automovil(String fabricante, String modelo, Color color){
        this(fabricante, modelo);
        this.color = color;
    }    
    
    // metodos obtener y establecer
    public String getFabricante(){
        return fabricante;
    }
    
    public void setFabricante(String fabricante){
        this.fabricante = fabricante;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public Color getColor(){
        return color;
    }
    
    public void setColor(Color color){
        this.color = color;
    }
 
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    // Polismorfismo: sobreescritura de métodos de la clase padre
    @Override
    // toString para representar un objeto en una salida de cadena
    public String toString(){
        return String.format("Id: %d"
                + "\nFabricante: %s"
                + "\nModelo: %s"
                + "\nColor: %s",
                getId(), 
                getFabricante(), 
                getModelo(), 
                //getColor().getColor() // se llama al metodo de enum Color, y cambia al texto personalizado
                getColor() // de este modo el texto aparece en mayuscula, pero si en enum Color se genera un metodo toString y se modifica su retorno, este retornara el texto personalizado, esto es para evitar tener que llamar directamente al metodo de enum, es decir no hacer esto: getColor().getColor()
        );
    }
    
    @Override
    public boolean equals(Object obj){
        
        if(!(obj instanceof Automovil))
            return false;
        
        Automovil automovil = (Automovil) obj; // castear
        return (getFabricante() != null && getModelo() != null && getFabricante().equals(automovil.getFabricante()) && getModelo().equals(automovil.getModelo()));
    }
    
}
