package DTOs;

import Logica.enumeraciones.TipoCompetencia;

public class CompetenciaDTO {
	private Integer codigo;
	private String nombre;
	private String descripcion;
	private TipoCompetencia tipoCompetencia;

	public CompetenciaDTO(Integer codigo, String nombre, String descripcion, TipoCompetencia tipoCompetencia) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipoCompetencia = tipoCompetencia;
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

	public TipoCompetencia getTipoCompetencia() {
		return tipoCompetencia;
	}

	public void setTipoCompetencia(TipoCompetencia tipoCompetencia) {
		this.tipoCompetencia = tipoCompetencia;
	}

}
