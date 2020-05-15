package com.genapct.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.genapct.entity.Book;
@Transactional
@Repository
public class BookDAO implements IBookDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Book getBookById(int bookId) {
		return entityManager.find(Book.class, bookId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAllBooks() {
		String hql = "FROM book as book";
		return (List<Book>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addBook(Book book) {
		entityManager.persist(book);
	}	
}
