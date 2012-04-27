package jet.hipics21.business.rules.dressage;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DressageTest {
	
	private Figure figure;
	private List<Figure> figuresList = new ArrayList<Figure>();
	
	@Before
	public void setUp() throws Exception {
		
		figure = new Figure("1", "A-X-C", "En A entrée au trot de travail",1);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertNotNull(figure);
		
		figuresList.add(figure);
		assertEquals(figuresList.size(), 1);
		figure = new Figure("2", "H-X-F", "Changement de main au trot enlevé",1);
		figuresList.add(figure);
		figure = new Figure("3", "E", "Volte à droite diam. 10m",1);
		figuresList.add(figure);
		
		System.out.println(figuresList);
		
	}

}
