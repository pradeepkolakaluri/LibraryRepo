package com.genapct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genapct.dao.ILibraryDAO;
import com.genapct.entity.Book;
import com.genapct.entity.Library;
@Service
public class LibraryService implements ILibraryService {
	@Autowired
	private ILibraryDAO libraryDao;
		
	@Override
	public List<Book> getBooksById(Integer libraryId) 
	{
		List<Book> books = libraryDao.getBooksById(libraryId);
		return books;
	}
	
	@Override
	public List<Library> getLibraries(){
		return libraryDao.getLibraries();
	}
	
	@Override
	public void addLibrary(Library library){
		libraryDao.addLibrary(library);
    	
	}
	
	@Override
	public void deleteLibraryById(Integer libraryId){
		libraryDao.deleteLibraryById(libraryId);
    	
	}

}
