package DTOs;

import Logica.entidades.Competencia;
import Logica.entidades.Puesto;

public class PonderacionDTO {
	
	private Competencia comp;
	private Puesto pto;
	private Integer pond;
	
	public PonderacionDTO(Competencia comp, Puesto pto, Integer pond) {
		super();
		this.comp = comp;
		this.pto = pto;
		this.pond = pond;
	} 
	
	public PonderacionDTO() {
		super();
	}
	public Competencia getComp() {
		return comp;
	}
	public void setComp(Competencia comp) {
		this.comp = comp;
	}
	public Puesto getPto() {
		return pto;
	}
	public void setPto(Puesto pto) {
		this.pto = pto;
	}
	public Integer getPond() {
		return pond;
	}
	public void setPond(Integer pond) {
		this.pond = pond;
	}
	public void setNombreComp(String nombreCompetencia) {
		this.comp.setNombre(nombreCompetencia);
	}
	public String getNombre() {
		return this.comp.getNombre();
	}
}
