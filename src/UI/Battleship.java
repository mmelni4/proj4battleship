package UI;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Battleship extends JFrame 
{
	static JPanel gamePanel;
<<<<<<< HEAD
	static JPanel opponentPanel;
	static JPanel container;
	
	static JLabel infoLabel;
	static JLabel opponentLabel;
	static JLabel infoLabel2;
	static JLabel opponentLabel2;
=======
	static JPanel opponentGamePanel;
	
	static JLabel infoLabel;
	static JLabel opponentInfoLabel;
>>>>>>> ships_v1
	
	private static Grid grid;
	private static Grid opponentGrid;
	
	public static void main(String args[])
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		Battleship b = new Battleship();
	}
	public Battleship()
	{
<<<<<<< HEAD
		container = new JPanel();
		gamePanel = new JPanel();
		opponentPanel = new JPanel();
=======
		gamePanel = new JPanel();
		//opponentGamePanel = new JPanel();
		
		infoLabel = new JLabel("Game status");
		//opponentInfoLabel = new JLabel("Opponent status");
		
		grid = new Grid();
		//opponentGrid = new Grid();
>>>>>>> ships_v1
		
		container.setLayout(new GridLayout(1,2)); // one row, two columns layout
		container.setBorder(new EmptyBorder(10,10,10,10));
		gamePanel.setLayout(new BorderLayout());
<<<<<<< HEAD
		opponentPanel.setLayout(new BorderLayout());
		
		infoLabel = new JLabel("Your Game Status");
		opponentLabel = new JLabel("Your Opponent Status");
		
		infoLabel2 = new JLabel("Updates will be shown here");
		opponentLabel2 = new JLabel("Updates will be shown here");
		
		gamePanel.add(infoLabel, BorderLayout.NORTH);
		opponentPanel.add(opponentLabel, BorderLayout.NORTH);
=======
				
		gamePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		grid.getPanel().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		//opponentGrid.getPanel().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
>>>>>>> ships_v1
		
		grid = new Grid();
		gamePanel.add(grid.getPanel(), BorderLayout.CENTER);
<<<<<<< HEAD
		gamePanel.add(infoLabel2, BorderLayout.SOUTH);
		container.add(gamePanel);
		//gamePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		//grid.getPanel().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		opponentGrid = new Grid(1);
	    opponentPanel.add(opponentGrid.getPanel(), BorderLayout.CENTER);
		opponentPanel.add(opponentLabel2, BorderLayout.SOUTH);
		container.add(opponentPanel);
		
		Menu menu = new Menu();
	    setJMenuBar(menu); // adds menu object to frame
	    		    
	    this.add(container); // add two panels side-by-side to the frame    	    
		this.setSize(1100, 600);		
=======
		//gamePanel.add(opponentGrid.getPanel(), BorderLayout.EAST);
		
		gamePanel.add(infoLabel, BorderLayout.SOUTH);
		Menu menu = new Menu();
	    setJMenuBar(menu); // adds menu object to frame
		this.add(gamePanel);
		this.setSize(500, 500);
>>>>>>> ships_v1
		this.setTitle("Battleship");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public static void setInfo(String s)
	{
<<<<<<< HEAD
		infoLabel2.setText(s);
	}
	public static void setOpponentInfo(String s)
	{
		opponentLabel2.setText(s);
=======
		infoLabel.setText(s);
>>>>>>> ships_v1
	}
}
