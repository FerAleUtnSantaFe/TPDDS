package Interfaz.Controladores;

import java.io.IOException;
import BaseDeDatos.Conexion.Sesion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Login{
	
	// DEFINICIÓN DE VARIABLES, LAS QUE TIENEN LA ETIQUETA FXML ASOCIADA ES UN OBJETO ASOCIADO AL ARCHIVO FXML (VISIBLE)
	@FXML
	private Label autentLabel;

	@FXML
	private Button consultorButton;
	
	@FXML
	private Button cuestionarioButton;
	
	@FXML
	private Button salirButton;
	
	@FXML
	private Button CrearButton;
	
	@FXML
	private Button BorrarButton;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void consultor(ActionEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("LoginConsultor.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setTitle("Capit@l humano - Autenticar Consultor");
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void salir(ActionEvent event) {
		Stage stage = (Stage) salirButton.getScene().getWindow();
		stage.close();
	}
	
	public void crearDatos(ActionEvent event) {
		Sesion.crearConexion();
	}
	
	public void borrarDatos(ActionEvent event) {
		Sesion.eliminarDatos();
	}
	
}

