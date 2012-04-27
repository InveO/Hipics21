package jet.hipics21.business.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.GregorianCalendar;

import jet.hipics21.business.address.Address;
import jet.hipics21.business.contact.Contact;
import jet.hipics21.business.contact.ContactManager;
import jet.hipics21.business.official.Official;
import jet.hipics21.business.official.OfficialManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EventTest {
	private Event event = null;
	private EventManager eventManager;
	private ContactManager contactManager;
	private OfficialManager officialManager;

	public static void main(String[] args) {
		junit.swingui.TestRunner.run(EventTest.class);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.eventManager = EventManager.getEventManager();
	}

	@After
	public void tearDown() throws Exception {
		this.event = null;
	}

	@Test 
	public void test1() {		
		assertNotNull(eventManager);
		
		// teste le create 

		this.event = this.eventManager.createEvent("Concours de dressage", "Monnaz");
		assertNotNull(this.event);
		
		this.eventManager.listEvent();
	}
	@Test 
	public void test2() {		
		// teste le getEvent by name
		assertTrue(eventManager.getEventByName("Concours de dressage", "Sullens").isEmpty());
		
		 // teste le getEvent
		assertNotNull(eventManager.getEvent(0));
		
	}
	@Test 
	public void test3() {		
		this.event = eventManager.getEvent(0);
		
		// teste les set
		
		this.contactManager = ContactManager.getContactManager();
		assertNotNull(this.contactManager);
		Contact contact = this.contactManager.createContact("Juillard", "Philippe");
		assertNotNull(contact);
		this.officialManager = OfficialManager.getOfficialManager();
		assertNotNull(this.officialManager);
		Official official = this.officialManager.createOfficial(contact);
		assertNotNull(official);
		this.event.setDoctor(official);
		assertEquals(this.event.getDoctor(), official);
		GregorianCalendar endDate = new GregorianCalendar(2012,04,15);
		this.event.setEndDate(endDate);
		assertEquals(endDate, this.event.getEndDate());
		Address address = new Address();
		address.setCountry("Suisse");
		address.setCounty("Vaud");
		address.setLine1("Hipics");
		address.setLine2("Av. de la Plage 37");
		address.setPostNumber("1028");
		address.setTown("Préverenges");
		this.event.setEntryAddress(address);
		assertEquals(address, this.event.getEntryAddress());
		GregorianCalendar entryDate = new GregorianCalendar(2012,03,20);
		this.event.setEntryDate(entryDate);
		assertEquals(entryDate, this.event.getEntryDate());
		this.event.setEntryInformations("Sur le site de la FNCH ou à Hipics");
		assertEquals("Sur le site de la FNCH ou à Hipics", this.event.getEntryInformations());
		Address eventLocation1 = new Address();
		eventLocation1.setLine1("Ferme du Château");
		eventLocation1.setTown("Monnaz");
		this.event.setEventLocation1(eventLocation1);
		assertEquals(eventLocation1, this.event.getEventLocation1());
		Address eventLocation2 = new Address();
		eventLocation2.setLine1("Paddock extérieur");
		this.event.setEventLocation2(eventLocation2);
		assertEquals(eventLocation2, this.event.getEventLocation2());
		this.event.setHomepage("www.hipics.com");
		assertEquals("www.hipics.com", this.event.getHomepage());
		this.event.setName1("Concours de Dressage");
		assertEquals("Concours de Dressage", this.event.getName1());
		this.event.setName2("Ferme du Château");
		assertEquals("Ferme du Château", this.event.getName2());
		Contact organizer = contactManager.createContact("Rochat", "Famille");		
		this.event.setOrganizer(organizer);
		assertEquals(organizer, this.event.getOrganizer());
		this.event.setPaymentInformations("CCP Rochat");
		assertEquals("CCP Rochat", this.event.getPaymentInformations());
		this.event.setRemarks1("Remarque 1");
		assertEquals("Remarque 1", this.event.getRemarks1());
		this.event.setRemarks2("Remarque 2");
		assertEquals("Remarque 2", this.event.getRemarks2());
		Contact secretary = contactManager.createContact("Hipics", "Griffiths");
		this.event.setSecretary(secretary);
		assertEquals(secretary, this.event.getSecretary());
		GregorianCalendar startDate = new GregorianCalendar(2012, 04, 14);
		this.event.setStartDate(startDate);
		assertEquals(startDate, this.event.getStartDate());
		Contact veto = contactManager.createContact("Dumauthioz", "Pierre");
		Official veterinary = new OfficialManager().createOfficial(veto);
		this.event.setVeterinary(veterinary);
		assertEquals(veterinary, this.event.getVeterinary());
		eventManager.listEvent();
	
	}
	@Test (expected= IllegalStateException.class)
	public void test4() {		
				
		// teste le remove
		event = eventManager.getEvent(0);
		assertNotNull(event);
		eventManager.removeEvent(0);
		assertNull(eventManager.getEvent(event.getEventId()));
		event.getName1();
		
		
		eventManager.listEvent();
		
	}

}
