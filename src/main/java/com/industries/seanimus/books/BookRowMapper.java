package com.industries.seanimus.books;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int arg1) throws SQLException {
		return new Book(rs.getString("name"), rs.getString("author_name"), rs.getLong("isbn_number"),
				rs.getString("category"), rs.getBigDecimal("price"));
	}
}
