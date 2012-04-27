package jet.hipics21.business.official;

import java.util.EnumSet;

public class JudgeImpl implements Judge {

	private final Official official;
	private EnumSet<JudgeQualification> judgeQualificationSet = EnumSet.noneOf(JudgeQualification.class);
	
	JudgeImpl(Official official) {
		
		assert official != null:"official null";
		
		this.official = official;
		
	}
	
	public boolean equals(Object other) {
		
		if (other == null) {
			return false;
		} else if (other == this) {
			return true;
		} else if (!(other instanceof Judge)) {
			return false;
		} else {
			Judge judge = (Judge) other;
			if (judge.getOfficial().equals(this.getOfficial())) {
				return true;
			}
			return false;
		}
	}

	public Official getOfficial() {
		return this.official;
	}

	public EnumSet<JudgeQualification> getJudgeQualification() {
		return this.judgeQualificationSet;
	}

	public void setJudgeQualification(JudgeQualification judgeQualification) {
		this.judgeQualificationSet.add(judgeQualification);
	}

	public boolean isJudgeQualification(JudgeQualification judgeQualification) {
		
		return judgeQualificationSet.contains(judgeQualification);
		
	}

	public String toString() {
		
		return this.official.getContact().getName1() + " " + this.official.getContact().getName2();
	}
}
