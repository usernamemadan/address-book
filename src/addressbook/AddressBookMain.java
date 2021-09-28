package addressbook;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 AddressBookMain class manages selecting addressbook
 and modifies the contacts
*/

public class AddressBookMain {
	static Map<String, List<Contact>> stateMap = new HashMap<String, List<Contact>>();
	static Map<String, List<Contact>> cityMap = new HashMap<String, List<Contact>>();
	final static String PATH = "/Users/madanar/eclipse-workspace/YML training/employee.java/AddressBook/data/storeContacts";

	public static void main(String[] args) {
		System.out.println("welcome to address book program");

		List<Contact> contactList = null;
		AddressBook addressBook = new AddressBook();
		Map<String, List<Contact>> addressBookList = new HashMap<String, List<Contact>>();

		do {
			contactList = addressBook.selectAddressBook(addressBookList);
		} while (contactList == null);

		int choice = 0;
		while (choice != 13) {

			System.out.println(
					"1 : Add Contact\n2 : Edit Contact\n3 : Delete Contact\n4 : Display Contact\n"
					+ "5 : Change address book \n6 : Search a person \n7 : sort contacts \n"
					+ "8 : sort contacts by state/city/zip \n9 : save contacts to the file \n10 : read contacts from the file \n"
					+ "13 : exit");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				createContact(contactList);
				break;

			case 2:
				System.out.println("enter the first name of the contact to edit");
				sc.nextLine();
				String name = sc.nextLine();
				for (Contact contact : contactList) {
					if ((contact.getFirstName()).equals(name)) {
						editContact(contact);
						break;
					}
				}
				break;

			case 3:
				System.out.println("enter the first name of the contact to delete");
				sc.nextLine();
				String name1 = sc.nextLine();
				for (Contact contact : contactList) {
					if ((contact.getFirstName()).equals(name1)) {
						contactList.remove(contact);
						break;
					}
				}
				break;

			case 4:
				printContacts(contactList);
				break;

			case 5:
				do {
					contactList = addressBook.selectAddressBook(addressBookList);
				} while (contactList == null);
				break;

			case 6:
				getInput(addressBookList);
				break;

			case 7:
				sortContacts(contactList);
				printContacts(contactList);
				break;

			case 8:
				sortBy(contactList);
				break;

			case 9:
				writeTofile(contactList);
				break;

			case 10:
				readFromFile();
				break;
				
			case 11:
				break;
				
			case 12:
				break;
				
			}
		}
	}

	/**
	 * function to print all the contacts in contact list
	 * 
	 * @param contactList
	 */
	public static void printContacts(List<Contact> contactList) {
		for (Contact contact : contactList) {
			System.out.println(contact);
		}
	}

	/**
	 * function to create a new contact
	 * 
	 * @param contactList
	 */
	public static void createContact(List<Contact> contactList) {
		String firstName;
		String LastName;
		String city;
		String state;
		String zipcode;
		String phoneNumber;
		String email;

		Scanner sc = new Scanner(System.in);
		System.out.println("enter the first name");
		firstName = sc.nextLine();
		System.out.println("enter the last name");
		LastName = sc.nextLine();
		System.out.println("enter the city");
		city = sc.nextLine();
		System.out.println("enter the state");
		state = sc.nextLine();
		System.out.println("enter the zipcode");
		zipcode = sc.nextLine();
		System.out.println("enter the phone number");
		phoneNumber = sc.nextLine();
		System.out.println("enter the email");
		email = sc.nextLine();

		Contact contact = new Contact();
		contact.addContact(firstName, LastName, city, state, zipcode, phoneNumber, email);
		Long countContact = contactList.stream().filter(c -> c.equals(contact)).count();
		if (countContact > 0) {
			System.out.println("contact already exist");
		} else {
			contactList.add(contact);
		}
	}

	/**
	 * function to edit a contact
	 * 
	 * @param contact
	 */
	public static void editContact(Contact contact) {
		String city;
		String state;
		String zipcode;
		String phoneNumber;
		String email;

		Scanner sc = new Scanner(System.in);

		System.out.println("enter the updated city");
		city = sc.nextLine();
		System.out.println("enter the updated state");
		state = sc.nextLine();
		System.out.println("enter the updated zipcode");
		zipcode = sc.nextLine();
		System.out.println("enter the updated number");
		phoneNumber = sc.nextLine();
		System.out.println("enter the updated email");
		email = sc.nextLine();

		contact.city = city;
		contact.state = state;
		contact.zipcode = zipcode;
		contact.phoneNumber = phoneNumber;
		contact.email = email;
	}

	/**
	 * function to input the choice of searching by city or state
	 * 
	 * @param addressBookList
	 */
	public static void getInput(Map<String, List<Contact>> addressBookList) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the choice \n1.by city \n2.by state");
		int choice = sc.nextInt();
		if (choice == 1)
			searchByCity(addressBookList);
		else
			searchByState(addressBookList);
	}

	/**
	 * function to search and count the people in a particular city
	 * 
	 * @param addressBookList
	 */
	public static void searchByCity(Map<String, List<Contact>> addressBookList) {
		List personListByCity = new ArrayList<>();
		long noOfPerson = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the city name to be searched");
		String city = sc.nextLine();
		System.out.println("list of person from city");
		for (String bookname : addressBookList.keySet()) {
			List<Contact> contactList = addressBookList.get(bookname);
			personListByCity = contactList.stream().filter(c -> c.city.equals(city)).collect(Collectors.toList());
			noOfPerson = contactList.stream().filter(c -> c.city.equals(city)).count();
		}
		for (Object object : personListByCity) {
			System.out.println(object);
		}
		System.out.println("No of people in city " + city + ": " + noOfPerson);
	}

	/**
	 * function to search and count the people in a particular state
	 * 
	 * @param addressBookList
	 */
	public static void searchByState(Map<String, List<Contact>> addressBookList) {
		List personListByState = new ArrayList<>();
		long noOfPerson = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the state name to be searched");
		String state = sc.nextLine();
		System.out.println("list of person from state");
		for (String bookname : addressBookList.keySet()) {
			List<Contact> contactList = addressBookList.get(bookname);
			personListByState = contactList.stream().filter(c -> c.city.equals(state)).collect(Collectors.toList());
			noOfPerson = contactList.stream().filter(c -> c.city.equals(state)).count();
		}
		for (Object object : personListByState) {
			System.out.println(object);
		}
		System.out.println("No of people in state " + state + ": " + noOfPerson);
	}
	
	/**
	 * store the person name and city in hashmap
	 * also store the person name and state in hashmap
	 * @param addressBookList
	 */
	public static void veiwBy(Map<String, List<Contact>> addressBookList) {
		System.out.println("View contacts by\n1.City\n2.State");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			cityMap.clear();
			for (String bookname : addressBookList.keySet()) {
				List<Contact> contactList = addressBookList.get(bookname);
				contactList.stream().forEach(c -> {
					List<Contact> contacts = cityMap.get(c.city);
					if (contacts == null) {
						List<Contact> contacts2 = new ArrayList<>();
						contacts2.add(c);
						cityMap.put(c.city, contacts2);
					} else {
						contacts.add(c);
						cityMap.put(c.city, contacts);
					}
				});
			}
			printView(cityMap);
			break;

		case 2:
			stateMap.clear();
			for (String bookname : addressBookList.keySet()) {
				List<Contact> contactList = addressBookList.get(bookname);
				contactList.stream().forEach(c -> {
					List<Contact> contacts = cityMap.get(c.state);
					if (contacts == null) {
						List<Contact> contacts2 = new ArrayList<>();
						contacts2.add(c);
						cityMap.put(c.state, contacts2);
					} else {
						contacts.add(c);
						cityMap.put(c.state, contacts);
					}
				});
			}
			printView(stateMap);
			break;

		}
	}
	/**
	 * prints the Hashmap of citymap and statemap
	 * @param map
	 */
	public static void printView(Map<String, List<Contact>> map) {
		for (Map.Entry<String, List<Contact>> e : map.entrySet()) {
			for (Contact contact : e.getValue()) {
				System.out.print(e.getKey() + ": " + contact.getFirstName() + " " + contact.getLastName());
				System.out.println();
			}
			System.out.println();
		}
	}

	/**
	 * Sort the contacts according to person's name
	 * @param contactList
	 */
	public static void sortContacts(List<Contact> contactList) {
		Collections.sort(contactList);
		System.out.println("Contact list is sorted");
	}

	/**
	 * method to call the sort methods according to city, state and zip code
	 * @param contactList
	 */
	public static void sortBy(List<Contact> contactList) {
		System.out.println("Sort contacts by\n1.City \n2.State \n3.zip code");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			sortContactsByCity(contactList);
			break;
		case 2:
			sortContactsByState(contactList);
			break;
		case 3:
			sortContactsByZip(contactList);
			break;
		}
	}

	/**
	 * sort contacts according to state
	 * @param contactList
	 */
	public static void sortContactsByState(List<Contact> contactList) {
		Collections.sort(contactList, Comparator.comparing((Contact c) -> c.state));
		System.out.println("Contact list is sorted by state");
		System.out.println(contactList);
	}

	/**
	 * sort contacts according to city
	 * @param contactList
	 */
	public static void sortContactsByCity(List<Contact> contactList) {
		Collections.sort(contactList, Comparator.comparing((Contact c) -> c.city));
		System.out.println("Contact list is sorted by city");
		System.out.println(contactList);
	}

	/**
	 * sort contacts according to zip code
	 * @param contactList
	 */
	public static void sortContactsByZip(List<Contact> contactList) {
		Collections.sort(contactList, Comparator.comparing((Contact c) -> c.zipcode));
		System.out.println("Contact list is sorted by zip code");
		System.out.println(contactList);
	}
	
	/**
	 * writes the contact list to the file
	 * @param contactList
	 */
	public static void writeTofile(List<Contact> contactList)
	{
		try {
		      FileWriter myWriter = new FileWriter(PATH);
		      for (Contact contact : contactList) {
				myWriter.write(contact.toString() + "\n");
			}
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	/**
	 * reads the contact list from the file and prints it
	 */
	public static void readFromFile() {
        try {
        	FileReader fileReader = new FileReader(PATH);
        	int i;    
            while((i = fileReader.read()) != -1) {
               System.out.print((char)i); 
            }
        } catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
