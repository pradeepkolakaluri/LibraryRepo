package com.genapct;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.genapct.entity.Book;
import com.genapct.entity.Library;
import com.genapct.service.BookService;
import com.genapct.service.LibraryService;
@SpringBootApplication
public class LibraryDemoApplication {  
	public static void main(String[] args) {
		SpringApplication.run(LibraryDemoApplication.class, args);
    } 
	
	// This methods loads default data into memory.
	@Bean
	public CommandLineRunner setup(LibraryService libraryservice , BookService bookService) {
		return (args) -> {
			Set<Book> books1 = new HashSet<Book>();  
			books1.add(new Book(21,"Title21","Author21", 3));
			books1.add(new Book(22,"Title22","Author22", 3));
			books1.add(new Book(23,"Title23","Author23", 3));
			books1.add(new Book(24,"Title24","Author24", 3));
			
			Library lib1 = new Library(3,"Library3"); 
			lib1.setBooks(books1);
			libraryservice.addLibrary(lib1);
			
			Set<Book> books2 = new HashSet<Book>();
			books2.add(new Book(31,"Title31","Author31", 4));
			books2.add(new Book(32,"Title32","Author32", 4));
			books2.add(new Book(33,"Title33","Author33", 4));
			books2.add(new Book(34,"Title33","Author34", 4));
			
			Library lib2 = new Library(4,"Library4"); 
			lib2.setBooks(books2);
			libraryservice.addLibrary(lib2);
		};
	}	
}            