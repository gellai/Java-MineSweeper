package com.gellai.minesweeper;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import com.gellai.minesweeper.ContentFrame;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * 
 * Unit test for the Minesweeper game.
 * 
 */
public class MinesweeperTest extends TestCase
{
    public MinesweeperTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( MinesweeperTest.class );
    }
    
    public void testContentFrame() 
    {   	
    	ContentFrameTest guiFrameTest = new ContentFrameTest();
    	guiFrameTest.setGrid(10, 10, 2);    	
    }
    
    /**
     * 
     * Main test frame
     * 
     * @param args Application arguments
     */
    public static void main(String[] args) 
    {

    	final int GRID_NUMBER_COLS = 15; //10
    	final int GRID_NUMBER_ROWS = 30; //16
    	final int MINE_COUNT = 25; //20
	
    	ContentFrame guiFrame = new ContentFrame();
        guiFrame.setTitle("TEST");
        guiFrame.setVisible(true);
        guiFrame.setResizable(false);
        guiFrame.setGrid(GRID_NUMBER_COLS, GRID_NUMBER_ROWS, MINE_COUNT);    	
        guiFrame.pack();
        guiFrame.setLocation(100, 100);
    }
    
    /**
     * 
     * Testing CellValues class methods.
     * 
     */
    public void testCellValues() 
    {
    	int testIndex = 2;
    	int mineCounter = 2;
    	
    	CellValuesTest cellValuesTest = new CellValuesTest(10, 10, mineCounter);
    	cellValuesTest.setCells();
    	cellValuesTest.setClickedIndex(testIndex);
    	cellValuesTest.setCellValue(testIndex, -1);
    	System.out.println("Cell value at index " + testIndex + ": " + cellValuesTest.getCellValue(2));
    	System.out.println("Number of mines: " + mineCounter);
    }
    
    /**
     * 
     * Testing CellBuilder class methods.
     * 
     */
    public void testCellBuilder()
    {
    	JButton btnCell = new JButton();
    	
    	CellBuilderTest cellBuilderTest = new CellBuilderTest();
    	btnCell = cellBuilderTest.getBtnCell();
    	System.out.println("Button(cell) width: " + new Dimension(btnCell.getPreferredSize()).getWidth());
    	System.out.println("Button(cell) height: " + new Dimension(btnCell.getPreferredSize()).getHeight());
    	Color color = btnCell.getBackground();
    	System.out.println("RGB Color: " + color.getRed() + " " + color.getGreen() + " " + color.getBlue());
    }
    
    /**
     * 
     * Testing Icons class methods.
     * 
     */
    public void testIcons()
    {
    	int testNumber = 5;
    	
    	IconsTest iconsTest = new IconsTest();
    	System.out.println("Cell Numbers: " + iconsTest.getCellNumber(testNumber).getIconWidth() + "x" + iconsTest.getCellNumber(testNumber).getIconHeight());
    	System.out.println("Flag: " + iconsTest.getFlag().getIconWidth() + "x" + iconsTest.getFlag().getIconHeight());
    	System.out.println("Mine: " + iconsTest.getMine().getIconWidth() + "x" + iconsTest.getMine().getIconHeight());
    	System.out.println("Exploded Mine: " + iconsTest.getExplodedMine().getIconWidth() + "x" + iconsTest.getExplodedMine().getIconHeight());
    	System.out.println("Flagged Mine: " + iconsTest.getFlaggedMine().getIconWidth() + "x" + iconsTest.getFlaggedMine().getIconHeight());
    	System.out.println("Digital Number: " + iconsTest.getDigitalNumber(testNumber).getIconWidth() + "x" + iconsTest.getDigitalNumber(testNumber).getIconHeight());
    	System.out.println("Face Stand By: " + iconsTest.getFaceStandBy().getIconWidth() + "x" + iconsTest.getFaceStandBy().getIconHeight());
    	System.out.println("Face On Click: " + iconsTest.getFaceOnClick().getIconWidth() + "x" + iconsTest.getFaceOnClick().getIconHeight());
    	System.out.println("Face Win: " + iconsTest.getFaceWin().getIconWidth() + "x" + iconsTest.getFaceWin().getIconHeight());
    	System.out.println("Face Game Over: " + iconsTest.getFaceGameOver().getIconWidth() + "x" + iconsTest.getFaceGameOver().getIconHeight());
    }
}
