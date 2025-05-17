package empresa;

public class Departamento {
	
	private int codigo;
	private String descripcion;
	
	public Departamento(int codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", descripcion="
				+ descripcion + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("ingresa equals");
		if (this == obj)
			return true;
		System.out.println("pasa 1?");
		
		if (obj == null)
			return false;
		System.out.println("pasa 2?");
		
		if (getClass() != obj.getClass())
			return false;
		System.out.println("pasa 3?");
		
		Departamento other = (Departamento) obj;
		
		if (codigo != other.codigo)
			return false;
		System.out.println("pasa 4?");
		
		return true;
	}

	
	
	
	
}
