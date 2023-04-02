package com.bridgelabz;

public class AddressBookMain {

	public static void main(String[] args) {

		Contact person = new Contact();
		AddressBook addressBook = new AddressBook();
        
		//UC2-Adding a New Contact in AddressBook

		addressBook.addContactDetails();
		addressBook.displayContact();
		
		//UC3-Edit an Existing Contact in AddressBook using person name
		
		addressBook.editContactDetails();
		
		//UC4-Delete an Existing Contact in AddressBook using person name
		
		addressBook.deleteContact();
		
	}	
}