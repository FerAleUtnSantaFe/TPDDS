package Logica.entidades;

public class Respuesta {
	public Integer numero;
	public String descripcion;
	public String nombre;

	public Respuesta(Integer numero, String descripcion, String nombre) {
		super();
		this.numero = numero;
		this.descripcion = descripcion;
		this.nombre = nombre;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
