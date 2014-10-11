package com.farevee.groceries;

public class BulkItem {
	BulkFood food;
	Units unit;
	int amount;
	
	public BulkItem(BulkFood food, int amount)
	{
		this.food = food;
		this.unit = food.getUnit();
		this.amount = amount;
	}
	
	public int getPrice(){
		return food.getPricePerUnit() * amount;
	}
	
	public Weight getWeight(){
		return new Weight(unit,amount);
	}
	
	public String toString(){
		if(amount == 1) return (amount + " " + unit.toString() + " of " + food.toString());
		else return (amount + " " + unit.plural() + " of " + food.toString());
	}
	
	public boolean equals(BulkItem other){
		return (this.toString().equals(other.toString()));
	}

}
