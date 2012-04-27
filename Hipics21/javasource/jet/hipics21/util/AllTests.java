package jet.hipics21.util;

import jet.hipics21.business.address.AddressTest;
import jet.hipics21.business.competition.CompetitionTest;
import jet.hipics21.business.contact.ContactTest;
import jet.hipics21.business.event.EventTest;
import jet.hipics21.business.horse.HorseTest;
import jet.hipics21.business.official.JudgeTest;
import jet.hipics21.business.official.OfficialTest;
import jet.hipics21.business.rider.RiderTest;
import jet.hipics21.business.rules.dressage.DressageTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


	@RunWith(Suite.class)
	
	@Suite.SuiteClasses({
	    AddressTest.class,
	    CompetitionTest.class,
	    ContactTest.class,
	    DressageTest.class,
	    EventTest.class,
	    HorseTest.class,
	    JudgeTest.class,
	    OfficialTest.class,
	    RiderTest.class,
	   
	})

	public class AllTests {}


