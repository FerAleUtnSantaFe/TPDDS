package DAOs;

import Logica.entidades.Puesto;

public interface PuestoDAO {
	public void CrearPuesto(Puesto p);
	public void ModificarPuesto(Puesto p);
	public void EliminarPuesto(Puesto p);
	public Puesto BuscarPuesto(Puesto p);
}