package com.company.service;

import java.util.List;

import javax.persistence.Id;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.company.dao.BookDaoInterface;
import com.company.entity.Author;
import com.company.entity.Book;
import com.company.util.HibernateUtility;

public class BookImpl implements  BookDaoInterface<Book> {
	private Query query;
	private Session session;
	@Override
	public List<Book> findAll() {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		query = session.createQuery("from Book");
		List<Book> books = query.list();
		
		
		session.getTransaction().commit();
		session.close();;
		return books;
	}

	@Override
	public Book findById(Id id) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		
	    query = session.createQuery("from Book where bookId=:b");
	    query.setParameter("b", id);
	    Object marksQuery2 = query.uniqueResult();
	 
	    
	    session.getTransaction().commit();
		session.close();
	    return (Book) marksQuery2;
	}

	@Override
	public void update(Book entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertBooks(List<Book> books) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.flush();
		
		
		books.forEach((book) -> session.save(book));
		
		session.getTransaction().commit();
		session.close();
		
	}


}
