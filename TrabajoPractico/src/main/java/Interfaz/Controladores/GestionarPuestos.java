package Interfaz.Controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DTOs.PuestoDTO;
import Interfaz.objetos.PuestoInterfaz;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;


public class GestionarPuestos implements Initializable {
	
	@FXML
	private TextField codigoTextField;
	
	@FXML
	private TextField puestoTextField;
	
	@FXML
	private TextField empresaTextField;
	
	@FXML
	private Button nuevoButton;
	
	@FXML
	private Button modificarButton;
	
	@FXML
	private Button eliminarButton;
	
	@FXML
	private Button reestablecerButton;
	
	@FXML
	private Button buscarButton;
	
	@FXML
	private Button cancelarButton;
	
	@FXML
	TableView<PuestoInterfaz> tablaPuestos = new TableView<PuestoInterfaz>();
	
	@FXML
	TableColumn<PuestoInterfaz, Integer> codigoColumna = new TableColumn<PuestoInterfaz, Integer>("Código");
	
	@FXML
	TableColumn<PuestoInterfaz, String> puestoColumna = new TableColumn<PuestoInterfaz, String>("Puesto");
	
	@FXML
	TableColumn<PuestoInterfaz, String> empColumna = new TableColumn<PuestoInterfaz, String>("Empresa");
	
	@FXML
	TableColumn<PuestoInterfaz, CheckBox> selColumna = new TableColumn<PuestoInterfaz, CheckBox>("[]");
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		cargarTablaPuestos();
		
	}
	
	public void buscar(ActionEvent event) {
		
		PuestoDTO puesto = new PuestoDTO();
		
		if(codigoTextField.getText() != null) 
			puesto.setCodigo(Integer.parseInt(codigoColumna.getText()));
		if(puestoTextField.getText() != null) 
			puesto.setCodigo(Integer.parseInt(codigoColumna.getText()));
		if(empresaTextField.getText() != null) 
			puesto.setCodigo(Integer.parseInt(codigoColumna.getText()));
		
		
	}
	
	public void cargarTablaPuestos() {

		tablaPuestos.setEditable(false);
		codigoColumna.setCellValueFactory(new PropertyValueFactory<PuestoInterfaz, Integer>("codigo"));
		codigoColumna.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		codigoColumna.setOnEditCommit(new EventHandler<CellEditEvent<PuestoInterfaz, Integer>>(){
			
			@Override
			public void handle(CellEditEvent<PuestoInterfaz, Integer> event) {
				PuestoInterfaz comp = event.getRowValue();
				comp.setCodigo(event.getNewValue());
			}
			
		});

		puestoColumna.setCellValueFactory(new PropertyValueFactory<PuestoInterfaz, String>("puesto"));
		puestoColumna.setCellFactory(TextFieldTableCell.forTableColumn());
		puestoColumna.setOnEditCommit(new EventHandler<CellEditEvent<PuestoInterfaz, String>>(){
			
			@Override
			public void handle(CellEditEvent<PuestoInterfaz, String> event) {
				PuestoInterfaz comp = event.getRowValue();
				comp.setPuesto(event.getNewValue());
			}
			
		});
		 
		empColumna.setCellValueFactory(new PropertyValueFactory<PuestoInterfaz, String>("empresa"));
		empColumna.setCellFactory(TextFieldTableCell.forTableColumn());
		empColumna.setOnEditCommit(new EventHandler<CellEditEvent<PuestoInterfaz, String>>(){
			
			@Override
			public void handle(CellEditEvent<PuestoInterfaz, String> event) {
				PuestoInterfaz comp = event.getRowValue();
				comp.setEmpresa(event.getNewValue());
			}
			
		});
		 

		selColumna.setCellValueFactory(new PropertyValueFactory<PuestoInterfaz, CheckBox>("selCheckBox"));
		selColumna.setCellFactory(new Callback<TableColumn<PuestoInterfaz, CheckBox>, TableCell<PuestoInterfaz, CheckBox>>(){
			 @Override
			 public TableCell<PuestoInterfaz, CheckBox> call(TableColumn<PuestoInterfaz, CheckBox> param){
				 return new CheckBoxTableCell<>();
			 }
		});
		selColumna.setOnEditCommit(new EventHandler<CellEditEvent<PuestoInterfaz, CheckBox>>(){
			
			@Override
			public void handle(CellEditEvent<PuestoInterfaz, CheckBox> event) {
				PuestoInterfaz comp = event.getRowValue();
				comp.setSelCheckBox(event.getNewValue());
			}
			
		});
		
		tablaPuestos.getColumns().clear();
		tablaPuestos.getColumns().add(codigoColumna);
		tablaPuestos.getColumns().add(puestoColumna);
		tablaPuestos.getColumns().add(empColumna);
		tablaPuestos.getColumns().add(selColumna);
		
		tablaPuestos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	
	}
	
	public void darDeAlta(ActionEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("DarDeAltaPuesto.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setTitle("Capit@l humano - Dar de Alta Puesto");
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void cancelar(ActionEvent event) {
		Stage stage = (Stage) cancelarButton.getScene().getWindow();
		stage.close();
	}
	
}
