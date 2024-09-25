package Programa;

import BaseDeDatos.Conexion.Sesion;
import DTOs.CompetenciaDTO;
import Logica.entidades.Competencia;
import Logica.enumeraciones.TipoCompetencia;
import Logica.gestores.*;
import jakarta.persistence.EntityManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class App extends Application {
	
	public static GestorPuesto gestorPuesto;
	public static GestorCompetencia gestorCompetencia;
	public static EntityManager entity;
	
	@Override
	public void start(Stage stage) throws Exception{

		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Capit@l humano - Nuevo Puesto");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) { 
		try {
			gestorPuesto = new GestorPuesto();
			gestorCompetencia = new GestorCompetencia();
			Sesion.crearConexion();
			
			CompetenciaDTO c1, c2, c3, c4;

			c1 = new CompetenciaDTO(10, "nom1", "comp1", TipoCompetencia.Tecnica);
			c2 = new CompetenciaDTO(20, "nom2", "comp2", TipoCompetencia.Tecnica);
			c3 = new CompetenciaDTO(30, "nom3", "comp3", TipoCompetencia.Actitudinal);
			c4 = new CompetenciaDTO(40, "nom4", "comp4", TipoCompetencia.Actitudinal);

			gestorCompetencia.CrearCompetencia(c1);
			gestorCompetencia.CrearCompetencia(c2);
			gestorCompetencia.CrearCompetencia(c3);
			gestorCompetencia.CrearCompetencia(c4);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		launch(args);
	}
}