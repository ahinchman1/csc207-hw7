package edu.grinnell.csc207.gaocharl17.layout;
import java.util.Arrays;

public class Grid implements TextBlock{
	//Fields
	private int width;
	private int height;
	private char ch;
	
	//Constructor
	public Grid(int width, int height, char ch)
	{
		this.width = width;
		this.height = height;
		this.ch = ch;
	}//Grid(int, height, char)
	
	//Methods
	public int width()
	{
		return width;
	}// width()
	
	public int height()
	{
		return height;
	}// height()
	
	public String row(int i) throws Exception
	{
		
		if(i >= 0 && i < height && width > 0)
		{
			//efficent string generation method thanks to: http://stackoverflow.com/questions/1802915
			///java-create-a-new-string-instance-with-specified-length-and-filled-with-specif
			char[] outArray = new char[width];
			Arrays.fill(outArray, ch);
			return new String(outArray);
		}//if

		throw new Exception("Invalid row: " + i);
	}// row(int)
}//class Grid
