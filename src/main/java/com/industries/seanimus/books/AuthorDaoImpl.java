package com.industries.seanimus.books;

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
		// TODO - update querry to view author table
		return jdbc.query("SELECT * FROM authors", new AuthorRowMapper());
	}

}

class AuthorRowMapper implements RowMapper<Author> {

	@Override
	public Author mapRow(ResultSet rs, int arg1) throws SQLException {
		return new Author(rs.getInt("id"), rs.getString("name"), rs.getDate("dob"), rs.getDate("dod"),
				rs.getString("bio"), rs.getString("picture_name"));
	}
}