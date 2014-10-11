package com.farevee.groceries;

public class NonFood implements Item{
	String name;
	Weight weight;
	int price;
	
	public NonFood(String name, Weight weight, int price)
	{
		this.name = name;
		this.weight = weight;
		this.price = price;
	}
	
	public Weight getWeight(){
		return weight;
	}
	
	public int getPrice(){
		return price;
	}
	
	public String toString()
	{
		return name;
	}
	
	public boolean equals(NonFood other)
	{
		return (weight.equals(other.getWeight()) && name.equals(other.toString()) && price == other.getPrice());
	}

}
