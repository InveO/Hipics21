package jet.hipics21.business.horse;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import jet.hipics21.business.entry.EntryResults;


public interface Horse extends Comparable<Horse> {
	
	public void addEntryResults (EntryResults entryResults);
	
	public String getBreed();
	
	public String getBreedCertificateNo();
	
	public HorseColor getColor();
	
	public String getCountryOfBirth();
	
	public Horse getDam();
	
	public Horse getDamSire();
	
	public GregorianCalendar getDateOfBirth();
	
	public int getHorseId();
	
	public HorseStatus getHorseStatus();
	
	public String getName();
	
	public String getOldName();
		
	public String getPassportNumFEI();
	
	public String getPassportNumFSSE();
	
	public BigDecimal getPoints();
	
	public HorseSex getSex();
	
	public Horse getSire();
	
	public BigDecimal getWinnings();
	
	public void removeEntryResults (EntryResults entryResults);
	
	public void setBreed(String breed);
	
	public void setBreedCertificateNo(String breedingCertificateNo);
	
	public void setColor(HorseColor horseColor);
	
	public void setCountryOfBirth(String countryOfBirth);
	
	public void setDam(Horse horse);
	
	public void setDamSire(Horse horse);
	
	public void setDateOfBirth(GregorianCalendar dateOfBirth);
	
	public void setHorseStatus(HorseStatus horseStatus);
	
	public void setName(String name);
		
	public void setOldName(String oldName);
	
	public void setPassportNumFEI(String passportNumFEI);
	
	public void setPassportNumFSSE(String passportNumFSSE);
	
	public void setPoints(BigDecimal points);
	
	public void setSex(HorseSex sex);
	
	public void setSire(Horse horse); 
	
	public void setWinnings(BigDecimal winnings);
	

}
