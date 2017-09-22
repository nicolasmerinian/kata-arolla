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

}