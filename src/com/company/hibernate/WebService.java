package com.company.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.company.dao.AuthorDaoInterface;
import com.company.entity.*;
import com.company.persistance.AuthorDao;
import com.company.persistance.BookDao;
import com.company.service.AuthorImpl;
import com.company.service.BookImpl;
import com.company.util.HibernateUtility;

public class WebService {

	public static void main(String[] args) {
		
		//insert some authors and books into Database
		List<Author> listOfAuthors = new AuthorDao().getAllAvailableAuthors();
		List<Book> listOfBooks = null;
		
		//new AuthorImpl().insertAuthors(listOfAuthors);
		for(Author author : listOfAuthors) {
			listOfBooks = new BookDao().generateBooks(4, author); // generam cate 4 carti per author
			author.setBook(listOfBooks);
			new AuthorImpl().insert(author);
			//new BookImpl().insertBooks(listOfBooks);	// no need for this because you Cascade in Authors
		}

		
		AuthorDaoInterface authorsImpl = new AuthorImpl();
		
		List<Author> authors = new AuthorImpl().findAll();
		
		authors.forEach((x) -> System.out.println(x));
		
		System.out.println("Find by id ");
		
		Author autor = (Author) authorsImpl.findById(1);
		
		System.out.println(autor);
		
		
		List<Book> books = new BookImpl().findAll();
		books.forEach((x) -> System.out.println(x));
		
		
		
	}

}
