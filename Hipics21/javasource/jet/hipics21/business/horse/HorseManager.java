package jet.hipics21.business.horse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HorseManager {
	
	private static final HorseManager horseManager = new HorseManager();

	private Map<Integer, HorseImpl> horseMap = new HashMap<Integer, HorseImpl>();
	private AtomicInteger lastHorseId = new AtomicInteger();
	
	public static HorseManager getHorseManager() {
		return horseManager;
	}
	
	private HorseManager() {
		// empty
	}
	private HorseImpl getHorseImpl(int horseId) {
		assert horseId >= 0:"horseId negative " + horseId;
		
		return this.horseMap.get(horseId);
	}
	
	private void putHorseImpl(HorseImpl horseImpl) {
		
		this.horseMap.put(horseImpl.getHorseId(), horseImpl);
	}
	
	public Horse createHorse(String name) {
		assert name != null:"name1 null";
		
		HorseImpl horseImpl = new HorseImpl(this.lastHorseId.getAndIncrement());
		horseImpl.setName(name);
		
		HorseImpl preExistingHorseImpl = getHorseImpl(horseImpl.getHorseId());
		
		if (preExistingHorseImpl != null) {
			throw new IllegalStateException("horseImpl already exists " + preExistingHorseImpl);
		}
		
		putHorseImpl(horseImpl);
		
		return horseImpl;
		
	}

	public Horse getHorse(int horseId) {
		assert horseId >= 0:"horseId negative " + horseId;
		
		HorseImpl horseImpl = getHorseImpl(horseId);
			
		return horseImpl;
		
	}
	
	public List<Horse> getHorseByName(String name) {
		assert name != null:"name null";
		List<Horse> horseList = new ArrayList<Horse>();
		
		for (HorseImpl horseImpl : this.horseMap.values()) {
			if (name != null) {
				if (!horseImpl.getName().equals(name)) {
					continue;
				}
			}
			horseList.add(horseImpl);
		}
		return horseList;
	}

	Collection<HorseImpl> getHorseCollection() {
		return this.horseMap.values();
	}
	
	public List<Horse> getHorseList() {
		
		return new ArrayList<Horse>(getHorseCollection());
		
	}

	public List<Horse> getHorseListSortedBySire() {
		List<Horse> horseList = new ArrayList<Horse>();
		
		for (Horse horse:getHorseCollection()) {
			if (horse.getSire() != null) {
				horseList.add(horse);
			}
		}
		Collections.sort(horseList, HorseImpl.getHorseComparatorBySire());
		return horseList;
		
	}
	
	public List<Horse> getSortedHorseList() {
		
		List<Horse> horseList = getHorseList();
		Collections.sort(horseList);
		
		return horseList;
		
	}
	
	public void removeHorse(int horseId) {
		assert horseId >= 0:"horseId negative " + horseId;
		
		HorseImpl horseImpl = this.horseMap.remove(horseId);
		horseImpl.setInvalid();
		
	}
	
	void listHorse() {
		
		System.out.println(horseMap.values());
	}

}
