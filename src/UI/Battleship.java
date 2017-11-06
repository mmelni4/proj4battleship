package UI;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Battleship extends JFrame 
{
	static JPanel gamePanel;
	static JPanel opponentGamePanel;
	static JPanel guiParent;
	
	static JLabel infoLabel;
	static JLabel opponentInfoLabel;
	
	private static Grid grid;
	private static Grid opponentGrid;
	
	public static void main(String args[])
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		Battleship b = new Battleship();
	}
	public Battleship()
	{
		JPanel gui = new JPanel(new GridLayout(1,2,5,5));
		gui.setBorder(new EmptyBorder(5,5,5,5));
		
		gamePanel = new JPanel();
		opponentGamePanel = new JPanel();
		
		infoLabel = new JLabel("Game status");
		opponentInfoLabel = new JLabel("Opponent status");
		
		grid = new Grid();
		opponentGrid = new Grid();
		
		gamePanel.setLayout(new BorderLayout());
		opponentGamePanel.setLayout(new BorderLayout());
				
		gamePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		opponentGamePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		grid.getPanel().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		opponentGrid.getPanel().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		gamePanel.add(grid.getPanel(), BorderLayout.CENTER);
		opponentGamePanel.add(opponentGrid.getPanel(), BorderLayout.CENTER);
		
		gamePanel.add(infoLabel, BorderLayout.SOUTH);
		opponentGamePanel.add(infoLabel, BorderLayout.SOUTH);
		
		Menu menu = new Menu();
	    setJMenuBar(menu); // adds menu object to frame
	    
	    gui.add(opponentGamePanel);
	    gui.add(gamePanel);
	    
	    this.add(gui); // add two panels side-by-side to the frame    
	    
		this.setSize(1000, 500);
		
		this.setTitle("Battleship");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setVisible(true);
		
	}
	public static void setInfo(String s)
	{
		infoLabel.setText(s);
		opponentInfoLabel.setText(s);
	}
}
