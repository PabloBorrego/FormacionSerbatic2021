package clasesDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Hibernate_Practicas.Practica_Hibernate1.App;
import entities.Departamento;
import entities.Empleado;


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
		
		CriteriaBuilder cb = App.sesion.getCriteriaBuilder();
		CriteriaQuery<Departamento> cr = cb.createQuery(Departamento.class);
		Root<Departamento> root = cr.from(Departamento.class);
		
		cr.multiselect(root);
		
		Query<Departamento> query = App.sesion.createQuery(cr);
		ArrayList<Departamento> results = (ArrayList<Departamento>)query.getResultList();
		
		return results;
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
