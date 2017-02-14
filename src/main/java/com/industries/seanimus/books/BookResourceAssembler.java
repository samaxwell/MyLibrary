package com.industries.seanimus.books;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import com.industries.seanimus.authors.AuthorController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class BookResourceAssembler {

	
	public Book toResource(Book book) {
		Link selfLink = linkTo(BookController.class).slash(book.getName()).withSelfRel();
		Link authLink = linkTo(AuthorController.class).slash(book.getAuthorName()).withRel("author");
		book.add(selfLink);
			book.add(authLink);
		return book;
	}

	public List<Book> toResource(List<Book> books) {
		for (Book book : books) {
			Link selfLink = linkTo(BookController.class).slash(book.getName()).withSelfRel();
			Link authLink = linkTo(AuthorController.class).slash(book.getAuthorName()).withRel("author");
			book.add(selfLink);
			book.add(authLink);
		}
		return books;
	}
}
