
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class represents GFA test cases for a Plot object.
 * 
 * @author Farnaz Eivazi
 * @version 7/11/2022
 * 
 */
public class PlotTest
{
	private Plot plot1, plot5;

	@BeforeEach
	public void setUp() throws Exception {
		plot1 = new Plot(2, 2, 6, 6);
		plot5 = new Plot(3, 4, 4, 3);
	}

	@AfterEach
	public void tearDown() throws Exception {
		plot1 = plot5 = null;
	}

	@Test
	public void testOverlaps() {
		assertTrue(plot1.overlaps(plot5)); // plot5 is entirely inside plot1
	}
	
	@Test
	public void testToString() {
		assertEquals("3,4,4,3",plot5.toString());	
	}

	@Test
	public void testOverlaps2() {
		Plot plot1 = new Plot(0, 1, 2, 2);
		Plot plot2 = new Plot(2, 3, 2, 2);
		assertFalse(plot1.overlaps(plot2));
	}

	@Test
	public void testOverlaps3() {
		Plot plot1 = new Plot(0, 1, 2, 2);
		Plot plot2 = new Plot(3, 2, 2, 2);
		assertFalse(plot1.overlaps(plot2));
	}

	@Test
	public void testOverlaps4() {
		Plot plot1 = new Plot(1, 1, 2, 2);
		Plot plot2 = new Plot(2, 4, 2, 2);
		assertFalse(plot1.overlaps(plot2));
	}

	@Test
	public void testOverlaps5() {
		Plot plot1 = new Plot(1, 1, 2, 2);
		Plot plot2 = new Plot(2, 2, 2, 2);
		assertTrue(plot1.overlaps(plot2));
	}

	@Test
	public void testOverlaps6() {
		Plot plot1 = new Plot(1, 1, 4, 4);
		Plot plot2 = new Plot(2, 2, 2, 2);
		assertTrue(plot1.overlaps(plot2));
	}

	@Test
	public void testConstructorAndGetter() {
		Plot plot = new Plot(1, 2, 3, 4);
		assertEquals(1, plot.getX());
		assertEquals(2, plot.getY());
		assertEquals(3, plot.getWidth());
		assertEquals(4, plot.getDepth());
	}

	@Test
	public void testConstructorAndGetter2() {
		Plot plot = new Plot();
		assertEquals(0, plot.getX());
		assertEquals(0, plot.getY());
		assertEquals(1, plot.getWidth());
		assertEquals(1, plot.getDepth());
	}

	@Test
	public void testSetter() {
		Plot plot = new Plot();
		plot.setX(3);
		plot.setY(4);
		plot.setWidth(5);
		plot.setDepth(6);
		assertEquals(3, plot.getX());
		assertEquals(4, plot.getY());
		assertEquals(5, plot.getWidth());
		assertEquals(6, plot.getDepth());
	}

	@Test
	public void testEncompasses1() {
		Plot plot1 = new Plot(1, 1, 2, 2);
		Plot plot2 = new Plot(2, 4, 2, 2);
		assertFalse(plot1.encompasses(plot2));
	}

	@Test
	public void testEncompasses2() {
		Plot plot1 = new Plot(1, 1, 2, 2);
		Plot plot2 = new Plot(2, 2, 2, 2);
		assertFalse(plot1.encompasses(plot2));
	}

	@Test
	public void testEncompasses3() {
		Plot plot1 = new Plot(1, 1, 4, 4);
		Plot plot2 = new Plot(2, 2, 2, 2);
		assertTrue(plot1.encompasses(plot2));
	}

	@Test
	public void testEncompasses4() {
		Plot plot1 = new Plot(2, 2, 2, 2);
		Plot plot2 = new Plot(1, 1, 4, 4);
		assertFalse(plot1.encompasses(plot2));
	}

	@Test
	public void testConstructor2() {
		Plot plot1 = new Plot(1, 2, 3, 4);
		Plot plot2 = new Plot(plot1);
		assertEquals(1, plot2.getX());
		assertEquals(2, plot2.getY());
		assertEquals(3, plot2.getWidth());
		assertEquals(4, plot2.getDepth());
	}

}



