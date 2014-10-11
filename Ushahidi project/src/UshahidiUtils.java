import org.json.*;

import edu.grinnell.glimmer.ushahidi.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.Vector;


public class UshahidiUtils{
	//Extra 1
	public void printIncidentsDateRange(UshahidiClient client, LocalDateTime startDate, LocalDateTime endDate) throws Exception
	{
		while(client.hasMoreIncidents())
		{
			UshahidiIncident currentIncident = client.nextIncident();
			if(currentIncident.getDate().isBefore(endDate) && currentIncident.getDate().isAfter(startDate))
			{
				System.out.println(currentIncident.toString());
			}
		}
	}
	
	//Extra 2
	public UshahidiIncident[] returnAllIncidentsDateRange(UshahidiClient client, LocalDateTime startDate, LocalDateTime endDate) throws Exception
	{
		ArrayList<UshahidiIncident> incidents = new ArrayList<UshahidiIncident>(0);
		
		while(client.hasMoreIncidents())
		{
			UshahidiIncident currentIncident = client.nextIncident();
			if(currentIncident.getDate().isBefore(endDate) && currentIncident.getDate().isAfter(startDate))
			{
				incidents.add(currentIncident);
			}
		}
		
		UshahidiIncident[] returnIncidents = (UshahidiIncident[]) incidents.toArray();
		return returnIncidents;
	}
	
	public Vector<UshahidiIncident> filterIncidentsByProximity(Vector<UshahidiIncident> incidents, double latitude, double longitude, double distance)
	{
		Vector<UshahidiIncident> outputVector = new Vector<UshahidiIncident>(0);
		// could use the removeIf function on incidents vector, but would be harder to code a proper predicate mechanism... maybe some other time.
		for(UshahidiIncident incident : incidents)
		{
			// distance calculator from: http://www.movable-type.co.uk/scripts/latlong.html
			double incidentLat = incident.getLocation().getLatitude();
			double incidentLong = incident.getLocation().getLongitude();
			double f1 = Math.toRadians(incidentLat);
			double f2 = Math.toRadians(latitude);
			double dl = Math.toRadians(longitude - incidentLong);
			double R = 6371; //assume distance is in km or something
			double distanceBetweenPoints = Math.acos(Math.sin(f1)*Math.sin(f2) + Math.cos(f1)*Math.cos(f2)*Math.cos(dl))*R;
			
			if(distanceBetweenPoints >= distance) outputVector.add(incident);
		}
		return outputVector;
	}
	
	
}