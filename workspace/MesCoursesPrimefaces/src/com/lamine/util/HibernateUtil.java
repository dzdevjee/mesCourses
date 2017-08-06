package com.lamine.util;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;

public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();
    private static ServiceRegistry serviceRegistry;
    private static Session session = null;

    //Creer l'objet SessionFactory
    private static SessionFactory buildSessionFactory() {
        try {
        	Configuration configuration = new Configuration();
            configuration.configure("config/hibernate.cfg.xml");
            
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            
            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.out.println("Failed to create SessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    //des methodes utiles
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Session openSession() {
    	return sessionFactory.openSession();
    }
    
    public Session getCurrentSession() {
    	return sessionFactory.getCurrentSession();
    }
    
    public static void close() {
    	if (sessionFactory != null) {
    		sessionFactory.close();
    	}
    	sessionFactory = null;
    }
}