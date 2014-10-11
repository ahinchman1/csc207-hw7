package com.farevee.shopping;

import java.util.ArrayList;
import java.io.PrintWriter;

import com.farevee.groceries.*;
import com.farevee.groceries.Package;

public class Cart
{
  //constructor
  ArrayList<Item> items = new ArrayList<Item>(0);

  //add item to cart
  public void addItem(Item i)
  {
    items.add(i);
  }// addItem(Item)

  //count the number of entries made
  public int numEntries()
  {
    return items.size();
  }// numEntries()

  // count the amount of things there are.  If multiple packages, count how
  // many packages there are
  public int numThings()
  {
    int count = 0;
    for (Item i : items)
      {
        if (i instanceof ManyPackages)
          {
            ManyPackages p = (ManyPackages) i;
            count += p.getCount();
          }// if
        else
          {
            count++;
          }// else
      }// for
    return count;
  }// numThings()

  //print what is in the shopping cart
  public void printContents(PrintWriter pen)
  {
    for (Item i : items)
      {
        pen.println(i.toString());
      }// for
  }// printContents(PrintWriter)

  //get the total price of the shopping cart.
  public int getPrice()
  {
    int price = 0;
    for (Item i : items)
      {
        price += i.getPrice();
      }
    return price;
  }//getPrice()

  // get the total weight of the cart
  public Weight[] getWeight()
  {
    Weight gramWeight = new Weight(Units.GRAM, 0);
    Weight ounceWeight = new Weight(Units.OUNCE, 0);
    Weight kilogramWeight = new Weight(Units.KILOGRAM, 0);
    Weight poundWeight = new Weight(Units.POUND, 0);
    //combine all these units if they match.
    for (Item i : items)
      {
        Weight currentWeight = i.getWeight();
        if (currentWeight.unit.equals(Units.GRAM))
          {
            gramWeight =
                new Weight(Units.GRAM, currentWeight.amount + gramWeight.amount);
          }// if
        if (currentWeight.unit.equals(Units.OUNCE))
          {
            ounceWeight =
                new Weight(Units.OUNCE, currentWeight.amount
                                        + ounceWeight.amount);
          }// if
        if (currentWeight.unit.equals(Units.KILOGRAM))
          {
            kilogramWeight =
                new Weight(Units.KILOGRAM, currentWeight.amount
                                           + kilogramWeight.amount);
          }// if
        if (currentWeight.unit.equals(Units.POUND))
          {
            poundWeight =
                new Weight(Units.POUND, currentWeight.amount
                                        + poundWeight.amount);
          }// if
      }// for

    ArrayList<Weight> outputArrayList = new ArrayList<Weight>(0);
    if (gramWeight.amount > 0)
      outputArrayList.add(gramWeight);
    if (ounceWeight.amount > 0)
      outputArrayList.add(ounceWeight);
    if (kilogramWeight.amount > 0)
      outputArrayList.add(kilogramWeight);
    if (poundWeight.amount > 0)
      outputArrayList.add(poundWeight);
    //^if these values exist

    Weight[] output = (Weight[]) outputArrayList.toArray();

    return output;
  }// getWeight()

  public void remove(String name)
  {
    for (Item i : items)
      {
        if (i.toString().equals(name))
          {
            items.remove(i);
          }
      }
  }

  public void merge()
  {
    // Items that can be merged: BulkItem, Package, ManyPackages

    ArrayList<Item> mergedItems = new ArrayList<Item>(0);

    for (Item i : items)
      {
        //BulkItem
        if (i instanceof BulkItem)
          {
            BulkItem i_bulkItem = (BulkItem) i;
            boolean foundMatch = false;
            for (Item j : mergedItems)
              {
                if (j instanceof BulkItem)
                  {
                    BulkItem j_bulkItem = (BulkItem) j;
                    if (i_bulkItem.getFood().equals(j_bulkItem.getFood())
                        && (i_bulkItem.getWeight().unit).equals
                        (j_bulkItem.getWeight().unit))
                      {
                        mergedItems.add((Item) new BulkItem(
                                                            i_bulkItem
                                                            .getFood(),
                                                            i_bulkItem
                                                            .getWeight()
                                                            .amount
                                                            + j_bulkItem
                                                            .getWeight()
                                                            .amount));
                        items.remove(i);
                        foundMatch = true;
                      }// if 
                  }// if
              }// for
            if (!foundMatch)
              {
                mergedItems.add(i);
              }// if
          }
        //Packages
        if (i instanceof Package || i instanceof ManyPackages)
          {
            ManyPackages convertedPackage;
            if (i instanceof Package)
              { //make it into a ManyPackages with a count of 1 anyways #yolo
                convertedPackage = new ManyPackages((Package) i, 1);
              }// if
            else
              {
                convertedPackage = (ManyPackages) i;
              }// else
            boolean foundMatch = false;
            for (Item j : mergedItems)
              {
                if (j instanceof Package || j instanceof ManyPackages)
                  {
                    ManyPackages convertedPackage2;
                    if (j instanceof Package)
                      { //make it into a ManyPackages with a count of 1
                        convertedPackage2 = new ManyPackages((Package) j, 1);
                      }// if
                    else
                      {
                        convertedPackage2 = (ManyPackages) j;
                      }// else
                    if (convertedPackage.getPackage()
                                        .equals(convertedPackage2
                                                .getPackage()))
                      {
                        mergedItems.add((Item) 
                                        new ManyPackages( 
                                                    convertedPackage
                                                    .getPackage(),
                                                    convertedPackage
                                                    .getCount()
                                                  + convertedPackage2
                                                  .getCount()));
                        items.remove(i);
                        foundMatch = true;
                      }// if 
                  }// if
              }// for
            if (!foundMatch)
              {
                mergedItems.add(i);
              }// if 

          }// if
        else
          mergedItems.add(i);
      }// for
  }// merge()
}// class Cart
