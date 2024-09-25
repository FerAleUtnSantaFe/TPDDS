package BaseDeDatos.MySQL;

import BaseDeDatos.Conexion.Sesion;
import Logica.entidades.Competencia;

public class CompetenciaMySQL {
	
	public static void CrearCompetencia(Competencia c) {
		Sesion.entity.getTransaction().begin();
		Sesion.entity.persist(c);
		Sesion.entity.getTransaction().commit();
	}
	public static void ModificarCompetencia(Competencia c) {
		Sesion.entity.getTransaction().begin();
		Sesion.entity.merge(c);
		Sesion.entity.getTransaction().commit();
	}
	public static void EliminarCompetencia(Competencia c) {
		
	}
	public static Competencia BuscarCompetencia(Competencia c) {
		return Sesion.entity.find(Competencia.class, c.getCodigo());
	}
	
	public static Competencia BuscarCompetenciaNombre(Competencia c) {
		return Sesion.entity.find(Competencia.class, c.getNombre());
	}
	
}
