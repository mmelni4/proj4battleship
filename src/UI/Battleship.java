package UI;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Battleship extends JFrame 
{
	static JPanel gamePanel;
	static JLabel infoLabel;
	private static Grid grid;
	
	public static void main(String args[])
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		Battleship b = new Battleship();
	}
	public Battleship()
	{
		gamePanel = new JPanel();
		infoLabel = new JLabel("Game status");
		grid = new Grid();
		
		gamePanel.setLayout(new BorderLayout());
				
		gamePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		grid.getPanel().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		gamePanel.add(grid.getPanel(), BorderLayout.CENTER);
		gamePanel.add(infoLabel, BorderLayout.SOUTH);
		
		this.add(gamePanel);
		this.setSize(500, 500);
		this.setTitle("Battleship");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public static void setInfo(String s)
	{
		infoLabel.setText(s);
	}
}
