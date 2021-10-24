package Hibernate_Practicas.Practica_Hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Factoria.HibernateFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SessionFactory sf = HibernateFactory.getSessionFactory();
		Session sesion = sf.openSession();
    }
}
