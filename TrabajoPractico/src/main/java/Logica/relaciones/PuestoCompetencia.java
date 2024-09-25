package Logica.relaciones;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

@Embeddable
public class PuestoCompetencia implements Serializable {

	private static final long serialVersionUID = 1L;

	public int id_puesto;
	public int id_competencia;

	public PuestoCompetencia() {
		
	}
	
	public PuestoCompetencia(int id_puesto, int id_competencia) {
		super();
		this.id_puesto = id_puesto;
		this.id_competencia = id_competencia;
	}

}