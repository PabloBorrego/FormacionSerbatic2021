package Hibernate_Practicas.Practica_Hibernate1;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Factoria.HibernateFactory;
import clasesDAO.DepartamentoDAO;
import clasesDAO.EmpleadoDAO;
import entities.Departamento;
import entities.Empleado;

/**
 * Hello world!
 *
 */
public class App 
{
	public static Logger logger = LogManager.getLogger(App.class);
   
	public static void main( String[] args )
    {
		
		
        System.out.println( "Hello World!" );
        SessionFactory sf = HibernateFactory.getSessionFactory();
		Session sesion = sf.openSession();
		
		Departamento d = new Departamento(4, "Limpieza", 1);
		DepartamentoDAO dDAO = new DepartamentoDAO(sesion);
		dDAO.create(d);
		
		Empleado e = new Empleado(0, "Ramon","Ramon","Ramon", "Ramon", 'p', "Ramon","Ramon", 1);
		EmpleadoDAO eDao = new EmpleadoDAO(sesion);
		//eDao.create(e);
		
		
		dDAO.read(1);
		
    }
}
