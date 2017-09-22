package model;

import java.util.ArrayList;

/** 
 * Pris sur développez.com
 * Pas de prise en compte du multithreading
 */

public class Database {

	private ArrayList<Order> orders;

	public static Database getInstance() {
		if (null == instance) {
			instance = new Database();
		}
		return instance;
	}

	private Database() {
		this.orders = new ArrayList<Order>();
	}

	private static Database instance;
	
	
	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void addOrder(Order o) {
		this.orders.add(o);
	}

	public String getReport() {
		StringBuilder reportBuilder = new StringBuilder();
		int teas = 0;
		int chocolates = 0;
		int coffees = 0;
		int orangeJuices = 0;
		int total = 0;

		for (Order o : this.orders) {
			String type = o.getDrinkType();
			float price = o.getPrice();
			
			switch(type) {
				case "C": coffees += 1; break;
				case "H": chocolates += 1; break;
				case "O": orangeJuices += 1; break;
				case "T": teas += 1; break;
			}
			
			total += price;
		}

		reportBuilder.append("Café ").append(coffees).append("\n");
		reportBuilder.append("Chocolat ").append(chocolates).append("\n");
		reportBuilder.append("Jus d'orange ").append(orangeJuices).append("\n");
		reportBuilder.append("Thé ").append(teas).append("\n");
		reportBuilder.append("Total ").append(total).append("€");
		
		return reportBuilder.toString();
	}

}






























