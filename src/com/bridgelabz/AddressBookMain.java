package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
 
		String check = "Yes";
		
		Contact person = new Contact();
		AddressBook addressBook = new AddressBook();
		
		//UC2-Adding a New Contact in AddressBook

		addressBook.addContactDetails();
		addressBook.displayContact();
		
		//UC3-Edit an Existing Contact in AddressBook using person name
		
		addressBook.editContactDetails();
		
		//UC4-Delete an Existing Contact in AddressBook using person name
		
		addressBook.deleteContact();
		
		//UC5- Add Multiple Person to AddressBook
		
		while(check.equals("Yes"))
		{
			System.out.println("Adding a New Contact : ");
			addressBook.addContactDetails();
			addressBook.displayContact();
			System.out.println("If want to add more Contacts put 'Yes' else 'No' or AnyKey");
			Scanner sc = new Scanner(System.in);
			check = sc.nextLine();	
		}
		
	}	
}