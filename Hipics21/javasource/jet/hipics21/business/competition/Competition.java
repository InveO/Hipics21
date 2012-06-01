package jet.hipics21.business.competition;

import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.List;

import jet.hipics21.business.entry.EntryResults;
import jet.hipics21.business.event.Event;
import jet.hipics21.business.rules.RULES;
import jet.hipics21.business.rules.disciplines.DISCIPLINES;
import jet.hipics21.business.security.ACCESS_STATUS;


public interface Competition  <T extends DISCIPLINES> {
	
	public void addEntryResults (EntryResults<T> entryResults) ;
	
	public void removeEntryResults (EntryResults<T> entryResults) ;
	
	public List<EntryResults<T>> getEntryResultsList();

	public String getCompetitionNumber();
	public String getCompetitionSerie();
	public String getName1();
	public String getName2();
	public String getName3();
	public String getRemark1();
	public String getRemark2();
	
	public int getCompetitionId();
	public int getMaxParticipant();
	public int getNumberOfPlaced();
	public int getNumberOfEliminated();
	public int getNumberOfEntered();
	public int getHorseMinAge();
	public int getHorseMaxAge();
	public int getHorseMinPoints();
	public int getHorseMaxPoints();
	public int getRiderMinAge();
	public int getRiderMaxAge();
	public int getRiderMinPoints();
	public int getRiderMaxPoints();
	public int getCoupleMinPoints();
	public int getCoupleMaxPoints();
	
	public BigDecimal getEntryCost();
	public BigDecimal getEntryDeposit();
	public BigDecimal getMinWinnings();
	public BigDecimal getMaxWinnings();
	
	public RULES getRules();
	public T getDisciplin();
	public COMPETITION_MODE getCompetitionMode();
	public Event getEvent();
	public ACCESS_STATUS getAccessStatus();
	
	public GregorianCalendar getStartDate();
	public GregorianCalendar getEndDate();

	public void setCompetitionNumber(String competitionNumber);
	public void setCompetitionSerie(String competitionSerie);
	public void setName1(String name1);
	public void setName2(String name2);
	public void setName3(String name3);
	public void setRemark1(String remark1);
	public void setRemark2(String remark2);
	
	public void setMaxParticipant(int maxParticipant);
	public void setNumberOfPlaced(int numberOfPlaced);
	public void setNumberOfEliminated (int numberOfEliminated);
	public void setNumberOfEntered(int numberOfEntered);
	public void setHorseMinAge(int horseMinAge);
	public void setHorseMaxAge(int horseMaxAge);
	public void setHorseMinPoints(int horseMinPoints);
	public void setHorseMaxPoints(int horseMaxPoints);
	public void setRiderMinAge(int riderMinAge);
	public void setRiderMaxAge(int riderMaxAge);
	public void setRiderMinPoints(int riderMinPoints);
	public void setRiderMaxPoints(int riderMaxPoints);
	public void setCoupleMinPoints(int coupleMinPoints);
	public void setCoupleMaxPoints(int coupleMaxPoints);
	
	public void setEntryCost(BigDecimal entryCost);
	public void setEntryDeposit(BigDecimal entryDeposit);
	public void setMinWinnings(BigDecimal minWinnings);
	public void setMaxWinnings(BigDecimal maxWinnings);
	
	public void setRules(RULES rules);
	public void setCompetitionMode(COMPETITION_MODE competitionMode);
	public void setAccessStatus(ACCESS_STATUS accessStatus);
	
	public void setStartDate(GregorianCalendar startDate);
	public void setEndDate(GregorianCalendar endDate);
}
