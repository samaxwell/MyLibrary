package com.industries.seanimus.people;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.industries.seanimus.books.BookDaoImpl;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/*
 * Check it out - Spring HATEOAS Reference Documentation
 * http://docs.spring.io/spring-hateoas/docs/current/reference/html/
 */

@RestController
public class PeopleController {

	BookDaoImpl jdbc = new BookDaoImpl();

	@RequestMapping("/people")
	public HttpEntity<List<Person>> getPeople() {

//		List<Person> people = jdbc.getAllPeople();
//		people.add(linkTo(methodOn(PeopleController.class).getPeople()).withSelfRel());

//		return new ResponseEntity<List<Person>>(people, HttpStatus.OK);
		return null;
	}
	
	@RequestMapping("/person/new")
	public HttpEntity<Person> getNewPerson(@RequestParam( value = "first", defaultValue = "Bob") String first,
										   @RequestParam( value = "last" , defaultValue = "Dole") String last) {

		Person person = new Person(first, last, "11261987", 'M', 123456788);
		person.add(linkTo(methodOn(PeopleController.class).getNewPerson(first, last)).withSelfRel());

		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

}
