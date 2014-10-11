package com.farevee.groceries;

public class BulkFood{
	String name;
	Units unit;
	int pricePerUnit;
	int supply;
	
	public BulkFood(String name, Units unit, int pricePerUnit, int supply)
	{
		this.name = name;
		this.unit = unit;
		this.pricePerUnit = pricePerUnit;
		this.supply = supply;
	}
	
	public int getPricePerUnit(){
		return pricePerUnit;
	}
	
	public Units getUnit(){
		return unit;
	}

	public int getSupply(){
		return supply;
	}
	
	public String toString(){
		return name;
		
	}
}
