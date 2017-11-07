package UI;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
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
		gamePanel = new JPanel();
		opponentPanel = new JPanel();
		
		container.setLayout(new GridLayout(1,2)); // one row, two columns layout
		container.setBorder(new EmptyBorder(5,5,5,5));
		gamePanel.setLayout(new BorderLayout());
		opponentPanel.setLayout(new BorderLayout());
		
		infoLabel = new JLabel("Your Game Status");
		opponentLabel = new JLabel("Your Opponent Status");
		
		infoLabel2 = new JLabel("");
		opponentLabel2 = new JLabel("");
		
		gamePanel.add(infoLabel, BorderLayout.NORTH);
		opponentPanel.add(opponentLabel, BorderLayout.NORTH);
		
		grid = new Grid();
		opponentGrid = new Grid();		
		//gamePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		//grid.getPanel().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		gamePanel.add(grid.getPanel(), BorderLayout.CENTER);
	    opponentPanel.add(opponentGrid.getPanel(), BorderLayout.CENTER);

	    gamePanel.add(infoLabel2, BorderLayout.SOUTH);
		opponentPanel.add(opponentLabel2, BorderLayout.SOUTH);
		
		Menu menu = new Menu();
	    setJMenuBar(menu); // adds menu object to frame
	    
		container.add(gamePanel);
		container.add(opponentPanel);
			    
	    this.add(container); // add two panels side-by-side to the frame    	    
		this.setSize(1000, 500);		
		this.setTitle("Battleship");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public static void setInfo(String s)
	{
		infoLabel2.setText(s);
		opponentLabel2.setText(s);
	}
}
