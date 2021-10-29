package entities;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate_Practicas.Practica_Hibernate1.App;


public class UsuariosDAO {
	
	public Session sesion;

	public UsuariosDAO(Session sesion) {
		super();
		this.sesion = sesion;
		// TODO Auto-generated constructor stub
	}

	public Usuarios read(int cod) {
		
		Transaction tx = sesion.beginTransaction();
		Usuarios e = sesion.get(Usuarios.class,cod);
		App.logger.info("Se recupera un usuario");
		tx.commit();
		return e;
	
	}

}
