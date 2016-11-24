package com.industries.seanimus.books;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Book {

	@Size(min = 3, max = 100, message = "Book title must be between 0 and 100 characters")
	@NotNull(message = "Book title must not be null")
	private String name;

	@Size(min = 3, max = 100, message = "Book author's name must be between 3 and 50 characters")
	@NotNull(message = "Book author's name must not be null")
	private String authorName;

	private String category;

	private long isbnNumber;

	private BigDecimal price;

	private int publishingDate;

	private String coverPath = "src/main/images/covers/";
	private byte[] cover;

	public Book() {
	}

	public Book(String name, String authorName, long isbnNumber, String category, BigDecimal price, int publishingDate,
			String cover) {
		super();
		this.name = name;
		this.authorName = authorName;
		this.isbnNumber = isbnNumber;
		this.category = category;
		this.price = price;
		this.publishingDate = publishingDate;
		this.setCover(cover);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(long isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getPublishingDate() {
		return publishingDate;
	}

	public void setPublishingDate(int publishingDate) {
		this.publishingDate = publishingDate;
	}

	public String getCoverPath() {
		return coverPath;
	}

	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}

	public byte[] getCover() {
		return cover;
	}

	public void setCover(String coverName) {
		if (coverName != null) {
			File img;
			try {
				img = new File(coverPath + coverName);
				BufferedImage bufferedImage = ImageIO.read(img);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(bufferedImage, "jpg", baos);
				this.cover = baos.toByteArray();
			} catch (IOException e) {
				System.out.println("THERE WAS AN ERROR CREATING PHOTO FOR " + this.toString());
			}
		} else {
			this.cover = new byte[0];
		}
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", authorName=" + authorName + ", category=" + category + ", isbnNumber="
				+ isbnNumber + ", price=" + price + ", publishingDate=" + publishingDate + "]";
	}

}
