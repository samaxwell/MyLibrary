package com.industries.seanimus.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * Start the application
 */

@EnableAutoConfiguration
@SpringBootApplication
@Configuration
@ComponentScan({"com.industries.seanimus.books", "com.industries.seanimus.authors"})
public class Launcher {

	public static void main(String[] args) {
		SpringApplication.run(Launcher.class, args);
	}
}
