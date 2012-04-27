package jet.hipics21.business.official;

import java.util.GregorianCalendar;

import jet.hipics21.business.contact.Contact;


public class OfficialImpl implements Official {
	
	private final Contact contact;
	private OfficialFunction officialFunction;
	private GregorianCalendar validFrom;
	private GregorianCalendar validTo;
	
	OfficialImpl(Contact contact) {
		
		assert contact != null:"contact null";
		
		this.contact = contact;
		
	}
	
	public boolean equals(Object other) {
		
		if (other == null) {
			return false;
		} else if (other == this) {
			return true;
		} else if (!(other instanceof Official)) {
			return false;
		} else {
			Official official = (Official) other;
			if (official.getContact().equals(this.getContact())) {
				return true;
			}
			return false;
		}
	}

	public Contact getContact() {
		return this.contact;
	}

	public OfficialFunction getOfficialFunction() {
		return this.officialFunction;
	}

	public GregorianCalendar getValidFrom() {
		return this.validFrom;
	}

	public GregorianCalendar getValidTo() {
		return this.validTo;
	}

	public void setOfficialFunction(OfficialFunction officialFunction) {
		this.officialFunction = officialFunction;
	}

	public void setValidFrom(GregorianCalendar validFrom) {
		this.validFrom = validFrom;
	}

	public void setValidTo(GregorianCalendar validTo) {
		this.validTo = validTo;
	}
	
	public String toString() {
		
		return getContact().getName1() + " " + getContact().getName2();
	}
	
	public int hashCode() {
		return getContact().getContactId();
	}


}
