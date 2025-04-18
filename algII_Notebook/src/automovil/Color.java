package automovil;

public enum Color {
    // personalizar para que al llamar a la constante no sea el mismo nombre de la constante en mayuscula
    
    // esto seria como invocar un constructor del enumerador, se pasa por argumento el color
    BLANCO("Blanco"),
    ROJO("Rojo"),
    AZUL("Azul"),
    NEGRO("Negro");    
    
    private final String color; // guardamos el color personalizado
    
    // constructor, se pasa por argumento el color asignandolo a la constante color
    Color(String color){
        this.color = color;
    }
    
    public String getColor(){
        return color;
    }
    
    @Override
    // al imprimir el enum se muestra esta representacion
    public String toString(){
        return this.color; // retorna texto personalizado
    }
}
