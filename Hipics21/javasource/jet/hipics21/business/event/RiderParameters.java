package jet.hipics21.business.event;

import java.util.ArrayList;
import java.util.List;

import jet.hipics21.business.entry.EntryResults;
import jet.hipics21.business.horse.Horse;
import jet.hipics21.business.rider.Rider;




public class RiderParameters {
	
	private Rider rider;
	private Event event;
	
	private List<EntryResults> entryResultsList = new ArrayList<EntryResults>();
}
