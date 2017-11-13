package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import Connection.Client;
import Connection.Server;

/******************************************************************
 *                                                                *
 * Menu class contains JMenu Items with short descriptions        *
 * Features used:                                                 *
 *                                                                *
 ******************************************************************/

@SuppressWarnings("serial")
public class Menu extends JMenuBar implements ActionListener, ItemListener{

	JMenu menu, submenu;
	JMenuItem menuItem;
	
	//JMenu Help box section is divided in two sub menu items for easier use
	public Menu() 
	{

		menu = new JMenu("Menu");
		  submenu = new JMenu("Help Menu");
			menuItem = new JMenuItem("Connection Info"); // Help on connection side of the program
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(menu, 
							"How Connection Side works:\n");
					}	  
			});
			submenu.add(menuItem);
			menuItem = new JMenuItem("Game Rules"); // battleship game rules
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(menu, 
							"How to Play Battleship:"
									+ "\nThe game is played on four squares"
									+ "\nEach player has two grids, one for its own ships"
									+ "\nOther grid is to keep track of opponent ships."
									+ "\nStart with placing ships on your grid:"
									+ "\n1 Aircraft Carrier of size 5"
									+ "\n1 Battleship of size 4"
									+ "\nOne destroyer of size 3"
									+ "\nOne submarine of size 3"
									+ "\nAnd one patrol boat of size 2"
									+ "\nEach player has the same number of ships"
									+ "\nShips cannot overlap and be placed outside of borders"
									+ "\nOnce all the ships has been placed,"
									+ "\nProceed to establish connection"
									+ "\nWhen all of your/your opponent ships are sink"
									+ "\nGame is over");
				}
			});
			submenu.add(menuItem);
		menu.add(submenu);
			menuItem = new JMenuItem("Establish Connection"); 
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try 
					{
						Battleship.server = new Server();
						if (!Battleship.server.isServer())
						{
							Battleship.client = new Client();
							Ribbon.setEnableAllButtons(true);
						}
						if (Battleship.server.isServer())
							Ribbon.setEnableAllButtons(true);
							
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			menu.add(menuItem);
			menuItem = new JMenuItem("View Statistics");
			menu.add(menuItem);
			menuItem = new JMenuItem("About"); //display names of authors with netID's
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(menu, 
							"Authors:"
							+ "\n1.Mariia Melnikova (mmelni4)"
							+ "\n2.Michael Wilkie (mwilki7)");
				}
			});
			menu.add(menuItem);	
			menuItem = new JMenuItem("Quit"); 	
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(WindowConstants.EXIT_ON_CLOSE);
				}
			});
			menu.add(menuItem);
		this.add(menu);
		
	//...for each JMenuItem instance:
	menuItem.addActionListener(this);
	
	
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		JMenuItem j = (JMenuItem) e.getSource();
	}
	
	public void itemStateChanged(ItemEvent e) {
	//...Get information from the item event...
	//...Display it in the text area...
	
	}


}

