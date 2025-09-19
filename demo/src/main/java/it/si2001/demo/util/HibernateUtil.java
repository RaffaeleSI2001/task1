package it.si2001.demo.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    
    private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory() {
        Configuration configuration = null;
        StandardServiceRegistry registry = null;
        
        try {
            System.out.println("Initializing Hibernate Configuration...");
            
            configuration = new Configuration();
            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:mysql://db:3306/db");
            configuration.setProperty("hibernate.connection.username", "admin");
            configuration.setProperty("hibernate.connection.password", "admin");
            
            configuration.addAnnotatedClass(it.si2001.demo.models.User.class);
            
            System.out.println("Hibernate Configuration loaded successfully.");
        } catch (Throwable ex) {
            System.err.println("Failed to initialize Configuration: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
        
        try {
            System.out.println("Building StandardServiceRegistry...");
            registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("StandardServiceRegistry built successfully.");
        } catch (Throwable ex) {
            System.err.println("Failed to build StandardServiceRegistry: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
        
        try {
            System.out.println("Building SessionFactory...");
            SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
            System.out.println("SessionFactory built successfully.");
            return sessionFactory;
        } catch (Throwable ex) {
            System.err.println("Failed to build SessionFactory, printing full stacktrace:");
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    /** Gracefully shuts down the SessionFactory, releasing all resources. */
    public static void shutdown() {
        getSessionFactory().close();
    }
}
