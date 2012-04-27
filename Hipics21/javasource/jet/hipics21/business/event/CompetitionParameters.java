package jet.hipics21.business.event;

import java.util.ArrayList;
import java.util.List;

import jet.hipics21.business.competition.Competition;
import jet.hipics21.business.entry.EntryResults;



public class CompetitionParameters {
	
	private Competition competition;
	private Event event;
	
	private List<EntryResults> entryResultsList = new ArrayList<EntryResults>();
}
