package UI;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connection.Client;
import Connection.Server;


public class Battleship extends JFrame 
{
	static Ribbon ribbon;
	static JPanel panel;
	static JPanel gamePanel;
	static JPanel opponentPanel;
	static JPanel container;	
	static JLabel infoLabel;
	static JLabel opponentLabel;
	static JLabel infoLabel2;
	static JLabel opponentLabel2;	
	static JLabel opponentInfoLabel;
	private FlowLayout layout;
	private static Grid grid;
	private static OpponentGrid opponentGrid;
	private static boolean ready;
	private static boolean bServer = false;
	public static Server server;
	public static Client client;
	
	public static void main(String args[])
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		Battleship b = new Battleship();
	}
	public Battleship()
	{
		ready = false;
		panel = new JPanel();
		ribbon = new Ribbon();
		container = new JPanel();		
		container.setLayout(new GridLayout(1,2)); // one row, two columns layout
		layout = new FlowLayout();
	    container.setLayout( layout );
		container.setBorder(new EmptyBorder(10,10,10,10));
		
		gamePanel = new JPanel();
		gamePanel.setLayout(new BorderLayout());
		infoLabel = new JLabel("Your Game Status");
		
		infoLabel2 = new JLabel("Updates will be shown here");
		grid = new Grid();
		gamePanel.add(grid.getPanel(), BorderLayout.CENTER);
		
		panel.setLayout(new BorderLayout());
		
		gamePanel.setLayout(new BorderLayout());
				
		opponentPanel = new JPanel();
		opponentPanel.setLayout(new BorderLayout());
		opponentLabel = new JLabel("Your Opponent Status");
		opponentPanel.add(opponentLabel, BorderLayout.NORTH);
		opponentLabel2 = new JLabel("Updates for Opponent will be shown here");
		opponentGrid = new OpponentGrid();
	    opponentPanel.add(opponentGrid.getOppPanel(), BorderLayout.CENTER);
		opponentPanel.add(opponentLabel2, BorderLayout.SOUTH);
		
		gamePanel.add(grid.getPanel(), BorderLayout.NORTH);
		
		gamePanel.add(ribbon.getPanel());
		panel.add(infoLabel, BorderLayout.NORTH);
		panel.add(infoLabel2, BorderLayout.SOUTH);
		panel.add(gamePanel, BorderLayout.CENTER);
		panel.add(ribbon.getPanel(), BorderLayout.EAST);
		container.add(panel);
		container.add(opponentPanel);
		Menu menu = new Menu();
	    setJMenuBar(menu); // adds menu object to frame
		this.add(container);
		this.setSize(1025, 550);
		this.setTitle("Battleship");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void setReady(boolean b)
	{
		ready = b;
	}
	public static boolean connectionReady()
	{
		return false;
	}
	public static boolean boardisReady()
	{
		return ready;
	}
	public static boolean isServer()
	{
		return bServer;
	}
	public static void setServer(boolean b)
	{
		bServer = b;
	}
	public static void setInfo(String s)
	{
		infoLabel2.setText(s);
	}
	public static void setOpponentInfo(String s)
	{
		opponentLabel2.setText(s);
	}
}
