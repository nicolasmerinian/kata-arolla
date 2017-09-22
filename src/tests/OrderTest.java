package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Order;

public class OrderTest {

	@Test
	public void testNoMoney() {
		Order order = new Order("T", 1, new Float(0.4), new Float(0));
		assertEquals("T:1:0", order.getDetails());
		assertEquals("0.40", order.getMessage());
	}

	@Test
	public void testNoChangeToBeGiven() {
		Order order = new Order("T", 2, new Float(0.4), new Float(0.4));
		assertEquals("T:2:0", order.getDetails());
		assertEquals("", order.getMessage());
	}

	@Test
	public void testTooMuchMoney() {
		Order order = new Order("C", 3, new Float(0.6), new Float(0.9));
		assertEquals("C:3:0", order.getDetails());
		assertEquals("", order.getMessage());
	}

	@Test
	public void testReallyTooMuchMoney() {
		Order order = new Order("H", 1, new Float(0.5), new Float(1.00));
		assertEquals("H:1:0", order.getDetails());
		assertEquals("", order.getMessage());
	}

	@Test
	public void testNotEnoughMoney() {
		Order order = new Order("H", 2, new Float(0.5), new Float(0.2));
		assertEquals("H:2:0", order.getDetails());
		assertEquals("0.30", order.getMessage());
	}

	@Test
	public void testNoSugarButWithEnoughMoney() {
		Order order = new Order("C", 0, new Float(0.6), new Float(0.7));
		assertEquals("C::", order.getDetails());
		assertEquals("", order.getMessage());
	}

	@Test
	public void testWithNeitherSugarOrEnoughMoney() {
		Order order = new Order("C", 0, new Float(0.6), new Float(0.1));
		assertEquals("C::", order.getDetails());
		assertEquals("0.50", order.getMessage());
	}

}
