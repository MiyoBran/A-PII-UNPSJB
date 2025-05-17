package ejemplos_TP02.complejo;

public class Complejo {
    private double real;
    private double imag;
  
    //Constructor por defecto de la clase
    public Complejo() {
   
    }
    //Constructor con par�metros
    public Complejo(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    //m�todos setters y getters
    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }
   
    //sumar dos n�meros complejos
    //(a, b) + (c, d) = (a + c, b + d);
    public Complejo sumar(Complejo c){
        Complejo aux = new Complejo();
        aux.real = real + c.real;
        aux.imag = imag + c.imag;
        return aux;
    }
   
    //restar dos n�meros complejos
    //(a, b) - (c, d) = (a - c, b - d);
    public Complejo restar(Complejo c){
        Complejo aux = new Complejo();
        aux.real = real - c.real;
        aux.imag = imag - c.imag;
        return aux;
    }
   
    //multiplicar dos n�meros complejos
    //(a, b) * (c, d) = (a*c � b*d, a*d + b*c)
    public Complejo multiplicar(Complejo c){
        Complejo aux = new Complejo();
        aux.real = real * c.real - imag * c.imag;
        aux.imag = real * c.imag + imag * c.real;
        return aux;
    }
   
    //multiplicar un n�mero complejo por un n�mero de tipo double
    //(a, b) * n = (a * n, b * n)
    public Complejo multiplicar(double n){
        Complejo aux = new Complejo();
        aux.real = real * n;
        aux.imag = imag * n;
        return aux;
    }
   
    //dividir dos n�meros complejos
    //(a, b) / (c, d) = ((a*c + b*d) / (c^2 + d^2) , (b*c � a*d) / (c^2 + d^2))
    public Complejo dividir(Complejo c){
        Complejo aux = new Complejo();
        aux.real = (real * c.real + imag * c.imag)/(c.real * c.real + c.imag * c.imag);
        aux.imag = (imag * c.real - real * c.imag)/(c.real * c.real + c.imag * c.imag);                           
        return aux;
    }

    //m�todo toString
    @Override
    public String toString() {
        return "(" + real + ", " + imag + ")";
    }

    //m�todo equals
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Complejo other = (Complejo) obj;
        if (this.real != other.real) {
            return false;
        }
        if (this.imag != other.imag) {
            return false;
        }
        return true;
    } 
} //Fin de la Clase Complejo Java
