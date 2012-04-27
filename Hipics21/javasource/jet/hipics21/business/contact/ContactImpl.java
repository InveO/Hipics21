package jet.hipics21.business.contact;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import jet.hipics21.business.address.Address;

public class ContactImpl implements Contact {
	private final int contactId;
	
	private String name1;
	private String name2;
	private String name3;
	private String telPrivate;
	private String telOffice;
	private String telMobile;
	private String mailPrivate;
	private String mailOffice;
	private String faxPrivate;
	private String faxOffice;
	
	private Locale language;
	private ContactType contactType;

	private List<Address> addressList;
	
	private GregorianCalendar dateOfBirth;

	private boolean valid;
	
	public ContactImpl(int contactId) {
		this.contactId = contactId;
		this.valid = true;
		
	}
	
	public void setInvalid() {
		this.valid = false;
	}
	
	public List<Address> getAddressList() {
		return this.addressList;
	}

	
	public ContactType getContactType() {
		return this.contactType;
	}


	public GregorianCalendar getDateOfBirth() {
		return this.dateOfBirth;
	}

	public int getContactId() {
		return this.contactId;
	}

	public String getFaxOffice() {
		return this.faxOffice;
	}

	public String getFaxPrivate() {
		return this.faxPrivate;
	}

	public Locale getLanguage() {
		return this.language;
	}

	public String getMailOffice() {
		return this.mailOffice;
	}

	public String getMailPrivate() {
		return this.mailPrivate;
	}

	public String getName1() {
		if (this.valid == false) {
			throw new IllegalStateException("ContactImpl " + this.getContactId() + " " + this.name1 + " " + this.name2 + " is invalid");
		}
		return this.name1;
	}

	public String getName2() {
		return this.name2;
	}

	public String getName3() {
		return this.name3;
	}

	public String getTelMobile() {
		return this.telMobile;
	}

	public String getTelOffice() {
		return this.telOffice;
	}

	public String getTelPrivate() {
		return this.telPrivate;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
		
	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	public void setDateOfBirth(GregorianCalendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setFaxOffice(String faxOffice) {
		this.faxOffice = faxOffice;
	}

	public void setFaxPrivate(String faxPrivate) {
		this.faxPrivate = faxPrivate;
	}

	public void setLanguage(Locale language) {
		this.language = language;
	}

	public void setMailOffice(String mailOffice) {
		this.mailOffice = mailOffice;
	}

	public void setMailPrivate(String mailPrivate) {
		this.mailPrivate = mailPrivate;
	}

	public void setName1(String name1) {
		this.name1 = name1;		
	}

	public void setName2(String name2) {
		this.name2 = name2;		
	}
	
	public void setName3(String name3) {
		this.name3 = name3;
	}
	
	public void setTelMobile(String telMobile) {
		this.telMobile = telMobile;
	}

	public void setTelOffice(String telOffice) {
		this.telOffice = telOffice;
	}

	public void setTelPrivate(String telPrivate) {
		this.telPrivate = telPrivate;
	}

	public String toString() {
		
		return getName1() + " " + getName2();
	}
	
	public int hashCode() {
		return getContactId();
	}
	
	public boolean equals(Object other) {
		
		if (other == null) {
			return false;
		} else if (other == this) {
			return true;
		} else if (!(other instanceof Contact)) {
			return false;
		} else {
			
			Contact contact = (Contact) other;
			if (contact.getContactId() == getContactId()) {
				return true;
			}
			return false;
		}
	}

}
