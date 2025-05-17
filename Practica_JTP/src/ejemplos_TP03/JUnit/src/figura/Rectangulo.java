package ejemplos_TP03.JUnit.src.figura;

public class Rectangulo {

	private int ancho;
	private int alto;
	
	public Rectangulo(int ancho, int alto) {
		super();
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public int area() {
		return ancho * alto;
	}
	
	public int perimetro() {
		return 2 * (ancho + alto);
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + alto;
		result = prime * result + ancho;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangulo other = (Rectangulo) obj;
		if (alto != other.alto && alto != other.ancho)
			return false;
		if (ancho != other.ancho && ancho != other.alto)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rectangulo [ancho=" + ancho + ", alto=" + alto + "]";
	}
	
	
	
}
