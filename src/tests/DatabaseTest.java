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
		assertEquals("Café 0\nChocolat 0\nJus d'orange 0\nThé 0\nTotal 0.0€", db.getReport());
	}

	@Test
	public void testGetReportWithOrders() {
		db.addOrder(new Order("T", true, 2, new Float(0.4), new Float(0.4)));
		db.addOrder(new Order("H", true, 1, new Float(0.5), new Float(0.5)));
		db.addOrder(new Order("O", 0, new Float(0.6), new Float(0.6)));
		db.addOrder(new Order("C", 0, new Float(0.6), new Float(0.6)));
		db.addOrder(new Order("H", 2, new Float(0.5), new Float(0.5)));
		db.addOrder(new Order("T", 2, new Float(0.4), new Float(0.4)));
		db.addOrder(new Order("C", true, 0, new Float(0.6), new Float(0.6)));
		db.addOrder(new Order("T", 1, new Float(0.5), new Float(0.5)));
		assertEquals("Café 2\nChocolat 2\nJus d'orange 1\nThé 3\nTotal 4.1€", Database.getInstance().getReport());
	}

}