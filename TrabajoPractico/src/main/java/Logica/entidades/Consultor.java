package Logica.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Consultor")
public class Consultor {

	@Id
	@Column(name = "id_consultor")
	public Integer ID;
	@Column(name = "nombre_consultor")
	public String usuario;
	@Column(name = "contraseña_consultor")
	public String contrasena;

	public Consultor(String usuario, String contrasena) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena; 
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}
