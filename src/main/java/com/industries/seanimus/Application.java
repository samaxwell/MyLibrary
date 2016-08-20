package com.industries.seanimus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.industries.seanimus.books.BookDaoImpl;

@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@SpringBootApplication
@Configuration
@ComponentScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

//		BookDao jdbcTemplate = new BookDao();

		// List<Book> books = jdbcTemplate.getAllBooks();
		// for (Book b : books){
		// System.out.println(b);
		// }

		// List<Person> people = jdbcTemplate.getAllPeople();
		// for (Person p : people){
		// System.out.println(p);
		// }
	}
}
