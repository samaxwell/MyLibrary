package com.industries.seanimus.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.industries.seanimus.books.Book;
import com.industries.seanimus.excel.AllBooksReport;
import com.industries.seanimus.query.MyJDBCTemplate;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.VndErrors;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import jxl.write.WriteException;

@RestController
public class BookController {

	MyJDBCTemplate jdbc = new MyJDBCTemplate();

	@RequestMapping(value = "/books/add", method = RequestMethod.POST)
	public int addBook(@RequestBody Book book) {
		validateBook(book);

		return jdbc.addBook(book.getName(), book.getAuthorName(), book.getIsbnNumber(), book.getCategory(),
				book.getPrice());
	}

	@RequestMapping(value = "/books/remove/{author}/{title}", method = RequestMethod.DELETE)
	public int removeBook(@PathVariable String title, @PathVariable String author) {

		return jdbc.removeBook(title, author);
	}

	 @RequestMapping(value = "/books/all", method = RequestMethod.GET)
	 public List<Book> getAllBooks(){
	
	 return jdbc.getAllBooks();
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

	@RequestMapping(value = "/books/authors/{author}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<Book> getBooksByAuthor(@PathVariable String author) {

		author = author.replace('-', ' ');

		return jdbc.getBooksByAuthor(author);
	}

	@RequestMapping(value = "/books/authors", method = RequestMethod.GET)
	public List<String> getAllAuthors() {
		List<String> authors = new ArrayList<>();

		authors = jdbc.getAuthors();
		return authors;
	}

	@RequestMapping(value = "/books/report/all", method = RequestMethod.GET)
	public HttpEntity<Book> getBookReport() throws WriteException, IOException {
		List<Book> books = jdbc.getAllBooks();
		AllBooksReport abr = new AllBooksReport();
		abr.setOutputFile("Report.xlsx");
		abr.write();
		return new ResponseEntity<Book>(HttpStatus.OK);
	}

	private void validateBook(Book book) {
		int valid = jdbc.validateBook(book);
		if ((valid > 0))
			throw new BookAlreadyExistsException(book);
	}
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class BookAlreadyExistsException extends RuntimeException {

	public BookAlreadyExistsException(Book book) {
		super("Entry already exists for: " + book);
	}
}
