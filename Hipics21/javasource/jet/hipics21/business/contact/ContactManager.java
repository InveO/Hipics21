package jet.hipics21.business.contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ContactManager {
	
	private static final ContactManager contactManager = new ContactManager();
	
	private Map<Integer, ContactImpl> contactMap = new HashMap<Integer, ContactImpl>();
	private AtomicInteger lastContactId = new AtomicInteger();
	
	public static ContactManager getContactManager() {
		return contactManager;
	}
	
	private ContactManager() {
		// empty
	}
	
	private ContactImpl getContactImpl(int contactId) {
		assert contactId >= 0:"contactId negative " + contactId;
		
		return this.contactMap.get(contactId);
	}
	
	private void putContactImpl(ContactImpl contactImpl) {
		
		this.contactMap.put(contactImpl.getContactId(), contactImpl);
	}
	
	public Contact createContact(String name1, String name2) {
		assert name1 != null:"name1 null";
		assert name2 != null:"name2 null";
		
		ContactImpl contactImpl = new ContactImpl(this.lastContactId.getAndIncrement());
		contactImpl.setName1(name1);
		contactImpl.setName2(name2);
		
		ContactImpl preExistingContactImpl = getContactImpl(contactImpl.getContactId());
		
		if (preExistingContactImpl != null) {
			throw new IllegalStateException("contactImpl already exists " + preExistingContactImpl);
		}
		
		putContactImpl(contactImpl);
		
		return contactImpl;
		
	}

	public Contact getContact(int contactId) {
		assert contactId >= 0:"contactId negative " + contactId;
		
		ContactImpl contactImpl = getContactImpl(contactId);
			
		return contactImpl;
		
	}
	
	public List<Contact> getContactByName(String name1, String name2) {
		assert name1 != null || name2 != null:"name1 and name2 null";
		List<Contact> contactList = new ArrayList<Contact>();
		
		for (ContactImpl contactImpl : this.contactMap.values()) {
			if (name1 != null) {
				if (!contactImpl.getName1().equals(name1)) {
					continue;
				}
			}
			if (name2 != null) {
				if (!contactImpl.getName2().equals(name2)) {
					continue;
				}
			}
			contactList.add(contactImpl);
		}
		return contactList;
	}

	public void removeContact(int contactId) {
		assert contactId >= 0:"contactId negative " + contactId;
		
		ContactImpl contactImpl = this.contactMap.remove(contactId);
		contactImpl.setInvalid();
		
	}
	
	void listContact() {
		
		System.out.println(contactMap.values());
	}


}
