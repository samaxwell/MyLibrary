package com.industries.seanimus.authors;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDaoImpl {

	@Autowired
	private JdbcTemplate jdbc;
	

	public List<Author> getAllAuthors() {
		return jdbc.query("SELECT * FROM authors", new AuthorRowMapper());
	}

	public Author createNewAuthor(Author author) {
		jdbc.update("INSERT INTO authors(name, dob, dod, bio, picture_name) VALUES(?, ?, ?, ?, ?)", author.getName(),
				author.getDob(), author.getDod(), author.getBio(), author.getPicture());
		return getAuthorByName(author.getName());
	}

	public Author getAuthorByName(String name) {
		List<Author> author = jdbc.query("Select * FROM authors WHERE name = ?", new Object[] { name.replace('-', ' ') },
				new AuthorRowMapper());
		return author.get(0);
	}

	public int removeAuthor(String name) {
		return jdbc.update("DELETE FROM authors WHERE name = ?", name);
	}

	// public List<Book> getBooksByAuthor(Author author) {
	// return jdbc.query("SELECT * FROM books WHERE author_name = ?", new
	// Object[] { author }, new BookRowMapper());
	// }
}

class AuthorRowMapper implements RowMapper<Author> {
	@Override
	public Author mapRow(ResultSet rs, int arg1) throws SQLException {
		Author author = new Author();
		author.setBio(rs.getString("bio"));
		author.setDob(rs.getDate("dob"));
		author.setDod(rs.getDate("dod"));
		author.setId(rs.getInt("id"));
		author.setName(rs.getString("name"));
		author.setPicture(rs.getString("picture_name"));

		return author;
	}
}