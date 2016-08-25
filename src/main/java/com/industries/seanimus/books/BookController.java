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

/*
 * Hateoas: https://opencredo.com/hal-hypermedia-api-spring-hateoas/
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/books") // Class level mapping. All method mappings are relative
public class BookController {

	@Autowired
	BookDaoImpl dao;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public int addBook(@RequestBody Book book) {

		validateBook(book);
		return dao.addBook(book);
	}

	@RequestMapping(value = "/remove/{author}/{title}", method = RequestMethod.DELETE)
	public int removeBook(@PathVariable String title, @PathVariable String author) {

		return dao.removeBook(title, author);
	}

	 @RequestMapping(value = "/all", method = RequestMethod.GET)
	 public List<Book> getAllBooks(){
	
		 long start = System.nanoTime();
		 List<Book> books = dao.getAllBooks();
		 return books;
	 }
//	@RequestMapping(value = "/books/all", method = RequestMethod.GET)
//	public List<Resource> getAllBooks() {
//
//		List<Book> books = jdbc.getAllBooks();
//		List<Resource> resBooks = new ArrayList<>();
//		for (Book book : books) {
//			Resource<Book> res = new Resource(book);
//			res.add(linkTo(methodOn(BookController.class).getAllBooks()).withSelfRel());
//			resBooks.add(res);
//		}
//
//		return resBooks;
//	}

	@RequestMapping(value = "/authors/{author}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<Book> getBooksByAuthor(@PathVariable String author) {

		return dao.getBooksByAuthor(author.replace('-', ' '));
	}

	@RequestMapping(value = "/authors", method = RequestMethod.GET)
	public List<String> getAllAuthors() {

		return dao.getAuthors();

	}

	// TODO
	@RequestMapping(value = "/report/all", method = RequestMethod.GET)
	public HttpEntity<Book> getBookReport() throws WriteException, IOException {
		List<Book> books = dao.getAllBooks();
		AllBooksReport abr = new AllBooksReport();
		abr.setOutputFile("Report.xlsx");
		abr.write();
		return new ResponseEntity<Book>(HttpStatus.OK);
	}

	private void validateBook(Book book) {
		int valid = dao.validateBook(book);
		if ((valid > 0)) throw new BookAlreadyExistsException(book);
	}
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class BookAlreadyExistsException extends RuntimeException {

	public BookAlreadyExistsException(Book book) {
		super("Entry already exists for: " + book);
	}
}
