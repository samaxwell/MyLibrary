
package com.industries.seanimus.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.industries.seanimus.books.Book;
import com.industries.seanimus.books.BookController;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * @author sean
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BookController.class)
@WebAppConfiguration
public class BookControllerTest {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
												  MediaType.APPLICATION_JSON.getSubtype(),
												  Charset.forName("utf8"));

	private MockMvc mockMvc;

	@Autowired
    private WebApplicationContext webApplicationContext;
	
	private List<Book> books = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();

//		this.books.add(new Book("Book1", "Author1", 1234567891234567L, "Fiction", new BigDecimal(5.45)));
//		this.books.add(new Book("Book2", "Author2", 2345678912345678L, "Fiction", new BigDecimal(3.99)));
	}


	@Test
	public void getBooksByAuthorTest() throws Exception {
		String getBook  = "/books/authors/" + this.books.get(0).getAuthorName() + "/";
		String getBook2 = "/books/authors/Author-1";

		mockMvc.perform(get(getBook))//.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(status().isOk())
		.andExpect(content().contentType(contentType))
		.andExpect(jsonPath("$.name", is(this.books.get(0).getName())))
		.andExpect(jsonPath("$.authorName", is(this.books.get(0).getAuthorName())));
	}

}
