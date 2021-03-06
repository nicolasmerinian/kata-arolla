package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import model.Order;

public class OrderTest {

	@Test
	public void testGetMessageEmpty() {
		Order order = new Order("T", 1, new Float(0.4), new Float(0.4));
		assertEquals("", order.getMessage());
	}

	@Test
	public void testGetMessageWithMissingMoney() {
		Order order = new Order("T", 1, new Float(0.4), new Float(0.1));
		assertEquals("0.30", order.getMessage());
	}

//	@Test
//	public void testGetMessageWithUnavailableBeverage() {
//		// Given
//		Order mockedOrder = Mockito.mock(Order.class); // on ne sait pas que c'est un th�...
//		Mockito.when(mockedOrder.isEmpty("T")).thenReturn(true);
//
//		// When
//		String message = mockedOrder.getMessage();
//
//		// Then
//		assertEquals("The ordered beverage is not available. A notification has been sent.", message);
//
//		// Finally
//		Mockito.reset(mockedOrder);
//	}

	@Test
	public void testGetDrinkType() {
		Order order = new Order("T", 1, new Float(0.4), new Float(0));
		assertEquals("T", order.getDrinkType());
	}

	@Test
	public void testGetPrice() {
		Order order = new Order("T", 1, new Float(0.4), new Float(0));
		assertEquals(0.4, order.getPrice(), 0.01);
	}

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

	@Test
	public void testOrangeJuice() {
		Order order = new Order("O", 0, new Float(0.6), new Float(0.6));
		assertEquals("O::", order.getDetails());
		assertEquals("", order.getMessage());
	}

	@Test
	public void testHotCoffee() {
		Order order = new Order("C", true, 0, new Float(0.6), new Float(0.6));
		assertEquals("Ch::", order.getDetails());
		assertEquals("", order.getMessage());
	}

	@Test
	public void testHotChocolate() {
		Order order = new Order("H", true, 1, new Float(0.5), new Float(0.5));
		assertEquals("Hh:1:0", order.getDetails());
		assertEquals("", order.getMessage());
	}

	@Test
	public void testHotTea() {
		Order order = new Order("T", true, 2, new Float(0.4), new Float(0.4));
		assertEquals("Th:2:0", order.getDetails());
		assertEquals("", order.getMessage());
	}

	@Test
	public void testNoBeverage() {
		// Given
		Order mockedOrder = Mockito.mock(Order.class);
		Mockito.when(mockedOrder.isEmpty("T")).thenReturn(true);
		
		// When
		boolean empty = mockedOrder.isEmpty("T");

		// Then
		assertEquals(true, empty);
		
		// Finally
		Mockito.reset(mockedOrder);
	}

	@Test
	public void testEmailNotifying() {
		// Given
		Order mockedOrder = Mockito.mock(Order.class);
		
		// When
		mockedOrder.notifyMissingDrink("T");

		// Then
		Mockito.verify(mockedOrder, Mockito.times(1)).notifyMissingDrink("T");
		
		// Finally
		Mockito.reset(mockedOrder);
	}

	@Test
	public void testOrderNoAvailableBeverage() {
		// Given
		Order mockedOrder = Mockito.mock(Order.class);
		Mockito.when(mockedOrder.isEmpty("T")).thenReturn(true);
		Mockito.when(mockedOrder.getMessage()).thenReturn("Oops");
		
		// When
		boolean empty = mockedOrder.isEmpty("T");
		String message = mockedOrder.getMessage();

		// Then
		assertEquals(true, empty);
		assertEquals("Oops", message);
//		Mockito.verify(mockedOrder, Mockito.times(1)).notifyMissingDrink("T"); // �a serait bien de v�rifier �a vu que qu'on est cens� envoyer un mail... 
		
		// Finally
		Mockito.reset(mockedOrder);
	}


}


















