package com.industries.seanimus.books;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Book {

	

	// TODO - add publish date
	private String name;
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

	public int getPublishingDate() {
		return publishingDate;
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
