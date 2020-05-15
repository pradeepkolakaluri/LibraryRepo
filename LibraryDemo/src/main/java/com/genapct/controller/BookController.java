package com.genapct.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.genapct.entity.Book;
import com.genapct.service.IBookService;

// Book spring boot controller accepts requests from Anjular node server. 
@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("book")
public class BookController {
	@Autowired
	private IBookService bookService;
	@GetMapping("book/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id) {
		Book book = bookService.getBookById(id);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	@GetMapping("books")
	public ResponseEntity<List<Book>> getAllbooks() {
		List<Book> list = bookService.getAllBooks();
		return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
	}
	@PostMapping("book")
	public ResponseEntity<Void> addBook(@RequestBody Book book, UriComponentsBuilder builder) {
        boolean flag = bookService.addBook(book);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/book/{id}").buildAndExpand(book.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

} 