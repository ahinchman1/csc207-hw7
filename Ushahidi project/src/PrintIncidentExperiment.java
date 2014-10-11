package edu.grinnell.glimmer.ushahidi

public class PrintIncidentExperiment {
	 public static void main(String[] args) 
		      throws Exception
		    {
		      // Create the output device
		      PrintWriter pen = new PrintWriter(System.out, true);

		      // A few basic incidents
		      UshahidiExtensions.printIncident(pen, UshahidiUtils.SAMPLE_INCIDENT);
		      UshahidiExtensions.printIncident(pen, UshahidiUtils.randomIncident());
		      UshahidiExtensions.printIncident(pen, UshahidiUtils.randomIncident());

		      // A newly created incident
		      UshahidiIncident myIncident = new UshahidiIncident(disaster, 10, location, description));
		      UshahidiExtensions.printIncident(pen, myIncident);

		      // One from a list
		      UshahidiClient client = UshahidiUtils.SAMPLE_CLIENT;
		      UshahidiExtensions.printIncident(pen, client.nextIncident());

		      // One that requires connecting to the server
		      UshahidiClient webclient = new UshahidiWebClient(URL);
		      UshahidiExtensions.printIncident(pen, webclient.nextIncident());
		    } // main(String[])
	
}
