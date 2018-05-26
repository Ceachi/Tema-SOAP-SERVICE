package com.company.dao;

import java.util.List;

import javax.persistence.Id;

import com.company.dao.*;
import com.company.entity.Book;

public interface AuthorDaoInterface<T> {
	public List<T> findAll();
    public T findById(int id);
    public void update(T entity);
    
    public void insertAuthors(List<T> authors);

}
