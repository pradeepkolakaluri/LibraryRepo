package com.genpact;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.genapct.entity.Book;
import com.genapct.entity.Library;



public class JUinitContollerTest extends AbstractTest {
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }
  
   @Test
   public void getLibraries() throws Exception {
      String uri = "/library/libraries";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      Library[] librareis = super.mapFromJson(content, Library[].class);
      assertTrue(librareis.length > 0);
   }
  
   @Test
   public void createLibrary() throws Exception {
	   
	   Set<Book> books = new HashSet<Book>();  
		books.add(new Book(41,"Title41","Author41", 15));
		books.add(new Book(42,"Title42","Author42", 15));
		books.add(new Book(43,"Title43","Author43", 15));
		books.add(new Book(44,"Title44","Author44", 15));
		
      String uri = "/library/library";
      Library library = new Library();
      library.setId(15);
      library.setLibraryName("Library5");
      library.setBooks(books);
      String inputJson = super.mapToJson(library);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(201, status);
     
   }
   
}