package jet.hipics21.business.entry;

import jet.hipics21.business.competition.Competition;
import jet.hipics21.business.event.HorseRiderCouple;
import jet.hipics21.business.results.Results;
import jet.hipics21.business.rules.disciplines.DISCIPLINES;

public class EntryResults <T extends DISCIPLINES> {
	
	private HorseRiderCouple horseRiderCouple;
	private Competition competition;
	private Entry entry;
	private Results results;
	
	EntryResults (HorseRiderCouple horseRiderCouple, Competition competition) {
		assert horseRiderCouple != null:"horseRiderCouple null";
		
		this.horseRiderCouple = horseRiderCouple;
		this.competition = competition;
	}

	public Competition getCompetition() {

		return this.competition;		
		
	}
	
	public HorseRiderCouple getHorseRiderCouple() {
		
		return this.horseRiderCouple;
	}


}
