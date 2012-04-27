package jet.hipics21.business.address;

public class Address {
	
	private String line1;
	private String line2;
	private String line3;
	private String postNumber;
	private String town;
	private String county;
	private String country;

	public Address() {
		
	}

	public String getCountry() {
		return this.country;
	}

	public String getCounty() {
		return this.county;
	}

	public String getLine1() {
		return this.line1;
	}

	public String getLine2() {
		return this.line2;
	}

	public String getLine3() {
		return this.line3;
	}

	public String getPostNumber() {
		return this.postNumber;
	}

	public String getTown() {
		return this.town;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public void setLine3(String line3) {
		this.line3 = line3;
	}

	public void setPostNumber(String postNumber) {
		this.postNumber = postNumber;
	}

	public void setTown(String town) {
		this.town = town;
	}
	
	

}
