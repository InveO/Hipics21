package jet.hipics21.business.competition;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import jet.hipics21.business.entry.EntryResults;
import jet.hipics21.business.event.Event;
import jet.hipics21.business.rules.RULES;
import jet.hipics21.business.rules.disciplines.DISCIPLINES;
import jet.hipics21.business.security.ACCESS_STATUS;


public abstract class CompetitionImpl<T extends DISCIPLINES> implements Competition<T> {
	private final int competitionId;
	
	private String competitionNumber;
	private String competitionSeries;
	private String name1;
	private String name2;
	private String name3;
	private String remark1;
	private String remark2;
	
	private int maxParticipant;
	private int numberOfPlaced;
	private int numberOfEliminated;
	private int numberOfEntered;
	private int horseMinAge;
	private int horseMaxAge;
	private int horseMinPoints;
	private int horseMaxPoints;
	private int riderMinAge;
	private int riderMaxAge;
	private int riderMinPoints;
	private int riderMaxPoints;
	private int coupleMinPoints;
	private int coupleMaxPoints;
	
	private BigDecimal entryCost;
	private BigDecimal entryDeposit;
	private BigDecimal minWinnings;
	private BigDecimal maxWinnings;
	
	private T disciplin;
	private COMPETITION_TYPE competitionType;
	private ACCESS_STATUS accessStatus;
	private final Event event;
	private RULES rules;
	
	private GregorianCalendar startDate;
	private GregorianCalendar endDate;

	private boolean valid;
	
	private List<Series> series = new ArrayList<Series>();
	private List<EntryResults<T>> entryResultsList = new ArrayList<EntryResults<T>>();

	protected CompetitionImpl(int competitionId, Event event) {
		
		if (competitionId < 0) {
			throw new IllegalArgumentException("Competition Id negative : " + competitionId);
		}
		this.competitionId = competitionId;
		
		if (event == null) {
			throw new NullPointerException("Event null");
		}
		this.event = event;
		
		this.valid = true;
		
	}
	
	public void setInvalid() {
		this.valid = false;
	}

	public void addEntryResults (EntryResults<T> entryResults) {
		
		assert entryResults != null:"entryResults null";
		this.entryResultsList.add(entryResults);
	}

	public void removeEntryResults (EntryResults<T> entryResults) {
		
		assert entryResults != null:"entryResults null";
		this.entryResultsList.remove(entryResults);
		
	}
	
	public ACCESS_STATUS getAccessStatus() {
		return this.accessStatus;
	}

	public int getCompetitionId() {
		return this.competitionId;
	}

	public String getCompetitionSeries() {
		return this.competitionSeries;
	}

	public boolean isValid() {
		return this.valid;
	}

	public String getCompetitionNumber() {
		return this.competitionNumber;
	}

	public String getCompetitionSerie() {
		return this.competitionSeries;
	}

	public COMPETITION_TYPE getCompetitionType() {
		return this.competitionType;
	}

	public int getCoupleMaxPoints() {
		return this.coupleMaxPoints;
	}

	public int getCoupleMinPoints() {
		return this.coupleMinPoints;
	}

	public T getDisciplin() {
		return this.disciplin;
	}

	public GregorianCalendar getEndDate() {
		return this.endDate;
	}

	public BigDecimal getEntryCost() {
		return this.entryCost;
	}

	public BigDecimal getEntryDeposit() {
		return this.entryDeposit;
	}

	public List<EntryResults<T>> getEntryResultsList() {
		return this.entryResultsList;
	}

	public Event getEvent() {
		return this.event;
	}
	
	public int getHorseMaxAge() {
		return this.horseMaxAge;
	}

	public int getHorseMaxPoints() {
		return this.horseMaxPoints;
	}

	public int getHorseMinAge() {
		return this.horseMinAge;
	}

	public int getHorseMinPoints() {
		return this.horseMinPoints;
	}

	public int getMaxParticipant() {
		return this.maxParticipant;
	}

	public BigDecimal getMaxWinnings() {
		return this.maxWinnings;
	}

	public BigDecimal getMinWinnings() {
		return this.minWinnings;
	}

	public String getName1() {
		if (this.valid == false) {
			throw new IllegalStateException("CompetitionImpl " + this.getCompetitionNumber() + " is invalid");
		}
		return this.name1;
	}

	public String getName2() {
		return this.name2;
	}

	public String getName3() {
		return this.name3;
	}

	public int getNumberOfEliminated() {
		return this.numberOfEliminated;
	}

	public int getNumberOfEntered() {
		return this.numberOfEntered;
	}

	public int getNumberOfPlaced() {
		return this.numberOfPlaced;
	}

	public String getRemark1() {
		return this.remark1;
	}

	public String getRemark2() {
		return this.remark2;
	}

	public int getRiderMaxAge() {
		return this.riderMaxAge;
	}

	public int getRiderMaxPoints() {
		return this.riderMaxPoints;
	}

	public int getRiderMinAge() {
		return this.riderMinAge;
	}

	public int getRiderMinPoints() {
		return this.riderMinPoints;
	}
	
	public RULES getRules() {
		
		if (this.rules == null) {
			return getEvent().getDefaultRules();
		}
		return this.rules;
		
	}

	public List<Series> getSeries() {
		return this.series;
	}

	public GregorianCalendar getStartDate() {
		return this.startDate;
	}

	public void setAccessStatus(ACCESS_STATUS accessStatus) {
		this.accessStatus = accessStatus;
	}

	public void setCompetitionSeries(String competitionSeries) {
		this.competitionSeries = competitionSeries;
	}

	public void setCompetitionNumber(String competitionNumber) {
		this.competitionNumber = competitionNumber;
	}

	public void setCompetitionSerie(String competitionSerie) {
		this.competitionSeries = competitionSerie;
	}

	public void setCompetitionType(COMPETITION_TYPE competitionType) {
		this.competitionType = competitionType;
	}

	public void setCoupleMaxPoints(int coupleMaxPoints) {
		this.coupleMaxPoints = coupleMaxPoints;
	}

	public void setCoupleMinPoints(int coupleMinPoints) {
		this.coupleMinPoints = coupleMinPoints;
	}

	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}

	public void setEntryCost(BigDecimal entryCost) {
		this.entryCost = entryCost;
	}

	public void setEntryDeposit(BigDecimal entryDeposit) {
		this.entryDeposit = entryDeposit;
	}

	public void setEntryResultsList(List<EntryResults<T>> entryResultsList) {
		this.entryResultsList = entryResultsList;
	}

	public void setHorseMaxAge(int horseMaxAge) {
		this.horseMaxAge = horseMaxAge;
	}

	public void setHorseMaxPoints(int horseMaxPoints) {
		this.horseMaxPoints = horseMaxPoints;
	}

	public void setHorseMinAge(int horseMinAge) {
		this.horseMinAge = horseMinAge;
	}

	public void setHorseMinPoints(int horseMinPoints) {
		this.horseMinPoints = horseMinPoints;
	}

	public void setMaxParticipant(int maxParticipant) {
		this.maxParticipant = maxParticipant;
	}

	public void setMaxWinnings(BigDecimal maxWinnings) {
		this.maxWinnings = maxWinnings;
	}

	public void setMinWinnings(BigDecimal minWinnings) {
		this.minWinnings = minWinnings;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public void setNumberOfEliminated(int numberOfEliminated) {
		this.numberOfEliminated = numberOfEliminated;
	}

	public void setNumberOfEntered(int numberOfEntered) {
		this.numberOfEntered = numberOfEntered;
	}

	public void setNumberOfPlaced(int numberOfPlaced) {
		this.numberOfPlaced = numberOfPlaced;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public void setRiderMaxAge(int riderMaxAge) {
		this.riderMaxAge = riderMaxAge;
	}

	public void setRiderMaxPoints(int riderMaxPoints) {
		this.riderMaxPoints = riderMaxPoints;
	}

	public void setRiderMinAge(int riderMinAge) {
		this.riderMinAge = riderMinAge;
	}

	public void setRiderMinPoints(int riderMinPoints) {
		this.riderMinPoints = riderMinPoints;
	}
	
	public void setRules(RULES rules) {
		
		this.rules = rules;
	}

	public void setSeries(List<Series> series) {
		this.series = series;
	}

	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}
	
	public boolean equals(Object other) {
		
		if (other == null) {
			return false;
		} else if (other == this) {
			return true;
		} else if (!(other instanceof Competition)) {
			return false;
		} else {
			
			@SuppressWarnings("unchecked")
			Competition<T> competition = (Competition<T>) other;
			if (competition.getCompetitionId() == getCompetitionId()) {
				return true;
			}
			return false;
		}
	}
	
	public int hashCode() {
		return getCompetitionId();
	}
	
	public String toString() {
		
		return getCompetitionNumber() + " " + getCompetitionSerie() + " " + getName1();
	}

	
}
