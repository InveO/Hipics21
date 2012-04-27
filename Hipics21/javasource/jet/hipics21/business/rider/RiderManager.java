package jet.hipics21.business.rider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jet.hipics21.business.contact.Contact;
import jet.hipics21.business.contact.ContactManager;
import jet.hipics21.business.licence.LicenceCode;
import jet.hipics21.business.licence.RiderLicence;

public class RiderManager {
	
	private static final RiderManager riderManager = new RiderManager();
	private static final ContactManager contactManager = ContactManager.getContactManager();
	
	private Map<Integer, RiderImpl> riderMap = new HashMap<Integer, RiderImpl>();
	
	public static RiderManager getRiderManager() {
		return riderManager;
	}
	
	private RiderManager() {
		
		// empty
	}
	
	public Rider createRider(Contact contact) {
		assert contact != null:"contact null";
		
		RiderImpl preExistingRiderImpl = getRiderImpl(contact.getContactId());
		
		if (preExistingRiderImpl != null) {
			throw new IllegalStateException("riderImpl already exists " + preExistingRiderImpl);
		}
		
		RiderImpl riderImpl = new RiderImpl(contact);
		putRiderImpl(riderImpl);
		
		return riderImpl;
		
	}

	public void removeRider(Contact contact) {
		assert contact != null:"contact null";
		
		RiderImpl riderImpl = this.riderMap.remove(contact.getContactId());		
	}

	public Rider getRider(Contact contact) {
		assert contact != null:"contact null";
		
		RiderImpl riderImpl = getRiderImpl(contact.getContactId());
		
	
		return riderImpl;
		
	}
	private RiderImpl getRiderImpl(Integer contactId) {
		assert contactId >= 0:"contactId negative " + contactId;
		
		return this.riderMap.get(contactId);
	}
	
	private void putRiderImpl(RiderImpl riderImpl) {
		
		this.riderMap.put(riderImpl.getContact().getContactId(), riderImpl);
	}
	
	Collection<RiderImpl> getRiderImplCollection() {
		
		return riderMap.values();
	}
	
	public List<Rider> getRiderList() {
		
		List<Rider> riderList = new ArrayList<Rider>(getRiderImplCollection());
		return riderList;
	}
	
	public List<Rider> getSortedRiderList() {
		
		List<Rider> riderList = getRiderList();
		Collections.sort(riderList);
		
		return riderList;
		
	}
	
	
	public List<Rider> getRiderListSortedByLicenceNumber(LicenceCode licenceCode) {
		
		List<Rider> riderList = new ArrayList<Rider>();
		
		for (Rider rider: getRiderImplCollection()) {
			RiderLicence riderLicence = rider.getRiderLicence(licenceCode);
			if (riderLicence != null) {
				riderList.add(rider);
			}
		}

		Comparator<Rider> riderLicenceComparator = RiderImpl.getComparatorByLicenceCode(licenceCode);
		Collections.sort(riderList, riderLicenceComparator);
		return riderList;

	}

}
