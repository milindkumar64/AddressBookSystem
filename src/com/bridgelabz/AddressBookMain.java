package com.bridgelabz;

import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.opencsv.CSVWriter;

public class AddressBookMain {

	public static void main(String[] args) throws IOException {

		HashMap<String, AddressBook> dictionary = new HashMap<>();
		AddressBook book = new AddressBook();
		Scanner input = new Scanner(System.in);

		int option;
		do {
			System.out.println("Options are : ");
			System.out.print("1.Add Contact to existing address book\t");
			System.out.print("2.Edit Contact\t");
			System.out.print("3.Display Address Book\n");
			System.out.print("4.Delete Contact\t");
			System.out.print("5.Display available Address Books\t");
			System.out.print("6.Add new Address Book\n");
			System.out.print("7.Search a person by City\t");
			System.out.print("8.Search a person by State\t");
			System.out.print("9.Sort by City\t");
			System.out.print("10.Exit\n");
			System.out.print("Enter an option from above :- ");
			option = input.nextInt();

			switch (option) {

			case 1:
				System.out.println("Enter name of address book in which you want to add contact : ");
				String addressBookName = input.next();
				if (dictionary.containsKey(addressBookName)) {
					System.out.println(addressBookName + " Address book exist.");
					AddressBook addressBook = dictionary.get(addressBookName);
					addressBook.getContactDetails();
				} else {
					System.out.println("Address Book does not exist");
				}
				break;
			case 2:
				System.out.println("Enter name of address book in which you want to edit contact : ");
				String addressBookName1 = input.next();
				if (dictionary.containsKey(addressBookName1)) {
					System.out.println(addressBookName1 + " Address book exist.");
					AddressBook addressBook = dictionary.get(addressBookName1);
					addressBook.editPersonDetails();
				} else {
					System.out.println("Address Book does not exist");
				}
				break;
			case 3:
				System.out.println("Enter name of address book in which you want to display contact : ");
				String addressBookName2 = input.next();
				if (dictionary.containsKey(addressBookName2)) {
					System.out.println(addressBookName2 + " Address book exist.");
					AddressBook addressBook = dictionary.get(addressBookName2);
					addressBook.displayContact();
				} else {
					System.out.println("Address Book does not exist");
				}
				break;
			case 4:
				System.out.println("Enter name of address book in which you want to delete contact : ");
				String addressBookName3 = input.next();
				if (dictionary.containsKey(addressBookName3)) {
					System.out.println(addressBookName3 + " Address book exist.");
					AddressBook addressBook = dictionary.get(addressBookName3);
					addressBook.deleteContact();
				} else {
					System.out.println("Address Book does not exist");
				}
				break;
			case 5:
				if (dictionary.isEmpty()) {
					System.out.println("Dictionary is empty");
				} else {
					System.out.println(dictionary.keySet());
				}
				break;
			case 6:
				System.out.println("Enter name of address book you want to add to dictionary : ");
				String addressBookName4 = input.next();
				if (dictionary.containsKey(addressBookName4)) {
					System.out.println(addressBookName4 + " Address book exist.");
				} else {
					System.out.println("Address Book does not exist");
					AddressBook addressBook = new AddressBook();
					dictionary.put(addressBookName4, addressBook);
				}
				break;
			case 7:
				System.out.println("Enter name of address book in which you want to search contact by city name : ");
				String addressBookName5 = input.next();
				if (dictionary.containsKey(addressBookName5)) {
					System.out.println("Enter name of city : ");
					String cityName = input.next();
					AddressBook addressBook = dictionary.get(addressBookName5);
					System.out.println("Enter a person's name : ");
					String personName = input.next();
					addressBook.searchByCityName(cityName, personName);
				} else {
					System.out.println("Address Book does not exist");
				}
				break;
			case 8:
				System.out.println("Enter name of address book in which you want to search contact by state name : ");
				String addressBookName6 = input.next();
				if (dictionary.containsKey(addressBookName6)) {
					System.out.println("Enter name of State : ");
					String stateName = input.next();
					AddressBook addressBook = dictionary.get(addressBookName6);
					System.out.println("Enter a person's name : ");
					String personName = input.next();
					addressBook.searchByStateName(stateName, personName);
				} else {
					System.out.println("Address Book does not exist");
				}
				break;
			case 9:
				System.out.println("Enter name of address book in which you want to sort contact by city : ");
				String addressBookName7 = input.next();
				if (dictionary.containsKey(addressBookName7)) {
					System.out.println(addressBookName7 + " Address book exist.");
					AddressBook addressBook = dictionary.get(addressBookName7);
					addressBook.sortByCity();
				} else {
					System.out.println("Address Book does not exist");
				}
				break;
			case 10:
				System.out.println("Exiting from dictionary");
				break;
			}
		} while (option != 10);
		Path path = Paths.get(
				"E:\\Notepad++ java code\\Eclipse Workspace\\AddressBookSystem\\src\\com\\bridgelabz\\AddressBook.txt");
		try {
			Files.deleteIfExists(path);
			Files.write(path, dictionary.keySet().stream().map(key -> dictionary.get(key).toString())
					.collect(Collectors.toList()));
			// StandardOpenOption.CREATE

			List<String> readAllLines = Files.readAllLines(path);
			readAllLines.stream().forEach(line -> System.out.println(line));

			// writing inside CSV file

			FileWriter outputfile = new FileWriter(
					"E:\\Notepad++ java code\\Eclipse Workspace\\AddressBookSystem\\src\\com\\bridgelabz\\AddressBookcsv.csv");
			CSVWriter writer = new CSVWriter(outputfile);
			Object[] arrayAddressBookObj = new String[dictionary.values().size()];
			Set keySet = dictionary.keySet();
			Iterator itr = keySet.iterator();
			while (itr.hasNext()) {
				String key = (String) itr.next();
				// System.out.println(key);
				AddressBook obj = dictionary.get(key);
				for (Contact con : obj.contacts) {
					String[] arr = { con.getFirstName(), con.getLastName(), con.getCity(), con.getAddress(),
							con.getState(), String.valueOf(con.getZipCode()), String.valueOf(con.getPhoneNumber()),
							con.getEmail() };
					writer.writeNext(arr);
				}
			}
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Writing on Json Files

		Gson gson = new Gson();
		BufferedWriter bw = new BufferedWriter(new FileWriter(
				"E:\\Notepad++ java code\\Eclipse Workspace\\AddressBookSystem\\src\\com\\bridgelabz\\AddressBookjson.json"));
		Object[] arrayAddressBookObj = new String[dictionary.values().size()];
		Set keySet = dictionary.keySet();
		Iterator itr = keySet.iterator();
		while (itr.hasNext()) {
			String key = (String) itr.next();
			System.out.println(key);
			AddressBook obj = dictionary.get(key);
			for (Contact con : obj.contacts) {

				String json = gson.toJson(con);

				bw.write(json);
			}
		}
		bw.close();
	}
}