package Logica.entidades;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "Evaluacion")
public class Evaluacion {
	
	@Id
	@Column(name = "id_evaluacion")
	private Integer id_evaluacion;
	@Column(name = "fecha_inicio")
	public Date fechaInicio;
	@Column(name = "fecha_final")
	public Date fechaFinal;
	@Column(name = "maximos_candidatos")
	public Integer maximoCandidatos;

	public Evaluacion(Date fechaInicio, Date fechaFinal, Integer maximoCandidatos) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal; 
		this.maximoCandidatos = maximoCandidatos;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Integer getMaximoCandidatos() {
		return maximoCandidatos;
	}

	public void setMaximoCandidatos(Integer maximoCandidatos) {
		this.maximoCandidatos = maximoCandidatos;
	}

}
