package jet.hipics21.business.official;

import java.util.ArrayList;
import java.util.List;


public class JudgesList {
	private List<Judge> judgesList = new ArrayList<Judge>();
	
	JudgesList() {
		
	}
	
	void add(Judge judge) {
		assert judge != null : "judge null";
		this.judgesList.add(judge);
	}
	
	void remove(Judge judge) {
		assert judge != null : "judge null";
		this.judgesList.remove(judge);
	}


}
