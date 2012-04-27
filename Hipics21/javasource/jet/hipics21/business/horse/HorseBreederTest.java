package jet.hipics21.business.horse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import jet.hipics21.business.contact.Contact;
import jet.hipics21.business.contact.ContactManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HorseBreederTest {

	private HorseBreeder horseBreeder = null;
	private Contact contact = null;
	private HorseBreederManager horseBreederManager;
	private ContactManager contactManager;
	
	public HorseBreederTest() {
	}
	public static void main(String[] args) {
		junit.swingui.TestRunner.run(HorseBreederTest.class);
		
	}
	
@Before
 	public void setUp() throws Exception {
		this.horseBreederManager = HorseBreederManager.getHorseBreederImplManager();
		this.contactManager = ContactManager.getContactManager();
		this.contact = this.contactManager.createContact("Jean-Jacques", "Fünfschilling");
		this.horseBreeder = this.horseBreederManager.createHorseBreeder(this.contact);  
		this.contact = this.contactManager.createContact("Pierre", "Saunier");
		this.horseBreeder = this.horseBreederManager.createHorseBreeder(this.contact);  
	}

	@After
	public void tearDown() throws Exception {
		horseBreeder = null;
	}

	@Test
	public void test1() {
		assertNotNull(horseBreederManager);
		
		// test le create du horseBreeder. D'abord, créer un contact
		assertNotNull(contactManager);
		assertNotNull(this.contact);
		
		// teste le create du horseBreeder
		assertNotNull(this.horseBreeder);
		
		assertEquals(this.horseBreederManager.getHorseBreederList().size(), 2);
		
		System.out.println(this.horseBreederManager.getHorseBreederList());
		
	}

	@Test
	public void test2() {
		assertNotNull(this.contact);
		// Test du getHorseBreeder		
		this.horseBreeder = horseBreederManager.getHorseBreeder(contact);
		
	}

	@Test
	public void test3() {
		
		this.contact = this.contactManager.getContact(0);
		assertNotNull(this.contact);
		
		// Test du getHorseBreeder		
		this.horseBreeder = horseBreederManager.getHorseBreeder(contact);
		
		// teste les set
		horseBreeder.setBreederNum("123");
		assertEquals("123", horseBreeder.getBreederNum());
		horseBreeder.setBreedingName("Elevage de Lully");
		assertEquals("Elevage de Lully", horseBreeder.getBreedingName());
		horseBreeder.setGroupBreeder("Syndicat fribourgeois");
		assertEquals("Syndicat fribourgeois", horseBreeder.getGroupBreeder());
		
		System.out.println(horseBreederManager.getHorseBreederList());		
		
	}

	@Test
	public void test4() {
		
 		// test le removeHorseBreeder
		this.contact = this.contactManager.getContact(1);
		assertNotNull(this.contact);
		this.horseBreederManager.removeHorseBreeder(contact);
		assertNull(this.horseBreederManager.getHorseBreeder(contact));

		
		System.out.println(horseBreederManager.getHorseBreederList());
		
	}

}
