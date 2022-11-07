
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagementCompanyTestStudent
{
	Property sampleProperty;
	ManagementCompany mangementCo ; 
	
	@BeforeEach
	public void setUp() throws Exception {
		mangementCo= new ManagementCompany("Railey", "555555555",6);
	}

	@AfterEach
	public void tearDown() throws Exception {
		mangementCo=null;
	}

	@Test
	public void testAddProperty() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);		 
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	//property has been successfully added to index 0
	}
	
	@Test
	public void testGetPropertiesCount() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);		 
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	
		assertEquals(mangementCo.getPropertiesCount(), 1);
	}

/*
	@Test
	public void testToString() {
		assertEquals("Railey,555555555,6,6", mangementCo.toString());
	}
*/

	@Test
	public void testConstructor() {
		ManagementCompany company = new ManagementCompany();
		assertEquals("", company.getName());
		assertEquals("", company.getTaxID());
		assertEquals(0, company.getMgmFeePer());
		assertArrayEquals(new Property[] {null, null, null, null, null}, company.getProperties());
		assertEquals(0, company.getPlot().getX());
		assertEquals(0, company.getPlot().getY());
		assertEquals(10, company.getPlot().getWidth());
		assertEquals(10, company.getPlot().getDepth());
		assertEquals(0, company.getPropertiesCount());
	}

	@Test
	public void testConstructor2() {
		ManagementCompany company = new ManagementCompany("A", "B", 1, 10, 11, 12, 13);
		assertEquals("A", company.getName());
		assertEquals("B", company.getTaxID());
		assertEquals(1, company.getMgmFeePer());
		assertArrayEquals(new Property[] {null, null, null, null, null}, company.getProperties());
		assertEquals(10, company.getPlot().getX());
		assertEquals(11, company.getPlot().getY());
		assertEquals(12, company.getPlot().getWidth());
		assertEquals(13, company.getPlot().getDepth());
		assertEquals(0, company.getPropertiesCount());
	}

	@Test
	public void testCopyConstructor() {
		ManagementCompany company = new ManagementCompany("A", "B", 1, 10, 11, 12, 13);
		ManagementCompany company2 = new ManagementCompany(company);
		assertEquals("A", company2.getName());
		assertEquals("B", company2.getTaxID());
		assertEquals(1, company2.getMgmFeePer());
		assertArrayEquals(new Property[] {null, null, null, null, null}, company2.getProperties());
		assertEquals(10, company2.getPlot().getX());
		assertEquals(11, company2.getPlot().getY());
		assertEquals(12, company2.getPlot().getWidth());
		assertEquals(13, company2.getPlot().getDepth());
		assertEquals(0, company2.getPropertiesCount());
	}

	@Test
	public void testProperty()
	{
		ManagementCompany company = new ManagementCompany();
		assertEquals(-2, company.addProperty(null));
		assertEquals(0, company.addProperty(new Property("A", "B", 1, "C",  1, 1, 1, 1)));
		assertEquals(-4, company.addProperty(new Property("A", "B", 1, "C",  1, 1, 1, 1)));
		assertEquals(1, company.addProperty(new Property("A", "B", 1, "C",  2, 2, 1, 1)));
		assertEquals(-3, company.addProperty(new Property("A", "B", 1, "C",  11, 11, 1, 1)));
		assertEquals(2, company.addProperty(new Property("A", "B", 1, "C",  3, 3, 1, 1)));
		assertEquals(3, company.addProperty(new Property("A", "B", 1, "C",  4, 4, 1, 1)));
		assertEquals(4, company.addProperty(new Property("A", "B", 1, "C",  5, 5, 1, 1)));
		assertEquals(-1, company.addProperty(new Property("A", "B", 1, "C",  6, 6, 1, 1)));
	}

}

