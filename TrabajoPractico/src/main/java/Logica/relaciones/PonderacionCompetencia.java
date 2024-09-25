package Logica.relaciones;

import jakarta.persistence.*;
import java.io.Serializable;
import Logica.entidades.Competencia;
import Logica.entidades.Puesto;

@SuppressWarnings("serial")
@Entity(name="Ponderacion_competencia")
public class PonderacionCompetencia implements Serializable{

	@Id
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="id_competencia", referencedColumnName="id_competencia")
	public Competencia competencia;
	@Id
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_puesto")
	public Puesto puesto;
	@Column(name = "ponderacion")
	public Integer ponderacion;

	
	public PonderacionCompetencia(Integer ponderacion, Competencia competencia, Puesto puesto) {
		super();
		this.ponderacion = ponderacion;
		this.competencia = competencia;
		this.puesto = puesto; 
	}

	public Integer getPonderacion() {
		return ponderacion;
	}

	public void setPonderacion(Integer ponderacion) {
		this.ponderacion = ponderacion;
	}

	public Competencia getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}
	
	
	
}

