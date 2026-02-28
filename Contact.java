package org.snhu.cs320.contact;

public class Contact {

	private String contactId; 
	private String firstName;
	private String lastName; 
	private String phone;
	private String address;
	
	public Contact(String contactId, String firstName, String lastName, String phone, String address) throws Exception {
		super();
		
		setContactId(contactId);
		
		setFirstName(firstName);
		
		setLastName(lastName);
		
		setPhone(phone);
		
		setAddress(address);

	}
	
	public String getContactId() {
	    return contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws Exception {
		if (firstName == null || firstName.trim().length() < 1 || firstName.length() > 10) {
			throw new IllegalArgumentException("Yikes, check First Name");
		}
		
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws Exception {
		if (lastName == null || lastName.trim().length() < 1 || lastName.length() > 10) {
			throw new IllegalArgumentException("Yikes, check Last Name");
		}
		
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) throws Exception {
	    if (phone == null || !phone.matches("\\d{10}")) {
	        throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
	    }
	    this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) throws Exception {
		
		if (address == null || address.length() < 1 || address.length() > 30) {
			throw new IllegalArgumentException("The address provided is too long");
		}
		this.address = address;
	}
	
	private void setContactId(String contactId) throws Exception {
		if (contactId == null || contactId.trim().length() < 1 || contactId.length() > 10) {
			throw new IllegalArgumentException("Yikes, check Contact ID");
		}
		
		this.contactId = contactId;
	}
	
	
}