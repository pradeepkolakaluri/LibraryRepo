package com.genapct.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "book")
@Table(name = "book")
public class Book {
 
       
    @Column(name = "library_id")
    @Id
    private Integer id;     
    @Column(name = "libid")
    private Integer libid;  
    @Column(name = "title")
    private String title;     
    @Column(name= "author")
    private String author;
     
    public Book() {
    	super();
    }
 
    public Book(Integer id, String title, String author , Integer libid) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.libid = libid;
    }
     
    
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getAuthor() {
        return author;
    }
 

	public void setAuthor(String author) {
        this.author = author;
    }
        
    public Integer getLibid() {
		return libid;
	}

	public void setLibid(Integer libid) {
		this.libid = libid;
	}      

	@Override
    public String toString() {
        return "Book: " + this.id + ", " + this.title + ", " + this.author; 
    }
     
}