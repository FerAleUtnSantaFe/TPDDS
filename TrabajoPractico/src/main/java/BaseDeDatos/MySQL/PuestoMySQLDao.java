package BaseDeDatos.MySQL;

import BaseDeDatos.Conexion.Temporal;
import Logica.entidades.Puesto;

public class PuestoMySQLDao {
	
	public static void CrearPuesto(Puesto p) {
		Temporal.entity.getTransaction().begin();
		Temporal.entity.persist(p);
		Temporal.entity.getTransaction().commit();
	}
}
