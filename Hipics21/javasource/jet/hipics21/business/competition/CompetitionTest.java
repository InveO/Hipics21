package jet.hipics21.business.competition;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import jet.hipics21.business.competition.dressage.DressageCompetition;
import jet.hipics21.business.contact.ContactManager;
import jet.hipics21.business.event.Event;
import jet.hipics21.business.event.EventManager;
import jet.hipics21.business.event.EventTest;
import jet.hipics21.business.official.OfficialManager;
import jet.hipics21.business.rules.disciplines.DISCIPLINES;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;




public class CompetitionTest {
	private Competition competition = null;
	private CompetitionManager competitionManager;
	private EventManager eventManager;

	public static void main(String[] args) {
		junit.swingui.TestRunner.run(CompetitionTest.class);
	}

	@Before
	public void setUp() throws Exception {
		this.competitionManager = CompetitionManager.getCompetitionManager();
		this.eventManager = EventManager.getEventManager();
	}

	@After
	public void tearDown() throws Exception {
		this.competition = null;
	}

	@Test
	public void test1() {		
		assertNotNull(competitionManager);
		
		// teste le create 

		Event event = eventManager.createEvent("CD Monnaz", "Ferme du château");
				
		this.competition = this.competitionManager.createCompetition(DressageCompetition.class, "1", "FB03", event);
		assertNotNull(this.competition);
		this.competition = this.competitionManager.createCompetition(DressageCompetition.class, "2", "FB05", event);
		assertNotNull(this.competition);
		this.competition = this.competitionManager.createCompetition(DressageCompetition.class, "3", "L11", event);
		assertNotNull(this.competition);
		
		this.competitionManager.listCompetition();
	}

	@Test 
	public void test2() {		
		// teste le getCompetition by name
		assertTrue(!competitionManager.getCompetitionByName("1", "FB03").isEmpty());
		
		 // teste le getCompetition
		assertNotNull(competitionManager.getCompetition(0));
		
	}
	@Test 
	public void test3() {		
		this.competition = competitionManager.getCompetition(0);
		
		// teste les set
		
		competition.setCompetitionMode(COMPETITION_MODE.OFFICIAL);
		assertEquals(COMPETITION_MODE.OFFICIAL, competition.getCompetitionMode());
		competition.setCoupleMaxPoints(800);
		assertEquals(800, competition.getCoupleMaxPoints());
		competition.setCoupleMinPoints(200);
		assertEquals(200, competition.getCoupleMinPoints());
		GregorianCalendar endDate = new GregorianCalendar(2012, 04, 15);
		competition.setEndDate(endDate);
		assertEquals(endDate, competition.getEndDate());
		competition.setEntryCost(new BigDecimal("45.00"));
		assertEquals(new BigDecimal("45.00"), competition.getEntryCost());
		competition.setEntryDeposit(new BigDecimal("50.00"));
		assertEquals(new BigDecimal("50.00"), competition.getEntryDeposit());
		competition.setHorseMaxAge(5);
		assertEquals(5, competition.getHorseMaxAge());
		competition.setHorseMaxPoints(200);
		assertEquals(200, competition.getHorseMaxPoints());
		competition.setHorseMinAge(4);
		assertEquals(4, competition.getHorseMinAge());
		competition.setHorseMinPoints(100);
		assertEquals(100, competition.getHorseMinPoints());
		competition.setMaxParticipant(35);
		assertEquals(35, competition.getMaxParticipant());
		competition.setMaxWinnings(new BigDecimal("100.00"));
		assertEquals(new BigDecimal("100.00"), competition.getMaxWinnings());
		competition.setMinWinnings(new BigDecimal("50.00"));
		assertEquals(new BigDecimal("50.00"), competition.getMinWinnings());
		competition.setName1("Prix du Château");
		assertEquals("Prix du Château", competition.getName1());
		competition.setName2("Sponsorisé par la famille Rochat");
		assertEquals("Sponsorisé par la famille Rochat", competition.getName2());
		competition.setName3("Nouveau carré");
		assertEquals("Nouveau carré", competition.getName3());
		competition.setNumberOfEliminated(2);
		assertEquals(2, competition.getNumberOfEliminated());
		competition.setNumberOfEntered(30);
		assertEquals(30, competition.getNumberOfEntered());
		competition.setNumberOfPlaced(9);
		assertEquals(9, competition.getNumberOfPlaced());
		competition.setRemark1("remarque 1");
		assertEquals("remarque 1", competition.getRemark1());
		competition.setRemark2("remarque 2");
		assertEquals("remarque 2", competition.getRemark2());
		competition.setRiderMaxAge(99);
		assertEquals(99, competition.getRiderMaxAge());
		competition.setRiderMaxPoints(1000);
		assertEquals(1000, competition.getRiderMaxPoints());
		competition.setRiderMinAge(12);
		assertEquals(12, competition.getRiderMinAge());
		competition.setRiderMinPoints(0);
		assertEquals(0, competition.getRiderMinPoints());
		competition.setStartDate(endDate);
		assertEquals(endDate, competition.getStartDate());
				
	}
	
	@Test (expected= IllegalStateException.class)
	public void test4() {		
				
		// teste le remove
		competition = competitionManager.getCompetition(0);
		assertNotNull(competition);
		competitionManager.removeCompetition(0);
		assertNull(competitionManager.getCompetition(competition.getCompetitionId()));
		
		// pour tester le illegalStateException lancé par competitionImmpl - getName1
		competition.getName1();
		
		competitionManager.listCompetition();
		
	}
}
