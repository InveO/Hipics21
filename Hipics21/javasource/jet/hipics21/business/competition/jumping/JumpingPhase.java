package jet.hipics21.business.competition.jumping;

import java.math.BigDecimal;

import jet.hipics21.business.rules.jumping.TABLE;

public class JumpingPhase {
	private static final int MAX_COURSE_LENGTH = 10000;
	private static final int MAX_TIME = 999999;
	private static final int MAX_FENCES = 99;
	private static final int MAX_EFFORTS = 99;
	private static final int MAX_PHASES = 9;
	private static final int MAX_SPEED = 1000;
	

	private final JumpingCompetition jumpingCompetition;
	private TABLE table;
	
	private int phaseNo;
	private int timeAllowed;
	private int maxTimeAllowed;
	private int numberOfFences;
	private int numberOfEfforts;
	
	private BigDecimal timePenalties;
	private int courseLength;
	private int speed;
		
	public JumpingPhase (JumpingCompetition jumpingCompetition) {
		this.jumpingCompetition = jumpingCompetition;
	}
	
	public int getCourseLength() {
		return this.courseLength;
	}

	public int getMaxTimeAllowed() {
		return this.maxTimeAllowed;
	}

	public int getNumberOfEfforts() {
		return this.numberOfEfforts;
	}

	public int getNumberOfFences() {
		return this.numberOfFences;
	}

	public int getPhaseNo() {
		return this.phaseNo;
	}
	
	public int getSpeed() {
		return this.speed;
	}

	public TABLE getTable() {
		return this.table;
	}

	public int getTimeAllowed() {
		return this.timeAllowed;
	}

	public BigDecimal getTimePenalties() {
		return this.timePenalties;
	}

	public void setCourseLength(int courseLength) {
		assert courseLength < MAX_COURSE_LENGTH:"courseLength too big : " + courseLength;
		this.courseLength = courseLength;
	}

	public void setMaxTimeAllowed(int maxTimeAllowed) {
		assert maxTimeAllowed < MAX_TIME:"max Time Allowd too big : " + maxTimeAllowed;
		this.maxTimeAllowed = maxTimeAllowed;
	}

	public void setNumberOfEfforts(int numberOfEfforts) {
		assert numberOfEfforts < MAX_EFFORTS:"Number of efforts too big : " + numberOfEfforts;
		this.numberOfEfforts = numberOfEfforts;
	}

	public void setNumberOfFences(int numberOfFences) {
		assert numberOfFences < MAX_FENCES:"Number of Fences too big : " + numberOfFences;
		this.numberOfFences = numberOfFences;
	}

	public void setPhaseNo(int phaseNo) {
		assert phaseNo < MAX_PHASES:"Phase no too big : " + phaseNo;
		this.phaseNo = phaseNo;
	}

	public void setSpeed(int speed) {
		assert speed < MAX_SPEED:"Speed too big : " + speed;
		this.speed = speed;
	}

	public void setTable(TABLE table) {
		this.table = table;
	}

	public void setTimeAllowed(int timeAllowed) {
		this.timeAllowed = timeAllowed;
	}

	public void setTimePenalties(BigDecimal timePenalties) {
		this.timePenalties = timePenalties;
	}

	public JumpingCompetition getJumpingCompetition() {
		return this.jumpingCompetition;
	}
	
	

}
