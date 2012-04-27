package jet.hipics21.business.event;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

import jet.hipics21.business.address.Address;
import jet.hipics21.business.competition.Competition;
import jet.hipics21.business.contact.Contact;
import jet.hipics21.business.official.Official;
import jet.hipics21.business.official.OfficialManager;
import jet.hipics21.business.rules.RULES;



public class EventImpl implements Event {
	private final int eventId;
	
	private List<Competition> competitionList = new ArrayList<Competition>();
	
	private String name1;
	private String name2;
	private String homepage;
	private String entryInformations;
	private String paymentInformations;
	private String remarks1;
	private String remarks2;
	
	private Address eventLocation1;
	private Address eventLocation2;
	private Address entryAddress;
	
	private Contact organizer;
	private Contact secretary;
	private Official veterinary;
	private Official doctor;
	private RULES defaultRules;
	
	
	GregorianCalendar entryDate;
	GregorianCalendar startDate;
	GregorianCalendar endDate;
	
	
	private OfficialManager officials;
	
	private boolean valid;
	
	public EventImpl(int eventId) {
		this.eventId = eventId;
		this.valid = true;
		
	}
	
	public void setInvalid() {
		this.valid = false;
	}
	

	@Override
	public void addCompetition(Competition competition) {
		assert competition!= null:"competition null";
		
		this.competitionList.add(competition);
		
	}

	@Override
	public void removeCompetition(Competition competition) {
		assert competition!= null:"competition null";
		
		boolean removed = this.competitionList.remove(competition);
		if (removed == false) {
			throw new IllegalStateException("Competition not in list " + competition);
		}
		
		
	}

	@Override
	public List<Competition> getCompetitionList() {

		return Collections.unmodifiableList(this.competitionList);
	}

	@Override
	public <T extends Competition> List<T> getCompetitionList(Class<T> competitionType) {
		assert competitionType != null : "Competition null";
		
		List<T> resultList = new ArrayList<T>();
		
		for (Competition competition:this.competitionList) {
			if (competitionType == competition.getClass()) {
				T tCompetition = competitionType.cast(competition);
				resultList.add(tCompetition);
			}
		}
 		return Collections.unmodifiableList(resultList);
	}

	public RULES getDefaultRules() {
		return this.defaultRules;
	}
	
	public Official getDoctor() {
		return this.doctor;
	}
	public GregorianCalendar getEndDate() {
		return this.endDate;
	}
	public Address getEntryAddress() {
		return this.entryAddress;
	}
	public GregorianCalendar getEntryDate() {
		return this.entryDate;
	}
	public String getEntryInformations() {
		return this.entryInformations;
	}
	public int getEventId() {
		return this.eventId;
	}
	public Address getEventLocation1() {
		return this.eventLocation1;
	}
	public Address getEventLocation2() {
		return this.eventLocation2;
	}
	
	public String getHomepage() {
		return this.homepage;
	}
	
	public String getName1() {
		if (this.valid == false) {
			throw new IllegalStateException("EventImpl " + this.getEventId() + " " + this.name1 + " " + this.name2 + " is invalid");
		}
		return this.name1;
	}
	
	public String getName2() {
		return this.name2;
	}
	
	public OfficialManager getOfficials() {
		return this.officials;
	}
	
	public Contact getOrganizer() {
		return this.organizer;
	}
	
	public String getPaymentInformations() {
		return this.paymentInformations;
	}
	
	public String getRemarks1() {
		return this.remarks1;
	}
	
	public String getRemarks2() {
		return this.remarks2;
	}
	
	public Contact getSecretary() {
		return this.secretary;
	}
	
	public GregorianCalendar getStartDate() {
		return this.startDate;
	}
	
	public Official getVeterinary() {
		return this.veterinary;
	}
	
	public void setDefaultRules(RULES defaultRules) {
		this.defaultRules = defaultRules;
	}
	
	public void setDoctor(Official doctor) {
		this.doctor = doctor;
	}
	
	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}
	
	public void setEntryAddress(Address entryAddress) {
		this.entryAddress = entryAddress;
	}
	
	public void setEntryDate(GregorianCalendar entryDate) {
		this.entryDate = entryDate;
	}
	
	public void setEntryInformations(String entryInformations) {
		this.entryInformations = entryInformations;
	}
	
	public void setEventLocation1(Address eventLocation1) {
		this.eventLocation1 = eventLocation1;
	}
	
	public void setEventLocation2(Address eventLocation2) {
		this.eventLocation2 = eventLocation2;
	}
	
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	
	public void setName1(String name1) {
		this.name1 = name1;
	}
	
	public void setName2(String name2) {
		this.name2 = name2;
	}
	
	public void setOfficials(OfficialManager officials) {
		this.officials = officials;
	}
	
	public void setOrganizer(Contact organizer) {
		this.organizer = organizer;
	}
	
	public void setPaymentInformations(String paymentInformations) {
		this.paymentInformations = paymentInformations;
	}
	
	public void setRemarks1(String remarks1) {
		this.remarks1 = remarks1;
	}
	
	public void setRemarks2(String remarks2) {
		this.remarks2 = remarks2;
	}
	
	public void setSecretary(Contact secretary) {
		this.secretary = secretary;
	}

	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}
	
	public void setVeterinary(Official veterinary) {
		this.veterinary = veterinary;
	}
	
	public boolean equals(Object other) {
		
		if (other == null) {
			return false;
		} else if (other == this) {
			return true;
		} else if (!(other instanceof Event)) {
			return false;
		} else {
			
			Event event = (Event) other;
			if (event.getEventId() == getEventId()) {
				return true;
			}
			return false;
		}
	}
	
	public int hashCode() {
		return getEventId();
	}
	
	public String toString() {
		
		return getName1() + " " + getName2() + " " + getEventLocation1();
	}

	private static class EventByNameComparator implements Comparator<Event> {

		@Override
		public int compare(Event event1, Event event2) {
			if (event1 == null) {
				throw new NullPointerException("Event<event1 is null");
			}
			
			if (event2 == null) {
				throw new NullPointerException("Event");
			}
			
			return event1.getName1().compareTo(event2.getName1());
		} 
	}
	private static class EventByLocationComparator implements Comparator<Event> {

		@Override
		public int compare(Event event1, Event event2) {
			if (event1 == null) {
				throw new NullPointerException("Event<event1 is null");
			}
			
			if (event2 == null) {
				throw new NullPointerException("Event");
			}
			
			return event1.getEventLocation1().getTown().compareTo(event2.getEventLocation1().getTown());
		} 
	}
	private static class EventByDateComparator implements Comparator<Event> {

		@Override
		public int compare(Event event1, Event event2) {
			if (event1 == null) {
				throw new NullPointerException("Event<event1 is null");
			}
			
			if (event2 == null) {
				throw new NullPointerException("Event");
			}
			
			return event1.getStartDate().compareTo(event2.getStartDate());
		} 
	}

}
