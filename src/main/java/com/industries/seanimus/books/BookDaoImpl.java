package com.industries.seanimus.books;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// Need to implement interface. This becomes BookDaoImpl
//@Component
@Repository
public class BookDaoImpl {

	@Autowired
	private JdbcTemplate jdbc;

	public int addBook(Book book) {

		return jdbc.update("INSERT INTO books(name, author_name, isbn_number, category, price) VALUES(?, ?, ?, ?, ?)",
				book.getName(), book.getAuthorName(), book.getIsbnNumber(), book.getCategory(), book.getPrice());
	}

	public int removeBook(String name, String author) {

		return jdbc.update("DELETE FROM books WHERE name = ? AND author_name = ?", name.replace('-', ' '),
				author.replace('-', ' '));
	}

	public List<Book> getAllBooks() {
		return jdbc.query("SELECT * FROM books ORDER BY category, author_name, name", new BookRowMapper());
	}

	public List<Book> getBooksByAuthor(String author) {
		return jdbc.query("SELECT * FROM books WHERE author_name = ?", new Object[] { author }, new BookRowMapper());
	}

	public List<String> getAuthors() {
		return jdbc.queryForList("SELECT DISTINCT author_name FROM books ORDER BY author_name", String.class);
	}

	public int validateBook(Book book) {
		return jdbc.query("SELECT * FROM books WHERE isbn_number = ?", new Object[] { book.getIsbnNumber() },
				new BookRowMapper()).size();
	}
}

class BookRowMapper implements RowMapper<Book> {
	@Override
	public Book mapRow(ResultSet rs, int arg1) throws SQLException {
		return new Book(rs.getString("name"), rs.getString("author_name"), rs.getLong("isbn_number"),
				rs.getString("category"), rs.getBigDecimal("price"));
	}
}
