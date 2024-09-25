package Interfaz.objetos;

import javafx.scene.control.CheckBox;

public class PuestoInterfaz {

	private String puesto, empresa;
	private int codigo;
	private CheckBox selCheckBox = new CheckBox();
	private Boolean seleccionado;
	
	public PuestoInterfaz(Integer cod, String pue, Boolean sel) {
		this.codigo = cod;
		this.puesto = pue;
		this.seleccionado = sel;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public CheckBox getSelCheckBox() {
		return selCheckBox;
	}

	public void setSelCheckBox(CheckBox selCheckBox) {
		this.selCheckBox = selCheckBox;
	}

	public Boolean getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(Boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
	
	
}
