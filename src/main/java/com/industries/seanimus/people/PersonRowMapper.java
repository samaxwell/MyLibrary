package com.industries.seanimus.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int arg1) throws SQLException {
		return new Person(rs.getString("first_name"),
				          rs.getString("last_name"),
				          rs.getString("birthday"),
				          rs.getString("gender").charAt(0),
				          rs.getInt("ssn"));
	}

}
