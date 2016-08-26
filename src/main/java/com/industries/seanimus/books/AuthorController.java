package com.industries.seanimus.books;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/authors") 

//TODO - what if authors exist without books. Or books without authors?
public class AuthorController {

	@Autowired
	AuthorDaoImpl dao;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public HttpEntity<List<Author>> getAllAuthors() {
		return new ResponseEntity<List<Author>>(dao.getAllAuthors(), HttpStatus.OK);
		
	}
}
