package com.company.persistance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.company.entity.Author;
import com.company.entity.Book;
public class BookDao {
	
	public List<Book> generateBooks(int count, Author author) {
		
		List<Book> listOfBooks = new ArrayList<>();
		Random random = new Random();
		
		
		for(int i = 0; i < count; i++) {
			Book book = new Book();
			
			book.setBookId(random.nextInt(1000));
			book.setTitle("Book" + i);
			book.setIsbn(random.nextInt(100) + "-" + "1" + random.nextInt(10000)
					     + "-" + random.nextInt(10000) + "-" + random.nextInt(1000));
			book.setAuthor(author);
			listOfBooks.add(book);
			
		}
		
		
		
		return listOfBooks;
	}

}
