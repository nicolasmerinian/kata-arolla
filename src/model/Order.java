package model;

public class Order {

	private String drinkType;
	private int sugarNumber;
	private String message;

	public Order(String drinkType, int sugarNumber) {
		this.drinkType = drinkType;
		this.sugarNumber = sugarNumber;
	}

	public Order(String drinkType, int sugarNumber, String message) {
		this(drinkType, sugarNumber);
		this.message = message;
	}

	public Object getDetails() {
		String details = "";
		if (this.sugarNumber == 0) {
			details = this.drinkType + "::";
		}
		else {
			details = this.drinkType + ":" + this.sugarNumber + ":0";
		}
		return details;
	}

	public String getMessage() {
		return this.message;
	}

}
