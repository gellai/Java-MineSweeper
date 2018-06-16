package com.gellai.minesweeper;

import com.gellai.minesweeper.CellValues;

/**
 * 
 * Test for <b>CellValuesTest</b> class.
 * 
 * @author gellai.com
 *
 */
public class CellValuesTest extends CellValues 
{
	public CellValuesTest(int cols, int rows, int mines) 
	{
		super(cols, rows, mines);
	}
	
	public void setClickedIndex(int idx) 
	{
		super.setClickedIndex(idx);
	}
	
	public void setCells() 
	{
		super.setCells();
	}
	
	public void setCellValue(int idx, int value) 
	{
		super.setCellValue(idx, value);
	}
	
	public int getCellValue(int idx) 
	{
		return super.getCellValue(idx);
	}
	
	public int getMines() 
	{
		return super.getMines();
	}
}
