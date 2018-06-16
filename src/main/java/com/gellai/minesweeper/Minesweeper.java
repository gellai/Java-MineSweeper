package com.gellai.minesweeper;

/**
 * The Minesweeper Game's main class.
 * 
 * @author gellai.com
 * 
 */
public class Minesweeper 
{
	//
	//	TODO: MULTIPLE DIFFICULTY LEVELS
	//
	private static final int GRID_NUMBER_COLS = 15; //15
	private static final int GRID_NUMBER_ROWS = 30; //30
	private static final int MINE_COUNT = 30; //30
	
    public static void main( String[] args )
    {
    	try {
    		
    		ContentFrame guiFrame = new ContentFrame();
    		guiFrame.setTitle("Minesweeper");
    		guiFrame.setVisible(true);
    		guiFrame.setResizable(false);
    		guiFrame.setGrid(GRID_NUMBER_COLS, GRID_NUMBER_ROWS, MINE_COUNT);    	
    		guiFrame.pack();
    		guiFrame.setLocation(100, 100);
    	}
    	catch(Exception e) {
    		
    		System.err.println("\nThe following error(s) occured:");
    		System.err.println(e);
    		System.exit(6);
    	}
    }
}
