package jet.hipics21.business.entry;

import jet.hipics21.business.competition.Competition;
import jet.hipics21.business.event.HorseRiderCouple;


public class EntryResultsManager {
	
	public EntryResults create (HorseRiderCouple horseRiderCouple, Competition competition) {		
		assert horseRiderCouple != null:"horseRiderCouple null";
		assert competition != null:"competition null";
		
		EntryResults entryResults = new EntryResults(horseRiderCouple, competition);
		
		horseRiderCouple.addEntryResults(entryResults);
		competition.addEntryResults(entryResults);
		
		return entryResults;
		
		
	}
	
	public void remove (EntryResults entryResults) {
		assert entryResults != null:"entryResults null";
		
		entryResults.getCompetition().removeEntryResults(entryResults);
		entryResults.getHorseRiderCouple().removeEntryResults(entryResults);
		
		
	}

}
