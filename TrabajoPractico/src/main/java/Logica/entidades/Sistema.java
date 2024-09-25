package Logica.entidades;

import javafx.scene.chart.PieChart.Data;

public class Sistema {
	public Integer cantPreguntas;
	public Data tiempoCuestionario;
	public String fuente;
	public Integer maxCuestionariosActivos;

	public Sistema(Integer cantPreguntas, Data tiempoCuestionario, String fuente, Integer maxCuestionariosActivos) {
		super();
		this.cantPreguntas = cantPreguntas;
		this.tiempoCuestionario = tiempoCuestionario;
		this.fuente = fuente;
		this.maxCuestionariosActivos = maxCuestionariosActivos;
	}

	public Integer getCantPreguntas() {
		return cantPreguntas;
	}

	public void setCantPreguntas(Integer cantPreguntas) {
		this.cantPreguntas = cantPreguntas;
	}

	public Data getTiempoCuestionario() {
		return tiempoCuestionario;
	}

	public void setTiempoCuestionario(Data tiempoCuestionario) {
		this.tiempoCuestionario = tiempoCuestionario;
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public Integer getMaxCuestionariosActivos() {
		return maxCuestionariosActivos;
	}

	public void setMaxCuestionariosActivos(Integer maxCuestionariosActivos) {
		this.maxCuestionariosActivos = maxCuestionariosActivos;
	}

}
