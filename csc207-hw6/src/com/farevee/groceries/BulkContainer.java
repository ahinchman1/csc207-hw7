package com.farevee.groceries;

public class BulkContainer extends BulkItem implements Item {
	String container;
	
	public BulkContainer(BulkFood food, int amount, String container)
	{
		super(food, amount);
		this.container = container;
	}
	
	@Override
	public Weight getWeight() {
		return super.getWeight();
	}

	@Override
	public int getPrice() {
		return super.getPrice();
	}
	
	public String toString(){
		return container + " of " + super.toString();
	}
	
	public boolean equals(BulkContainer other){
		return(this.toString().equals(other.toString()));
	}

}
