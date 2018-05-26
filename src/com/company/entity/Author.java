package com.company.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "author_table")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // make it autoIncrement
	@Column(name = "id", updatable = false, nullable = false)
	private int authorId;
	
	private String name;
	
	@OneToMany(mappedBy = "author", cascade = {CascadeType.ALL})
	private List<Book> book = new ArrayList<>();
	
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getBook() {
		System.out.println("returnam book");
		return book;
	}
	public void setBook(List<Book> book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", name=" + name;
	}
	
	
	
	
	
	
	
}
