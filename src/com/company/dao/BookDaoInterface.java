package com.company.dao;

import java.util.List;

import javax.persistence.Id;

public interface BookDaoInterface<T> {
	public List<T> findAll();
    public T findById(Id id);
    public void update(T entity);
    public void insertBooks(List<T> books);


}
