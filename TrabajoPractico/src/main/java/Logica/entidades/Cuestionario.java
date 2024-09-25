package Logica.entidades;

import java.util.Date;

import Logica.enumeraciones.EstadoCuestionario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cuestionario")
public class Cuestionario {
	
	@Id
	@Column(name = "id_cuestionario")
	private Integer id_cuestionario;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "tiempo_restante")
	private Date tiempo;
	@Column(name = "clave")
	private String clave;
	@Column(name = "estado")
	private EstadoCuestionario estado;
	
	public Cuestionario(String nombre, Date tiempo, EstadoCuestionario estado, String clave) {
		super();
		this.nombre = nombre;
		this.tiempo = tiempo;
		this.estado = estado; 
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getTiempo() {
		return tiempo;
	}

	public void setTiempo(Date tiempo) {
		this.tiempo = tiempo;
	}

	public EstadoCuestionario getEstado() {
		return estado;
	}

	public void setEstado(EstadoCuestionario estado) {
		this.estado = estado;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
