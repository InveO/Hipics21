package jet.hipics21.business.event;

import java.util.GregorianCalendar;
import java.util.List;

import jet.hipics21.business.address.Address;
import jet.hipics21.business.competition.Competition;
import jet.hipics21.business.contact.Contact;
import jet.hipics21.business.official.Official;
import jet.hipics21.business.rules.RULES;

public interface Event {
	
	public void addCompetition(Competition competition);
	public void removeCompetition(Competition competition);
	public List<Competition> getCompetitionList();
	public <T extends Competition> List<T> getCompetitionList(Class<T> competitionType);
	public RULES getDefaultRules();
	
	public String getEntryInformations();
	public String getHomepage();
	public String getName1();
	public String getName2();
	public String getPaymentInformations();
	public String getRemarks1();
	public String getRemarks2();
	
	public int getEventId();

	public Contact getOrganizer();
	public Contact getSecretary();
	public Address getEntryAddress();
	public Address getEventLocation1();
	public Address getEventLocation2();
	public GregorianCalendar getStartDate();
	public GregorianCalendar getEndDate();
	public GregorianCalendar getEntryDate();
	public Official getDoctor();
	public Official getVeterinary();
	
	public void setDefaultRules(RULES defaultRules);
	public void setDoctor(Official doctor);
	public void setEndDate(GregorianCalendar endDate);
	public void setEntryAddress(Address entryAddress);
	public void setEntryDate(GregorianCalendar entryDate);
	public void setEntryInformations(String entryInformations);
	public void setEventLocation1(Address eventLocation1);
	public void setEventLocation2(Address eventLocation2);
	public void setHomepage(String homepage);
	public void setName1(String name1);
	public void setName2(String name2);
	public void setOrganizer(Contact organizer);
	public void setPaymentInformations(String paymentInformations);
	public void setRemarks1(String remarks1);
	public void setRemarks2(String remarks2);
	public void setSecretary(Contact secretary);
	public void setStartDate(GregorianCalendar startDate);
	public void setVeterinary(Official veterinary);

}
