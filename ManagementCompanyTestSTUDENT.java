import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {

	ManagementCompany m;
	Property p1, p2, p3, p4, p5, p6;
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		m = new ManagementCompany();
		//student add three properties, with plots, to mgmt co
		p1 = new Property("Hanover Street", "Federal Hill", 1950.0, "Tim", 3, 1, 2, 2);
		p2 = new Property("Washington Street","Fells Point", 1450.0, "Trent", 6, 1, 2, 2);
		p3 = new Property("Nanticoke Street", "Pigtown", 1200.0, "Brenda", 7, 6, 2, 2);
		p4 = new Property("Bourbon Street", "Laurel", 1000.0, "Cathy");
		p5 = new Property("Ladybird Street", "McLean", 4000.0, "Bethany", 3, 6, 2, 2);
		
		
		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
		m.addProperty(p4);
		m.addProperty(p5);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null
		m = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//Added to setup due to scope issues
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		p6 = new Property();
		assertEquals(m.addProperty(p6), -1, 0);
	}
 
	@Test
	public void testMaxRentProp() {
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(m.maxRentProp(), 4000.0, .001);
	}

	@Test
	public void testTotalRent() {
		//student should test if totalRent returns the total rent of properties
		assertEquals(m.totalRent(), 9600.0, .001);
	}

 }
