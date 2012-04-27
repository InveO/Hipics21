package jet.hipics21.business.horse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jet.hipics21.business.contact.Contact;
import jet.hipics21.business.contact.ContactManager;

public class HorseBreederManager {
	
	private static final HorseBreederManager horseBreederManager = new HorseBreederManager();
	private static final ContactManager contactManager = ContactManager.getContactManager();
	
	private Map<Integer, HorseBreederImpl> horseBreederMap = new HashMap<Integer, HorseBreederImpl>();
	
	public static HorseBreederManager getHorseBreederImplManager() {
		return horseBreederManager;
	}
	
	private HorseBreederManager() {
		
	}
	
	public HorseBreeder createHorseBreeder(Contact contact) {
		assert contact != null:"contact null";
		
		HorseBreederImpl preExistingHorseBreederImpl = getHorseBreederImpl(contact.getContactId());
		
		if (preExistingHorseBreederImpl != null) {
			throw new IllegalStateException("horseBreederImpl already exists " + preExistingHorseBreederImpl);
		}
		
		HorseBreederImpl horseBreederImpl = new HorseBreederImpl(contact);
		putHorseBreederImpl(horseBreederImpl);
		
		return horseBreederImpl;
		
	}

	public void removeHorseBreeder(Contact contact) {
		assert contact != null:"contact null";
		
		HorseBreederImpl horseBreederImpl = this.horseBreederMap.remove(contact.getContactId());		
	}

	public HorseBreeder getHorseBreeder(Contact contact) {
		assert contact != null:"contact null";
		
		HorseBreederImpl horseBreederImpl = getHorseBreederImpl(contact.getContactId());
		
	
		return horseBreederImpl;
		
	}
	private HorseBreederImpl getHorseBreederImpl(Integer contactId) {
		assert contactId >= 0:"contactId negative " + contactId;
		
		return this.horseBreederMap.get(contactId);
	}
	
	private void putHorseBreederImpl(HorseBreederImpl horseBreederImpl) {
		
		this.horseBreederMap.put(horseBreederImpl.getContact().getContactId(), horseBreederImpl);
	}
	
	Collection<HorseBreederImpl> getHorseBreederImplCollection() {
		
		return horseBreederMap.values();
	}
	
	public List<HorseBreeder> getHorseBreederList() {
		
		List<HorseBreeder> horseBreederList = new ArrayList<HorseBreeder>(getHorseBreederImplCollection());
		return horseBreederList;
	}

}
