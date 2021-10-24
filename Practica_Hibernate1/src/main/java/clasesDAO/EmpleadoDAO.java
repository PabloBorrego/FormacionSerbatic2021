package clasesDAO;

import org.hibernate.Session;

import entities.Empleado;

public class EmpleadoDAO {

	public Session sesion;
	
	
	
	public EmpleadoDAO(Session sesion) {
		super();
		this.sesion = sesion;
	}


	public void create(Empleado ob) {
		// TODO Auto-generated method stub
		Transaction tx = sesion.beginTransaction();
		Equipo e= sesion.get(Equipo.class, 1);
		System.out.println(e.getDenCorta());
		tx.commit();
		sesion.close();
		
	}


	public Empleado read(Empleado ob) {
		// TODO Auto-generated method stub
		return null;
	}


	public void update(Empleado ob) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Empleado ob) {
		// TODO Auto-generated method stub
		
	}
	
}
