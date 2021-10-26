package Hibernate_Practicas.Practica_Hibernate1;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Factoria.HibernateFactory;
import clasesDAO.DepartamentoDAO;
import clasesDAO.EmpleadoDAO;
import controller.ControlMenu;
import controller.ControladorDepartamento;
import entities.Departamento;
import entities.Empleado;
import services.Servicios;

/**
 * Hello world!
 *
 */
public class App 
{
	public static Logger logger = LogManager.getLogger(App.class);
	public static SessionFactory sf = HibernateFactory.getSessionFactory();
	public static Session sesion = sf.openSession();
   
	public static void main( String[] args ) throws InterruptedException
    {
		
		ControlMenu cM = new ControlMenu();
		cM.elegirControl();
		
    }
}
