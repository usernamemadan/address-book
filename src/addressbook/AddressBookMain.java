package addressbook;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AddressBookMain {
	
	public static void main(String[] args) {
		System.out.println("welcome to address book program");
		
		Set<Contact> contactList = new HashSet<Contact>();
		
		int choice=0;
		while(choice != 5) {
			
			System.out.println("1 : Add Contact\n2 : Edit Contact\n3 : Delete Contact\n4 : Display Contact\n5.exit");
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
					contact.print();
				}
				break;
			case 5:
					break;
			
			}
		}
	}
		
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
