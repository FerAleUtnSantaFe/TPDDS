package Logica.entidades;

import jakarta.persistence.*;
import Logica.enumeraciones.TipoCompetencia;

@Entity
@Table(name = "Competencia")
public class Competencia {

	@Id
	@Column(name = "id_competencia")
	private Integer id_competencia;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "tipoCompetencia")
	private TipoCompetencia tipoCompetencia;

	public Competencia() {
	}
	
	public Competencia(Integer codigo, String nombre, String descripcion, TipoCompetencia tipoCompetencia) {
		super();
		this.id_competencia = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipoCompetencia = tipoCompetencia;
	}

	public Integer getCodigo() {
		return id_competencia;
	}

	public void setCodigo(Integer codigo) {
		this.id_competencia = codigo;
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

	public TipoCompetencia getTipoCompetencia() {
		return tipoCompetencia;
	}

	public void setTipoCompetencia(TipoCompetencia tipoCompetencia) {
		this.tipoCompetencia = tipoCompetencia;
	}

}