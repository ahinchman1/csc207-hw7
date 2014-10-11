package edu.grinnell.glimmer.ushahidi
import java.io.PrintWriter;

public class UshahidiExtensions {

		public static printIncident(PrintWriter pen, UshahidiIncident())
		{
			String title = UshahidiIncident.getTitle();
			String description = UshahidiIncident.getDescription();
			String location = UshahidiIncident.getLocation();
			String status = UshahidiIncident.getActive();
			PrintWriter pen = new PrintWriter(System.out, true);
			
			pen.println("Incident #: " + title);
			pen.println(description);
			pen.println("Location: " + location);
			pen.println("Status: (" + status + ")");
		}
}
