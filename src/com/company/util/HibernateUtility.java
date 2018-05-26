package com.company.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.company.entity.Author;
import com.company.entity.Book;

public class HibernateUtility {
    public static SessionFactory factory;
    public static Configuration con;
    public static ServiceRegistry reg;
    

    private HibernateUtility() {
    }
    
    
    public static synchronized SessionFactory getSessionFactory() {
        if (factory == null) {
        	reg = getServiceRegistry();     	
        	factory = con.buildSessionFactory(reg);
        }
        return factory;
    }
    
    
    public static synchronized Configuration getConfiguration() {
    	if(con  == null) {
    		 con = new Configuration().configure()
    				.addAnnotatedClass(Author.class)
    				.addAnnotatedClass(Book.class);
    	}
    	return con;
    }
    
    
    public static synchronized ServiceRegistry getServiceRegistry() {
    	if(reg  == null) {
    		con = getConfiguration();
    		System.out.println("con = " + con);
    		reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
    		
    	}
    	return reg;
    }
}
