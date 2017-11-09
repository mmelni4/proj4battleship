package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Battleship extends JFrame 
{
	static JPanel gamePanel;
	static JPanel opponentPanel;
	static JPanel container;	
	static JLabel infoLabel;
	static JLabel opponentLabel;
	static JLabel infoLabel2;
	static JLabel opponentLabel2;
	
	private static Grid grid;
	private static Grid opponentGrid;
	
	public static void main(String args[])
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		Battleship b = new Battleship();
	}
	public Battleship()
	{
		container = new JPanel();		
		container.setLayout(new GridLayout(1,2)); // one row, two columns layout
		container.setBorder(new EmptyBorder(10,10,10,10));
		
		gamePanel = new JPanel();
		gamePanel.setLayout(new BorderLayout());
		infoLabel = new JLabel("Your Game Status");
		gamePanel.add(infoLabel, BorderLayout.NORTH);
		infoLabel2 = new JLabel("Updates will be shown here");
		grid = new Grid();
		gamePanel.add(grid.getPanel(), BorderLayout.CENTER);
		gamePanel.add(infoLabel2, BorderLayout.SOUTH);
		
		opponentPanel = new JPanel();
		opponentPanel.setLayout(new BorderLayout());
		opponentLabel = new JLabel("Your Opponent Status");
		opponentPanel.add(opponentLabel, BorderLayout.NORTH);
		opponentLabel2 = new JLabel("Updates for Opponent will be shown here");
		opponentGrid = new Grid(1);
	    opponentPanel.add(opponentGrid.getOppPanel(), BorderLayout.CENTER);
		opponentPanel.add(opponentLabel2, BorderLayout.SOUTH);
				
		container.add(gamePanel);
		container.add(opponentPanel);
		
		Menu menu = new Menu();
	    setJMenuBar(menu); // adds menu object to frame
	    		    
	    this.add(container); // add two panels side-by-side to the frame    	    
		this.setSize(1100, 600);		
		
		this.setTitle("Battleship");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public static void setInfo(String s)
	{
		infoLabel2.setText(s);
	}
	public static void setOpponentInfo(String s)
	{
		opponentLabel2.setText(s);
	}
	public static Grid getPlayerGrid()
	{
		return grid;
	}
	public static Grid getOpponentGrid()
	{
		return opponentGrid;
	}
}
