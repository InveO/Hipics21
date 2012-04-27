package jet.hipics21.business.horse;

import jet.hipics21.business.contact.Contact;

public interface HorseBreeder {

	public Contact getContact();
	
	public String getGroupBreeder();
	public String getBreedingName();
	public String getBreederNum();
	
	public void setGroupBreeder(String groupBreeder);
	public void setBreedingName(String breedingName);
	public void setBreederNum(String breederNum);
	
}
