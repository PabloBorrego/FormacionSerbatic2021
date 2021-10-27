package services;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;

import Hibernate_Practicas.Practica_Hibernate1.App;
import entities.Empleado;

public class Servicios {

	public static void CriteriaEmpeladoDepartamentos(int codigodep) {
		

		CriteriaBuilder cb = App.sesion.getCriteriaBuilder();
		CriteriaQuery<Empleado> cr = cb.createQuery(Empleado.class);
		Root<Empleado> root = cr.from(Empleado.class);
		
		cr.select(root).where(cb.equal(root.get("codDepartamento"),codigodep));

		Query<Empleado> query = App.sesion.createQuery(cr);
		List<Empleado> results = query.getResultList();
		
		if(results.isEmpty()) {
			System.err.println("No hay empleados con ese codigo");
			App.logger.warn("No se ha devueto nada a la lista");
		}else {
			for(Empleado e : results) {
				System.err.println(e.toString());
			}
		}
		
		
	}
	
	
	public static void consultaHQLEdad(char edad) {
		
		String hql = "FROM empleado E WHERE E.edad >= "+edad;
		Query<Empleado> query = App.sesion.createQuery(hql);
		List<Empleado> results = query.list();
		
		for(Object e : results) {
			System.out.println(e.toString());
		}
	}
	
	
}
