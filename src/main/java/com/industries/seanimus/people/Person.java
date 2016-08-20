package com.industries.seanimus.people;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person extends ResourceSupport {

	private String firstName;
	private String lastName;
	private String birthday;
	private char gender;
	private String maritalStatus;
	private int SSN;
	private int spouseSSN;
	private int parentSSN;


	@JsonCreator
	public Person(@JsonProperty String firstName, @JsonProperty String lastName, @JsonProperty String birthday,
				  @JsonProperty char gender, @JsonProperty int SSN) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.gender = gender;
		this.SSN = SSN;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public int getSSN() {
		return SSN;
	}

	public void setSSN(int sSN) {
		SSN = sSN;
	}

	public int getSpouseSSN() {
		return spouseSSN;
	}

	public void setSpouseSSN(int spouseSSN) {
		this.spouseSSN = spouseSSN;
	}

	public int getParentSSN() {
		return parentSSN;
	}

	public void setParentSSN(int parentSSN) {
		this.parentSSN = parentSSN;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", birthday="
				+ birthday + ", SSN=" + SSN + ", maritalStatus=" + maritalStatus + ", spouseSSN=" + spouseSSN
				+ ", parentSSN=" + parentSSN + "]";
	}

}
