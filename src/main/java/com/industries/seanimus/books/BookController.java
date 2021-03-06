package com.industries.seanimus.books;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.VndErrors;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import jxl.write.WriteException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/books") 

public class BookController {

	@Autowired
	BookDaoImpl dao;


	@RequestMapping(value = "", method = RequestMethod.GET)
	public HttpEntity<List<Book>> getAllBooks() {
		return new ResponseEntity<List<Book>>(dao.getAllBooks(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public HttpEntity<List<Book>> getBookByName(@PathVariable String name) {
		return new ResponseEntity<List<Book>>(dao.getBookByName(name.replace('-', ' ')), HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public HttpEntity<Book> addBook(@RequestBody Book book) {

		if (validateBook(book))
			throw new BookAlreadyExistsException(book);
		else {
			dao.addBook(book);
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
	public HttpEntity<String> removeBookByName(@PathVariable String name) {
		int success = dao.removeBookByName(name.replace('-', ' '));
		if (success >= 1) {
			return new ResponseEntity<String>("", HttpStatus.OK);
		}
		else 
			return new ResponseEntity<String>("No book found by name: " + name, HttpStatus.CONFLICT);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public HttpEntity<Book> removeBookByResource(@RequestBody Book book) {
		if (validateBook(book)) {
			dao.removeBook(book);
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		} else {
			throw new BookDoesntExistException(book);
		}
	}
	
	@RequestMapping(value = "/author/{name}", method = RequestMethod.GET)
	public HttpEntity<List<Book>> getBooksByAuthorName(@PathVariable String name) {

		return new ResponseEntity<List<Book>>(dao.getBooksByAuthor(name.replace('-', ' ')), HttpStatus.OK);
	}

//	 @RequestMapping(value = "/books/all", method = RequestMethod.GET)
//	 @ResponseBody
//	 public List<Resource> getAllBooks() {
//	
//	 List<Book> books = jdbc.getAllBooks();
//	 List<Resource> resBooks = new ArrayList<>();
//	 for (Book book : books) {
//	 Resource<Book> res = new Resource(book);
//	 res.add(linkTo(methodOn(BookController.class).getAllBooks()).withSelfRel());
//	 resBooks.add(res);
//	 }
//	
//	 return resBooks;
//	}

	// TODO: return Excel workbook
//	@RequestMapping(value = "/report/all", method = RequestMethod.GET)
//	public HttpEntity<Book> getBookReport() throws WriteException, IOException {
//		List<Book> books = dao.getAllBooks();
//		AllBooksReport abr = new AllBooksReport();
//		abr.setOutputFile("Report.xlsx");
//		abr.write();
//		return new ResponseEntity<Book>(HttpStatus.OK);
//	}

	private boolean validateBook(Book book) {
		int count = dao.getBook(book).size();
		return (count > 0);
	}

}

@ResponseStatus(HttpStatus.CONFLICT)
class BookAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BookAlreadyExistsException(Book book) {
		super("Entry already exists for: " + book);
	}
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class BookDoesntExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BookDoesntExistException(Book book) {
		super("No entry exists for: " + book);
	}
}