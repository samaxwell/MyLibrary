package com.industries.seanimus.books;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BookTest {

	private ValidatorFactory factory;
	private Validator validator;

	@Before
	public void setUp() throws Exception {
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void createBookWithNoAuthorName() {

		Book book = new Book();
		book.setAuthorName("");
		book.setCategory("Science Fiction");
		book.setCoverPath("");
		book.setIsbnNumber(2);
		book.setName("");
		book.setPrice(new BigDecimal(12));
		book.setPublishingDate(12);

		Set<ConstraintViolation<Book>> violations = validator.validate(book);
		for (ConstraintViolation<Book> violation : violations)
			System.out.println(violation.getMessage());

		 Assert.assertEquals(violations.isEmpty(), false);
	}

	@Test
	public void createBookWithNullAuthorName() {

		Book book = new Book();
		book.setAuthorName(null);
		book.setCategory("Science Fiction");
		book.setCoverPath("");
		book.setIsbnNumber(2);
		book.setName("");
		book.setPrice(new BigDecimal(12));
		book.setPublishingDate(12);

		Set<ConstraintViolation<Book>> violations = validator.validate(book);
		for (ConstraintViolation<Book> violation : violations)
			System.out.println(violation.getMessage());

		 Assert.assertEquals(violations.isEmpty(), false);
	}
	
	@Test
	public void createBookWithNoName() {

		Book book = new Book();
		book.setAuthorName("Author McAuthorFace");
		book.setCategory("Science Fiction");
		book.setCoverPath("");
		book.setIsbnNumber(2);
		book.setName("");
		book.setPrice(new BigDecimal(12));
		book.setPublishingDate(12);

		Set<ConstraintViolation<Book>> violations = validator.validate(book);
		for (ConstraintViolation<Book> violation : violations)
			System.out.println(violation.getMessage());

		 Assert.assertEquals(violations.isEmpty(), false);
	}

	@Test
	public void createBookWithNullName() {

		Book book = new Book();
		book.setAuthorName("Author McAuthorFace");
		book.setCategory("Science Fiction");
		book.setCoverPath("");
		book.setIsbnNumber(2);
		book.setName(null);
		book.setPrice(new BigDecimal(12));
		book.setPublishingDate(12);

		Set<ConstraintViolation<Book>> violations = validator.validate(book);
		for (ConstraintViolation<Book> violation : violations)
			System.out.println(violation.getMessage());

		 Assert.assertEquals(violations.isEmpty(), false);
	}
}
