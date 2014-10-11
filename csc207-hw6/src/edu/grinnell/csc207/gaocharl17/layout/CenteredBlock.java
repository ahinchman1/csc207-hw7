package edu.grinnell.csc207.gaocharl17.layout;

public class CenteredBlock implements TextBlock {
	
	TextBlock _contents;
	int width;
	int height;
	/**
	 * Create a new truncated block of the specified width.
	 */
	public CenteredBlock(TextBlock tb, int width)
	{
		this._contents = tb;
		this.width = width;
	} // CenteredBlock(TextBlock, int)

	/**
	 * Get the ith row of the block.
	 */
	public String row(int i) throws Exception
	{
		int spacerLength = (width - _contents.width())/2;
		
		if(i >= 0 && i < _contents.height() && _contents.width() > 0)
		{
			return TBUtils.spaces(spacerLength) + _contents.row(i) 
					+ TBUtils.spaces(spacerLength);
		} //if
		throw new Exception("Invalid row: " + i);
	}// row(int)

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
} // class CenteredBlock