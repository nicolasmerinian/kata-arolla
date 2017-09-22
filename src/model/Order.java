package model;

public class Order {

	private String drinkType;
	private int sugarNumber;
	private float price;
	private float amount;

	public Order(String drinkType, int sugarNumber) {
		this.drinkType = drinkType;
		this.sugarNumber = sugarNumber;
	}

	public Order(String drinkType, int sugarNumber, float price, float amount) {
		this(drinkType, sugarNumber);
		this.price = price;
		this.amount = amount;
	}

	public Object getDetails() {
		String details = "";

		if (this.sugarNumber == 0) {
			details = this.drinkType + "::";
		} else {
			details = this.drinkType + ":" + this.sugarNumber + ":0";
		}

		return details;
	}

	public String getMessage() {
		float delta = this.amount - this.price;
		return delta < 0 ? this.formatPrice(Math.abs(delta)) : "";
	}
	
	private String formatPrice(Float price) {
		return price + "0";
	}

}
