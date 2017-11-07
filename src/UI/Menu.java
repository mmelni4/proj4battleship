package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/******************************************************************
 *                                                                *
 * Menu class contains JMenu Items with short descriptions        *
 * Features used:                                                 *
 *                                                                *
 ******************************************************************/

@SuppressWarnings("serial")
public class Menu extends JMenuBar implements ActionListener{

	JMenu menu, submenu;
	JMenuItem menuItem;
	
	//JMenu Help box section is divided in two sub menu items for easier use
	public Menu() {

		menu = new JMenu("Menu");
		  submenu = new JMenu("Help Menu");
			menuItem = new JMenuItem("Connection Info"); // Help on connection side of the program
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(menuItem, 
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
			menu.add(menuItem);
			menuItem = new JMenuItem("View Statistics");
			menu.add(menuItem);
			menuItem = new JMenuItem("About"); //display names of authors with netID's
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(menu, 
							"Authors:"
							+ "\n1.Mariia Melnikova (mmelni4)"
							+ "\n2.Michael Wilkie (mwilkie2)");
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
	
	public void actionPerformed(ActionEvent e) {
	//...Get information from the action event...
	//...Display it in the text area...
	}


}

