package jet.hipics21.business.official;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import jet.hipics21.business.contact.Contact;
import jet.hipics21.business.contact.ContactManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JudgeTest {

	private Official official = null;
	private Judge judge = null;
	private Contact contact1 = null;
	private Contact contact2 = null;
	private OfficialManager officialManager;
	private JudgeManager judgeManager;
	private ContactManager contactManager;
	
	public JudgeTest() {
	}
	public static void main(String[] args) {
		junit.swingui.TestRunner.run(JudgeTest.class);
		
	}
	
	

	@Before
	public void setUp() throws Exception {
		this.officialManager = OfficialManager.getOfficialManager();
		assertNotNull(this.officialManager);
		this.judgeManager = JudgeManager.getJudgeManager();
		assertNotNull(this.judgeManager);
		this.contactManager = ContactManager.getContactManager();
		assertNotNull(this.contactManager);
		
		this.contact1 = this.contactManager.createContact("Ginette", "Chauvy");
		this.official = this.officialManager.createOfficial(contact1);
		this.judge = this.judgeManager.createJudge(this.official);
		this.contact2 = this.contactManager.createContact("Elisabeth", "Fischer");
		this.official = this.officialManager.createOfficial(contact2);
		this.judge = this.judgeManager.createJudge(this.official);
	}

	@After
	public void tearDown() throws Exception {
		assertNotNull(this.contact1);
		this.official = this.officialManager.getOfficial(contact1);
		assertNotNull(this.official);
		this.judgeManager.removeJudge(official);
		assertNull(this.judgeManager.getJudge(official));
		this.officialManager.removeOfficial(contact1);
		assertNull(this.officialManager.getOfficial(contact1));
		
		assertNotNull(this.contact2);
		this.official = this.officialManager.getOfficial(contact2);
		assertNotNull(this.official);
		this.judgeManager.removeJudge(official);
		assertNull(this.judgeManager.getJudge(official));
		this.officialManager.removeOfficial(contact2);
		assertNull(this.officialManager.getOfficial(contact2));
		
		System.out.println("nombre d'officiels dans la liste : " + this.officialManager.getOfficialList().size());
		System.out.println("Liste des juges" + judgeManager.getJudgeList());
		this.contact1 = null;
		this.contact2 = null;
		this.official = null;
		this.judge = null;
	}

	@Test
	public void test1() {
		
		// test le create du juge. D'abord, créer un contact, ensuite un officiel et enfin un juge
		assertNotNull(contactManager);
		assertNotNull(this.contact1);
		assertNotNull(officialManager);
		assertNotNull(this.official);
		
		// teste le create du juge
		assertNotNull(judgeManager);
		assertNotNull(this.judge);
		assertEquals(this.judgeManager.getJudgeList().size(), 2);
		
		System.out.println("Liste des juges :" + this.judgeManager.getJudgeList());

	}
		
	@Test
	public void test2() {
		assertNotNull(this.official);
		// Test du getJudge		
		this.judge = judgeManager.getJudge(this.official);
		System.out.println("Judge: " + this.judge.getOfficial().getContact().getName1() + " " +
		                               this.judge.getOfficial().getContact().getName2());
		
	}

	@Test
	public void test3() {
		assertNotNull(this.judge);
		
		// Test les set sur le juge

		this.judge.setJudgeQualification(JudgeQualification.DRESSAGE_L);
		assertTrue(this.judge.getJudgeQualification().contains(JudgeQualification.DRESSAGE_L));
		assertTrue(this.judge.isJudgeQualification(JudgeQualification.DRESSAGE_L));
		
	} 
	
	@Test
	public void test4() {
		// test le removeJudge
		System.out.println("nombre d'officiels dans la liste : " + this.officialManager.getOfficialList().size());
		assertNotNull(this.contact1);
		this.official = this.officialManager.getOfficial(contact1);
		assertNotNull(this.official);
		this.judgeManager.removeJudge(official);
		assertNull(this.judgeManager.getJudge(official));
		
		System.out.println("Liste des juges" + judgeManager.getJudgeList());

	}

}
