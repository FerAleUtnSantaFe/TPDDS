package Interfaz.Controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginConsultor implements Initializable{
	
	@FXML
	private Button aceptarAutButton;
	
	@FXML
	private Button cancelarAutButton;
	
	@FXML
	private Label usuarioErrorLabel;
	
	@FXML
	private Label contErrorLabel;
	
	@FXML
	private TextField usuarioTextField;
	
	@FXML
	private TextField contTextField;

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	String usuario;
	int cont;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		usuarioErrorLabel.setVisible(false);
		contErrorLabel.setVisible(false);
		usuario = "";
		cont = 0;
		
	}
	
	
	public void aceptarAutConsultor(ActionEvent event) throws IOException {
		
		usuario = usuarioTextField.getText();
		cont = Integer.parseInt(contTextField.getText());
		if(comprobarDatos(usuario, cont)) menuPrincipal(event);
		
	}
	
	public void cancelarAutConsultor(ActionEvent event) {
		Stage stage = (Stage) cancelarAutButton.getScene().getWindow();
		stage.close();
	}
	
	public Boolean comprobarDatos(String usuario, int cont) {
		// BUSCAR EN BASE DE DATOS SU EL USUARIO EXISTE, A MODO DE EJEMPLO SIGUIENTES CONDICIONES
		if (usuario.equals("1") && cont == 1) return true;
		else {
			usuarioErrorLabel.setVisible(true);
			contErrorLabel.setVisible(true);
			return false;
		}
	}
	public void menuPrincipal(ActionEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("GestionarPuestos.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setTitle("Capit@l humano - Gestionar Puestos");
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}

