
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class represents GFA test cases for a Property object.
 *
 * @author Farnaz Eivazi
 * @version 7/11/2022
 */
class PropertyTest
{
	Property propertyOne;

	@BeforeEach
	void setUp() throws Exception {
		propertyOne = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank");
	}

	@AfterEach
	void tearDown() throws Exception {
		propertyOne = null;
	}

	@Test
	void testGetPropertyName() {
		assertEquals("Property ABC", propertyOne.getPropertyName());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(2450.00, propertyOne.getRentAmount());
	}

	@Test
	void testGetPlot() {
		assertEquals(0, propertyOne.getPlot().getX());
		assertEquals(0, propertyOne.getPlot().getY());
		assertEquals(1, propertyOne.getPlot().getWidth());
		assertEquals(1, propertyOne.getPlot().getDepth());
	}

	@Test
	void testToString() {
		assertEquals("Property ABC,Rockville,Wells Fargo Bank,2450.0",propertyOne.toString());	
	}

	@Test
	void testConstructor() {
		Property property = new Property();
		assertEquals("", property.getPropertyName());
		assertEquals("", property.getCity());
		assertEquals(0, property.getRentAmount());
		assertEquals("", property.getOwner());
	}

	@Test
	void testCopyConstructor() {
		Property property = new Property(propertyOne);
		assertEquals("Property ABC", property.getPropertyName());
		assertEquals("Rockville", property.getCity());
		assertEquals(2450.00, property.getRentAmount());
		assertEquals("Wells Fargo Bank", property.getOwner());
	}

	@Test
	void testCopyConstructor2() {
		Property property = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank", 10, 11, 12, 13);
		Property property2 = new Property(property);
		assertEquals("Property ABC", property2.getPropertyName());
		assertEquals("Rockville", property2.getCity());
		assertEquals(2450.00, property2.getRentAmount());
		assertEquals("Wells Fargo Bank", property2.getOwner());
		assertEquals(10, property2.getPlot().getX());
		assertEquals(11, property2.getPlot().getY());
		assertEquals(12, property2.getPlot().getWidth());
		assertEquals(13, property2.getPlot().getDepth());
	}

	@Test
	void testPlot() {
		Property property = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank", 10, 11, 12, 13);
		assertEquals(10, property.getPlot().getX());
		assertEquals(11, property.getPlot().getY());
		assertEquals(12, property.getPlot().getWidth());
		assertEquals(13, property.getPlot().getDepth());
	}


}


