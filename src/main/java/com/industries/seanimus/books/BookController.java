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
@RequestMapping(value = "/books") 

public class BookController {

	@Autowired
	BookDaoImpl dao;

	// Does it make sense to search for a book using a book object? Shouldn't the name suffice? Or should we have both?
	// What about duplicates? 
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public HttpEntity<Book> getBook(@RequestBody Book book) {

		if (validateBook(book)) {
			return new ResponseEntity<Book>(dao.getBook(book).get(0), HttpStatus.OK);
		} else
			throw new BookDoesntExistException(book);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public HttpEntity<Book> addBook(@RequestBody Book book) {

		if (validateBook(book))
			throw new BookAlreadyExistsException(book);
		else {
			dao.addBook(book);
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	public HttpEntity<Book> removeBook(@RequestBody Book book) {

		if (validateBook(book)) {
			dao.removeBook(book);
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		} else {
			throw new BookDoesntExistException(book);
		}
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public HttpEntity<List<Book>> getAllBooks() {

		return new ResponseEntity<List<Book>>(dao.getAllBooks(), HttpStatus.OK);
	}

/*	 @RequestMapping(value = "/books/all", method = RequestMethod.GET)
	 public List<Resource> getAllBooks() {
	
	 List<Book> books = jdbc.getAllBooks();
	 List<Resource> resBooks = new ArrayList<>();
	 for (Book book : books) {
	 Resource<Book> res = new Resource(book);
	 res.add(linkTo(methodOn(BookController.class).getAllBooks()).withSelfRel());
	 resBooks.add(res);
	 }
	
	 return resBooks;
	 }
*/

	// Should we be able to search by both author name and author object?
	@RequestMapping(value = "/authors/{author}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public HttpEntity<List<Book>> getBooksByAuthor(@PathVariable String author) {

		return new ResponseEntity<List<Book>>(dao.getBooksByAuthor(author.replace('-', ' ')), HttpStatus.OK);
	}

	@RequestMapping(value = "/authors", method = RequestMethod.GET)
	public HttpEntity<List<String>> getAllAuthors() {
		// SELECT a.name 'Author Name', b.name 'Book Title' FROM authors a,
		// books b WHERE b.author_name = a.name ORDER BY a.name, b.name;
		return new ResponseEntity<List<String>>(dao.getAuthors(), HttpStatus.OK);

	}

	// TODO: return Excel workbook
	@RequestMapping(value = "/report/all", method = RequestMethod.GET)
	public HttpEntity<Book> getBookReport() throws WriteException, IOException {
		List<Book> books = dao.getAllBooks();
		AllBooksReport abr = new AllBooksReport();
		abr.setOutputFile("Report.xlsx");
		abr.write();
		return new ResponseEntity<Book>(HttpStatus.OK);
	}

	private boolean validateBook(Book book) {
		int count = dao.getBook(book).size();
		return (count > 0);
	}

}

@ResponseStatus(HttpStatus.CONFLICT)
class BookAlreadyExistsException extends RuntimeException {

	public BookAlreadyExistsException(Book book) {
		super("Entry already exists for: " + book);
	}
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class BookDoesntExistException extends RuntimeException {
	public BookDoesntExistException(Book book) {
		super("No entry exists for: " + book);
	}
}