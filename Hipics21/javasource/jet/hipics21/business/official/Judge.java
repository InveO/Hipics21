package jet.hipics21.business.official;

import java.util.EnumSet;

public interface Judge {
	
	public Official getOfficial();
	
	public EnumSet<JudgeQualification> getJudgeQualification();
	public void setJudgeQualification(JudgeQualification judgeQualification);
	public boolean isJudgeQualification(JudgeQualification judgeQualification);

}
