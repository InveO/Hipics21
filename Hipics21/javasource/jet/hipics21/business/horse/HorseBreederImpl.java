package jet.hipics21.business.horse;

import jet.hipics21.business.contact.Contact;

public class HorseBreederImpl implements HorseBreeder {
	
	private final Contact contact;
	
	private String groupBreeder;
	private String breedingName;
	private String breederNum;
	
	HorseBreederImpl(Contact contact) {
		
		assert contact != null:"contact null";
		
		this.contact = contact;		
	}
	
	public boolean equals(Object other) {
		
		if (other == null) {
			return false;
		} else if (other == this) {
			return true;
		} else if (!(other instanceof HorseBreeder)) {
			return false;
		} else {
			HorseBreeder horseBreeder = (HorseBreeder) other;
			if (horseBreeder.getContact().equals(this.getContact())) {
				return true;
			}
			return false;
		}
	}

	public String getBreederNum() {
		return this.breederNum;
	}

	public String getBreedingName() {
		return this.breedingName;
	}

	public Contact getContact() {
		return this.contact;
	}

	public String getGroupBreeder() {
		return this.groupBreeder;
	}

	public void setBreederNum(String breederNum) {
		this.breederNum = breederNum;
	}

	public void setBreedingName(String breedingName) {
		this.breedingName = breedingName;
	}

	public void setGroupBreeder(String groupBreeder) {
		this.groupBreeder = groupBreeder;
	}

	public String toString() {
		
		return this.contact.getName1() + " " + this.contact.getName2() + " " + this.getBreedingName() + " " + this.getGroupBreeder();
	}
	
	public int hashCode() {
		return this.contact.getContactId();
	}
	

}
