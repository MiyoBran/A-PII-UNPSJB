package ejemplos_TP03.ejemplo_clone.figura;

public class Rectangulo implements Cloneable {
	private int ancho;
	private int alto;
	private Punto origen;

	public Rectangulo() {
		origen = new Punto(0, 0);
		ancho = 0;
		alto = 0;
	}

	public Rectangulo(Punto p) {
		this(p, 0, 0);
	}

	public Rectangulo(int w, int h) {
		this(new Punto(0, 0), w, h);
	}

	public Rectangulo(Punto p, int w, int h) {
		origen = p;
		ancho = w;
		alto = h;
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

	public Punto getOrigen() {
		return origen;
	}

	public void setOrigen(Punto origen) {
		this.origen = origen;
	}

	public Object clone() {
		Rectangulo obj = null;
		try {
			obj = (Rectangulo) super.clone();
		} catch (CloneNotSupportedException ex) {
			System.out.println(" no se puede duplicar");
		}
		// Probar que pasa si se comenta la siguiente l�nea.
		obj.origen = (Punto) obj.origen.clone();
		return obj;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + alto;
		result = prime * result + ancho;
		result = prime * result + ((origen == null) ? 0 : origen.hashCode());
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
		if (alto != other.alto)
			return false;
		if (ancho != other.ancho)
			return false;
		if (origen == null) {
			if (other.origen != null)
				return false;
		} else if (!origen.equals(other.origen))
			return false;
		return true;
	}

	public void mover(int dx, int dy) {
		origen.trasladar(dx, dy);
	}

	public int area() {
		return ancho * alto;
	}

	public String toString() {
		String texto = origen + " ancho: " + ancho + " alto: " + alto;
		return texto;
	}
}