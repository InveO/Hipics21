package jet.hipics21.business.rules.dressage;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;


public class DressageTestDetails {
	
	public Dimension arenaDimension;
	public List<Figure> figureList = new ArrayList<Figure>();
	public DRESSAGE_PROGRAM programName;
	
	
	public DressageTestDetails(DRESSAGE_PROGRAM programName) {
	 
		if (programName ==  null) {
			throw new NullPointerException();
		}
		synchronized (programName) {
			if (programName.getDressageTestDetails() != null) {
				throw new IllegalArgumentException("programName " + programName + " already has DressageTestDetails attributed to it");
			}
			
			programName.setDressageTestDetails(this);
			this.programName = programName;
			
		}
		
	}

	public void addFigure(Figure figure) {
		assert figure!= null:"figure null";

		this.figureList.add(figure);
		
	}
	
	public void removeFigure(int figureNumber) {
		if (figureNumber < 0) {
			throw new IllegalArgumentException("figure number illegal : " + figureNumber);
		}
		
		this.figureList.remove(figureNumber);
	}

}
