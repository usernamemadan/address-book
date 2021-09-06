package addressbook;
/*
contact class stores the contact information of a person
*/
public class Contact {
	String firstName;
	String LastName;
	String city;
	String state;
	String zipcode;
	String phoneNumber;
	String email;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public void addContact(String firstName, String LastName, String city, String state, String zipcode, String phoneNumber, String email) {
		this.firstName = firstName;
		this.LastName = LastName;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", LastName=" + LastName + ", city=" + city + ", state=" + state
				+ ", zipcode=" + zipcode + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}

}
