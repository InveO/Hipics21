package jet.hipics21.business.event;

import java.util.ArrayList;
import java.util.List;

import jet.hipics21.business.entry.EntryResults;
import jet.hipics21.business.horse.Horse;



public class HorseParameters {
	
	private Horse horse;
	private Event event;
	
	private String headNumber;
	private String stableNumber;

	private List<EntryResults> entryResultsList = new ArrayList<EntryResults>();
}
