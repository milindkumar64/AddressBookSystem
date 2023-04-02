package com.bridgelabz;

import java.util.ArrayList;
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
	
	public void editContactDetails()
	{
		Scanner input1 = new Scanner(System.in);
        System.out.println("Enter perosn name to edit : " ) ;
        String name = input1.next();
        
        for (Contact person:contacts) {
            if (person.getFirstName().equals(name)) {
                System.out.println("Enter the option to edit");
                System.out.println("1.Firstname\t 2.Lastname\t 3.Address\t 4.City\t 5.State\t 6.Zipcode\t 7.Phone number\t 8.Email\t 9.Exit");
                int choice = input1.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Changing First name : ");
                        person.setFirstName(input1.next());
                        break;
                    case 2:
                        System.out.println("Changing last name : ");
                        person.setLastName(input1.next());
                        break;
                    case 3:
                        System.out.println("Changing address : ");
                        person.setAddress(input1.next());
                        break;
                    case 4:
                        System.out.println("Changing city : ");
                        person.setCity(input1.next());
                        break;
                    case 5:
                        System.out.println("Changing state : ");
                        person.setState(input1.next());
                        break;
                    case 6:
                        System.out.println("Changing zipcode : ");
                        person.setZipCode(input1.nextInt());
                        break;
                    case 7:
                        System.out.println("Changing phone number: ");
                        person.setPhoneNumber(input1.nextInt());
                        break;
                    case 8:
                        System.out.println("Changing email : ");
                        person.setEmail(input1.next());
                        break;
                    case 9:
                        System.out.println("Exiting from edit operation");
                        break;
                }
            }
        }
	}
	
	public void displayContact(){
        for (Contact contact:contacts) {
            System.out.println(contact);
        }
    }
}