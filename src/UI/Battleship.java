// main class Battleship initiates the game
// Game doesn't start until connection is successfully
// established initiated from Menu class 
// Battleship sets up a "parent" container for two JPanels
// that sets them side by side, using separate classes for differentiation
// Each "child" panel has two labels, one to display the players grid
// Another label is to display grid information, 
// every time Button(JLabel/Cell) is pressed, information about coordinates
// or when Error is encountered 
// Letters indicating position of the board are represented as JLabel component
// nested in the Grid North label area


package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Connection.Client;
import Connection.Server;

@SuppressWarnings("serial")
public class Battleship extends JFrame 
{
	static JPanel container; // "parent" panel
	static Ribbon ribbon; // Buttons to click when placing ships on the grid
	static JPanel panel; // player's panel
	static JPanel gamePanel; // "child" panel located on the right that represents player's grid
	static JPanel opponentPanel; // panel located on the right side, represents opponent's	
	static JLabel infoLabel;
	static JLabel infoLabel2;
	static JLabel opponentLabel;
	static JLabel opponentLabel2;	
	static JPanel labelPanel;
	static JPanel labelPanelOp;
	static JLabel letters;
	static JLabel lettersOp;
	static JLabel verticalIndicators;
	static JLabel verticalIndicatorsOp;
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
		labelPanelOp = new JPanel();
		labelPanel.setLayout(new BorderLayout());
		labelPanelOp.setLayout(new BorderLayout());
		container = new JPanel();		
		container.setLayout(new GridLayout(1,4)); // one row, two columns layout
		layout = new FlowLayout();
		letters = new JLabel("    A            B            C          D"
				+ "           E             F            G          "
				+ " H           I           J");
		lettersOp = new JLabel("    A            B            C          D"
				+ "           E             F            G          "
				+ " H           I           J");
		verticalIndicators = new JLabel();
		verticalIndicators.setFont(new Font("Serif", Font.BOLD, 15));
		verticalIndicators.setText("<HTML><br>1<br><br>2<br><br>3<br><br>4<br><br>5<br><br>"
				+ "6<br><br>7<br><br>8<br><br>9<br><br>10<br></HTML>");
		verticalIndicatorsOp = new JLabel();
		verticalIndicatorsOp.setFont(new Font("Serif", Font.BOLD, 15));
		verticalIndicatorsOp.setText("<HTML><br>1<br><br>2<br><br>3<br><br>4<br><br>5<br><br>"
				+ "6<br><br>7<br><br>8<br><br>9<br><br>10<br></HTML>");
		container.setLayout( layout );
		container.setBorder(new EmptyBorder(10,10,10,10));
		
		gamePanel = new JPanel();
		gamePanel.setLayout(new BorderLayout());
		infoLabel = new JLabel("Your Game Status");
		
		infoLabel2 = new JLabel("Updates will be shown here");
		grid = new Grid();
		
		panel.setLayout(new BorderLayout());
		
		gamePanel.setLayout(new BorderLayout());
				
		opponentPanel = new JPanel();
		opponentPanel.setLayout(new BorderLayout());
		opponentLabel = new JLabel("Your Opponent Status");
		opponentLabel2 = new JLabel("Updates for Opponent will be shown here");
		opponentGrid = new OpponentGrid();
	    opponentPanel.add(opponentGrid.getOppPanel(), BorderLayout.CENTER);
		opponentPanel.add(opponentLabel2, BorderLayout.SOUTH);
		
		gamePanel.add(grid.getPanel(), BorderLayout.NORTH);	
		labelPanel.add(infoLabel, BorderLayout.NORTH);
		labelPanel.add(letters, BorderLayout.SOUTH);
		labelPanelOp.add(opponentLabel, BorderLayout.NORTH);
		labelPanelOp.add(lettersOp, BorderLayout.SOUTH);
		gamePanel.add(ribbon.getPanel());
		//gamePanel.add(verticalIndicators, BorderLayout.WEST);
		panel.add(labelPanel, BorderLayout.NORTH);
		opponentPanel.add(labelPanelOp, BorderLayout.NORTH);
		panel.add(infoLabel2, BorderLayout.SOUTH);
		panel.add(gamePanel, BorderLayout.CENTER);
		panel.add(ribbon.getPanel(), BorderLayout.EAST);
		container.add(verticalIndicators);
		container.add(panel);
		container.add(verticalIndicatorsOp);
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
	public static OpponentGrid getOppGrid()
	{
		return opponentGrid;
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