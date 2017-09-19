package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Order;

public class OrderTest {

	@Test
	public void testGetDetails() {
		Order order = new Order("tea", 1);
		assertEquals(order.getDetails(), "T:1:0");
	}

}
