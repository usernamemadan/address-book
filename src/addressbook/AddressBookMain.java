package addressbook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 AddressBookMain class manages selecting addressbook
 and modifies the contacts
*/

public class AddressBookMain {
	
	public static void main(String[] args) {
		System.out.println("welcome to address book program");
		
		Set<Contact> contactList = null;
		Map< String,Set<Contact> > addressBookList = new HashMap<String,Set<Contact>>();
		
		do {
			contactList = selectAddressBook(addressBookList);
		}while(contactList == null);
		
		int choice=0;
		while(choice != 6) {
			
			System.out.println("1 : Add Contact\n2 : Edit Contact\n3 : Delete Contact\n4 : Display Contact\n5 : Change address book \n6 : exit");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			
			
			switch(choice){
			case 1:
				Contact newContact =  createContact();
				contactList.add(newContact);
				break;
			case 2:
				System.out.println("enter the first name of the contact to edit");
				sc.nextLine();
				String name=sc.nextLine();
				for(Contact contact: contactList){
					if((contact.getFirstName()).equals(name)) {
						editContact(contact);
						break;						
					}
				}
				break;
				
			case 3:
				System.out.println("enter the first name of the contact to delete");
				sc.nextLine();
				String name1=sc.nextLine();
				for(Contact contact: contactList){
					if((contact.getFirstName()).equals(name1)) {
						contactList.remove(contact);
						break;
					}
				}
				break;
				
			case 4:
				for(Contact contact: contactList){
					System.out.println(contact);
				}
				break;
			case 5:
				do {
					contactList = selectAddressBook(addressBookList);
				}while(contactList == null);
				break;
			case 6:
				break;
			}
		}
	}

	/*
	function to select or create a addressbook
	*/
	public static Set<Contact> selectAddressBook(Map<String,Set<Contact>> addressBookList) {
		System.out.println("1.Create address book \n2.Choose address book");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.nextLine();
		String name;
		if(choice == 1) {
			System.out.println("Enter the name of new address book");
			name = sc.nextLine();
			Set<Contact> contactList1 = new HashSet<Contact>();
			addressBookList.put(name, contactList1);
		}
		else if(choice == 2) {
	            for (String bookname : addressBookList.keySet()) {
	                System.out.println(bookname);
	            }
	            System.out.println("Enter the name of address book from the given list");
	            name = sc.nextLine();
		}
		else {
			System.out.println("invalid choice. try again");
			return null;
		}
		return addressBookList.get(name);
	}
	
	/*
	function to create a new contact
	*/
	public static Contact createContact() {	
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
		return contact;
		
	}
	/*
	function to edit a contact
	*/
	public static void editContact(Contact contact) {
		String city;
		String state;
		String zipcode;
		String phoneNumber;
		String email;
		
		Scanner sc = new Scanner(System.in);

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
		
		contact.city = city;
		contact.state = state;
		contact.zipcode = zipcode;
		contact.phoneNumber = phoneNumber;
		contact.email = email;
	}
}
