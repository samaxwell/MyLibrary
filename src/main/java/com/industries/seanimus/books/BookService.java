package com.industries.seanimus.books;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class BookService {

	@Autowired
	BookDaoImpl bookDao;
	
	@Autowired
	BookResourceAssembler assembler;

	public HttpEntity<List<Book>> getAllBooks() {
		List<Book> allBooks = bookDao.getAllBooks();
		return new ResponseEntity<List<Book>>(assembler.toResource(allBooks), HttpStatus.OK);
	}

	public HttpEntity<List<Book>> getBookByName(String name) {
		List<Book> books = bookDao.getBookByName(name.replace('-',  ' '));
		return new ResponseEntity<List<Book>>(assembler.toResource(books), HttpStatus.OK);
	}

	public HttpEntity<Book> addBook(Book book) {
		if (validate(book)) {
			throw new BookAlreadyExistsException(book);
		} else {
			bookDao.addBook(book);
			return new ResponseEntity<Book>(assembler.toResource(book), HttpStatus.CREATED);
		}
	}

	public HttpEntity<String> removeBookByName(String name) {
		int success = bookDao.removeBookByName(name.replace('-', ' '));
		if (success >= 1) {
			return new ResponseEntity<String>("", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No book found by name: " + name, HttpStatus.CONFLICT);
		}
	}

	public HttpEntity<Book> removeBook(Book book) {
		if (validate(book)) {
			bookDao.removeBook(book);
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		}
		else {
			throw new BookDoesntExistException(book);
		}
	}

	public HttpEntity<List<Book>> getBooksByAuthor(String name) {

		return new ResponseEntity<List<Book>>(bookDao.getBooksByAuthor(name.replace('-', ' ')), HttpStatus.OK);
	}

	private boolean validate(Book book) {
		int count = bookDao.getBook(book).size();
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