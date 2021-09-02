package addressbook;

import java.util.Scanner;

public class AddressBookMain {
	
	public static void main(String[] args) {
		System.out.println("welcome to address book program");
		
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
		
		Contact person1 = new Contact();
		person1.addContact(firstName, LastName, city, state, zipcode, phoneNumber, email);
		person1.print();
	}
}
