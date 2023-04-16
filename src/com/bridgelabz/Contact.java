package com.bridgelabz;

import java.util.Objects;
import java.util.Scanner;

public class Contact  implements Comparable {

	String firstName, lastName, address, city, state;
	int zipCode;
	long phoneNumber;
	String email;

	public Contact(String firstName, String lastName, String address, String city, String state, int zipCode,
			long phoneNumber, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Contact() {

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void getPersonDetails() {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter First Name : ");
		firstName = input.next();
		this.setFirstName(firstName);

		System.out.print("Enter Last Name : ");
		lastName = input.next();
		this.setLastName(lastName);

		System.out.print("Enter Address : ");
		address = input.next();
		this.setAddress(address);
		System.out.print("Enter City : ");
		city = input.next();
		this.setCity(city);

		System.out.print("Enter State : ");
		state = input.next();
		this.setState(state);

		System.out.print("Enter Zipcode : ");
		zipCode = input.nextInt();
		this.setZipCode(zipCode);

		System.out.print("Enter Phone number : ");
		phoneNumber = input.nextLong();
		this.setPhoneNumber(phoneNumber);

		System.out.print("Enter Email ID : ");
		email = input.next();
		this.setEmail(email);
	}

	public String toString() {
		return "Contact[" + "firstName= " + firstName + " ,lastName= " + lastName + " ,address= " + address + " ,city= "
				+ city + " ,state= " + state + " ,zipcode= " + zipCode + " ,phoneNumber= " + phoneNumber + " ,email= "
				+ email + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Contact contact = (Contact) o;
		return Objects.equals(firstName, contact.firstName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName);
	}

	@Override
	public int compareTo(Object o) {
		Contact contact = (Contact) o;
		int compareResult = this.city.compareTo(contact.city);
		return compareResult;
	}
}