package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Database;
import model.Order;

public class DatabaseTest {
	
	private Database db = Database.getInstance();

	@Before
	public void initEach(){
	    db.getOrders().clear();
	}

	@Test
	public void testUniqueInstance() {
		Database db1 = Database.getInstance();
		Database db2 = Database.getInstance();
		assertEquals(db1, db2);
	}

	@Test
	public void testAddOrder() {
		db.addOrder(new Order(null, 0));
		assertEquals(db.getOrders().size(), 1);
	}

	@Test
	public void testGetReportWithoutAnyOrder() {
		assertEquals("Café 0\nChocolat 0\nJus d'orange 0\nThé 0\nTotal 0€", db.getReport());
	}

}