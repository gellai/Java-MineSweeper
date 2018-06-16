package com.gellai.minesweeper;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.BorderFactory;

/**
 * 
 * Build an individual cell (button) for the GUI frame.
 * 
 * @author gellai.com
 * 
 */
public class CellBuilder
{
	private JButton cell;
	
	/**
	 * 
	 * Class constructor to create a button object 
	 * to be used a cell within the grid.
	 * 
	 */
	public CellBuilder() 
	{	
		cell = new JButton();
		cell.setPreferredSize(new Dimension(17, 17) );
		cell.setBackground( new Color(189, 189, 189) );
		cell.setFocusable(false);		
		cell.setBorder( BorderFactory.createRaisedBevelBorder() );
	}
	
	/**
	 * 
	 * Accessor method to return the button object (cell).
	 * 
	 * @return Return the button object from cell instance variable.
	 * 
	 */
	public JButton getBtnCell()
	{	
		return cell;
	}
}
