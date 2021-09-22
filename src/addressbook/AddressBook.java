package addressbook;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AddressBook {
	/*
	function to select or create a addressbook
	*/
	public Set<Contact> selectAddressBook(Map<String,Set<Contact>> addressBookList) {
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
	
	
}
