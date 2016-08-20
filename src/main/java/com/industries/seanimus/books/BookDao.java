package com.industries.seanimus.books;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.industries.seanimus.parser.Parser;
import com.industries.seanimus.people.Person;
import com.industries.seanimus.people.PersonRowMapper;

@Component
public class BookDao {

	private JdbcTemplate jdbcTemplateObject;
	private Map<String, DriverManagerDataSource> dataSources;

	public void setDataSource(String sourceName) {
		Map<String, DriverManagerDataSource> ds = new Parser("Database.xml").getConnections(); //ps.getConnections();
		this.dataSources = ds;
		DataSource dataSource = dataSources.get(sourceName);
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public int addBook(String name, String authorName, long isbnNumber, String category, BigDecimal price) {

		setDataSource("Books");
		String SQL = "INSERT INTO books(name, author_name, isbn_number, category, price) VALUES(?, ?, ?, ?, ?)";
		return jdbcTemplateObject.update(SQL, name, authorName, isbnNumber, category, price);
	}
	
	public int removeBook(String name, String author){

		setDataSource("Books");

		name = name.replace('-', ' ');
		author = author.replace('-',  ' ');

		String SQL = "DELETE FROM books WHERE name = ? AND author_name = ?";
		return jdbcTemplateObject.update(SQL, name, author);
	}

	public List<Book> getAllBooks() {
		setDataSource("Books");
		return jdbcTemplateObject.query("SELECT * FROM books ORDER BY category, author_name, name",	new BookRowMapper());
	}
	
	public List<Book> getBooksByAuthor(String author) {
		setDataSource("Books");
		String SQL = "SELECT * FROM books WHERE author_name = ? ";
		return jdbcTemplateObject.query(SQL, new Object[] { author }, new BookRowMapper());
	}


	public List<String> getAuthors() {
		setDataSource("Books");
		return jdbcTemplateObject.queryForList("SELECT DISTINCT author_name FROM books ORDER BY author_name", String.class);
	}

	
	public int validateBook(Book book) {
		setDataSource("Books");
		String SQL = "SELECT * FROM books WHERE isbn_number = ?";
		return jdbcTemplateObject.query(SQL, new Object[] { book.getIsbnNumber() }, new BookRowMapper()).size();
	}
}


