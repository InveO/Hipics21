package jet.hipics21.business.official;

import java.util.GregorianCalendar;

import jet.hipics21.business.contact.Contact;

public interface Official {
	
	public Contact getContact();
	
	public OFFICIAL_FUNCTION getOfficialFunction();
	public GregorianCalendar getValidFrom();
	public GregorianCalendar getValidTo();
	
	public void setOfficialFunction(OFFICIAL_FUNCTION function);
	public void setValidFrom(GregorianCalendar validFrom);
	public void setValidTo(GregorianCalendar validTo);

}
