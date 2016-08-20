package com.industries.seanimus.books;

import java.math.BigDecimal;

public class Book {
	
	private String name;
	private String authorName;
	private long isbnNumber;
	private String category;
	private BigDecimal price;
	
	public Book(){
	}

	public Book(String name, String authorName, long isbnNumber, String category, BigDecimal price) {
		super();
		this.name = name;
		this.authorName = authorName;
		this.isbnNumber = isbnNumber;
		this.category = category;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public long getIsbnNumber() {
		return isbnNumber;
	}

	public String getCategory() {
		return category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", category=" + category + ", price=" + price + ", authorName=" + authorName
				+ ", isbnNumber=" + isbnNumber + "]";
	}
	
}
