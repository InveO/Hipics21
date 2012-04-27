package jet.hipics21.business.rider;

import java.util.List;

import jet.hipics21.business.contact.Contact;
import jet.hipics21.business.entry.EntryResults;
import jet.hipics21.business.licence.LicenceCode;
import jet.hipics21.business.licence.RiderLicence;

public interface Rider  extends Comparable<Rider> {
	
	public Contact getContact();
	public RiderAgeStatus getRiderAgeStatus();
	public RiderStatus getRiderStatus();
	public RiderLicence getRiderLicence(LicenceCode licenceCode);
	public List<RiderLicence> getRiderLicenceList();
	
	public void addLicence(RiderLicence riderLicence);
	public void removeLicence(RiderLicence riderLicence);

	public void setRiderAgeStatus (RiderAgeStatus riderAgeStatus);
	public void setRiderStatus (RiderStatus riderStatus);
	
	public void addEntryResults (EntryResults entryResults);
	public void removeEntryResults (EntryResults entryResults);

}
