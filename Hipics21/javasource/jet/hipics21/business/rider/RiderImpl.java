package jet.hipics21.business.rider;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jet.hipics21.business.contact.Contact;
import jet.hipics21.business.entry.EntryResults;
import jet.hipics21.business.licence.LICENCE_CODE;
import jet.hipics21.business.licence.RiderLicence;


public class RiderImpl implements Rider {
	
	private static Map<LICENCE_CODE, Comparator<Rider>> comparatorByLicenceCode = new HashMap<LICENCE_CODE, Comparator<Rider>>();
	static {
		for (LICENCE_CODE licenceCode: LICENCE_CODE.values()) {
			Comparator<Rider> comparator = new RiderByLicenceCode(licenceCode);
			comparatorByLicenceCode.put(licenceCode, comparator);
		}
			
	}
	public static Comparator<Rider> getComparatorByLicenceCode(LICENCE_CODE licenceCode) {
		
		return comparatorByLicenceCode.get(licenceCode);
	}
	
	private final Contact contact;
	private RiderAgeStatus riderAgeStatus;
	private RiderStatus riderStatus;
	private String licenceNumber;
	
	private List<EntryResults> entryResultsList = new ArrayList<EntryResults>();
	private Map<LICENCE_CODE, RiderLicence> riderLicenceMap = new EnumMap<LICENCE_CODE, RiderLicence>(LICENCE_CODE.class);
	
	RiderImpl(Contact contact) {
		
		assert contact != null:"contact null";
		
		this.contact = contact;
		
	}
	
	public int compareTo(Rider otherRider) {
		if (otherRider == null) {
			throw new NullPointerException("Rider null");
		}
		
		int compareName2 = getContact().getName2().compareTo(otherRider.getContact().getName2());
		if (compareName2 == 0) {
			
			return getContact().getName1().compareTo(otherRider.getContact().getName1());
			
		}
		return compareName2;
	}

	public boolean equals(Object other) {
		
		if (other == null) {
			return false;
		} else if (other == this) {
			return true;
		} else if (!(other instanceof Rider)) {
			return false;
		} else {
			Rider rider = (Rider) other;
			if (rider.getContact().equals(this.getContact())) {
				return true;
			}
			return false;
		}
	}

	public Contact getContact() {
		return this.contact;
	}

	public String getLicenceNumber() {
		return this.licenceNumber;
	}

	public void addEntryResults (EntryResults entryResults) {
		
		assert entryResults != null:"entryResults null";
		assert entryResults.getHorseRiderCouple().getRider() == this;

		this.entryResultsList.add(entryResults);
	}
	
	public void removeEntryResults (EntryResults entryResults) {
		
		assert entryResults != null:"entryResults null";
		this.entryResultsList.remove(entryResults);
	}
	public RiderAgeStatus getRiderAgeStatus() {
		return this.riderAgeStatus;
	}

	public RiderStatus getRiderStatus() {
		return this.riderStatus;
	}

	public void setRiderAgeStatus(RiderAgeStatus riderAgeStatus) {
		this.riderAgeStatus = riderAgeStatus;
	}

	public void setRiderStatus(RiderStatus riderStatus) {
		this.riderStatus = riderStatus;		
	}

	public void addLicence(RiderLicence riderLicence) {
		assert riderLicence != null : "riderLicence null";
		this.riderLicenceMap.put(riderLicence.getLicenceCode(), riderLicence);
	}
	
	public void removeLicence(RiderLicence riderLicence) {
		assert riderLicence != null : "riderLicence null";
		this.riderLicenceMap.remove(riderLicence);
	}

	public RiderLicence getRiderLicence(LICENCE_CODE code) {
		return this.riderLicenceMap.get(code);
		
	}
	
	public List<RiderLicence> getRiderLicenceList() {
		return Collections.unmodifiableList(new ArrayList<RiderLicence>(this.riderLicenceMap.values()));
	}
		

	private static class RiderByLicenceCode implements Comparator<Rider> {
		
		private final LICENCE_CODE licenceCode;

		RiderByLicenceCode(LICENCE_CODE licenceCode) {
			
			this.licenceCode = licenceCode;
			
		}
		
		@Override
		public int compare(Rider rider1, Rider rider2) {
			if (rider1 == null) {
				throw new NullPointerException("Rider<rider 1 is null");
			}
			
			if (rider2 == null) {
				throw new NullPointerException("Rider<rider 2 is null");
			}
			
			RiderLicence rider1Licence = rider1.getRiderLicence(licenceCode);
			if (rider1Licence == null) {
				throw new ClassCastException("rider1Licence null");
			}
			RiderLicence rider2Licence = rider2.getRiderLicence(licenceCode);
			if (rider2Licence == null) {
				throw new ClassCastException("rider1Licence null");
			}
					
			return rider1Licence.compareTo(rider2Licence);
		} 
	}
	
	public String toString() {
		
		return this.contact.getName1() + " " + this.contact.getName2() + " " + this.riderLicenceMap.toString();
	}

}
