package com.company.service;

import java.util.List;

import javax.persistence.Id;

import com.company.dao.AuthorDaoInterface;
import com.company.entity.Author;
import com.company.util.HibernateUtility;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AuthorImpl implements AuthorDaoInterface<Author> {

	private Query query;
	private Session session;
	
	@Override
	public List<Author> findAll() {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		query = session.createQuery("from Author");
		List<Author> authors = query.list();
		
		
		session.getTransaction().commit();
		session.close();;
		return authors;
	}

	@Override
	public Author findById(int id) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		

		
	    query = session.createQuery("from Author where authorId=:b");
	    query.setParameter("b", id);
	    Object marksQuery2 = query.uniqueResult();
	 
	    
	    session.getTransaction().commit();
		session.close();
	    return (Author) marksQuery2;
	}

	@Override
	public void update(Author entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertAuthors(List<Author> authors) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.flush();
		
		authors.forEach((author) -> session.save(author));
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	
	public void insert(Author author) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		 System.out.println("");
		session.save(author);
		
		
		session.getTransaction().commit();
		session.close();
	}
}
