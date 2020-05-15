package com.genapct.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.genapct.entity.Book;
import com.genapct.entity.Library;
@Transactional
@Repository
public class LibraryDAO implements ILibraryDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Library> getLibraries() {
		String hql = "FROM Library as library";
		return (List<Library>) entityManager.createQuery(hql).getResultList();
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBooksById(Integer libId) {
		String hql = "FROM Library as library where library.id = ? ";
		return (List<Book>) entityManager.createQuery(hql).setParameter(1, libId).getResultList();
	}
	
	@Override
	public void addLibrary(Library library){
			entityManager.persist(library);
	}
	
	@Override
	public void deleteLibraryById(Integer libId){
		String hql = "DELETE FROM Library as library where library.id = ? ";
		entityManager.createQuery(hql).setParameter(1, libId);		
	}
	
}
