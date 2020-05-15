package com.genapct.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "library")
public class Library implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id   
	@Column(name = "library_id")
	private Integer id;	
	private String  libraryName;

	public Library(Integer id, String libraryName) {
		this.id = id;
		this.libraryName = libraryName;
	}

	public Library() {
		super();
	}	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;					
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	@OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Book> books;

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Library [toString()=" + super.toString() + "]";
	}
	
}