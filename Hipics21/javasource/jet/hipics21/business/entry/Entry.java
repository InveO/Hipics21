package jet.hipics21.business.entry;

import java.util.Comparator;

import jet.hipics21.business.event.HorseRiderCouple;


public class Entry {
	
	private static class EntryComparator implements Comparator<Entry> {

		@Override
		public int compare(Entry entry1, Entry entry2) {
			if (entry1 == null) {
				throw new NullPointerException("Entry<entry 1 is null");
			}
			
			if (entry2 == null) {
				throw new NullPointerException("Entry<entry 2 is null");
			}
			
			return entry1.getDepartureNumber().compareTo(entry2.getDepartureNumber());
		} 
	}
	private Integer order;
	private Float departureNumber;
	private String number;
	private String series;
	
	private Boolean horsConcours;

	Entry () {
		
	}

	public Float getDepartureNumber() {
		return this.departureNumber;
	}

	public Boolean getHorsConcours() {
		return this.horsConcours;
	}

	public String getNumber() {
		return this.number;
	}

	public Integer getOrder() {
		return this.order;
	}

	public String getSerie() {
		return this.series;
	}

	public void setDepartureNumber(Float departureNumber) {
		this.departureNumber = departureNumber;
	}

	public void setHorsConcours(Boolean horsConcours) {
		this.horsConcours = horsConcours;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
	
	public void setSerie(String serie) {
		this.series = serie;
	}

	

}
