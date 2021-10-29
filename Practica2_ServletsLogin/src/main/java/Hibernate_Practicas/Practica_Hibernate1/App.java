package Hibernate_Practicas.Practica_Hibernate1;

import org.apache.logging.log4j.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.UsuariosDAO;

/**
 * Hello world!
 *
 */
public class App 
{
	public static Logger logger = (Logger) LogManager.getLogger(App.class);
	public static SessionFactory sf = HibernateUtil.getSessionFactory();
	public static Session sesion = sf.openSession();
	
	public static void main( String[] args ) throws InterruptedException
    {
		UsuariosDAO usDAO = new UsuariosDAO(sesion);
		usDAO.read(1);
    }
}
