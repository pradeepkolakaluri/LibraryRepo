package com.genapct.service;

import java.util.List;

import com.genapct.entity.Book;
import com.genapct.entity.Library;

public interface ILibraryService {
     List<Library> getLibraries(); 
     List<Book> getBooksById(Integer libId);
     void addLibrary(Library library);
     public void deleteLibraryById(Integer libraryId);
}
