package Logica.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.*;
import Logica.relaciones.PonderacionCompetencia;

@Entity
@Table(name = "Puesto")
public class Puesto {

	@Id
	@Column(name = "id_puesto")
	public Integer id_puesto;
	@Column(name = "nombre")
	public String nombre;
	@Column(name = "descripcion")
	public String descripcion;
	@Column(name = "empresa")
	public String empresa; 
	
	@OneToMany(
			mappedBy="puesto",
	        cascade = CascadeType.ALL,
	        orphanRemoval = false
			)
	public List<PonderacionCompetencia> ponderaciones = new ArrayList<>();

	public Puesto() {
	
	}
	
	public Puesto(Integer codigo, String nombre, String descripcion, String empresa,
			List<PonderacionCompetencia> ponderaciones) {
		super();
		this.id_puesto = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.empresa = empresa;
		this.ponderaciones = ponderaciones;
	}

	public Puesto(Integer codigo, String nombre, String descripcion, String empresa) {
		super();
		this.id_puesto = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.empresa = empresa;
	}

	public List<PonderacionCompetencia> getPonderaciones() {
		return ponderaciones;
	}

	public void setPonderaciones(ArrayList<PonderacionCompetencia> ponderaciones) {
		this.ponderaciones = ponderaciones;
	}

	public Integer getCodigo() {
		return id_puesto;
	}

	public void setCodigo(Integer codigo) {
		this.id_puesto = codigo;
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

	@Override
	public int hashCode() {
		return Objects.hash(id_puesto, descripcion, empresa, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null) 
			return false;
		if (getClass() != obj.getClass())
			return false;
		Puesto other = (Puesto) obj;
		return Objects.equals(id_puesto, other.id_puesto) && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(empresa, other.empresa) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Puesto [id_puesto=" + id_puesto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", empresa="
				+ empresa + ", ponderaciones=" + ponderaciones + "]";
	}
	
}