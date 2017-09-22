package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Database;
import model.Order;

public class DatabaseTest {

	@Test
	public void testUniqueInstance() {
		Database db1 = Database.getInstance();
		Database db2 = Database.getInstance();
		assertEquals(db1, db2);
	}

	@Test
	public void testAddOrder() {
		Database db = Database.getInstance();
		db.addOrder(new Order(null, 0));
		assertEquals(db.getOrders().size(), 1);
	}

}