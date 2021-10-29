package Factoria;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import entities.Departamento;

//Clase que va a dar la conexion al Sesion Factory de Hibernate
public class HibernateFactory {



  private static final SessionFactory sessionFactory = buildSessionFactory();



  private static SessionFactory buildSessionFactory() {
      
      try {
//    	  
//          String dir = "hibernate.cfg.xml";
//          
//          File f = new File(dir);
//          Configuration conf = new Configuration();
//          conf.configure(f);
          
          Configuration configuration = new Configuration().configure();
          StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder(). applySettings(configuration.getProperties());
          SessionFactory factory = configuration.buildSessionFactory(builder.build());
          configuration.addAnnotatedClass(Departamento.class);
          
//          ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure(dir).build();
//        		  //.applySettings(conf.getProperties()).build();
//          return conf.buildSessionFactory();
          return factory;
      
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
