package com.industries.seanimus.books;

import java.util.List;

import org.springframework.hateoas.Link;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class BookResourceAssembler {

	
	public Book toResource(Book book) {
		return null;
	}

	public List<Book> toResource(List<Book> books) {

		for (Book book : books) {
			Link selfLink = linkTo(BookController.class).slash(book.getName()).withSelfRel();
			book.add(selfLink);
		}
		return books;
	}
}
