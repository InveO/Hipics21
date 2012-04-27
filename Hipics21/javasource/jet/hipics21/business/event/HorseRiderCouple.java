package jet.hipics21.business.event;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import jet.hipics21.business.entry.EntryResults;
import jet.hipics21.business.horse.Horse;
import jet.hipics21.business.rider.Rider;



public class HorseRiderCouple {
	
	private final static HorseComparator horseComparator = new HorseComparator();
	private final static RiderComparator riderComparator = new RiderComparator();
	private final Rider rider;
	private final Horse horse;
	
	private List<EntryResults> entryResultsList = new ArrayList<EntryResults>();
	
	static HorseComparator getHorseComparator() {
		
		return horseComparator;
	}
	
	static RiderComparator getRiderComparator() {
		
		return riderComparator;
	}
	
	public HorseRiderCouple (Rider rider, Horse horse) {
		
		this.rider = rider;
		this.horse = horse;
		
	}
	
	public void addEntryResults (EntryResults entryResults) {
		assert entryResults != null:"entryResults null";
		
		this.rider.addEntryResults(entryResults);
		this.horse.addEntryResults(entryResults);		
		this.entryResultsList.add(entryResults);
	}
	
	public Rider getRider() {
		return this.rider;
	}

	public Horse getHorse() {
		return this.horse;
	}

	public void removeEntryResults (EntryResults entryResults) {		
		assert entryResults != null:"entryResults null";
		
		this.entryResultsList.remove(entryResults);
		this.horse.removeEntryResults(entryResults);
		this.rider.removeEntryResults(entryResults);
		
	}
	
	public void finalize() {
		
		if (!this.entryResultsList.isEmpty()) {
			throw new IllegalStateException("entryResult is not empty");
		}
			
	}
	
	/**
	 *
	 */
	private static class HorseComparator implements Comparator<HorseRiderCouple> {

		@Override
		public int compare(HorseRiderCouple hrc1, HorseRiderCouple hrc2) {
			if (hrc1 == null) {
				throw new NullPointerException("HorseRider<couple 1 is null");
			}
			
			if (hrc2 == null) {
				throw new NullPointerException("HorseRider<couple 2 is null");
			}
			
			return hrc1.getHorse().compareTo(hrc2.getHorse());
		} 
	}

	private static class RiderComparator implements Comparator<HorseRiderCouple> {

		@Override
		public int compare(HorseRiderCouple hrc1, HorseRiderCouple hrc2) {
			if (hrc1 == null) {
				throw new NullPointerException("HorseRider<couple 1 is null");
			}
			
			if (hrc2 == null) {
				throw new NullPointerException("HorseRider<couple 2 is null");
			}
			
			return hrc1.getRider().compareTo(hrc2.getRider());
		} 
	}

}
