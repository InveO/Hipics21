package jet.hipics21.business.rider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.GregorianCalendar;

import jet.hipics21.business.contact.Contact;
import jet.hipics21.business.contact.ContactManager;
import jet.hipics21.business.licence.LICENCE_CATEGORY;
import jet.hipics21.business.licence.LICENCE_CODE;
import jet.hipics21.business.licence.LICENCE_DISCIPLIN;
import jet.hipics21.business.licence.RiderLicence;
import jet.hipics21.business.licence.LICENCE_STATUS;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RiderTest {

	private Rider rider = null;
	private Contact contact = null;
	private RiderManager riderManager;
	private ContactManager contactManager;
	
	public RiderTest() {
	}
	public static void main(String[] args) {
		junit.swingui.TestRunner.run(RiderTest.class);
		
	}
	
@Before
 	public void setUp() throws Exception {
		this.riderManager = RiderManager.getRiderManager();
		this.contactManager = ContactManager.getContactManager();
	}

	@After
	public void tearDown() throws Exception {
		rider = null;
	}

	@Test
	public void test1() {
		assertNotNull(riderManager);
		
		// test le create du Rider. D'abord, créer un contact
		assertNotNull(contactManager);
		
		this.contact = this.contactManager.createContact("Jules", "Tartempion");
		assertNotNull(this.contact);
		this.rider = this.riderManager.createRider(this.contact);  
		// teste le create du rider
		assertNotNull(this.rider);
		assertNotNull(this.contact);
		
		GregorianCalendar examDate = new GregorianCalendar(1998, 8, 6);
		GregorianCalendar validFrom = new GregorianCalendar(2001, 6, 13);
		GregorianCalendar validTo = new GregorianCalendar(2012,12,31);
		RiderLicence riderLicence = new RiderLicence(LICENCE_DISCIPLIN.DRESSAGE, LICENCE_CATEGORY.AMATOR, LICENCE_CODE.CH_DN, 
				LICENCE_STATUS.ACTIVE, "Lausanne", 
				"333", examDate, validFrom, validTo);
		this.rider.addLicence(riderLicence);

		this.contact = this.contactManager.createContact("Willi", "Melliger");
		this.rider = this.riderManager.createRider(this.contact);  
		examDate = new GregorianCalendar(1998, 8, 6);
		validFrom = new GregorianCalendar(2001, 6, 13);
		validTo = new GregorianCalendar(2012,12,31);
		riderLicence = new RiderLicence(LICENCE_DISCIPLIN.DRESSAGE, LICENCE_CATEGORY.AMATOR, LICENCE_CODE.CH_DN,  
				LICENCE_STATUS.ACTIVE, "Lausanne", 
				"222", examDate, validFrom, validTo);
		this.rider.addLicence(riderLicence);

		this.contact = this.contactManager.createContact("Francine", "Weigle");
		this.rider = this.riderManager.createRider(this.contact);  
		examDate = new GregorianCalendar(1998, 8, 6);
		validFrom = new GregorianCalendar(2001, 6, 13);
		validTo = new GregorianCalendar(2012,12,31);
		riderLicence = new RiderLicence(LICENCE_DISCIPLIN.DRESSAGE, LICENCE_CATEGORY.AMATOR, LICENCE_CODE.CH_DN,  
				LICENCE_STATUS.ACTIVE, "St-Sulpice", 
				"111", examDate, validFrom, validTo);
		this.rider.addLicence(riderLicence);

		this.contact = this.contactManager.createContact("Céline", "Michaud");
		this.rider = this.riderManager.createRider(this.contact);  
		examDate = new GregorianCalendar(1998, 8, 6);
		validFrom = new GregorianCalendar(2001, 6, 13);
		validTo = new GregorianCalendar(2012,12,31);
		riderLicence = new RiderLicence(LICENCE_DISCIPLIN.DRESSAGE, LICENCE_CATEGORY.AMATOR, LICENCE_CODE.CH_DN,  
				LICENCE_STATUS.ACTIVE, "Fey", 
				"9000", examDate, validFrom, validTo);
		this.rider.addLicence(riderLicence);

		assertEquals(this.riderManager.getRiderList().size(), 4);
		
	}

	@Test
	public void test2() {
		this.contact = this.contactManager.getContact(0);
		assertNotNull(this.contact);
		// Test du getRider		
		
		this.rider = riderManager.getRider(contact);
		
		System.out.println(this.riderManager.getRiderList());
		
	}
	@Test 
	public void test3() {		
		
		// teste les sort: trié par code de licence
		System.out.println("rider trié par code licence : " + riderManager.getRiderListSortedByLicenceNumber(LICENCE_CODE.CH_DN));
		// teste les sort: trié par nom
		System.out.println("rider trié par nom : " + riderManager.getSortedRiderList());
		
	}

	@Test
	public void test4() {
		// test le removeRider
		this.contact = this.contactManager.getContact(0);
		assertNotNull(this.contact);
		this.riderManager.removeRider(contact);
		assertNull(this.riderManager.getRider(contact));


	}
}
