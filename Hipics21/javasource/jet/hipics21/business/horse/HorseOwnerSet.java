package jet.hipics21.business.horse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class HorseOwnerSet {
	
	private Set<HorseOwner> horseOwnerSet = new HashSet<HorseOwner>();
	
	HorseOwnerSet() {
		
	}
	
	void add(HorseOwner horseOwner) {
		assert horseOwner != null : "horseOwner null";
		this.horseOwnerSet.add(horseOwner);
	}
	
	void remove(HorseOwner horseOwner) {
		assert horseOwner != null : "horseOwner null";
		this.horseOwnerSet.remove(horseOwner);
	}
}
