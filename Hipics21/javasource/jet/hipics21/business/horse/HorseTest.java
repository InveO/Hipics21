package jet.hipics21.business.horse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HorseTest {

	private Horse horse = null;
	private HorseManager horseManager = null;
	
	public static void main(String[] args) {
		junit.swingui.TestRunner.run(HorseTest.class);
	}
	
	@Before
	public void setUp() throws Exception {
		this.horseManager = HorseManager.getHorseManager();
	}

	@After
	public void tearDown() throws Exception {
		this.horse = null;
	}

	@Test
	public void test1() {
		assertNotNull(horseManager);
		
		// teste le create 
		this.horse = this.horseManager.createHorse("Mandy de Milavy CH");
		assertNotNull(this.horse);
		this.horse = this.horseManager.createHorse("Aladin CH");
		assertNotNull(this.horse);
		this.horse = this.horseManager.createHorse("Top des Chaînes");
		assertNotNull(horse);
		
		this.horseManager.listHorse();
	}
	
	@Test 
	public void test2() {		
		// teste le getHorse by name
		assertFalse(horseManager.getHorseByName("Aladin CH").isEmpty());
		// teste le getHorse
		assertNotNull(horseManager.getHorse(1));
		
	}

	@Test 
	public void test3() {		
		horse = horseManager.getHorse(0);
		
		// teste les set
		horse.setBreed("CH");
		assertEquals("CH", horse.getBreed());
		horse.setBreedCertificateNo("CH-123-1996");
		assertEquals("CH-123-1996", horse.getBreedCertificateNo());
		horse.setColor(HorseColor.BAY);
		assertEquals(HorseColor.BAY, horse.getColor());
		horse.setCountryOfBirth("Suisse");
		assertEquals("Suisse", horse.getCountryOfBirth());
		Horse horseDam = horseManager.createHorse("Ida");
		horse.setDam(horseDam);
		assertEquals(horseDam.getName(), horse.getDam().getName());
		Horse horseDamSire = horseManager.createHorse("Wendekreis");
		horse.setDamSire(horseDamSire);
		assertEquals(horseDamSire.getName(), horse.getDamSire().getName());
		GregorianCalendar dateOfBirth = new GregorianCalendar(1996, 6, 13);
		horse.setDateOfBirth(dateOfBirth);
		assertEquals(dateOfBirth, horse.getDateOfBirth());
		horse.setHorseStatus(HorseStatus.ACTIVE);
		assertEquals(HorseStatus.ACTIVE, horse.getHorseStatus());
		horse.setName("Mandy de Milavy CH");
		assertEquals("Mandy de Milavy CH", horse.getName());
		horse.setOldName("Mémére");
		assertEquals("Mémére", horse.getOldName());
		horse.setPassportNumFEI("--");
		assertEquals("--", horse.getPassportNumFEI());
		horse.setPassportNumFSSE("99111");
		assertEquals("99111", horse.getPassportNumFSSE());
		horse.setPoints(BigDecimal.valueOf(123));
		assertEquals(BigDecimal.valueOf(123), horse.getPoints());
		horse.setSex(HorseSex.MARE);
		assertEquals(HorseSex.MARE, horse.getSex());
		Horse horseSire = horseManager.createHorse("Maarten");
		horse.setSire(horseSire);
		assertEquals(horseSire, horse.getSire());
		horse.setWinnings(BigDecimal.valueOf(0));
		assertEquals(BigDecimal.valueOf(0), horse.getWinnings());		
		
	}
	
	@Test 
	public void test4() {		
		
		// teste les sort: trié par nom
		System.out.println("HorseList triée : " + horseManager.getSortedHorseList());
		
		// teste les sort: trié par père
		horse = horseManager.getHorse(1);
		Horse horseSire = horseManager.createHorse("Adonis");
		horse.setSire(horseSire);
		horse = horseManager.getHorse(2);
		horseSire = horseManager.createHorse("Huit de Coeur");
		horse.setSire(horseSire);
		System.out.println("HorseList triée par étalon : " + horseManager.getHorseListSortedBySire());
	}
	
	@Test (expected= IllegalStateException.class)
	public void test5() {		
				
		// teste le remove
		horse = horseManager.getHorse(1);
		assertNotNull(horse);
		horseManager.removeHorse(horse.getHorseId());		
		assertNull(horseManager.getHorse(horse.getHorseId()));
		horseManager.listHorse();

		horse.getName();
				
			}

}
