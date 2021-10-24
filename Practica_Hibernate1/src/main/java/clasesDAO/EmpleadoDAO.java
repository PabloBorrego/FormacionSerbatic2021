package clasesDAO;


import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate_Practicas.Practica_Hibernate1.App;
import entities.Empleado;

public class EmpleadoDAO {

	public Session sesion;
	
	public EmpleadoDAO(Session sesion) {
		super();
		this.sesion = sesion;
	}


	public void create(Empleado ob) {
		Transaction tx = sesion.beginTransaction();
		sesion.save(ob);
		App.logger.info("Se ha insertado un empleado");
		tx.commit();
		
	}


	public void read(int cod) {
		Transaction tx = sesion.beginTransaction();
		Empleado e = sesion.get(Empleado.class,cod);
		App.logger.info("Se va a leer un empleado");
		e.toString();
		tx.commit();
		
	}


	public void update(Empleado ob) {
		Transaction tx = sesion.beginTransaction();
		Empleado up = sesion.get(Empleado.class, ob.getCodEmpleado());
		up = ob;
		sesion.update(up);
		App.logger.info("Se ha actualizado un empleado");
		tx.commit();
		
	}

	public void delete(Empleado ob) {
		Transaction tx = sesion.beginTransaction();
		App.logger.info("Se ha borrado un empleado");
		sesion.remove(ob);
		tx.commit();
		
	}
	
}
