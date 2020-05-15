package com.genapct.dao;
import java.util.List;

import com.genapct.entity.Book;
public interface IBookDAO {
    List<Book> getAllBooks();
    Book getBookById(int bookId);
    void addBook(Book book);
}
 