package model;

public class Order {

	private String drinkType;
	private int sugarNumber;

	public Order(String drinkType, int sugarNumber) {
		this.drinkType = drinkType;
		this.sugarNumber = sugarNumber;
	}

	public Object getDetails() {
		return this.drinkType + ":" + this.sugarNumber + ":0";
	}

}
