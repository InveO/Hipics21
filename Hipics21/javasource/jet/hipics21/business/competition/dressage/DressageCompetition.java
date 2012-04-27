package jet.hipics21.business.competition.dressage;

import java.awt.Dimension;

import jet.hipics21.business.competition.Competition;
import jet.hipics21.business.official.JudgesList;
import jet.hipics21.business.rules.dressage.DRESSAGE_PROGRAM;

public interface DressageCompetition extends Competition {

	public Dimension getArenaDimension();
	
	public DRESSAGE_PROGRAM getDressageProgram();
	
	public JudgesList getJudgesList();
	
		
	public void setArenaDimension(Dimension arenaDimension);
	
	public void setDressageProgram(DRESSAGE_PROGRAM dressageProgram);
	
	public void setJudgesList(JudgesList judgesList);

}
