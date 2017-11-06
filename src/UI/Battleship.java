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
<<<<<<< HEAD
=======
	static JPanel opponentGamePanel;
	static JPanel guiParent;
	
>>>>>>> 207e30db6e93a02aae606ae7c60d7e14850b4093
	static JLabel infoLabel;
	private static Grid grid;
	
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
		infoLabel = new JLabel("Game status");
		grid = new Grid();
		
		gamePanel.setLayout(new BorderLayout());
				
		gamePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		grid.getPanel().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		gamePanel.add(grid.getPanel(), BorderLayout.CENTER);
		gamePanel.add(infoLabel, BorderLayout.SOUTH);
		Menu menu = new Menu();
	    setJMenuBar(menu); // adds menu object to frame
<<<<<<< HEAD
		this.add(gamePanel);
		this.setSize(500, 500);
=======
	    
	    gui.add(opponentGamePanel);
	    gui.add(gamePanel);
	    
	    this.add(gui); // add two panels side-by-side to the frame    
	    
		this.setSize(1000, 500);
		
>>>>>>> 207e30db6e93a02aae606ae7c60d7e14850b4093
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
