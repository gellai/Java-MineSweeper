package com.gellai.minesweeper;

import java.util.ArrayList;
import java.util.Random;


/**
 * 
 * Create, store and handle the cell values.
 * 
 * @author gellai.com
 * 
 */
public class CellValues 
{
	/**
	 * 
	 * @param cols Parameter for column number instance variable. 
	 * @param rows Parameter for row number instance variable.
	 * @param mines Parameter for mine number instance variable. 
	 * 
	 */
	public CellValues(int cols, int rows, int mines) 
	{		
		this.cols = cols;
		this.rows = rows;
		this.mines = mines;
		cellValues = new ArrayList<Integer>();
	}
	
	/**
	 * 
	 * Set the index of the clicked cell into instance variable. 
	 * 
	 * @param idx Index of the clicked cell.
	 * 
	 */
	public void setClickedIndex(int idx) 
	{		
		clickedIndex = idx;
	}
	
	/**
	 * 
	 * Setting up the cell values to 0, placing the mines randomly
	 * by setting the cell values to 9 and calculating the numbers
	 * next for the cells next to the mines.
	 * 
	 */
	public void setCells()
	{
		int gridSize = cols * rows;
		
		// Set cell values to 0
		for(int i = 0; i < gridSize; i++) 
			cellValues.add(0);
			
		Random rand = new Random();		
		
		// Set mines randomly
		for(int j = 0; j < mines; j++) {
			
			int randIdx = rand.nextInt(gridSize);

			int tmpCellValue = cellValues.get(randIdx);
			
			// Prevent to put mine under the first click, around the first click and on an other mine
			// Default cell values: 0 
			// Mine cell value: 9
			//
			// TODO: ADD GRID BOUNDARY RULE
			//
			if(tmpCellValue == 0 && clickedIndex != randIdx) {
				
				// Prevent to place mines around the clicked cell
				if( (randIdx == clickedIndex + 1) || // Right cell
					(randIdx == clickedIndex - 1) || // Left cell
					(randIdx == clickedIndex - cols) || // Top cell 
					(randIdx == clickedIndex + cols) || // Bottom cell
					(randIdx == clickedIndex - cols - 1) || // Top left cell 
					(randIdx == clickedIndex - cols + 1) || // Top right cell
					(randIdx == clickedIndex + cols - 1) || // Bottom left cell
					(randIdx == clickedIndex + cols + 1)  // Bottom right cell
				)
					j--; 
				
				else
					cellValues.set(randIdx, 9);
			}
			else			
				j--;
		}
		
		// Get the mines X, Y coordinates and set the neighbouring numbers
		for(int k = 0; k < gridSize; k++) 
		{
			int x = k % cols;
			int y = k / cols;
			int xNext = x + 1;
			int xPrev = x - 1;
			int yNext = y + 1;
			int yPrev = y - 1;
			int xMax = (gridSize / rows) - 1;
			int xMin = 0;
			int yMax = (gridSize / cols) - 1;
			int yMin = 0;
			
			int indexCellValue = cellValues.get(k);
			
			// If it's a mine
			if(indexCellValue == 9) {
				
				// Increment right cell by 1
				if( xNext <= xMax && cellValues.get(k+1) != 9 ) 
					cellValues.set(k+1, cellValues.get(k+1) + 1);
				
				// Increment left cell by 1
				if( xPrev >= xMin && cellValues.get(k-1) != 9 ) 
					cellValues.set(k-1, cellValues.get(k-1) + 1);
				
				// Increment bottom cell by 1
				if( yNext <= yMax && cellValues.get(k+cols) != 9 ) 
					cellValues.set(k+cols, cellValues.get(k+cols) + 1);
				
				// Increment top cell by 1
				if( yPrev >= yMin && cellValues.get(k-cols) != 9 ) 
					cellValues.set(k-cols, cellValues.get(k-cols) + 1);
				
				// Increment top left cell by 1
				if( xPrev >= xMin && yPrev >= yMin && cellValues.get(k-cols-1) != 9 ) 
					cellValues.set(k-cols-1, cellValues.get(k-cols-1) + 1);
				
				// Increment top right cell by 1
				if( xNext <= xMax && yPrev >= yMin && cellValues.get(k-cols+1) != 9 )
					cellValues.set(k-cols+1, cellValues.get(k-cols+1) + 1);
				
				// Increment bottom right cell by 1
				if( xNext <= xMax && yNext <= yMax && cellValues.get(k+cols+1) != 9)
					cellValues.set(k+cols+1, cellValues.get(k+cols+1) + 1);
				
				// Increment bottom left cell by 1
				if( xPrev >= xMin && yNext <= yMax && cellValues.get(k+cols-1) != 9)
					cellValues.set(k+cols-1, cellValues.get(k+cols-1) + 1);
			}
		}	
	}
	
	/**
	 * 
	 * Mutator method to set a cell value within the cell
	 * values instance variable array. 
	 * 
	 * @param idx The index of the cell value within the array.
	 * @param value The value to set within the cell values array.
	 * 
	 */
	public void setCellValue(int idx, int value) 
	{
		cellValues.set(idx, value);
	}
	
	/**
	 * 
	 * Accessor method to get a value from the cell values instance 
	 * variable array by its index.
	 * 
	 * @param idx The index of the requested value within the cell variables array.
	 * @return Returns the requested value from the cell variables array by its index. 
	 * 
	 */
	public int getCellValue(int idx) 
	{
		return cellValues.get(idx);
	}
	
	/**
	 * 
	 * Accessor method to get the value of the mine instance variable.
	 * 
	 * @return Returns the number of mines from the mine variable. 
	 * 
	 */
	public int getMines() 
	{
		return mines;
	}
	
	private int clickedIndex, cols, rows, mines;
	ArrayList<Integer> cellValues;
}
