package com.farevee.groceries;

public class Package implements Item {
	public String name;
	public Weight weight;
	public int price;
	
	public Package(String name, Weight weight, int price)
	{
		this.name = name;
		this.weight = weight;
		this.price = price;
	}
	
	public Weight getWeight()
	{
		return weight;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public String toString()
	{
		return weight.amount + " " + weight.unit.abbrev() + " package of " + name;
	}
	
	public boolean equals(Package other)
	{
		return (name.equals(other.name) && weight.equals(other.getWeight()) && price == other.getPrice());
	}
}
