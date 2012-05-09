package jet.hipics21.business.official;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.GregorianCalendar;

import jet.hipics21.business.contact.Contact;
import jet.hipics21.business.contact.ContactManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OfficialTest {

	private Official official = null;
	private Contact contact = null;
	private OfficialManager officialManager;
	private ContactManager contactManager;
	
	public OfficialTest() {
	}
	public static void main(String[] args) {
		junit.swingui.TestRunner.run(OfficialTest.class);
		
	}
	
@Before
 	public void setUp() throws Exception {
		this.officialManager = OfficialManager.getOfficialManager();
		this.contactManager = ContactManager.getContactManager();
		this.contact = this.contactManager.createContact("Jules", "Tartempion");
		this.official = this.officialManager.createOfficial(this.contact);
		this.contact = this.contactManager.createContact("Geneviève", "Rochat");
		this.official = this.officialManager.createOfficial(contact);
	}

	@After
	public void tearDown() throws Exception {
		official = null;
	}

	@Test
	public void test1() {
		assertNotNull(officialManager);
		
		// test le create du official. D'abord, créer un contact
		assertNotNull(contactManager);
		assertNotNull(this.contact);
		
		// teste le create du official
		assertNotNull(this.official);
		System.out.println("nombre d'officiels dans la liste : " + this.officialManager.getOfficialList().size());
		System.out.println("Liste des officiels :" + this.officialManager.getOfficialList());

		assertEquals(this.officialManager.getOfficialList().size(), 3);
		
	}
		
	@Test
	public void test2() {
		assertNotNull(this.contact);
		// Test du getOfficial		
		this.official = officialManager.getOfficial(contact);
	//	System.out.println("Officiel: " + this.official.getContact().getName1() + " " + this.official.getContact().getName2());
		
	}

	@Test
	public void test3() {
		assertNotNull(this.official);
		// Test les set sur l'officiel
		official.setOfficialFunction(OFFICIAL_FUNCTION.JUGE_INTERNA_FEI_DRESSAGE);
		assertEquals(OFFICIAL_FUNCTION.JUGE_INTERNA_FEI_DRESSAGE, this.official.getOfficialFunction());
		GregorianCalendar dateValidity = new GregorianCalendar(2000, 01, 01);
		official.setValidFrom(dateValidity);
		assertEquals(dateValidity, official.getValidFrom());		
		dateValidity = new GregorianCalendar(2020, 12, 31);
		official.setValidTo(dateValidity);
		assertEquals(dateValidity, this.official.getValidTo());
		
	}
	
	@Test
	public void test4() {
		// test le removeOfficial
		this.contact = this.contactManager.getContact(0);
		assertNotNull(this.contact);
		this.officialManager.removeOfficial(contact);
		assertNull(this.officialManager.getOfficial(contact));
		
	//	System.out.println("Liste des officiels" + officialManager.getOfficialList());

	}

}
