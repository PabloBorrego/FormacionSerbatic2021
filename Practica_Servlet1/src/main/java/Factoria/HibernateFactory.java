package Factoria;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

//Clase que va a dar la conexion al Sesion Factory de Hibernate
public class HibernateFactory {



  private static final SessionFactory sessionFactory = buildSessionFactory();



  private static SessionFactory buildSessionFactory() {
      
      try {
    	  
          String dir = "src\\main\\resources\\hibernate.cfg.xml";
          
          File f = new File(dir);
          Configuration conf = new Configuration();
          conf.configure(f);
          
          ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
          return conf.buildSessionFactory();
      
      }catch(Exception e) {
                  
          System.err.println("Error en Hibernate " + e.getMessage() );
          return null;
      }
      
      
  }
  
  public static SessionFactory getSessionFactory()
  {
      
      return sessionFactory;
  }
  
}
