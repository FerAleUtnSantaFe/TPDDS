package BaseDeDatos.Conexion;

import jakarta.persistence.*;

public class Sesion {
	public static EntityManager entity;

	public static void crearConexion() {
		entity = JPA.getEntityManagerFactory().createEntityManager();
	}

	public static void eliminarDatos() {
		entity.getTransaction().begin();
		entity.createNativeQuery("SET FOREIGN_KEY_CHECKS = 0").executeUpdate();
		entity.createNativeQuery("DROP DATABASE tp_ds_3a").executeUpdate();
		entity.createNativeQuery("CREATE DATABASE tp_ds_3a").executeUpdate();
		entity.getTransaction().commit();
	}
}
