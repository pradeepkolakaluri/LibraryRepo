package com.genapct.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.genapct.entity.Book;
import com.genapct.entity.Library;
import com.genapct.service.ILibraryService;

//Library spring boot controller accepts requests from Anjular node server.
@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("library")
public class LibraryController {
	@Autowired
	private ILibraryService libraryService;
	@GetMapping("librarybooks/{id}")
	public ResponseEntity<List<Book>> getBooksById(@PathVariable("id") Integer libId) {
		List<Book> books = libraryService.getBooksById(libId);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	@GetMapping("libraries")
	public ResponseEntity<List<Library>> getAlllibraries() {
		List<Library> list = libraryService.getLibraries();
		return new ResponseEntity<List<Library>>(list, HttpStatus.OK);
	}
	@PostMapping("library")
	public ResponseEntity<Void> addLibrary(@RequestBody Library library, UriComponentsBuilder builder) {
        libraryService.addLibrary(library);     
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/library/{id}").buildAndExpand(library.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteLibraryById(@PathVariable("id") Integer library) {
        libraryService.deleteLibraryById(library);    
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

} 