package DTOs;

import java.util.ArrayList;
import Logica.relaciones.PonderacionCompetencia;
import javafx.collections.ObservableList;

public class PuestoDTO {
	public Integer codigo;
	public String nombre;
	public String descripcion;
	public String empresa;
	public ArrayList<PonderacionCompetencia> ponderaciones;
	
	public PuestoDTO() {
		
	}
	
	public PuestoDTO(Integer codigo, String nombre, String descripcion, String empresa,
			ArrayList<PonderacionCompetencia> ponderaciones) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.empresa = empresa; 
		this.ponderaciones = ponderaciones;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public ArrayList<PonderacionCompetencia> getPonderaciones() {
		return ponderaciones;
	}

	public void setPonderaciones(ArrayList<PonderacionCompetencia> ponderaciones) {
		this.ponderaciones = ponderaciones;
	}
	
}
