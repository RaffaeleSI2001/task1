package it.si2001.demo.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import it.si2001.demo.models.User;

public class HibernateUtil {
    
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Properties settings = new Properties();
                settings.put("jakarta.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
                settings.put("jakarta.persistence.jdbc.url", "jdbc:mysql://localhost:3306/hibernate_db?useSSL=false");
                
                settings.put("jakarta.persistence.jdbc.user", "admin");
                settings.put("jakarta.persistence.jdbc.password", "admin");
                
                settings.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                settings.put("hibernate.show_sql", "true");
                settings.put("hibernate.format_sql", "true");
                
                Configuration configuration = new Configuration();
                configuration.setProperties(settings);
                
                configuration.addAnnotatedClass(User.class);
                
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

                System.out.println("SessionFactory built: " + (sessionFactory != null));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
