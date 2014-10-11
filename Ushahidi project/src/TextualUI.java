package edu.grinnell.glimmer.ushahidi
import java.io.PrintWriter;
import java.io.Scanner;

public class TextualUI {
	public static void main(String args[]){
		Vector notedUshahidi = new Vector();
		PrintWriter pen = new PrintWriter(System.out, true);
		Scanner input = new Scanner(System.in);
		int numberOfElementsInVec = incident.size;
		String option;
		String description;
		
		pen.println("Welcome to Ushahidi.  What do you wish to do?");
		
		pen.println("Add an incident. [Add]");
		pen.println("View an incident. [View]");
		pen.println("Delete an incident. [Delete]");
		
		option = input.next(); 
		//credit to http://www.homeandlearn.co.uk/java/user_input.html
		// for the brush up.
		
		if (input.compareTo("Add"))
		{
			pen.println("Please type in the name of the incident along with the attributes including a "
					+ "description, location, and status.");
			
			description = input.next();
			
			pen.println(noteUshahidi.add(description));
			
		}// if
		else if (input.compareTo("View"))
		{
			pen.println("Which incident do you wish to view?");
			
			description = input.next();
			
			for (int i = 0; i < numberOfElementsInVec; i++)
			{
				if (input.compareTo(incident.getLocation)
						{
							pen.println(noteUshahidi.get(i));
						}// if
			} // while
		}// else if
		else if (input.compareTo("Delete"))
		{
			pen.println("Which incident do you wish to delete?");
			
			description = input.next();
			
			for (int i = 0; i < numberOfElementsInVec; i++)
			{
				if (input.compareTo(incident.getLocation)
						{
							noteUshahidi.remove(i);
							pen.println(noteUshahidi);
						}// if
			} // while
		}// else if
		else pen.println("Try again...");
		
	}// main(String[])

}// class TextualUI
