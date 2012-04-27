package jet.hipics21.business.official;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jet.hipics21.business.contact.Contact;
import jet.hipics21.business.contact.ContactManager;

public class OfficialManager {
	
	private static final OfficialManager officialManager = new OfficialManager();
	private static final ContactManager contactManager = ContactManager.getContactManager();
	
	private Map<Integer, OfficialImpl> officialMap = new HashMap<Integer, OfficialImpl>();
	
	public static OfficialManager getOfficialManager() {
		return officialManager;
	}
	
	public OfficialManager() {
		
		// empty
	}
	
	public Official createOfficial(Contact contact) {
		assert contact != null:"contact null";
		
		OfficialImpl preExistingOfficialImpl = getOfficialImpl(contact.getContactId());
		
		if (preExistingOfficialImpl != null) {
			throw new IllegalStateException("officialImpl already exists " + preExistingOfficialImpl);
		}
		
		OfficialImpl officialImpl = new OfficialImpl(contact);
		putOfficialImpl(officialImpl);
		
		return officialImpl;
		
	}

	public void removeOfficial(Contact contact) {
		assert contact != null:"contact null";
		
		OfficialImpl officialImpl = this.officialMap.remove(contact.getContactId());		
	}

	public Official getOfficial(Contact contact) {
		assert contact != null:"contact null";
		
		OfficialImpl officialImpl = getOfficialImpl(contact.getContactId());
		
	
		return officialImpl;
		
	}
	private OfficialImpl getOfficialImpl(Integer contactId) {
		assert contactId >= 0:"contactId negative " + contactId;
		
		return this.officialMap.get(contactId);
	}
	
	private void putOfficialImpl(OfficialImpl officialImpl) {
		
		this.officialMap.put(officialImpl.getContact().getContactId(), officialImpl);
	}
	
	Collection<OfficialImpl> getOfficialImplCollection() {
		
		return officialMap.values();
	}
	
	public List<Official> getOfficialList() {
		
		List<Official> officialList = new ArrayList<Official>(getOfficialImplCollection());
		return officialList;
	}

}
