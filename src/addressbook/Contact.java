package addressbook;

import java.util.Objects;

/*
contact class stores the contact information of a person
*/
public class Contact implements Comparable<Contact>{
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

	public void addContact(String firstName, String LastName, String city, String state, String zipcode,
			String phoneNumber, String email) {
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

	@Override
	public int hashCode() {
		return Objects.hash(LastName, city, email, firstName, phoneNumber, state, zipcode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(LastName, other.LastName) && Objects.equals(city, other.city)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(state, other.state)
				&& Objects.equals(zipcode, other.zipcode);
	}

	@Override
	public int compareTo(Contact o) {
		return (this.firstName + this.LastName).compareTo(o.getFirstName() + o.getLastName());
	}
	
}
