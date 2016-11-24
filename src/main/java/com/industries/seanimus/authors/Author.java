package com.industries.seanimus.authors;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Author {

	private int id;

	@Size(min = 3, max = 100, message = "This author needs a name between 3 and 100 characters")
	@NotNull(message = "This author needs a name")
	private String name;

	@Past(message = "This author's DOB must be in the past")
	@NotNull(message = "This author needs a date of birth")
	private Date dob;

	@Past(message = "This author's DOD must be in the past")
	private Date dod;

	@Size(min = 0, max = 1000, message = "This author's bio cannot exceed 1000 characters")
	private String bio;
	private String picture;

	public Author() {
	}

	public Author(int id, String name, Date dob, Date dod, String bio, String picture) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.dod = dod;
		this.bio = bio;
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

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
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
