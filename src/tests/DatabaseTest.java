package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Database;

public class DatabaseTest {

	@Test
	public void testUniqueInstance() {
		Database db1 = Database.getInstance();
		Database db2 = Database.getInstance();
		assertEquals(db1, db2);
	}

}