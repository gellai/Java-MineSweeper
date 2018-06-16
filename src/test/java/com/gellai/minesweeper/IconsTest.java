package com.gellai.minesweeper;

import java.awt.Image;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.gellai.minesweeper.Icons;

/**
 * 
 * Test for <b>Icons</b> class.
 * 
 * @author gellai.com
 *
 */
public class IconsTest extends Icons {
	public IconsTest() {
		super();
	}

	public ImageIcon getCellNumber(int n) 
	{
		return super.getCellNumber(n);
	}

	public ImageIcon getFlag() 
	{
		return super.getFlag();
	}

	public ImageIcon getMine() 
	{
		return super.getMine();
	}

	public ImageIcon getExplodedMine() 
	{
		return super.getExplodedMine();
	}

	public ImageIcon getFlaggedMine() 
	{
		return super.getFlaggedMine();
	}

	public ImageIcon getDigitalNumber(int n) 
	{
		return super.getDigitalNumber(n);
	}

	public ImageIcon getFaceStandBy() 
	{
		return super.getFaceStandBy();
	}

	public ImageIcon getFaceOnClick() 
	{
		return super.getFaceOnClick();
	}

	public ImageIcon getFaceWin() 
	{
		return super.getFaceWin();
	}

	public ImageIcon getFaceGameOver() 
	{
		return super.getFaceGameOver();
	}
	
	public ArrayList<Image> getFrameIcons() 
	{
		return super.getFrameIcons();
	}
}
