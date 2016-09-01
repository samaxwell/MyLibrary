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

//TODO - what if authors exist without books. Or books without authors?
public class AuthorController {

	@Autowired
	AuthorDaoImpl dao;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public HttpEntity<List<Author>> getAllAuthors() {
		return new ResponseEntity<List<Author>>(dao.getAllAuthors(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public HttpEntity<Author> createNewAuthor(@RequestBody Author author) {
		return new ResponseEntity<Author>(dao.createNewAuthor(author), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public HttpEntity<Author> getAuthorByName(@PathVariable String name) {
		return new ResponseEntity<Author>(dao.getAuthorByName(name.replace('-', ' ')), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
	public HttpEntity<String> deleteAuthor(@PathVariable String name) {
		int success = dao.removeAuthor(name.replace('-', ' '));
		if (success >= 1) {
			return new ResponseEntity<String>("", HttpStatus.OK);
		}
		else 
			return new ResponseEntity<String>("No author found by that name", HttpStatus.NOT_FOUND);
	}
}
