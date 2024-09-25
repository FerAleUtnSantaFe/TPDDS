package Interfaz.main;

import java.net.URL;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ResourceBundle;
import BaseDeDatos.Conexion.Temporal;
import Interfaz.objetos.Caracteristicas;
import Interfaz.objetos.CompetenciasInterfaz;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;

public class Controlador implements Initializable{
	
	// DEFINICIÓN DE VARIABLES, LAS QUE TIENEN LA ETIQUETA FXML ASOCIADA ES UN OBJETO ASOCIADO AL ARCHIVO FXML (VISIBLE)
	
	@FXML
	private Label codigoLabel;
	@FXML
	private Label codigoErrorLabel;
	@FXML
	private TextField codigoTextField;
	
	@FXML
	private Label puestoLabel;
	@FXML
	private Label puestoErrorLabel;
	@FXML
	private TextField puestoTextField;
	
	@FXML
	private Label empresaLabel;
	@FXML
	private Label empresaErrorLabel;
	@FXML
	private TextField empresaTextField;
	
	@FXML
	private Label descripcionLabel;
	@FXML
	private Label descripcionErrorLabel;
	@FXML
	private TextArea descripcionTextArea;
	
	@FXML
	private Label caractLabel;

	@FXML
	private Label tipoCompErrorLabel;
	
	@FXML
	private Label caracteristicaErrorLabel;
	
	public int codigo = 0;
	public String puesto, empresa, descripcion, seleccion, tipoCompetencia;
	
	@FXML
	private ChoiceBox<String> caractChoiceBox;
	
	@FXML
	private Button aceptarButton;
	
	@FXML
	private Button cancelarButton;
	
	@FXML
	private Button agregarButton;
	
	private ArrayList<Caracteristicas> caracteristicas = new ArrayList<Caracteristicas>();

	@FXML
	private CheckBox actitudinalesCheckBox;
	
	@FXML
	private CheckBox tecnicasCheckBox;

	@FXML
	TableView<CompetenciasInterfaz> tabla = new TableView<CompetenciasInterfaz>();
	
	@FXML
	TableColumn<CompetenciasInterfaz, String> nombreColumna = new TableColumn<CompetenciasInterfaz, String>("Nombre");
	
	@FXML
	TableColumn<CompetenciasInterfaz, Double> puntColumna = new TableColumn<CompetenciasInterfaz, Double>("puntuacion");
	
	@FXML
	TableColumn<CompetenciasInterfaz, CheckBox> selColumna = new TableColumn<CompetenciasInterfaz, CheckBox>("[]");
	
	public void Prueba() {
		Temporal.programa();
	}
		
	
	@Override
	// INICIALIZA LAS VARIABLES, OCULTA LOS LABEL DE ERROR Y LLAMA A LAS FUNCIONES RESPONSABLES DE CARGAR LOS DATOS
	public void initialize(URL arg0, ResourceBundle arg1) {

		ArrayList<CompetenciasInterfaz> competencias = new ArrayList<CompetenciasInterfaz>();
		
		// EJEMPLO DE COMPETENCIAS
		competencias.add(new CompetenciasInterfaz("competencia 1", 60.5, false));
		competencias.add(new CompetenciasInterfaz("competencia 2", 60.5, false));
		competencias.add(new CompetenciasInterfaz("competencia 3", 70.3, false));
		
		// CARACTERÍSTICAS ASOCIADAS A LAS COMPETENCIAS CREADAS Y A UN NOMBRE
		caracteristicas.add(new Caracteristicas(competencias, "Caracteristica 1"));
		caracteristicas.add(new Caracteristicas(competencias, "Caracteristica 2"));
		caracteristicas.add(new Caracteristicas(competencias, "Caracteristica 3"));
		
		// LABELS DE ERROR OCULTOS E INICIALIZACIÓN DE CAMPOS A CARGAR POR EL USUARIO
		codigoErrorLabel.setVisible(false);
		puestoErrorLabel.setVisible(false);
		empresaErrorLabel.setVisible(false);
		descripcionErrorLabel.setVisible(false);
		tipoCompErrorLabel.setVisible(false);
		caracteristicaErrorLabel.setVisible(false);
		tecnicasCheckBox.setDisable(false);
		actitudinalesCheckBox.setDisable(false);
		puesto = null; empresa = null; descripcion = null; seleccion = null; tipoCompetencia = null;
		
		cargarListaCompetencias();
		cargarCaracteristicas();
		caractChoiceBox.setOnAction(this::getSeleccion);
		
	}
	
	// CARGA EN EL CHOICEBOX DE LAS CARACTERISTICAS LOS NOMBRES EXISTENTES EN EL VECTOR CARACTERISTICAS
	private void cargarCaracteristicas() {
		for(Caracteristicas carac : caracteristicas) {
			caractChoiceBox.getItems().add(carac.getNombre());
		}
		
	}

	// EXTRAE LA SELECCIÓN DE CARACTERÍSTICA
	public void getSeleccion(ActionEvent event) {
		
		seleccion = caractChoiceBox.getValue();
		
	}
	
	// DEJA SELECCIONAR UNO O AMBOS TIPO DE COMPETENCIA Y DESACTIVA EL MENSAJE DE ERROR EN CASO DE QUE AL MENOS UN CHECKBOX ESTÉ SELECCIONADO
	public void seleccionarCheckBox(ActionEvent event) {
		if (actitudinalesCheckBox.isSelected() && !tecnicasCheckBox.isSelected()) tipoCompetencia = "Actitudinales";
		if (tecnicasCheckBox.isSelected() && !actitudinalesCheckBox.isSelected()) tipoCompetencia = "Técnicas";
		if (tecnicasCheckBox.isSelected() && actitudinalesCheckBox.isSelected()) tipoCompetencia = "Actitudinales y técnicas";
		if (tecnicasCheckBox.isSelected() || actitudinalesCheckBox.isSelected()) tipoCompErrorLabel.setVisible(false);

	}
	
	// DEFINE LA LISTA COMPETENCIAS CON LAS TABLE CELLS STRING, DOUBLE Y CHECKBOX CORRESPONDIENTE A UNA COMPETENCIA
	public void cargarListaCompetencias() {
		

		tabla.setEditable(true);
		nombreColumna.setEditable(false);
		
		nombreColumna.setCellValueFactory(new PropertyValueFactory<CompetenciasInterfaz, String>("nombreComp"));
		nombreColumna.setCellFactory(TextFieldTableCell.forTableColumn());
		nombreColumna.setOnEditCommit(new EventHandler<CellEditEvent<CompetenciasInterfaz, String>>(){
			
			@Override
			public void handle(CellEditEvent<CompetenciasInterfaz, String> event) {
				CompetenciasInterfaz comp = event.getRowValue();
				comp.setNombreComp(event.getNewValue());
			}
			
		});

		puntColumna.setCellValueFactory(new PropertyValueFactory<CompetenciasInterfaz, Double>("puntComp"));
		puntColumna.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
		puntColumna.setOnEditCommit(new EventHandler<CellEditEvent<CompetenciasInterfaz, Double>>(){
			
			@Override
			public void handle(CellEditEvent<CompetenciasInterfaz, Double> event) {
				CompetenciasInterfaz comp = event.getRowValue();
				comp.setPuntComp(event.getNewValue());
			}
			
		});
		
		selColumna.setCellValueFactory(new PropertyValueFactory<CompetenciasInterfaz, CheckBox>("checkSelComp"));
		selColumna.setCellFactory(new Callback<TableColumn<CompetenciasInterfaz, CheckBox>, TableCell<CompetenciasInterfaz, CheckBox>>(){
			 @Override
			 public TableCell<CompetenciasInterfaz, CheckBox> call(TableColumn<CompetenciasInterfaz, CheckBox> param){
				 return new CheckBoxTableCell<>();
			 }
		});
		selColumna.setOnEditCommit(new EventHandler<CellEditEvent<CompetenciasInterfaz, CheckBox>>(){
			
			@Override
			public void handle(CellEditEvent<CompetenciasInterfaz, CheckBox> event) {
				CompetenciasInterfaz comp = event.getRowValue();
				comp.setCheckSelComp(event.getNewValue());
			}
			
		});
		
		tabla.getColumns().clear();
		tabla.getColumns().add(nombreColumna);
		tabla.getColumns().add(puntColumna);
		tabla.getColumns().add(selColumna);
		
		tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	
	}
	
	// BOTÓN ACEPTAR, COMPRUEBA SI LOS TODOS LOS DATOS FUERON CARGADOS Y LOS GUARDA, EN EL CASO DE QUE NO HAYAN SIDO GUARDADO ACTIVA LOS LABELS DE ERROR
	public void aceptar(ActionEvent event) {
		Prueba();
	}
	
	// COMPRUEBA SI NO ESTÁN VACIOS Y ACTIVA LABEL DE ERROR EN CASO DE ESTARLO
	@SuppressWarnings("unused")
	private boolean comprobarDatos(int cod, String pto, String emp, String desc) {
		
		if (!actitudinalesCheckBox.isSelected() && !tecnicasCheckBox.isSelected()) tipoCompErrorLabel.setVisible(true);
		else tipoCompErrorLabel.setVisible(false);
		
		if(cod != 0 && !pto.isEmpty() && !empresa.isEmpty() && !descripcion.isEmpty() && 
				(!actitudinalesCheckBox.isSelected() && !tecnicasCheckBox.isSelected())) return true;
		else {
			if (codigo == 0) codigoErrorLabel.setVisible(true);
			else codigoErrorLabel.setVisible(false);
			
			if (puesto.isEmpty()) puestoErrorLabel.setVisible(true);
			else puestoErrorLabel.setVisible(false);
			
			if (empresa.isEmpty()) empresaErrorLabel.setVisible(true);
			else empresaErrorLabel.setVisible(false);
			
			if (descripcion.isEmpty()) descripcionErrorLabel.setVisible(true);
			else descripcionErrorLabel.setVisible(false);
		}
		
		return false;
	}

	// BOTÓN AGREGAR QUE OCASIONA LA CARGA DE LAS COMPETENCIAS A PARTIR DE LA CARACTERÍSTICA SELECCIONADA, MANEJA EXCEPCIÓN EN CASO DE QUE NO SE SELECIONÓ CARACTERÍSTICA
	public void agregar(ActionEvent event) {
		
		Optional<Caracteristicas> selCarac = null;
		try {
			selCarac = obtenerCaracteristica();
			cargarDatos(selCarac);
		}catch(NoSuchElementException e) {
			caracteristicaErrorLabel.setVisible(true);
		}
		
	}
	
	// COMPRUEBA SI EL USUARIO SELECCIONÓ UN TIPO DE CARACTERÍSTICA Y SI NO LANZA UNA EXCEPCIÓN
	private Optional<Caracteristicas> obtenerCaracteristica() throws NoSuchElementException {
		Optional<Caracteristicas> selCarac = Optional.ofNullable(caracteristicas.stream()
				.filter(e -> e.getNombre().equals(seleccion)).findFirst().get());
		if (selCarac.isPresent()) {
			caracteristicaErrorLabel.setVisible(false);
			return selCarac;
		}
		else throw new NoSuchElementException();
	}

	// CARGA LA TABLA DE COMPETENCIAS A PARTIR DE LA CARACTERÍSTICA SELECCIONADA
	public void cargarDatos(Optional<Caracteristicas> selCarac) {
		
		for(CompetenciasInterfaz comp : selCarac.get().getComps()) {
			tabla.getItems().add(comp);
		}
		
	}
	
	// PRESIONA CANCELAR Y CIERRA EL STAGE (VENTANA) ACTUAL
	public void cancelar(ActionEvent event) {
		
		Stage stage = (Stage) cancelarButton.getScene().getWindow();
		stage.close();
	
	}
	
}