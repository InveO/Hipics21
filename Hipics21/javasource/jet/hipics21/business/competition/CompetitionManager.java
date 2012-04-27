package jet.hipics21.business.competition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import jet.hipics21.business.competition.dressage.DressageCompetition;
import jet.hipics21.business.competition.dressage.DressageCompetitionImpl;
import jet.hipics21.business.event.Event;



public class CompetitionManager {

	private static final CompetitionManager competitionManager = new CompetitionManager();
	
	private Map<Integer, CompetitionImpl> competitionMap = new HashMap<Integer, CompetitionImpl>();
	private AtomicInteger lastCompetitionId = new AtomicInteger();
	
	public static CompetitionManager getCompetitionManager() {
		return competitionManager;
	}
	
	private CompetitionManager() {
		// empty
	}
	
	private CompetitionImpl getCompetitionImpl(int competitionId) {
		assert competitionId >= 0:"competitionId negative " + competitionId;
		
		return this.competitionMap.get(competitionId);
	}
	
	private void putCompetitionImpl(CompetitionImpl competitionImpl) {
		
		this.competitionMap.put(competitionImpl.getCompetitionId(), competitionImpl);
	}
	
	public <T extends Competition> T createCompetition(Class<T> competitionClass, String competitionNumber, String competitionSerie, Event event) {
		assert competitionClass != null:"competitionClass null";
		assert competitionNumber != null:"competitionNumber null";
		assert competitionSerie != null:"competitionSerie null";
		assert event != null:"event null";
		
		CompetitionImpl competitionImpl;
		if (competitionClass == DressageCompetition.class) {
			competitionImpl = new DressageCompetitionImpl(this.lastCompetitionId.getAndIncrement(), event);
		} else {
			throw new IllegalArgumentException("unknown competition type : " + competitionClass.getName());
		}
		competitionImpl.setCompetitionNumber(competitionNumber);
		competitionImpl.setCompetitionSerie(competitionSerie);
		
		CompetitionImpl preExistingCompetitionImpl = getCompetitionImpl(competitionImpl.getCompetitionId());
		
		if (preExistingCompetitionImpl != null) {
			throw new IllegalStateException("competitionImpl already exists " + preExistingCompetitionImpl);
		}
		
		putCompetitionImpl(competitionImpl);
		
		return competitionClass.cast(competitionImpl);
		
	}

	public Competition getCompetition(int competitionId) {
		assert competitionId >= 0:"competitionId negative " + competitionId;
		
		CompetitionImpl competitionImpl = getCompetitionImpl(competitionId);
			
		return competitionImpl;
		
	}
	
	public List<Competition> getCompetitionByName(String competitionNumber, String competitionSerie) {
		assert competitionNumber != null || competitionSerie != null:"competitionNumber and competitionSerie null";
		List<Competition> competitionList = new ArrayList<Competition>();
		
		for (CompetitionImpl competitionImpl : this.competitionMap.values()) {
			if (competitionNumber != null) {
				if (!competitionImpl.getCompetitionNumber().equals(competitionNumber)) {
					continue;
				}
			}
			if (competitionSerie != null) {
				if (!competitionImpl.getCompetitionSerie().equals(competitionSerie)) {
					continue;
				}
			}
			competitionList.add(competitionImpl);
		}
		return competitionList;
	}

	public void removeCompetition(int competitionId) {
		assert competitionId >= 0:"competitionId negative " + competitionId;
		
		CompetitionImpl competitionImpl = this.competitionMap.remove(competitionId);
		competitionImpl.setInvalid();
		
	}
	
	void listCompetition() {
		
		System.out.println(competitionMap.values());
	}


}
