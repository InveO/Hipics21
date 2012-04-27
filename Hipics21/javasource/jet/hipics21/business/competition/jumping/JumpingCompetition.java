package jet.hipics21.business.competition.jumping;

import jet.hipics21.business.competition.Competition;
import jet.hipics21.business.rules.disciplines.JUMPING;

public interface JumpingCompetition extends Competition<JUMPING> {
	public static final int MAX_FENCES = 40;
	
	int getNumberOfPhases();
	
	JumpingPhase getPhase(int phaseNo);
	

}
