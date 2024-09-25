package Logica.entidades;

import java.util.Date;
import Logica.enumeraciones.TipoDoc;
import jakarta.persistence.*;

@Entity
@Table(name="Candidato")
public class Candidato {
	
	@Id
	@Column(name = "id_candidato")
	public Integer NroCandidato;
	@Column(name = "tipoDoc")
	public TipoDoc tipoDoc;
	@Column(name = "documento")
	public Integer documento;
	@Column(name = "apellido")
	public String apellido;
	@Column(name = "nombre")
	public String nombre;
	@Column(name = "fechaNacimiento")
	public Date fechaNacimiento;
	@Column(name = "nacionalidad")
	public String nacionalidad;
	@Column(name = "escolaridad")
	public String escolaridad;
	@Column(name = "eliminado")
	public boolean eliminado;

	public Candidato(Integer nroCandidato, TipoDoc tipoDoc, Integer documento, String apellido, String nombre,
			Date fechaNacimiento, String nacionalidad, String escolaridad, boolean eliminado) {
		super();
		NroCandidato = nroCandidato;
		this.tipoDoc = tipoDoc;
		this.documento = documento;
		this.apellido = apellido; 
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.escolaridad = escolaridad;
		this.eliminado = eliminado;
	}

	public Integer getNroCandidato() {
		return NroCandidato;
	}

	public void setNroCandidato(Integer nroCandidato) {
		NroCandidato = nroCandidato;
	}

	public TipoDoc getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(TipoDoc tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public Integer getDocumento() {
		return documento;
	}

	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEscolaridad() {
		return escolaridad;
	}

	public void setEscolaridad(String escolaridad) {
		this.escolaridad = escolaridad;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}

}
