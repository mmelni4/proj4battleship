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
	public Menu() {

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
							+ "\nThe goal of the game is "
							+ "to...");
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
	
	public void itemStateChanged(ItemEvent e) {
	//...Get information from the item event...
	//...Display it in the text area...
	
	}


}

