package com.bridgelabz;

public class AddressBookMain {

	public static void main(String[] args) {

		Contact person = new Contact();
		AddressBook addressBook = new AddressBook();
        
		//UC1-Adding a New Contact in AddressBook

		addressBook.addContactDetails();
		addressBook.displayContact();
	}
	
}