package jet.hipics21.business.competition.dressage;

import java.awt.Dimension;

import jet.hipics21.business.competition.COMPETITION_MODE;
import jet.hipics21.business.competition.CompetitionImpl;
import jet.hipics21.business.event.Event;
import jet.hipics21.business.official.JudgesList;
import jet.hipics21.business.rules.dressage.DRESSAGE_PROGRAM;

public class DressageCompetitionImpl extends CompetitionImpl implements DressageCompetition {

	public DressageCompetitionImpl(int competitionId, Event event) {
		super(competitionId, event);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public Dimension getArenaDimension() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public DRESSAGE_PROGRAM getDressageProgram() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JudgesList getJudgesList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setArenaDimension(Dimension arenaDimension) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDressageProgram(DRESSAGE_PROGRAM dressageProgram) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setJudgesList(JudgesList judgesList) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setCompetitionMode(COMPETITION_MODE competitionMode) {
		// TODO Auto-generated method stub
		
	}
	
	

}
