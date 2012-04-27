package jet.hipics21.business.horse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

import jet.hipics21.business.entry.EntryResults;


public class HorseImpl implements Horse {
	private static final Comparator<Horse> horseComparatorBySire = new HorseBySireAndHorseName();
	
	public static Comparator<Horse> getHorseComparatorBySire() {
		
		return horseComparatorBySire;
	}
	
	private final int horseId;
	
	private String name;
	private String oldName;
	private String breed;
	private String countryOfBirth;
	private String passportNumFSSE;
	private String passportNumFEI;
	private String breedCertificateNo;
		
	private BigDecimal winnings;
	private BigDecimal points;
	
	private GregorianCalendar dateOfBirth;
	
	private Horse dam;
	private Horse damSire;
	private Horse sire;
	private HorseColor color;
	private HorseSex horseSex;
	private HorseStatus horseStatus;
	
	private HorseOwnerSet horseOwnerSet;
	private HorseBreeder horseBreeder;
	
	private List<EntryResults> entryResultsList = new ArrayList<EntryResults>();
	
	private boolean valid;
	
	HorseImpl(int horseId) {
		this.horseId = horseId;
		this.horseOwnerSet = new HorseOwnerSet();
		this.valid = true;
	}
	
	public void setInvalid() {
		this.valid = false;
	}
	
	public void addEntryResults (EntryResults entryResults) {
 		
		assert entryResults != null:"entryResults null";
		assert entryResults.getHorseRiderCouple().getHorse() == this;
		
		this.entryResultsList.add(entryResults);
	}
	
	public int getAge() {
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		int currentYear = gregorianCalendar.get(Calendar.YEAR);
		int birthYear = getYearOfBirth();
		int age = currentYear - birthYear;
		System.out.println("currentYear " + currentYear);
		System.out.println("birthYear " + birthYear);
		System.out.println("age " + age);
		return age;
	}

	public String getBreed() {
		return this.breed;
	}

	public String getBreedCertificateNo() {
		return this.breedCertificateNo;
	}

	public HorseColor getColor() {
		return this.color;
	}

	public int getHorseId() {
		return this.horseId;
	}

	public String getCountryOfBirth() {
		return this.countryOfBirth;
	}

	public Horse getDam() {
		return this.dam;
	}

	public Horse getDamSire() {
		return this.damSire;
	}

	public GregorianCalendar getDateOfBirth() {
		return this.dateOfBirth;
	}

	public List<EntryResults> getEntryResultsList() {
		return this.entryResultsList;
	}

	public HorseSex getSex() {
		return this.horseSex;
	}

	public HorseBreeder getHorseBreeder() {
		return this.horseBreeder;
	}

	public HorseOwnerSet getHorseOwnerSet() {
		return this.horseOwnerSet;
	}

	public HorseStatus getHorseStatus() {
		return this.horseStatus;
	}

	public String getName() {
		if (this.valid == false) {
			throw new IllegalStateException("HorseImpl " + this.getHorseId() + " " + this.name + " is invalid");
		}
		return this.name;
	}

	public String getOldName() {
		return this.oldName;
	}

	public String getPassportNumFEI() {
		return this.passportNumFEI;
	}

	public String getPassportNumFSSE() {
		return this.passportNumFSSE;
	}

	public BigDecimal getPoints() {
		return this.points;
	}

	public Horse getSire() {
		return this.sire;
	}

	public BigDecimal getWinnings() {
		return this.winnings;
	}

	private int getYearOfBirth() {
		return getDateOfBirth().get(Calendar.YEAR);
	}

	public void removeEntryResults (EntryResults entryResults) {
		
		assert entryResults != null:"entryResults null";
		this.entryResultsList.remove(entryResults);
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public void setBreedCertificateNo(String breedCertificateNo) {
		this.breedCertificateNo = breedCertificateNo;
	}

	public void setColor(HorseColor color) {
		this.color = color;
	}

	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}

	public void setDam(Horse dam) {
		this.dam = dam;
	}
	
	public void setDamSire(Horse damSire) {
		this.damSire = damSire;
	}

	public void setDateOfBirth(GregorianCalendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setEntryResultsList(List<EntryResults> entryResultsList) {
		this.entryResultsList = entryResultsList;
	}

	public void setSex(HorseSex horseSex) {
		this.horseSex = horseSex;
	}

	public void setHorseBreeder(HorseBreeder horseBreeder) {
		this.horseBreeder = horseBreeder;
	}

	public void setHorseOwnerSet(HorseOwnerSet horseOwnerSet) {
		this.horseOwnerSet = horseOwnerSet;
	}

	public void setHorseStatus(HorseStatus horseStatus) {
		this.horseStatus = horseStatus;
	}

	public void setName(String name) {
		if (name == null) {
			throw new NullPointerException("Name null");
		}
		this.name = name;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public void setPassportNumFEI(String passportNumFEI) {
		this.passportNumFEI = passportNumFEI;
	}

	public void setPassportNumFSSE(String passportNumFSSE) {
		this.passportNumFSSE = passportNumFSSE;
	}

	public void setPoints(BigDecimal points) {
		this.points = points;
	}

	public void setSire(Horse sire) {
		this.sire = sire;
	}

	public void setWinnings(BigDecimal winnings) {
		this.winnings = winnings;
	} 

	@Override
	public int compareTo(Horse otherHorse) {
		if (otherHorse == null) {
			throw new NullPointerException("Horse null");
		}
		return this.name.compareTo(otherHorse.getName());
	}

	public boolean equals(Object other) {
		
		if (other == null) {
			return false;
		} else if (other == this) {
			return true;
		} else if (!(other instanceof Horse)) {
			return false;
		} else {

			Horse horse = (Horse) other;
			if (horse.getHorseId() == getHorseId()) {
				return true;
			}
			return false;
		}
	}
	
	public String toString() {
		
		String sire = "unknown";
		if (getSire()!= null) {
			sire = getSire().getName();
		}
		return getName() + " (par " + sire + ")";
	}
	
	public int hashCode() {
		return getHorseId();
	}
	
	private static class HorseByPassportFSSEComparator implements Comparator<Horse> {

		@Override
		public int compare(Horse horse1, Horse horse2) {
			if (horse1 == null) {
				throw new NullPointerException("Horse<horse 1 is null");
			}
			
			if (horse2 == null) {
				throw new NullPointerException("Horse");
			}
			
			return horse1.getPassportNumFSSE().compareTo(horse2.getPassportNumFSSE());
		} 
	}
	private static class HorseByPassportFEIComparator implements Comparator<Horse> {

		@Override
		public int compare(Horse horse1, Horse horse2) {
			if (horse1 == null) {
				throw new NullPointerException("Horse<horse 1 is null");
			}
			
			if (horse2 == null) {
				throw new NullPointerException("Horse");
			}
			
			return horse1.getPassportNumFEI().compareTo(horse2.getPassportNumFEI());
		} 
	}
	private static class HorseBySireAndHorseName implements Comparator<Horse> {

		@Override
		public int compare(Horse horse1, Horse horse2) {
			if (horse1 == null) {
				throw new NullPointerException("Horse<horse 1 is null");
			}
			
			if (horse2 == null) {
				throw new NullPointerException("Horse");
			}
			
			if (horse1.getSire().compareTo(horse2.getSire()) == 0) {
				return horse1.getName().compareTo(horse2.getName());
				
			}
			return horse1.getSire().compareTo(horse2.getSire());
		} 
}
	private static class HorseByDamAndHorseName implements Comparator<Horse> {

		@Override
		public int compare(Horse horse1, Horse horse2) {
			if (horse1 == null) {
				throw new NullPointerException("Horse<horse 1 is null");
			}
			
			if (horse2 == null) {
				throw new NullPointerException("Horse");
			}
			
			if (horse1.getDam().compareTo(horse2.getDam()) == 0) {
				return horse1.getName().compareTo(horse2.getName());
				
			}
			return horse1.getDam().compareTo(horse2.getDam());
		} 
}

	
}
