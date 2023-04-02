package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook extends Contact {

	public AddressBook(String firstName, String lastName, String address, String city, String state, int zipCode,
			long phoneNumber, String email) {
		super(firstName, lastName, address, city, state, zipCode, phoneNumber, email);

	}

	public AddressBook() {
	}

	ArrayList<Contact> contacts = new ArrayList<>();

	public void addContactDetails() {
		System.out.println("Enter details Of A Contact : ");
		Contact person = new Contact();
		person.getPersonDetails();

		contacts.add(person);
	}
	
	public void displayContact(){
        for (Contact contact:contacts) {
            System.out.println(contact);
        }
    }
}