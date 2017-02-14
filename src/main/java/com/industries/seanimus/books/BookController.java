package com.industries.seanimus.books;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/books") 

public class BookController {


	@Autowired
	BookService bookService;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/hal+json")
	public HttpEntity<List<Book>> getAllBooks() {
		return bookService.getAllBooks();
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/hal+json")
	public HttpEntity<List<Book>> getBookByName(@PathVariable String name) {
		return bookService.getBookByName(name);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public HttpEntity<Book> addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
	public HttpEntity<String> removeBookByName(@PathVariable String name) {
		return bookService.removeBookByName(name);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public HttpEntity<Book> removeBookByResource(@RequestBody Book book) {
		return bookService.removeBook(book);
	}
	
	@RequestMapping(value = "/author/{name}", method = RequestMethod.GET)
	public HttpEntity<List<Book>> getBooksByAuthorName(@PathVariable String name) {
		return bookService.getBooksByAuthor(name);
	}
}