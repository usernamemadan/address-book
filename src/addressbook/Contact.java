package addressbook;

public class Contact {
	String firstName;
	String LastName;
	String city;
	String state;
	String zipcode;
	String phoneNumber;
	String email;
	
	public void addContact(String firstName, String LastName, String city, String state, String zipcode, String phoneNumber, String email) {
		this.firstName = firstName;
		this.LastName = LastName;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public void print() {
		System.out.println("firstName=" + firstName + ", LastName=" + LastName + ", city=" + city + ", state=" + state
				+ ", zipcode=" + zipcode + ", phoneNumber=" + phoneNumber + ", email=" + email );
	}

	
}
