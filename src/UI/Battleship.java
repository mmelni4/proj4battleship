// main class Battleship initiates the game
// Game doesn't start until connection is successfully
// established initiated from Menu class 
// Battleship sets up a "parent" container for two JPanels
// that sets them side by side, using separate classes for differentiation
// Each "child" panel has two labels, one to display the players grid
// Another label is to display grid information, 
// every time Button(JLabel/Cell) is pressed, information about coordinates
// or when Error is encountered 


package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Connection.Client;
import Connection.Server;

@SuppressWarnings("serial")
public class Battleship extends JFrame 
{
	static Ribbon ribbon; // Buttons to click when placing ships on the grid
	static JPanel panel; // "parent" panel
	static JPanel gamePanel; // "child" panel located on the right that represents player's grid
	static JPanel opponentPanel; // panel located on the right side, represents opponent's
	static JPanel container;	
	static JLabel infoLabel;
	static JLabel opponentLabel;
	static JLabel infoLabel2;
	static JLabel opponentLabel2;	
	static JLabel opponentInfoLabel;
	static JPanel labelPanel;
	//static JPanel letters;
	static JLabel letters;
	private FlowLayout layout;
	private static Grid grid;
	private static OpponentGrid opponentGrid;
	private static boolean ready;
	private static boolean bServer = false;
	public static Server server;
	public static Client client;
	private static boolean myturn = false;
	
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
		labelPanel = new JPanel();
		labelPanel.setLayout(new BorderLayout());
		container = new JPanel();		
		container.setLayout(new GridLayout(1,2)); // one row, two columns layout
		layout = new FlowLayout();
		letters = new JLabel("    A           B            C          D"
				+ "           E             F             G          "
				+ "  H           I           J");
		//letters = new JPanel();
		/*JLabel[] labels=new JLabel[10];
		        for (int i=0;i<10;i++){
		            labels[i]= new JLabel("     " + i + "     ");
		            letters.add(labels[i]);
		        }*/
		container.setLayout( layout );
		container.setBorder(new EmptyBorder(10,10,10,10));
		
		gamePanel = new JPanel();
		gamePanel.setLayout(new BorderLayout());
		infoLabel = new JLabel("Your Game Status");
		
		infoLabel2 = new JLabel("Updates will be shown here");
		grid = new Grid();
		//grid.getPanel().setLayout(new BorderLayout());
		//grid.getPanel().add(letters);
		//gamePanel.add(grid.getPanel(), BorderLayout.CENTER);
		
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
		labelPanel.add(infoLabel, BorderLayout.NORTH);
		labelPanel.add(letters, BorderLayout.SOUTH);
		gamePanel.add(ribbon.getPanel());
		panel.add(labelPanel, BorderLayout.NORTH);
		//panel.add(infoLabel, BorderLayout.NORTH);
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
	public static Grid getGrid()
	{
		return grid;
	}
	public static void setInfo(String s)
	{
		infoLabel2.setText(s); // info displayed in players Grid label
	}
	public static boolean ismyTurn()
	{
		return myturn;
	}
	public static void useTurn()
	{
		myturn = !myturn;
	}
	public static void setOpponentInfo(String s)
	{
		opponentLabel2.setText(s); // info displayed in opponents Grid
	}
}
