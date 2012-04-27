package jet.hipics21.business.rules.dressage;


public class Figure {
	
	public String number;
	public String location;
	public String description;
	public float coefficient;
	
	public Figure(String number, String location, String description,float coefficient) {
		
		setNumber(number);
		this.location = location;
		this.description = description;
		this.coefficient = coefficient;
	}

	public float getCoefficient() {
		return this.coefficient;
	}

	public String getDescription() {
		return this.description;
	}

	public String getLocation() {
		return this.location;
	}

	public String getNumber() {
		return this.number;
	}

	public void setCoefficient(float coefficient) {
		
		if (coefficient < 1 | coefficient > 4) {
			throw new IllegalArgumentException("coefficient out of bonds: " + coefficient);
		}
		this.coefficient = coefficient;
	}

	public void setDescription(String description) {
		
		assert description != null:"description null";
		
		this.description = description;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setNumber(String number) {
		
		assert number != null:"number null";
		
		this.number = number;
	}
	public String toString() {
		
		return this.getNumber() + " " + this.getLocation() + " " + this.getDescription() + " " + getCoefficient();
	}

	
}
