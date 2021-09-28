package addressbook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
	
	/**
	 * function to create or select an address book
	 * @param addressBookList
	 * @return contact list from selected address book list
	 */
	public List<Contact> selectAddressBook(Map<String, List<Contact>> addressBookList) {
		System.out.println("1.Create address book \n2.Choose address book");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.nextLine();
		String name;
		if(choice == 1) {
			System.out.println("Enter the name of new address book");
			name = sc.nextLine();
			List<Contact> contactList1 = new ArrayList<Contact>();
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
