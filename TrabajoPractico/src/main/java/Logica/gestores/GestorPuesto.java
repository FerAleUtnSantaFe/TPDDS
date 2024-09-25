package Logica.gestores;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import BaseDeDatos.MySQL.PuestoMySQL;
import DTOs.PonderacionDTO;
import DTOs.PuestoDTO;
import Logica.entidades.Puesto;
import Logica.relaciones.PonderacionCompetencia;
import javafx.collections.ObservableList;

public class GestorPuesto{
	
	public void CrearPuesto(PuestoDTO p) {
		
		Puesto puesto = transformarPuesto(p);
		if(PuestoMySQL.BuscarPuesto(puesto) == null) {
			PuestoMySQL.CrearPuesto(puesto);
			}
		else {
			System.out.println("Puesto existente, intente nuevamente");
			}
		}
	
	public Puesto BuscarPuesto(PuestoDTO p) {
		
		Puesto puesto = transformarPuesto(p);
		Puesto aux = PuestoMySQL.BuscarPuesto(puesto);
		if(aux == null) {
			System.out.println("Puesto existente, intente nuevamente");
			}
		else {
			return aux; 
			}
		return null;
	}
	
	public void ModificarPuesto(PuestoDTO p) {
		Puesto puesto = transformarPuesto(p);
		PuestoMySQL.ModificarPuesto(puesto);
	}
	
	public Puesto transformarPuesto(PuestoDTO p) {
		
		Puesto puesto = new Puesto();
		
		puesto.setCodigo(p.getCodigo());
		puesto.setDescripcion(p.getDescripcion());
		puesto.setEmpresa(p.getEmpresa());
		puesto.setNombre(p.getNombre());
		puesto.setPonderaciones(p.getPonderaciones());
		
		System.out.println(puesto.toString());
		return puesto;
	}
	
	public ArrayList<PonderacionCompetencia> transformarArrayPonderacionesDTO(ArrayList<PonderacionDTO> pond){
		return pond.stream().map(p -> this.transformarPonderacionCompetencia(p)).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public PonderacionCompetencia transformarPonderacionCompetencia(PonderacionDTO p) {
		return new PonderacionCompetencia(p.getPond(), p.getComp(), p.getPto());
	}
	
}
