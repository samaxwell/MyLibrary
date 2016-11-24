package com.industries.seanimus.authors;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
	
	@Autowired
	AuthorDaoImpl authorDao;

	public HttpEntity<List<Author>> getAllAuthors() {
		return new ResponseEntity<List<Author>>(authorDao.getAllAuthors(), HttpStatus.OK);
	}

	public ResponseEntity<Author> createNewAuthor(Author author) {
		return new ResponseEntity<Author>(authorDao.createNewAuthor(author), HttpStatus.OK);
	}

	public HttpEntity<Author> getAuthorByName(String name) {
		return new ResponseEntity<Author>(authorDao.getAuthorByName(name), HttpStatus.OK);
	}

	public HttpEntity<String> removeAuthor(String name) {
		int success = authorDao.removeAuthor(name.replace('-', ' '));
		if (success >= 1) {
			return new ResponseEntity<String>("", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("No author found by that name", HttpStatus.NOT_FOUND);
		}
	}


}
