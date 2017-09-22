package model;

public class Order implements EmailNotifier, BeverageQuantityChecker {

	private String drinkType;
	private boolean extraHot;
	private int sugarNumber;
	private float price;
	private float amount;

	public Order(String drinkType, int sugarNumber, float price, float amount) {
		this.drinkType = drinkType;
		this.sugarNumber = sugarNumber;
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
		StringBuilder details = new StringBuilder();
		details.append(this.drinkType);
		
		if (this.extraHot) {
			details.append("h");
		}

		details.append(":");

		if (this.sugarNumber == 0) {
			details.append(":");
		} else {
			details.append(this.sugarNumber);
			details.append(":0");
		}

		return details.toString();
	}

	public String getMessage() {
		if (this.isEmpty(this.drinkType)) {
			return "The ordered beverage is not available. A notification has been sent.";
		}
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
