package jet.hipics21.business.address;

import static org.junit.Assert.*;
import jet.hipics21.business.contact.ContactTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class AddressTest {

	private Address address = null;
	
	public static void main(String[] args) {
		junit.swingui.TestRunner.run(AddressTest.class);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		address = new Address();
	}

	@After
	public void tearDown() throws Exception {
		address = null;
	}

	@Test
	public void test() {

		address.setCountry("suisse");
		assertEquals("suisse", address.getCountry());
		address.setCounty("Vaud");
		assertEquals("Vaud", address.getCounty());
		address.setLine1("Ch. du Chapitre");
		assertEquals("Ch. du Chapitre", address.getLine1());
		address.setLine2("c/o Griffiths");
		assertEquals("c/o Griffiths", address.getLine2());
		address.setLine3("line3");
		assertEquals("line3", address.getLine3());
		address.setPostNumber("1026");
		assertEquals("1026", address.getPostNumber());
		address.setTown("Echandens");
		assertEquals("Echandens", address.getTown());
	}

}
