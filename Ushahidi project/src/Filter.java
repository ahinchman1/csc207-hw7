package edu.grinnell.glimmer.ushahidi
import java.util.Vector;
import java.io.PrintWriter;

public class Filter {
	public static void main(String args[]){
		
		Vector incident = new Vector;
		//instance represents some new element of the Vector
		incident.add(instance);
		incident.add(instance2);
		incident.add(instance3);
		
	}//main(String[])
	
	public filterByLocation (Vector incident)
	{
		Printwriter pen = new PrinterWriter(System.out, true);
		Scanner input = new Scanner(System.in);
		int numberOfElementsInVec = incident.size;
		String wish;
		
		pen.println("Type in the name of the location you wish to view");
		
		wish = input.next();
		
		for (int i = 0; i < numberOfElementsInVec; i++)
		{
			if (input.compareTo(incident.getLocation)
					{
						pen.println(incident.get(i));
					}// if
		} // while
	}// filterByLocation(Vector)
	
	public filterByDate (Vector incident)
	{
		Printwriter pen = new PrinterWriter(System.out, true);
		Scanner input = new Scanner(System.in);
		int numberOfElementsInVec = incident.size;
		
		pen.println("Type in the name of the date of incident(s) you "
				+ "wish to view");
		
		wish = input.next();
		
		for (int i = 0; i < numberOfElementsInVec; i++)
		{
			if (input.compareTo(incident.getDate)
					{
						pen.println(incident.get(i));
					}// if
		} // while
	}// filterByDate(Vector)
	
	public filterByStatus (Vector incident)
	{
		Printwriter pen = new PrinterWriter(System.out, true);
		Scanner input = new Scanner(System.in);
		int numberOfElementsInVec = incident.size;
		
		pen.println("Type in the name of the status you wish to view");
		
		wish = input.next();
		
		for (int i = 0; i < numberOfElementsInVec; i++)
		{
			if (input.compareTo(incident.getStatus)
					{
						pen.println(incident.get(i));
					}// if
		} // while
	}// filterByStatus(Vector)
}// class Filter
