package com.genapct.service;

import java.util.List;
import com.genapct.entity.Book;

public interface IBookService {
     List<Book> getAllBooks();
     Book getBookById(int articleId);
     boolean addBook(Book article); 
}
