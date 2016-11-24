package com.industries.seanimus.authors;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/authors") 

public class AuthorController {

	
	@Autowired
	AuthorService authorService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public HttpEntity<List<Author>> getAllAuthors() {
		return authorService.getAllAuthors();
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public HttpEntity<Author> createNewAuthor(@RequestBody Author author) {
		return authorService.createNewAuthor(author);
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public HttpEntity<Author> getAuthorByName(@PathVariable String name) {
		return authorService.getAuthorByName(name);
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
	public HttpEntity<String> deleteAuthor(@PathVariable String name) {
		return authorService.removeAuthor(name);
	}
	
}
