package jet.hipics21.business.contact;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import jet.hipics21.business.address.Address;

public interface Contact {
	
	
	public List<Address> getAddressList();
	
	public ContactType getContactType();

	public GregorianCalendar getDateOfBirth();
	
	public int getContactId();

	public String getFaxOffice();
	
	public String getFaxPrivate();

	public Locale getLanguage();

	public String getMailOffice();

	public String getMailPrivate();

	public String getName1();

	public String getName2();

	public String getName3();

	public String getTelMobile();

	public String getTelOffice();

	public String getTelPrivate();

	public void setAddressList(List<Address> addressList);

	public void setContactType(ContactType contactType);

	public void setDateOfBirth(GregorianCalendar dateOfBirth);

	public void setFaxOffice(String faxOffice);

	public void setFaxPrivate(String faxPrivate);

	public void setLanguage(Locale language);

	public void setMailOffice(String mailOffice);

	public void setMailPrivate(String mailPrivate);

	public void setName1(String name1);

	public void setName2(String name2);

	public void setName3(String name3);

	public void setTelMobile(String telMobile);

	public void setTelOffice(String telOffice);

	public void setTelPrivate(String telPrivate);
	

}
