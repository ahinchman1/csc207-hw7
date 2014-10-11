package edu.grinnell.csc207.gaocharl17.layout;
import java.io.PrintWriter;

public class testClass {
	public static void main(String[] args) {

		PrintWriter pen = new PrintWriter(System.out,true);
		TextLine tb1 = new TextLine("Hello");
		TextLine tb2 = new TextLine("World");
		TextBlock compound = new BoxedBlock(new CenteredBlock(new BoxedBlock(
				new CenteredBlock(new VComposition(tb1, tb2), 7)), 15));
		pen.println("ORIGINAL");
		TBUtils.print(pen, compound);
		
		tb2.setContents("Someone");
		pen.println("UPDATED");
		TBUtils.print(pen, compound);
		tb1.setContents("Nice to meet you,");
		pen.println("RE-UPDATED");
		TBUtils.print(pen, compound);
	}// main(String[])

}// class testClass
