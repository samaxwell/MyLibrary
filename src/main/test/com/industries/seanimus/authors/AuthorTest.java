package com.industries.seanimus.authors;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import javax.validation.ConstraintViolation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AuthorTest {

	private ValidatorFactory factory;
	private Validator validator; 

	@Before
	public void setUp() throws Exception {
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void createAuthorWithNoName() {

		Author author = new Author();
		author.setId(1);
		author.setName("");
		author.setDob(new Date());
		author.setDod(new Date());
		author.setBio("");
		author.setPicture("");
		
		Set<ConstraintViolation<Author>> violations = validator.validate(author);
		for (ConstraintViolation<Author> violation : violations) System.out.println(violation.getMessage()); 

		Assert.assertEquals(violations.isEmpty(), false);
	}

	@Test
	public void createAuthorWithNullName() {

		Author author = new Author();
		author.setId(1);
		author.setName(null);
		author.setDob(new Date());
		author.setDod(new Date());
		author.setBio("");
		author.setPicture("");
		
		Set<ConstraintViolation<Author>> violations = validator.validate(author);
		for (ConstraintViolation<Author> violation : violations) System.out.println(violation.getMessage()); 

		Assert.assertEquals(violations.isEmpty(), false);
	}
	
	@Test
	public void createAuthorWithFutureDOB() {

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, +10);

		Author author = new Author();
		author.setId(1);
		author.setName("Author McAuthorFace");
		author.setDob(cal.getTime());
		author.setDod(new Date());
		author.setBio("");
		author.setPicture("");
		
		Set<ConstraintViolation<Author>> violations = validator.validate(author);
		for (ConstraintViolation<Author> violation : violations) System.out.println(violation.getMessage()); 

		Assert.assertEquals(violations.isEmpty(), false);
	}
	
	@Test
	public void createAuthorWithBioLengthGreaterThanAllowable() {
		Author author = new Author();
		author.setId(1);
		author.setName("Author McAuthorFace");
		author.setDob(new Date());
		author.setDod(new Date());
		author.setBio("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii" + 
					  "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii" + 
					  "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii" + 
					  "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii" + 
					  "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii" + 
					  "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii" + 
					  "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii" + 
					  "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii" + 
					  "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii" + 
					  "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii" + 
					  "i");
		author.setPicture("");
		
		Set<ConstraintViolation<Author>> violations = validator.validate(author);
		for (ConstraintViolation<Author> violation : violations) System.out.println(violation.getMessage()); 

		Assert.assertEquals(violations.isEmpty(), false);
	}
	
	@Test
	public void createAuthorWithFutureDateOfDeath() {

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, +10);

		Author author = new Author();
		author.setId(1);
		author.setName("Author McAuthorFace");
		author.setDob(new Date());
		author.setDod(cal.getTime());
		author.setBio("");
		author.setPicture("");
	
		Set<ConstraintViolation<Author>> violations = validator.validate(author);
		for (ConstraintViolation<Author> violation : violations) System.out.println(violation.getMessage()); 

		Assert.assertEquals(violations.isEmpty(), false);
	}

}
