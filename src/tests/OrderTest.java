package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Order;

public class OrderTest {

	@Test
	public void testGetDetails() {
		Order order = new Order("T", 1);
		assertEquals(order.getDetails(), "T:1:0");
	}

	@Test
	public void testGetDetailsWithoutAnySugar() {
		Order order = new Order("H", 0);
		assertEquals(order.getDetails(), "H::");
	}

}
