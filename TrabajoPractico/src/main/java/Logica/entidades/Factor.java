package Logica.entidades;

public class Factor {
	public String nombre;
	public String descripcion;
	public Integer puntaje;

	public Factor(String nombre, String descripcion, Integer puntaje) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.puntaje = puntaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

}
