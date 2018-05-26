package com.company.persistance;

import java.util.ArrayList;
import java.util.List;

import com.company.entity.Author;

public class AuthorDao {
	
	public List<Author> getAllAvailableAuthors() {
		
		List<Author> listOfAuthors = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			Author author = new Author();
			author.setName("Author" + i);
			listOfAuthors.add(author);
		}
		
		
		
		return listOfAuthors;
	}

}
