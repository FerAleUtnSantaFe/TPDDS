package BaseDeDatos.MySQL;

import BaseDeDatos.Conexion.Sesion;
import Logica.entidades.Puesto;

public class PuestoMySQL{
	
	public static void CrearPuesto(Puesto p) {
		Sesion.entity.getTransaction().begin();
		Sesion.entity.persist(p);
		Sesion.entity.getTransaction().commit();
	}

	public static void ModificarPuesto(Puesto p) {
		Sesion.entity.getTransaction().begin();
		Sesion.entity.merge(p);
		Sesion.entity.getTransaction().commit();
		
	}

	public static void EliminarPuesto(Puesto p) {
		// TODO Auto-generated method stub
		
	}

	public static Puesto BuscarPuesto(Puesto p) {
		return Sesion.entity.find(Puesto.class, p.getCodigo());
	}
}
