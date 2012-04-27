package jet.hipics21.business.licence;

import java.util.GregorianCalendar;


public class RiderLicence implements Comparable<RiderLicence> {
	
	private LicenceDisciplin disciplin; /* saut, dressage, etc. */
	private LicenceCategory category;  /* amateur, pro, etc.*/
	private LicenceCode licenceCode;  /* saut-régional, dressage-national, fei, etc. */
	private RiderLicenceStatus licenceStatus; /* active, suspendu*/
	
	private String examLocation;
	private String licenceNumber;
	
	GregorianCalendar examDate;
	GregorianCalendar validFrom;
	GregorianCalendar validTo;
		
	public RiderLicence(LicenceDisciplin disciplin, LicenceCategory category, LicenceCode licenceCode, RiderLicenceStatus licenceStatus,
						String examLocation, String licenceNumber, 
						GregorianCalendar examDate, GregorianCalendar validFrom, GregorianCalendar validTo) {
		assert licenceCode != null:"licenceCode null";
		if (licenceNumber == null) {
			throw new NullPointerException("Licence number null");
		}
		this.disciplin = disciplin;
		this.category = category;
		this.licenceCode = licenceCode;
		this.licenceStatus = licenceStatus;
		this.examLocation = examLocation;
		this.licenceNumber = licenceNumber;
		this.examDate = examDate;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}

	@Override
	public int compareTo(RiderLicence otherLicence) {
		assert otherLicence != null:"otherLicence null";
		
		return getLicenceNumber().compareTo(otherLicence.getLicenceNumber());

	}

	public boolean equals(Object other) {
		
		if (other == null) {
			return false;
		} else if (other == this) {
			return true;
		} else if (!(other instanceof RiderLicence)) {
			return false;
		} else {
			
			RiderLicence riderLicence = (RiderLicence) other;
			if (riderLicence.getLicenceCode() == getLicenceCode()) {
				return true;
			}
			return false;
		}
	}

	public LicenceCategory getCategory() {
		return this.category;
	}

	public LicenceDisciplin getDisciplin() {
		return this.disciplin;
	}

	public GregorianCalendar getExamDate() {
		return this.examDate;
	}
	
	public String getExamLocation() {
		return this.examLocation;
	}

	public LicenceCode getLicenceCode() {
		return this.licenceCode;
	}

	public String getLicenceNumber() {
		return this.licenceNumber;
	}

	public RiderLicenceStatus getLicenceStatus() {
		return this.licenceStatus;
	}

	public GregorianCalendar getValidFrom() {
		return this.validFrom;
	}

	public GregorianCalendar getValidTo() {
		return this.validTo;
	}

	public int hashCode() {
		return this.licenceCode.hashCode();
	}

	public RiderLicenceStatus licenceStatus() {
		return this.licenceStatus;
	}

	public void setCategory(LicenceCategory category) {
		this.category = category;
	}

	public void setDisciplin(LicenceDisciplin disciplin) {
		this.disciplin = disciplin;
	}

	public void setExamDate(GregorianCalendar examDate) {
		this.examDate = examDate;
	}

	public void setExamLocation(String examLocation) {
		this.examLocation = examLocation;
	}

	public void setLicenceCode(LicenceCode licenceCode) {
		this.licenceCode = licenceCode;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}
	
	
	public void setLicenceStatus(RiderLicenceStatus licenceStatus) {
		this.licenceStatus = licenceStatus;
	}
	
	public void setValidFrom(GregorianCalendar validFrom) {
		this.validFrom = validFrom;
	}
		
	public void setValidTo(GregorianCalendar validTo) {
		this.validTo = validTo;
	}

	public String toString() {
		
		return getLicenceCode() + " " + getLicenceNumber();
	}

	
}
