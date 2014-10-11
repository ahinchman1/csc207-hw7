package edu.grinnell.csc207.gaocharl17.layout;

import java.util.Arrays;

public class RightJustified implements TextBlock {
	
	private TextBlock _contents;
	private int width;
	/**
	 * Create a new truncated block of the specified width.
	 */
	public RightJustified(TextBlock tb, int width)
	{
		this._contents = tb;
		this.width = width;
	} // RightJustified(TextBlock, int)

	/**
	 * Get the ith row of the block.
	 */
	public String row(int i) throws Exception
	{
		//check if justification is possible
		if((width - _contents.width()) < 0)
		{
			throw new Exception("Invalid width to justify in: " + width);
			//check if matching odd/even
		}
		
		//make spacer
		int spacerLength = (width - _contents.width());
		char[] spacerArray = new char[spacerLength];
		Arrays.fill(spacerArray, ' ');
		String spacer = new String(spacerArray);
		
		if(i >= 0 && i < _contents.height() && _contents.width() > 0)
		{
			return spacer + _contents.row(i);
		}
		
		throw new Exception("Invalid row: " + i);
	}	 // row(int)

	/**
	 * Determine how many rows are in the block.
	 */
	public int height()
	{
		return _contents.height();
	} // height()

	/**
	 * Determine how many columns are in the block.
	 */
	public int width()
	{
		return width;
	} // width()
} // class RightJustified