package clasesDAO;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

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
	
	public ArrayList<Departamento> readAll() {
		
		ArrayList<Departamento> departamentos = new ArrayList<>();
		CriteriaBuilder builder = App.sesion.getCriteriaBuilder();
	    CriteriaQuery<Departamento> criteria = builder.createQuery(Departamento.class);
	    departamentos = (ArrayList<Departamento>) App.sesion.createQuery(criteria).getResultList();
		return departamentos;
		
	}


	public void update(int ob) {
		Transaction tx = sesion.beginTransaction();
		Departamento up = sesion.get(Departamento.class, ob);
		up.setNombre("Actualizado");
		sesion.update(up);
		App.logger.info("Se ha actualizado un departamento");
		tx.commit();
	}

	public void delete(int ob) {
		Transaction tx = sesion.beginTransaction();
		Departamento dp = sesion.get(Departamento.class, ob);
		sesion.remove(dp);
		App.logger.info("Se ha borrado un departamento");
		tx.commit();
	}


	

}
