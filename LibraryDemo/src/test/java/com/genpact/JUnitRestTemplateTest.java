package com.genpact;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.genapct.entity.Book;
import com.genapct.entity.Library;
import com.genapct.service.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@SpringBootApplication
public class JUnitRestTemplateTest {
	
	@InjectMocks
    private BookService booService = new BookService();
    @Autowired
    private RestTemplate restTemplate;
 
    private MockRestServiceServer mockServer;
    private ObjectMapper mapper = new ObjectMapper();
 
    @Before
    public void init() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }
    
    // @Ignore
	 @Test
	 public void testGetBookById() throws URISyntaxException 
	 {
	     RestTemplate restTemplate = new RestTemplate();
	      
	     final String baseUrl = "http://localhost:8080/book/book/31"; 
	     URI uri = new URI(baseUrl);
	  
	     ResponseEntity<Book> result = restTemplate.getForEntity(uri, Book.class);	    
	     //Verify request succeed
	     assertEquals(200, result.getStatusCodeValue());
	     assertEquals(Integer.valueOf(31), result.getBody().getId()); 
	 }
	 @Ignore
	 @Test
	 public void testGetBooksByLibraryId() throws URISyntaxException 
	 {
	     RestTemplate restTemplate = new RestTemplate();
	      
	     final String baseUrl = "http://localhost:8080/library/librarybooks/3"; 
	     URI uri = new URI(baseUrl);
	  
	     ResponseEntity<Library> result = restTemplate.getForEntity(uri,Library.class );	    
	     //Verify request succeed
	     assertEquals(200, result.getStatusCodeValue());	     
	 }	 

}
