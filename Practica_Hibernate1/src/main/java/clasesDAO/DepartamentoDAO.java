package clasesDAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate_Practicas.Practica_Hibernate1.App;
import entities.Departamento;


public class DepartamentoDAO {

	public Session sesion;
	
	public DepartamentoDAO(Session sesion) {
		super();
		this.sesion = sesion;
	}


	public void create(Departamento ob) {
		Transaction tx = sesion.beginTransaction();
		sesion.save(ob);
		App.logger.info("Se ha insertado un departamento");
		tx.commit();
		
	}


	public void read(int cod) {
		Transaction tx = sesion.beginTransaction();
		Departamento e = sesion.get(Departamento.class,cod);
		App.logger.info("Se va a leer un departamento");
		System.out.print(e.toString());
		tx.commit();
	}


	public void update(Departamento ob) {
		Transaction tx = sesion.beginTransaction();
		Departamento up = sesion.get(Departamento.class, ob.getCodDepartamento());
		up = ob;
		sesion.update(up);
		App.logger.info("Se ha actualizado un departamento");
		tx.commit();
	}

	public void delete(Departamento ob) {
		Transaction tx = sesion.beginTransaction();
		App.logger.info("Se ha borrado un departamento");
		sesion.remove(ob);
		tx.commit();
	}


	

}
