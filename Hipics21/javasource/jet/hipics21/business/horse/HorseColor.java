package jet.hipics21.business.horse;

public enum HorseColor {

	GRAY("gr","gray"), CHESTNUT("ch","chestnut"), BAY("b","bay"), BLACK("bl","black");
	
	private final String shortName;
	private final String longName;
	
	private HorseColor (final String shortName, final String longName) {
		this.shortName = shortName;
		this.longName = longName;
	}
	

}
