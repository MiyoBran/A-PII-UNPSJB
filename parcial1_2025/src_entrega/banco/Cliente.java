package banco;

import java.util.Objects;

/**
 * Representa a un cliente del banco que puede poseer activos financieros.
 * 
 * @author MiyenBrandolino
 */
public class Cliente {

	// --- Atributos ---
	private String nombre;
	private String email;

	/**
	 * Límite máximo de títulos distintos que puede tener un cliente. Para evitar
	 * "número mágico" Usamos static final para definirlo como constante.
	 */
	private static final int MAX_ACTIVOS_DISTINTOS = 100;

	/**
	 * Array para almacenar las tenencias de activos del cliente. Se usa un array de
	 * tamaño fijo para cumplir con el requisito de lanzar
	 * ArrayIndexOutOfBoundsException.
	 */
	private Activo[] activos;

	/**
	 * Lleva la cuenta de cuántos activos *distintos* tiene el cliente actualmente.
	 * También indica la próxima posición libre en el array 'activos'.
	 */
	private int cantidadActivosDistintos;

	// --- Constructor ---
	/**
	 * Crea un nuevo cliente.
	 * 
	 * @param nombre Nombre del cliente.
	 * @param email  Email del cliente (usado como identificador).
	 */
	public Cliente(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
		// Inicializa el array de activos con el tamaño máximo
		this.activos = new Activo[MAX_ACTIVOS_DISTINTOS];
		// Inicialmente no tiene ningún activo distinto
		this.cantidadActivosDistintos = 0;
	}

	// --- Getters ---
	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	// --- Métodos de Negocio ---

	/**
	 * Agrega nuevos activos al portafolio del cliente. Si el título ya existe,
	 * incrementa su cantidad. Si el título no existe y hay espacio, lo agrega como
	 * un nuevo Activo.
	 *
	 * @param titulo   El Título comprado (Accion o Bono).
	 * @param cantidad La cantidad comprada.
	 * @throws ArrayIndexOutOfBoundsException si el cliente ya tiene el máximo
	 *                                        permitido de activos distintos y se
	 *                                        intenta agregar uno nuevo.
	 */
	public void comprarActivo(Titulo titulo, int cantidad) throws ArrayIndexOutOfBoundsException {
		if (cantidad <= 0) {
			System.out.println("Advertencia: La cantidad a comprar debe ser positiva.");
			return;
		}
		if (titulo == null) {
			System.out.println("Advertencia: El título a comprar no puede ser nulo.");
			return; 
		}

		// 1. Buscar si el cliente ya posee este título
		for (int i = 0; i < this.cantidadActivosDistintos; i++) {
			// Equals de Activo, que compara por Título
			if (this.activos[i].getTitulo().equals(titulo)) {
				this.activos[i].setCantidad(this.activos[i].getCantidad() + cantidad);
				System.out.println("Cantidad actualizada para " + titulo.getSimbolo() + " para cliente " + this.nombre);
				return;
			}
		}

		// 2. El cliente no tiene ese título. Hay que agregarlo.
		// Verificar si hay espacio en el array
		if (this.cantidadActivosDistintos >= MAX_ACTIVOS_DISTINTOS) {
			throw new ArrayIndexOutOfBoundsException("El cliente " + this.nombre + " ha alcanzado el máximo de "
					+ MAX_ACTIVOS_DISTINTOS + " activos distintos.");
		}

		// Hay espacio, crear el nuevo Activo y agregarlo
		Activo nuevoActivo = new Activo(titulo, cantidad);
		this.activos[this.cantidadActivosDistintos] = nuevoActivo;
		this.cantidadActivosDistintos++; // Incrementar el contador de activos distintos
		System.out.println("Nuevo activo " + titulo.getSimbolo() + " agregado para cliente " + this.nombre);
	}

	/**
	 * Calcula el valor total del portafolio del cliente. Suma el valor de cada
	 * activo (precio del título * cantidad poseída).
	 *
	 * @return La valuación total de los activos del cliente.
	 */
	public double totalActivo() {
		double total = 0.0;
		for (int i = 0; i < this.cantidadActivosDistintos; i++) {
			Activo activo = this.activos[i];
			total += activo.getTitulo().getPrecio() * activo.getCantidad();
		}
		return total;
	}

	// --- equals, hashCode, toString ---

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Cliente cliente = (Cliente) obj;
		// Email como identificador único del cliente
		return Objects.equals(email, cliente.email);
	}

	@Override
	public int hashCode() {
		// Email para generar el hashCode
		return Objects.hash(email);
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", email=" + email + "]";
	}
}