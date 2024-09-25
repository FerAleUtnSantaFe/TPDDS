package Interfaz.Controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import DTOs.CompetenciaDTO;
import DTOs.PonderacionDTO;
import DTOs.PuestoDTO;
import Logica.entidades.Competencia;
import Programa.App;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class DarDeAltaPuesto implements Initializable {

	private int codigo = 0;
	private String puesto, empresa, descripcion, seleccion, tipoCompetencia;
	private ArrayList<PonderacionDTO> ponderaciones;

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
	private Label buscarErrorLabel;
	@FXML
	private TextArea descripcionTextArea;
	@FXML
	private TextField caracTextField;
	@FXML
	private Label caractLabel;
	@FXML
	private Label tipoCompErrorLabel;
	@FXML
	private Button aceptarButton;
	@FXML
	private Button cancelarButton;
	@FXML
	private Button agregarButton;
	@FXML
	private Button buscarButton;
	@FXML
	private CheckBox actitudinalesCheckBox;
	@FXML
	private CheckBox tecnicasCheckBox;
	@FXML
	TableView<PonderacionDTO> tabla = new TableView<PonderacionDTO>();
	@FXML
	TableColumn<PonderacionDTO, String> nombreColumna = new TableColumn<PonderacionDTO, String>("Nombre");
	@FXML
	TableColumn<PonderacionDTO, Integer> puntColumna = new TableColumn<PonderacionDTO, Integer>("puntuacion");

	@Override
	// INICIALIZA LAS VARIABLES, OCULTA LOS LABEL DE ERROR Y LLAMA A LAS FUNCIONES
	// RESPONSABLES DE CARGAR LOS DATOS
	public void initialize(URL arg0, ResourceBundle arg1) {

		// LABELS DE ERROR OCULTOS E INICIALIZACIÓN DE CAMPOS A CARGAR POR EL USUARIO
		codigoErrorLabel.setVisible(false);
		puestoErrorLabel.setVisible(false);
		empresaErrorLabel.setVisible(false);
		descripcionErrorLabel.setVisible(false);
		tipoCompErrorLabel.setVisible(false);
		buscarErrorLabel.setVisible(false);
		tecnicasCheckBox.setDisable(false);
		actitudinalesCheckBox.setDisable(false);
		puesto = null;
		empresa = null;
		descripcion = null;
		seleccion = null;
		tipoCompetencia = null;
		ponderaciones = new ArrayList<PonderacionDTO>();
		cargarListaCompetencias();
	}

	// DEJA SELECCIONAR UNO O AMBOS TIPO DE COMPETENCIA Y DESACTIVA EL MENSAJE DE
	// ERROR EN CASO DE QUE AL MENOS UN CHECKBOX ESTÉ SELECCIONADO
	public void seleccionarCheckBox(ActionEvent event) {
		if (actitudinalesCheckBox.isSelected() && !tecnicasCheckBox.isSelected())
			tipoCompetencia = "Actitudinales";
		if (tecnicasCheckBox.isSelected() && !actitudinalesCheckBox.isSelected())
			tipoCompetencia = "Técnicas";
		if (tecnicasCheckBox.isSelected() && actitudinalesCheckBox.isSelected())
			tipoCompetencia = "Actitudinales y técnicas";
		if (tecnicasCheckBox.isSelected() || actitudinalesCheckBox.isSelected())
			tipoCompErrorLabel.setVisible(false);

	}

	// DEFINE LA LISTA COMPETENCIAS CON LAS TABLE CELLS STRING, DOUBLE Y CHECKBOX
	// CORRESPONDIENTE A UNA COMPETENCIA
	public void cargarListaCompetencias() {

		tabla.setEditable(true);
		nombreColumna.setEditable(false);

		nombreColumna.setCellValueFactory(new PropertyValueFactory<PonderacionDTO, String>("nombre"));
		nombreColumna.setCellFactory(TextFieldTableCell.forTableColumn());

		puntColumna.setCellValueFactory(new PropertyValueFactory<PonderacionDTO, Integer>("pond"));
		puntColumna.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

		puntColumna.setOnEditCommit(new EventHandler<CellEditEvent<PonderacionDTO, Integer>>() {
			@Override
			public void handle(CellEditEvent<PonderacionDTO, Integer> event) {
				event.getRowValue().setPond(event.getNewValue());
			}
		});

		tabla.getColumns().clear();
		tabla.getColumns().add(nombreColumna);
		tabla.getColumns().add(puntColumna);
		tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

	}

	// BOTÓN ACEPTAR, COMPRUEBA SI LOS TODOS LOS DATOS FUERON CARGADOS Y LOS GUARDA,
	// EN EL CASO DE QUE NO HAYAN SIDO GUARDADO ACTIVA LOS LABELS DE ERROR
	public void aceptar(ActionEvent event) {
		// COMPRUEBA QUE CÓDIGO SEA DE TIPO NUM�RICO
		try {
			codigo = Integer.parseInt(codigoTextField.getText());
		} catch (NumberFormatException e) {
			System.out.println("Ingrese números");
		}

		// EXTRAE LOS DATOS DE LOS CAMPOS
		puesto = puestoTextField.getText();
		empresa = empresaTextField.getText();
		descripcion = descripcionTextArea.getText();
		// COMPRUEBA SI NO ESTÁN VACIOS Y ACTIVA LABEL DE ERROR EN CASO DE ESTARLO
		if (comprobarDatos(codigo, puesto, empresa, descripcion)) {

			PuestoDTO nuevo = new PuestoDTO();
			nuevo.setCodigo(codigo);
			nuevo.setEmpresa(empresa);
			nuevo.setDescripcion(descripcion);
			nuevo.setNombre(puesto);

			// haya competencias, COMPROBAR!!!!!!!!!!!!!!!!

			ArrayList<PonderacionDTO> aux = new ArrayList<PonderacionDTO>();
			for (PonderacionDTO p : tabla.getItems()) {
				p.setPto(App.gestorPuesto.transformarPuesto(nuevo));
				aux.add(p);
			}

			nuevo.setPonderaciones(App.gestorPuesto.transformarArrayPonderacionesDTO(aux));
			App.gestorPuesto.CrearPuesto(nuevo);

			Alert alert = new Alert(AlertType.NONE,
					"El puesto: " + puesto + " ha sido creado con correctamente. ¿Desea cargar otro?", ButtonType.YES,
					ButtonType.NO);
			alert.showAndWait();

			if (alert.getResult() == ButtonType.YES) {
				codigo = 0;
				puesto = "";
				empresa = "";
				descripcion = "";
				codigoTextField.clear();
				puestoTextField.clear();
				empresaTextField.clear();
				descripcionTextArea.clear();
				tabla.getItems().clear();
			} else {
				Stage stage = (Stage) cancelarButton.getScene().getWindow();
				stage.close();
			}
		}
	}

	// COMPRUEBA SI NO ESTÁN VACIOS Y ACTIVA LABEL DE ERROR EN CASO DE ESTARLO
	private boolean comprobarDatos(int cod, String pto, String emp, String desc) {

		if (cod != 0 && !pto.isEmpty() && !empresa.isEmpty() && !descripcion.isEmpty()
				&& (actitudinalesCheckBox.isSelected() || tecnicasCheckBox.isSelected()))
			return true;
		else {
			if (codigo == 0)
				codigoErrorLabel.setVisible(true);
			else
				codigoErrorLabel.setVisible(false);

			if (puesto.isEmpty())
				puestoErrorLabel.setVisible(true);
			else
				puestoErrorLabel.setVisible(false);

			if (empresa.isEmpty())
				empresaErrorLabel.setVisible(true);
			else
				empresaErrorLabel.setVisible(false);

			if (descripcion.isEmpty())
				descripcionErrorLabel.setVisible(true);
			else
				descripcionErrorLabel.setVisible(false);

			if (!actitudinalesCheckBox.isSelected() && !tecnicasCheckBox.isSelected())
				tipoCompErrorLabel.setVisible(true);
			else
				tipoCompErrorLabel.setVisible(false);
		}

		return false;
	}

	public void agregar(ActionEvent event) throws Exception {

		String comp = caracTextField.getText();

		if (!comp.isEmpty()) {

			Competencia c = App.gestorCompetencia
					.BuscarCompetencia(new CompetenciaDTO(Integer.parseInt(comp), null, null, null));
			PonderacionDTO p = new PonderacionDTO();
			p.setComp(c);
			p.setPond(null);

			try {
				comprobarExistencia(c.getNombre());
			} catch (NoSuchElementException e) {
				cargarDatos(p);
			}
			buscarErrorLabel.setVisible(false);
		} else
			buscarErrorLabel.setVisible(true);

	}

	private void comprobarExistencia(String nombre) {
		Optional<PonderacionDTO> pondExistente = Optional.ofNullable(
				tabla.getItems().stream().filter(e -> e.getComp().getNombre().equals(nombre)).findFirst().get());
		if (pondExistente.isPresent()) {
			Alert alert = new Alert(AlertType.NONE, "Competencia existente, intente nuevamente", ButtonType.OK);
			alert.showAndWait();
		} else
			throw new NoSuchElementException();

	}

	public void cargarDatos(PonderacionDTO comp) throws Exception {

		try {
			tabla.getItems().add(comp);
		} catch (Exception e) {
			throw new Exception();
		}

	}

	public void cancelar(ActionEvent event) {

		Stage stage = (Stage) cancelarButton.getScene().getWindow();
		stage.close();

	}

}