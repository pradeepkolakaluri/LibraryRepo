package com.genapct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genapct.dao.IBookDAO;
import com.genapct.entity.Book;
@Service
public class BookService implements IBookService {
	@Autowired
	private IBookDAO bookDao;
	@Override
	public Book getBookById(int bookId) {
		Book obj = bookDao.getBookById(bookId);
		return obj;
	}	
	@Override
	public List<Book> getAllBooks(){
		return bookDao.getAllBooks();
	}
	
	@Override
	public synchronized boolean addBook(Book book){
    	   bookDao.addBook(book);
    	   return true;
       }	
}
