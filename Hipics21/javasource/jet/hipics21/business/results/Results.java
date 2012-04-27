package jet.hipics21.business.results;

import jet.hipics21.business.rules.disciplines.DISCIPLINES;

public abstract class Results  <T extends DISCIPLINES> {
	
	private Integer rank;
	
	private String exAequo;
	
	private Boolean placed;
	
	private RESULT_STATUS resultStatus = RESULT_STATUS.NOTSTARTED;

	private Boolean manuallyPlaced;
	
	protected abstract void refresh();

	public String getExAequo() {
		return this.exAequo;
	}

	public Boolean getPlaced() {
		return this.placed;
	}

	public Boolean getManuallyPlaced() {
		return this.manuallyPlaced;
	}

	public Integer getRank() {
		return this.rank;
	}

	public RESULT_STATUS getResultStatus() {
		return this.resultStatus;
	}

	protected void setExAequo(String exAequo) {
		this.exAequo = exAequo;
	}

	protected void setPlaced(Boolean placed) {
		this.placed = placed;
	}

	protected void setManuallyPlaced(Boolean placed) {
		this.manuallyPlaced = placed;
	}

	protected void setRank(Integer rank) {
		this.rank = rank;
	}

	protected void setResultStatus(RESULT_STATUS resultStatus) {
		this.resultStatus = resultStatus;
	}
	
	

}
