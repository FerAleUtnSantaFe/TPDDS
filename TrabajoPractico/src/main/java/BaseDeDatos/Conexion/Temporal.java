package BaseDeDatos.Conexion;

import java.util.ArrayList;

import jakarta.persistence.*;

import Logica.entidades.Competencia;
import Logica.entidades.Puesto;
import Logica.enumeraciones.TipoCompetencia;
import Logica.gestores.GestorCompetencia;
import Logica.gestores.GestorPuesto;
import Logica.relaciones.PonderacionCompetencia;

public class Temporal {
	public static EntityManager entity;
	public static void programa() {
				try {
					entity = JPA.getEntityManagerFactory().createEntityManager();
					GestorPuesto g = new GestorPuesto();
					GestorCompetencia g2 = new GestorCompetencia();
					Puesto p1,p2,p3,p4,p5,p6,p7,p8;
					
					p1 = new Puesto(1, "nombre1", "descripcion1", "empresa1");
					p2 = new Puesto(2, "nombre2", "descripcion2", "empresa2");
					p3 = new Puesto(3, "nombre3", "descripcion3", "empresa3");
					p4 = new Puesto(4, "nombre4", "descripcion4", "empresa4");
					p5 = new Puesto(5, "nombre5", "descripcion5", "empresa5");
					p6 = new Puesto(6, "nombre6", "descripcion6", "empresa6");
					p7 = new Puesto(7, "nombre7", "descripcion7", "empresa7");
					p8 = new Puesto(8, "nombre8", "descripcion8", "empresa8");
					
					Competencia c1,c2,c3,c4;
					
					c1 = new Competencia(10, "nom1", "comp1", TipoCompetencia.Tecnica);
					c2 = new Competencia(20, "nom2", "comp2", TipoCompetencia.Tecnica);
					c3 = new Competencia(30, "nom3", "comp3", TipoCompetencia.Actitudinal);
					c4 = new Competencia(40, "nom4", "comp4", TipoCompetencia.Actitudinal);
					
					g2.CrearCompetencia(c1);
					g2.CrearCompetencia(c2);
					g2.CrearCompetencia(c3);
					g2.CrearCompetencia(c4);
					
					ArrayList<PonderacionCompetencia> a = new ArrayList<PonderacionCompetencia>();

					a.add(new PonderacionCompetencia(10, c1, p1));
					a.add(new PonderacionCompetencia(8, c2, p1));
					a.add(new PonderacionCompetencia(5, c3, p1));
					a.add(new PonderacionCompetencia(6, c4, p1));
					
					p1.setPonderaciones(a);
					g.CrearPuesto(p1);
					
					a.add(new PonderacionCompetencia(10, c1, p2));
					a.add(new PonderacionCompetencia(7, c2, p2));
					a.add(new PonderacionCompetencia(6, c3, p2));
					a.add(new PonderacionCompetencia(1, c4, p2));
					
					p2.setPonderaciones(a);
					g.CrearPuesto(p2);
					a.clear();
					
					a.add(new PonderacionCompetencia(10, c1, p3));
					a.add(new PonderacionCompetencia(8, c2, p3));
					a.add(new PonderacionCompetencia(6, c4, p3));
					
					p3.setPonderaciones(a);
					g.CrearPuesto(p3);
					a.clear();
					
					a.add(new PonderacionCompetencia(6, c1, p4));
					a.add(new PonderacionCompetencia(6, c2, p4));

					p4.setPonderaciones(a);
					g.CrearPuesto(p4);					
					
					g.BuscarPuesto(p1);
					p1.setNombre("LOCAMBIEEEEEE");
					g.ModificarPuesto(p1);
					
					
					System.out.println("Buscandoooo");
					g.CrearPuesto(p1);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}

