package com.gellai.minesweeper;

import java.awt.Image;

import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * 
 * Load the icon images for the GUI frame 
 * 
 * @author gellai.com
 * 
 */
public class Icons
{	
	private ArrayList<ImageIcon> cellNumbers, digitalNumbers;
	private ArrayList<Image> frameIcons;
	private ImageIcon flag, mine, explodedMine, flaggedMine, faceStandBy, faceOnClick, faceWin, faceGameOver;
	
	/**
	 * 
	 * The constructor loads the files first for
	 * a faster performance.
	 * 
	 */
	public Icons() 
	{
		cellNumbers = new ArrayList<ImageIcon>();
		cellNumbers.add(null);
		cellNumbers.add(loadImageIconFile("cell_number_1.gif"));
		cellNumbers.add(loadImageIconFile("cell_number_2.gif"));
		cellNumbers.add(loadImageIconFile("cell_number_3.gif"));
		cellNumbers.add(loadImageIconFile("cell_number_4.gif"));
		cellNumbers.add(loadImageIconFile("cell_number_5.gif"));
		cellNumbers.add(loadImageIconFile("cell_number_6.gif"));
		cellNumbers.add(loadImageIconFile("cell_number_7.gif"));
		cellNumbers.add(loadImageIconFile("cell_number_8.gif"));
		
		digitalNumbers = new ArrayList<ImageIcon>();
		digitalNumbers.add(loadImageIconFile("digital_number_0.gif"));
		digitalNumbers.add(loadImageIconFile("digital_number_1.gif"));
		digitalNumbers.add(loadImageIconFile("digital_number_2.gif"));
		digitalNumbers.add(loadImageIconFile("digital_number_3.gif"));
		digitalNumbers.add(loadImageIconFile("digital_number_4.gif"));
		digitalNumbers.add(loadImageIconFile("digital_number_5.gif"));
		digitalNumbers.add(loadImageIconFile("digital_number_6.gif"));
		digitalNumbers.add(loadImageIconFile("digital_number_7.gif"));
		digitalNumbers.add(loadImageIconFile("digital_number_8.gif"));
		digitalNumbers.add(loadImageIconFile("digital_number_9.gif"));
		
		mine = loadImageIconFile("mine.gif");
		explodedMine = loadImageIconFile("exploded_mine.gif");
		flaggedMine = loadImageIconFile("flagged_mine.gif");
		flag = loadImageIconFile("flag.gif");
		faceStandBy = loadImageIconFile("face_standby.gif");
		faceOnClick = loadImageIconFile("face_on_click.gif");
		faceWin = loadImageIconFile("face_win.gif");
		faceGameOver = loadImageIconFile("face_game_over.gif");
		
		frameIcons = new ArrayList<Image>();
		frameIcons.add(loadImageFile("minesweeper_16x16.png"));
		frameIcons.add(loadImageFile("minesweeper_32x32.png"));
		frameIcons.add(loadImageFile("minesweeper_64x64.png"));
		frameIcons.add(loadImageFile("minesweeper_128x128.png"));
	}
	
	/**
	 * 
	 * Load the file from the resources and convert
	 * it to an image icon. Exit if file not found.
	 * 
	 * @param fileName The name of the image file.
	 * @return The converted image icon.
	 * 
	 */
	private ImageIcon loadImageIconFile(String fileName) 
	{
		Image tmpImage = null;
		
		try {
			
			tmpImage = ImageIO.read(getClass().getResource("/" + fileName));
		}
		catch(Exception e) {
			
			System.err.println("\nThe following file is missing: " + fileName);
			System.exit(4);
		}
		
		return new ImageIcon(tmpImage);
	}
	
	/**
	 * 
	 * Load an image file from the resources.
	 * 
	 * @param fileName The name of the image file.
	 * @return The loaded image file. 
	 */
	private Image loadImageFile(String fileName) 
	{
		Image tmpImage = null;
		
		try {
			
			tmpImage = ImageIO.read(getClass().getResource("/" + fileName));
		}
		catch(Exception e) {
			
			System.err.println("\nThe following file is missing: " + fileName);
			System.exit(5);
		}
		
		return tmpImage;
	}
	
	/**
	 * 
	 * Returns a number's image icon.
	 * 
	 * The requested number is the index within the array.  
	 * 
	 * Icon size: 10px * 10px
	 * 
	 * @param n The requested number.
	 * @return ImageIcon The image icon of the number.
	 * 
	 */
	public ImageIcon getCellNumber(int n) 
	{		
		return cellNumbers.get(n);
	}
	
	/**
	 * 
	 * Returns the flag image icon.
	 * 
	 * Icon size: 8px * 10px
	 * 
	 * @return ImageIcon The image icon of the flag.
	 * 
	 */
	public ImageIcon getFlag() 
	{		
		return flag;
	}
		
	/**
	 * 
	 * Returns the mine image icon.
	 * 
	 * Icon size: 13px * 13px
	 * 
	 * @return ImageIcon The image icon of the mine.
	 * 
	 */
	public ImageIcon getMine() 
	{		
		return mine;
	}
	
	/**
	 * 
	 * Returns the exploded mine image icon.
	 * 
	 * Icon size: 15px * 15px
	 * 
	 * @return ImageIcon The image icon of the exploded mine.
	 * 
	 */
	public ImageIcon getExplodedMine() 
	{
		return explodedMine;
	}
	
	/**
	 * 
	 * Returns the flagged mine image icon.
	 * 
	 * Icon size: 13px * 13px
	 * 
	 * @return ImageIcon The image icon of the flagged mine.
	 * 
	 */
	public ImageIcon getFlaggedMine() 
	{	
		return flaggedMine;
	}
	
	/**
	 * 
	 * Returns a digital number's image icon. 
	 * 
	 * The requested number is the index within the array.  
	 * 
	 * Icon size: 11px * 21px
	 * 
	 * @param n The requested number.
	 * @return ImageIcon The image icon of the number.
	 * 
	 */
	public ImageIcon getDigitalNumber(int n) 
	{	
		return digitalNumbers.get(n);
	}
	
	/**
	 * 
	 * Returns the face stand by image icon.
	 * 
	 * Icon size: 17px * 17px
	 * 
	 * @return ImageIcon The image icon of the face stand by.
	 * 
	 */
	public ImageIcon getFaceStandBy() 
	{	
		return faceStandBy;
	}
	
	/**
	 * 
	 * Returns the face on click by image icon.
	 * 
	 * Icon size: 17px * 17px
	 * 
	 * @return ImageIcon The image icon of the face on click.
	 * 
	 */
	public ImageIcon getFaceOnClick() 
	{	
		return faceOnClick;
	}
	
	/**
	 * 
	 * Returns the face win image icon.
	 * 
	 * Icon size: 17px * 17px
	 * 
	 * @return ImageIcon The image icon of the win.
	 * 
	 */
	public ImageIcon getFaceWin() 
	{	
		return faceWin;
	}
	
	/**
	 * 
	 * Returns the face game over image icon.
	 * 
	 * Icon size: 17px * 17px
	 * 
	 * @return ImageIcon The image icon of the face game over.
	 * 
	 */
	public ImageIcon getFaceGameOver() 
	{	
		return faceGameOver;
	}
	
	/**
	 * 
	 * Returns an array list of icons containing various sizes of icons.
	 * 
	 *  16x16, 32x32, 64x64, 128x128
	 * 
	 * @return ArrayList&lt;Image&gt; An array list of the frame icons.
	 */
	public ArrayList<Image> getFrameIcons()
	{
		return frameIcons;
	}
}
