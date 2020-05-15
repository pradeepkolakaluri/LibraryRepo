package com.genapct.dao;
import java.util.List;

import com.genapct.entity.Book;
import com.genapct.entity.Library;
public interface ILibraryDAO {
	List<Library> getLibraries(); 
    List<Book> getBooksById(Integer bookId);
    void addLibrary(Library library);
    public void deleteLibraryById(Integer libraryId);
}
 