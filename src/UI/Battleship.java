package UI;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Battleship extends JFrame 
{
	static Ribbon ribbon;
	static JPanel panel;
	static JPanel gamePanel;
	static JPanel opponentGamePanel;
	
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
		panel = new JPanel();
		ribbon = new Ribbon();
		gamePanel = new JPanel();
		//opponentGamePanel = new JPanel();
		
		infoLabel = new JLabel("Game status");
		//opponentInfoLabel = new JLabel("Opponent status");
		
		grid = new Grid();
		//opponentGrid = new Grid();
		
		panel.setLayout(new BorderLayout());
		
		gamePanel.setLayout(new BorderLayout());
				
		//gamePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		//grid.getPanel().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		//opponentGrid.getPanel().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		gamePanel.add(grid.getPanel(), BorderLayout.NORTH);
		//gamePanel.add(opponentGrid.getPanel(), BorderLayout.EAST);
		
		gamePanel.add(ribbon.getPanel());
		gamePanel.add(infoLabel, BorderLayout.SOUTH);
		panel.add(gamePanel, BorderLayout.CENTER);
		panel.add(ribbon.getPanel(), BorderLayout.EAST);
		Menu menu = new Menu();
	    setJMenuBar(menu); // adds menu object to frame
		this.add(panel);
		this.setSize(525, 500);
		this.setTitle("Battleship");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void setInfo(String s)
	{
		infoLabel.setText(s);
	}
}
