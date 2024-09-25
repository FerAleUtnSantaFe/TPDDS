package Logica.gestores;

import BaseDeDatos.MySQL.CompetenciaMySQL;
import DTOs.CompetenciaDTO;
import Logica.entidades.Competencia;

public class GestorCompetencia {
	
	public GestorCompetencia() {
		
	}
	
	public void CrearCompetencia(CompetenciaDTO c) {
		
		Competencia competencia = transformarCompetencia(c);
		if(CompetenciaMySQL.BuscarCompetencia(competencia) == null)
			CompetenciaMySQL.CrearCompetencia(competencia);
		else
			System.out.println("Competencia existente, intente nuevamente");
	}
	public void ModificarCompetencia(CompetenciaDTO c) {
		
		Competencia competencia = transformarCompetencia(c);
		CompetenciaMySQL.ModificarCompetencia(competencia);
		
	}

	public void EliminarCompetencia(CompetenciaDTO c) {
	}

	public Competencia BuscarCompetencia(CompetenciaDTO c) {
		
		Competencia competencia = transformarCompetencia(c);
		Competencia aux = CompetenciaMySQL.BuscarCompetencia(competencia);
		if(aux == null)
			System.out.println("Competencia inexistente, intente nuevamente"); // retornar null y analizarlo en la presentacion directamente
		else
			return aux;
		return null;
	}
	
	public Competencia BuscarCompetenciaNombre(CompetenciaDTO c) {
		
		Competencia competencia = transformarCompetencia(c);
		Competencia aux = CompetenciaMySQL.BuscarCompetenciaNombre(competencia);
		if(aux == null)
			System.out.println("Competencia inexistente, intente nuevamente"); // retornar null y analizarlo en la presentacion directamente
		else
			return aux;
		return null;
	}
	
	public Competencia transformarCompetencia(CompetenciaDTO c) {
		
		Competencia competencia = new Competencia();
		
		competencia.setCodigo(c.getCodigo());
		competencia.setNombre(c.getNombre());
		competencia.setDescripcion(c.getDescripcion());
		competencia.setTipoCompetencia(c.getTipoCompetencia());
		
		return competencia;
	}
}
