package jet.hipics21.business.contact;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ContactTest {
	
	private Contact contact = null;
	private ContactManager contactManager;

	public static void main(String[] args) {
		junit.swingui.TestRunner.run(ContactTest.class);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.contactManager = ContactManager.getContactManager();
	}

	@After
	public void tearDown() throws Exception {
		this.contact = null;
	}

	@Test 
	public void test1() {		
		assertNotNull(contactManager);
		
		// teste le create 
		this.contact = this.contactManager.createContact("Florence", "Griffiths");
		assertNotNull(this.contact);
		this.contact = this.contactManager.createContact("Ian", "Griffiths");
		assertNotNull(this.contact);
		this.contact = this.contactManager.createContact("Simon", "Griffiths");
		assertNotNull(this.contact);
		this.contact = this.contactManager.createContact("Fred", "Griffiths");
		assertNotNull(this.contact);
		this.contact = this.contactManager.createContact("Joyce", "Griffiths");
		assertNotNull(this.contact);
		this.contact = this.contactManager.createContact("Simon", "Griffiths");
		assertNotNull(this.contact);
		this.contact = this.contactManager.createContact("Simon", "Griffiths");
		assertNotNull(this.contact);
		this.contact = this.contactManager.createContact("Simon", "Griffiths");
		assertNotNull(this.contact);
		this.contact = this.contactManager.createContact("Ian", "Griffiths");
		assertNotNull(this.contact);
		
		this.contactManager.listContact();
	}
	@Test 
	public void test2() {		
		// teste le getContact by name
		assertTrue(contactManager.getContactByName("Toto", "Titi").isEmpty());
		
		 // teste le getContact
		assertNotNull(contactManager.getContact(1));
		
	}
	@Test 
	public void test3() {		
		contact = contactManager.getContact(0);
		
		// teste les set
		contact.setName1("Marianne");
		assertEquals("Marianne", contact.getName1());
		contact.setName2("Krebs");
		assertEquals("Krebs", contact.getName2());
		contact.setName3("Gonin");
		assertEquals("Gonin", contact.getName3());
		
		ContactType contactType = null;
		contact.setContactType(contactType);
		assertEquals(null, contact.getContactType());
		
		GregorianCalendar dateOfBirth = new GregorianCalendar(1960, 7, 13);
		contact.setDateOfBirth(dateOfBirth);
		assertEquals(dateOfBirth, contact.getDateOfBirth());
		DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
		String dateString = dateFormat.format(contact.getDateOfBirth().getTime());
		System.out.println("date = " + dateString);
		
		contact.setFaxOffice("fax office");
		assertEquals("fax office", contact.getFaxOffice());
		contact.setFaxPrivate("fax private");
		assertEquals("fax private", contact.getFaxPrivate());
		Locale l = new Locale("fr");
		contact.setLanguage(l);
		assertEquals(l, contact.getLanguage());
		contact.setMailOffice("mail office");
		assertEquals("mail office", contact.getMailOffice());
		contact.setMailPrivate("mail private");
		assertEquals("mail private", contact.getMailPrivate());
		contact.setTelMobile("tel mobile");
		assertEquals("tel mobile", contact.getTelMobile());
		contact.setTelOffice("tel office");
		assertEquals("tel office", contact.getTelOffice());
		contact.setTelPrivate("tel private");
		assertEquals("tel private", contact.getTelPrivate());
	}
	@Test (expected= IllegalStateException.class)
	public void test4() {		
				
		// teste le remove
		contact = contactManager.getContact(1);
		assertNotNull(contact);
		contactManager.removeContact(contact.getContactId());
		assertNull(contactManager.getContact(contact.getContactId()));
		contact.getName1();
		
		
		contactManager.listContact();
		
	}

}
