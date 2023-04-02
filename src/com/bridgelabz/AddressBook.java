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
		System.out.println("New Contact has been added");
	}

	public void editContactDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter person name to edit : ");
		String name = sc.next();

		for (Contact person : contacts) {
			if (person.getFirstName().equals(name)) {
				System.out.println("Enter the option to edit : ");
				System.out.println(
						"1.Firstname 2.Lastname  3.Address  4.City  5.State  6.Zipcode  7.Phone number  8.Email  9.Exit");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Changing First name : ");
					person.setFirstName(sc.next());
					break;
				case 2:
					System.out.println("Changing last name : ");
					person.setLastName(sc.next());
					break;
				case 3:
					System.out.println("Changing address : ");
					person.setAddress(sc.next());
					break;
				case 4:
					System.out.println("Changing city : ");
					person.setCity(sc.next());
					break;
				case 5:
					System.out.println("Changing state : ");
					person.setState(sc.next());
					break;
				case 6:
					System.out.println("Changing zipcode : ");
					person.setZipCode(sc.nextInt());
					break;
				case 7:
					System.out.println("Changing phone number: ");
					person.setPhoneNumber(sc.nextInt());
					break;
				case 8:
					System.out.println("Changing email : ");
					person.setEmail(sc.next());
					break;
				case 9:
					System.out.println("Exiting from edit operation");
					break;
				}
			}
		}
	}

	public void deleteContact() {
		Scanner sc = new Scanner(System.in);
		System.out.println(contacts);
		System.out.println("Enter Person Name to delete : ");
		String name = sc.next();
		for (Contact person : contacts) {
			if (person.getFirstName().equals(name)) {
				contacts.remove(person);
				System.out.println("Contact deleted successfully !!!");
				break;
			}
		}
	}

	public void displayContact() {
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}
}