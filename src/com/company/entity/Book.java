package com.company.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_table")
public class Book {
	
	@Id
	private int bookId;
	
	
	private String title;
	private String isbn;
	@ManyToOne
	private Author author; //FK

	
	
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", author=" + author + ", title=" + title + ", isbn=" + isbn + "]";
	}
	
	
	
	
	
	
	

}
