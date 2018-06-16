package com.gellai.minesweeper;

import java.util.ArrayList;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import java.util.Timer; 
import java.util.TimerTask; 

/**
 * 
 * Initialise the content frame and processe user interactions.
 * 
 * @author gellai.com
 * 
 */
public class ContentFrame extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * The class constructor creates the GUI frame. 
	 * 
	 */
	public ContentFrame() 
	{
		final Color PANEL_BACKGROUND = new Color(192, 192, 192);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Initialise borders
		emptyBorder = BorderFactory.createLineBorder( new Color(123, 123, 123) );
		Border padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border loweredBorder = BorderFactory.createLoweredBevelBorder();
		
		getContentPane().setBackground(PANEL_BACKGROUND);
		
		// Main panel
		JPanel mainPanel = new JPanel( new BorderLayout() );
		mainPanel.setBorder(padding);
		mainPanel.setBackground(PANEL_BACKGROUND);	
				
		// Header main pane
		JPanel headerPane = new JPanel( new BorderLayout() );
		headerPane.setBorder(loweredBorder);
		headerPane.setBackground(PANEL_BACKGROUND);
		
		// Counter pane
		JPanel leftCounterPane = new JPanel( new BorderLayout() );
		leftCounterPane.setBackground( new Color(0, 0, 0) );
		leftCounterPane.setBorder( BorderFactory.createMatteBorder(5, 5, 5, 0, PANEL_BACKGROUND) );
	
		icon = new Icons();
		setIconImages(icon.getFrameIcons());
		
		// Counter number left digit
		counterLeftNumber = new JLabel(icon.getDigitalNumber(0), JLabel.CENTER);
		counterLeftNumber.setPreferredSize( new Dimension(13, 23) );
		counterLeftNumber.setBackground( new Color(0, 0, 0) );
		
		// Counter number middle digit
		counterMiddleNumber = new JLabel(icon.getDigitalNumber(0), JLabel.CENTER);
		counterMiddleNumber.setPreferredSize( new Dimension(13, 23) );
		counterMiddleNumber.setBackground( new Color(0, 0, 0) );
		
		// Counter number right digit
		counterRightNumber = new JLabel(icon.getDigitalNumber(0), JLabel.CENTER);
		counterRightNumber.setPreferredSize( new Dimension(13, 23) );
		counterRightNumber.setBackground( new Color(0, 0, 0) );
		
		// Adding the counter digits to counter pane
		leftCounterPane.add(counterLeftNumber, BorderLayout.WEST);
		leftCounterPane.add(counterMiddleNumber, BorderLayout.CENTER);
		leftCounterPane.add(counterRightNumber, BorderLayout.EAST);
		
		// Face Button pane
		JPanel middleFacePane = new JPanel();
		middleFacePane.setBackground(PANEL_BACKGROUND);
		
		// Face Button
		faceBtn = new JButton();
		faceBtn.setIcon(icon.getFaceStandBy());
		faceBtn.setPressedIcon(icon.getFaceStandBy());
		faceBtn.setPreferredSize( new Dimension(23, 23) );
		faceBtn.setBackground( new Color(189, 189, 189) );
		faceBtn.setFocusable(false);		
		faceBtn.setBorder( BorderFactory.createRaisedBevelBorder() );
		faceBtn.addMouseListener( new MouseAction() );
		middleFacePane.add(faceBtn);
		
		// Timer pane
		JPanel rightTimerPane = new JPanel( new BorderLayout() );
		rightTimerPane.setBackground( new Color(0, 0, 0) );
		rightTimerPane.setBorder( BorderFactory.createMatteBorder(5, 0, 5, 5, PANEL_BACKGROUND) );
		
		// Timer number left digit
		timerLeftNumber = new JLabel(icon.getDigitalNumber(0), JLabel.CENTER);
		timerLeftNumber.setPreferredSize( new Dimension(13, 23) );
		timerLeftNumber.setBackground( new Color(0, 0, 0) );
				
		// Timer number middle digit
		timerMiddleNumber = new JLabel(icon.getDigitalNumber(0), JLabel.CENTER);
		timerMiddleNumber.setPreferredSize( new Dimension(13, 23) );
		timerMiddleNumber.setBackground( new Color(0, 0, 0) );
				
		// Timer number right digit
		timerRightNumber = new JLabel(icon.getDigitalNumber(0), JLabel.CENTER);
		timerRightNumber.setPreferredSize( new Dimension(13, 23) );
		timerRightNumber.setBackground( new Color(0, 0, 0) );
		
		// Adding the timer digits to counter pane
		rightTimerPane.add(timerLeftNumber, BorderLayout.WEST);
		rightTimerPane.add(timerMiddleNumber, BorderLayout.CENTER);
		rightTimerPane.add(timerRightNumber, BorderLayout.EAST);
		
		headerPane.add(leftCounterPane, BorderLayout.WEST);
		headerPane.add(middleFacePane, BorderLayout.CENTER);
		headerPane.add(rightTimerPane, BorderLayout.EAST);
		mainPanel.add(headerPane, BorderLayout.NORTH);
		
		// Cell grid pane
		cellPane = new JPanel();
		cellPane.setBackground(PANEL_BACKGROUND);
		cellPane.setBorder(loweredBorder);			
		
		mainPanel.add(cellPane, BorderLayout.SOUTH);
		
		add(mainPanel);
		
		cellBtns = new ArrayList<JButton>();
		cellFlags = new ArrayList<Boolean>();
		
		isGameOver = false;
		isFirstClick = true;
		
		timeCounter = new TimeCounter();
	}
	
	/**
	 * 
	 * Set the cells dynamically and set the flags to FALSE.
	 * 
	 * @param cols Set the number of rows for the grid.
	 * @param rows Set the number of columns for the grid.
	 * @param mines Set the number of mines.
	 * 
	 */
	public void setGrid(int cols, int rows, int mines)
	{	
		// Rows and columns must be bigger than 2
		if(rows <= 2 || cols <= 2) {
			
			System.err.println("\nThe grid value must be larger than 2!");
			System.exit(1);
		}
		
		// Rows and columns cannot be bigger than 30
		if(rows > 30 || cols > 30) {
			
			System.err.println("\nThe grid value cannot be larger than 30!");
			System.exit(2);
		}
		
		// Mines must be less than the number of cells
		if(mines >= (cols * rows)) {
			
			System.err.println("\nThe number of mines must be less than the number of cells in the grid!");
    		System.exit(3);
		}
		
		cellValues = new CellValues(cols, rows, mines);
		
		cellPane.removeAll();
		
		GridLayout cellGrid = new GridLayout(rows, cols); 		
		cellPane.setLayout(cellGrid);
		
		// Build the cells using button objects and set the flags
		cellBtns.clear();
		cellFlags.clear();
		for(int i = 0; i < (cols * rows); i++) {
			
			CellBuilder cellBuilder = new CellBuilder();
			JButton cellBtnObj = cellBuilder.getBtnCell();
			cellBtnObj.addActionListener(this);
			cellBtnObj.addMouseListener( new MouseAction() );		
			
			cellPane.add(cellBtnObj);
			cellBtns.add(cellBtnObj);
			
			cellFlags.add(false);
		}
		
		cellPane.revalidate();
		
		this.cols = cols;
		this.rows = rows;
		flags = mines;
		
		setDigitalCounter();
	}

	/**
	 * 
	 * Process Game Over when clicked on a cell containing a mine.
	 * 
	 * @param index The index of the clicked mine cell.
	 * 
	 */
	private void gameOver(int index)
	{
		for(int idx = 0; idx < cellBtns.size(); idx++) {
			
			JButton cellBtnObj = cellBtns.get(idx);
			
			// Set the icon for the clicked mine
			if(index == idx) {
				
				cellBtnObj.setBorder(emptyBorder);
				cellBtnObj.setIcon(icon.getExplodedMine());
				continue;
			}
			
			// Set the icon for the flagged mines
			if( cellValues.getCellValue(idx) == 9 && cellFlags.get(idx) ) {
				
				cellBtnObj.setBorder(emptyBorder);
				cellBtnObj.setIcon(icon.getFlaggedMine());
				continue;
			}
			
			// Set the icon for the undiscovered mines
			if( cellValues.getCellValue(idx) == 9 && !cellFlags.get(idx) ) {
				
				cellBtnObj.setBorder(emptyBorder);
				cellBtnObj.setIcon(icon.getMine());
				continue;
			}
		}
		
		isGameOver = true;
		timeCounter.stopTimer();
		faceBtn.setIcon(icon.getFaceGameOver());
	}
	
	/**
	 * 
	 * Check if the game is completed.
	 * 
	 */
	private void checkCompletion() 
	{
		isGameOver = true;
		
		for(JButton button: cellBtns) {
			
			int idx = cellBtns.indexOf(button);
			
			if(button.getBorder() != emptyBorder && !cellFlags.get(idx)) {
				
				isGameOver = false;
				break;
			}
		}
		
		// The game is completed
		if(isGameOver) {
			
			timeCounter.stopTimer();
			faceBtn.setIcon(icon.getFaceWin());
		}
	}
	
	/**
	 * 
	 * Set the GUI for the digital flag counter.
	 * 
	 */
	private void setDigitalCounter()
	{
		counterLeftNumber.setIcon(icon.getDigitalNumber(flags / 100));
		counterMiddleNumber.setIcon(icon.getDigitalNumber(flags % 100 / 10));
		counterRightNumber.setIcon(icon.getDigitalNumber(flags % 10));	
	}
	
	/**
	 * 
	 * Action performed when clicked on a cell button.
	 * 
	 */
	public void actionPerformed(ActionEvent aev) 
	{	
		if( !isGameOver ) {
			
			for(int idx = 0; idx < (cols * rows); idx++) {
			
				JButton clickedBtn = cellBtns.get(idx);
			
				if(aev.getSource() == clickedBtn) {
					
					// Check if it is the first click
					if(isFirstClick) {
						
						// Create the cell values and place mines randomly
						cellValues.setClickedIndex(idx);
						cellValues.setCells();
						isFirstClick = false;
						timeCounter.startTimer();
					}
					
					if(cellFlags.get(idx) == false) {
					
						// Clicked on a mine, the game is over		
						if(cellValues.getCellValue(idx) == 9) {
							
							gameOver(idx);
						}
						else { 
							
							// Process the clicked field (not mine)
							new ClickedCellProcessor(idx);
							checkCompletion();
						}
					}				
				}			
			}
		}
	}
	
	/**
	 * 
	 * Mouse adapter class to process mouse activities.
	 * 
	 * @author gellai.com
	 * @version 1.0
	 * 
	 */
	class MouseAction extends MouseAdapter 
	{	
		/**
		 * 
		 * Mouse is clicked on a cell
		 * 
		 */
		@Override
		public void mouseClicked(MouseEvent mev) 
		{
			// Mouse right click event
			if(mev.getButton() == MouseEvent.BUTTON3 && !isGameOver) {
				
				JButton rightClickedCell = (JButton)mev.getSource();
				int indexRightClicked = cellBtns.indexOf(rightClickedCell);
				
				// The field is not flagged
				if(cellFlags.get(indexRightClicked) == false) { 
					
					if(flags > 0 && rightClickedCell.getBorder() != emptyBorder) {
						
						rightClickedCell.setIcon(icon.getFlag());
						cellFlags.set(indexRightClicked, true);
						flags--;
						setDigitalCounter();
					}
				}
				
				// The field is flagged
				else {
					
					rightClickedCell.setIcon(null);
					cellFlags.set(indexRightClicked, false);
					flags++;
					setDigitalCounter();
				}
				
				checkCompletion();
			}
			
			// Mouse clicked on the reset face.
			if(mev.getSource() == faceBtn) {
				
				isGameOver = false;
				isFirstClick = true;
				timeCounter.resetTimer();
				faceBtn.setIcon(icon.getFaceStandBy());
				flags = cellValues.getMines();
				setGrid(cols, rows, flags);
			}
		}
		
		/**
		 * 
		 * Mouse button hold down; change face.
		 * 
		 */
		@Override
		public void mousePressed(MouseEvent mev)
		{
			if(!isGameOver)				
				faceBtn.setIcon(icon.getFaceOnClick());
			
			if(mev.getSource() == faceBtn) 
				faceBtn.setBorder(BorderFactory.createLoweredBevelBorder());
		}
		
		/**
		 * 
		 * Mouse button released; change face back to stand by.
		 * 
		 */
		@Override
		public void mouseReleased(MouseEvent mev)
		{
			if(!isGameOver)				
				faceBtn.setIcon(icon.getFaceStandBy());
			
			if(mev.getSource() == faceBtn)
				faceBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		}
	}

	/**
	 * 
	 * Clicked cell processor.
	 * 
	 * User clicks on an empty cell and the class will 
	 * reveal all the neighbouring empty or numbered cells.
	 * The process will stop when the boundary cell contains a number.
	 * Numbered cells are also revealed during the process. 
	 * 
	 * @author gellai.com
	 * @version 1.0
	 * 
	 */
	class ClickedCellProcessor 
	{	
		public ClickedCellProcessor(int idx)
		{
			int cellValue = cellValues.getCellValue(idx);
			JButton cellBtnObj = cellBtns.get(idx);
			boolean isFlagged = cellFlags.get(idx);
			
			// Clicked on a number next to a mine (not flagged)
			if( (cellValue > 0 && cellValue < 9) && !isFlagged ) {
				
				cellBtnObj.setBorder(emptyBorder);
				cellBtnObj.setIcon(icon.getCellNumber(cellValue));
			}
			
			// Clicked on an empty cell (not flagged) and
			// set its value to -1 so it will be ignored when
			// the parent class is re-instantiated as a 
			// parallel session
			if(cellValue == 0 && !isFlagged) {
				
				cellBtnObj.setBorder(emptyBorder);
				cellValues.setCellValue(idx, -1);
				
				int iX = idx % cols;
				int iY = idx / cols;
				int leftX = iX - 1;
				int rightX = iX +1;
				int upY = iY - 1;
				int downY = iY + 1;
				
				// Left cell
				if(leftX >= 0) {
					
					int leftIdx = idx - 1;
					int leftIdxValue = cellValues.getCellValue(leftIdx);
					revealCell(leftIdx, leftIdxValue);
				}
				// Right cell
				if(rightX < cols) {
					
					int rightIdx = idx + 1;
					int rightIdxValue = cellValues.getCellValue(rightIdx);
					revealCell(rightIdx, rightIdxValue);
				}
				// Top cell
				if(upY >= 0) {
					
					int upIdx = idx - cols;
					int upIdxValue = cellValues.getCellValue(upIdx);
					revealCell(upIdx, upIdxValue);
				}
				// Bottom cell
				if(downY < rows) {
					
					int downIdx = idx + cols;
					int downIdxValue = cellValues.getCellValue(downIdx);
					revealCell(downIdx, downIdxValue);				
				}
			}
		}
		
		/**
		 * 
		 * Method to reveal an empty or numbered cell. 
		 * 
		 * @param idx The index of the cell to be revealed.		
		 * @param idxValue The value of the cell to be revealed
		 * 
		 */
		private void revealCell(int idx, int idxValue) 
		{	
			// Empty cells
			if(idxValue == 0) {
				
				// Instantiate a new class to start a new parallel process
				new ClickedCellProcessor(idx);
			}
			
			// Cells containing numbers
			if(idxValue > 0 && idxValue < 9) {
				
				cellBtns.get(idx).setBorder(emptyBorder);
				cellBtns.get(idx).setIcon(icon.getCellNumber(idxValue));
			}
		}
	}
	
	/**
	 * 
	 * Game elapsed time counter. Triggers after the first click.
	 * 
	 * @author gellai.com
	 *
	 */
	class TimeCounter 
	{ 
		private int counter = 0; 
		private Timer timer;
		
		/**
		 * 
		 * Start the game timer and set the GUI digits.
		 * 
		 */
		public void startTimer()
		{
			timer = new Timer(); 
			timer.scheduleAtFixedRate(new TimerTask(){ 
				public void run() 
				{ 
					counter++;
					if(counter <= 999) {
						
						timerLeftNumber.setIcon(icon.getDigitalNumber(counter / 100));
						timerMiddleNumber.setIcon(icon.getDigitalNumber(counter % 100 / 10));
						timerRightNumber.setIcon(icon.getDigitalNumber(counter % 10));
					}
				} 
			}, 0, 1000); 
		}
		
		/**
		 * 
		 * Stop the timer.
		 * 
		 */
		public void stopTimer() 
		{
			if(timer != null) {
				
				timer.cancel();
				timer.purge();
			}
		}
		
		/**
		 * 
		 * Reset the timer and the GUI digits.
		 * 
		 */
		public void resetTimer()
		{
			if(timer != null) {
				
				stopTimer();
				counter = 0;
				timerLeftNumber.setIcon(icon.getDigitalNumber(0));
				timerMiddleNumber.setIcon(icon.getDigitalNumber(0));
				timerRightNumber.setIcon(icon.getDigitalNumber(0));
			}
		}
	} 
	
	private JPanel cellPane;
	private JButton faceBtn;
	private JLabel counterLeftNumber, counterMiddleNumber, counterRightNumber, timerLeftNumber, timerMiddleNumber, timerRightNumber;
	private int rows, cols, flags;
	private ArrayList<JButton> cellBtns;
	private CellValues cellValues;
	private ArrayList<Boolean> cellFlags;
	private Border emptyBorder;
	private Icons icon;
	private boolean isGameOver, isFirstClick;
	private TimeCounter timeCounter;
}
