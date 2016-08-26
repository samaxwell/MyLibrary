package com.industries.seanimus.books;

import java.sql.Date;

public class Author {

	private int id;
	private String name;
	private Date dob;
	private Date dod;
	private StringBuffer bio;
	private String picture;

	public Author() {
	}

	public Author(int id, String name, Date dob, Date dod, String bio, String picture) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.dod = dod;
		this.bio = new StringBuffer(bio);
		this.picture = picture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDod() {
		return dod;
	}

	public void setDod(Date dod) {
		this.dod = dod;
	}

	public StringBuffer getBio() {
		return bio;
	}

	public void setBio(StringBuffer bio) {
		this.bio = bio;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", dob=" + dob + ", dod=" + dod + ", bio=" + bio + ", picture="
				+ picture + "]";
	}

}
