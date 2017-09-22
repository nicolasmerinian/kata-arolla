package model;

public class Order implements EmailNotifier, BeverageQuantityChecker {

	private String drinkType;
	private boolean extraHot;
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

	public Order(String drinkType, boolean extraHot, int sugarNumber, float price, float amount) {
		this(drinkType, sugarNumber, price, amount);
		this.extraHot = extraHot;
	}

	public String getDrinkType() {
		return this.drinkType;
	}

	public float getPrice() {
		return this.price;
	}

	public Object getDetails() {
		String details = this.drinkType;
		
		if (this.extraHot) {
			details += "h";
		}

		if (this.sugarNumber == 0) {
			details += "::";
		} else {
			details += ":" + this.sugarNumber + ":0";
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

	@Override
	public boolean isEmpty(String drink) {
		return false;
	}

	@Override
	public void notifyMissingDrink(String drink) {
		
	}

}
