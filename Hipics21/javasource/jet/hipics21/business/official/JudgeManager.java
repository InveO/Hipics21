package jet.hipics21.business.official;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jet.hipics21.business.official.Official;
import jet.hipics21.business.official.OfficialManager;


public class JudgeManager {
	
	private JudgesList judgesList;
	private static final JudgeManager judgeManager = new JudgeManager();
	private static final OfficialManager officialManager = OfficialManager.getOfficialManager();
	
	private Map<Integer, JudgeImpl> judgeMap = new HashMap<Integer, JudgeImpl>();
	
	public static JudgeManager getJudgeManager() {
		return judgeManager;
	}
	
	public Judge createJudge(Official official) {
		assert official != null:"official null";
		
		JudgeImpl preExistingJudgeImpl = getJudgeImpl(official.getContact().getContactId());
		
		if (preExistingJudgeImpl != null) {
			throw new IllegalStateException("judgeImpl already exists " + preExistingJudgeImpl);
		}
		
		JudgeImpl judgeImpl = new JudgeImpl(official);
		putJudgeImpl(judgeImpl);
		
		return judgeImpl;
		
	}

	public void removeJudge(Official official) {
		assert official != null:"official null";
		
		JudgeImpl judgeImpl = this.judgeMap.remove(official.getContact().getContactId());
	}

	public Judge getJudge(Official official) {
		assert official != null:"official null";
		
		JudgeImpl judgeImpl = getJudgeImpl(official.getContact().getContactId());		
	
		return judgeImpl;
		
	}
	private JudgeImpl getJudgeImpl(Integer contactId) {
		assert contactId >= 0:"contactId negative " + contactId;
		
		return this.judgeMap.get(contactId);
	}
	
	private void putJudgeImpl(JudgeImpl judgeImpl) {
		
		this.judgeMap.put(judgeImpl.getOfficial().getContact().getContactId(), judgeImpl);
	}
	
	Collection<JudgeImpl> getJudgeImplCollection() {
		
		return judgeMap.values();
	}
	
	public List<Judge> getJudgeList() {
		
		List<Judge> judgeList = new ArrayList<Judge>(getJudgeImplCollection());
		return judgeList;
	}



}
