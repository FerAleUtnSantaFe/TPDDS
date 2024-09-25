package Interfaz.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class App extends Application {

	@Override
	public void start(Stage stage) throws Exception{

		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("MainSB.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Capit@l humano - Nuevo Puesto");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}