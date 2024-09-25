package Interfaz.Controladores;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;


public class MenuPrincipal {

	@FXML
	private Button GestionarPuestoButton;
	
	@FXML
	private Button CompletarCuestionarioButton;
	
	@FXML
	private Button EvaluarCandidatosButton;
	
	@FXML
	private Button SeleccionCandidatosButton;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void gestionarPuesto(ActionEvent event) throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("GestionarPuestos.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setTitle("Capit@l humano - Gestionar Puestos");
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
}
