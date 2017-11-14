package UI;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Boat.Carrier;
import Boat.Destroyer;
import Boat.Direction;
import Boat.Gunship;
import Boat.PatrolBoat;
import Boat.Ship;
import Boat.Shiptype;
import Boat.Submarine;
import java.awt.FlowLayout;

public class Ribbon 
{
    private JPanel    rPanel;
    private BoxLayout layout;
    private static JButton   rotateButton;
    private static JButton   carrierButton;
    private static JButton   gunshipButton;
    private static JButton   subButton;
    private static JButton   destroyerButton;
    private static JButton   patrolButton;
    
    private static JButton   selectedButton;
    
    private static ArrayList<Ship> shiplist;
    private ActionListener boatListener;
    public static Shiptype shiptype;
    public static Direction direction;
    public static int shipsUsed = 0;
    public static boolean selectMode = false;
    
    public Ribbon()
    {
        shiptype = Shiptype.CARRIER;
        shiplist = new ArrayList<Ship>();
        direction = Direction.EAST;
        rPanel = new JPanel();
        layout = new BoxLayout(rPanel,BoxLayout.Y_AXIS);
        //layout = new FlowLayout(FlowLayout.LEFT);
        rPanel.setLayout(layout);
        rPanel.setPreferredSize(new Dimension(100, 25));
        rPanel.setMinimumSize(new Dimension(100, 25));
        rPanel.setMaximumSize(new Dimension(100, 25));
        rPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        rotateButton    = new JButton("Rotate"     );
        carrierButton   = new JButton("Carrier"    );
        gunshipButton   = new JButton("Gunship"    );
        subButton       = new JButton("Submarine"  );
        destroyerButton = new JButton("Destroyer"  );
        patrolButton    = new JButton("Patrol Boat");
        selectedButton  = null;
        
        addListener();
        
        carrierButton  .addActionListener(boatListener);
        gunshipButton  .addActionListener(boatListener);
        subButton      .addActionListener(boatListener);
        destroyerButton.addActionListener(boatListener);
        patrolButton   .addActionListener(boatListener);
        
        rotateButton.setMnemonic(KeyEvent.VK_R);
        
        rPanel.add(rotateButton   );
        rPanel.add(carrierButton  );
        rPanel.add(gunshipButton  );
        rPanel.add(subButton      );
        rPanel.add(destroyerButton);
        rPanel.add(patrolButton   );
        
        setEnableAllButtons(false);
    }
    private void setSize(JButton j)
    {
    	//j.setPreferredSize(new Dimension(450, 10));
    }
    public JPanel getPanel()
    {
        return rPanel;
    }
    private void addListener()
    {
        boatListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	selectMode = true;
                // Set type of ship to create when placing them on the board
                JButton ship = (JButton) e.getSource();
                selectedButton = ship;
                if (ship.getText().equals("Carrier"        )) shiptype = Shiptype.CARRIER   ;
                else if(ship.getText().equals("Gunship"    )) shiptype = Shiptype.GUNSHIP   ;
                else if(ship.getText().equals("Submarine"  )) shiptype = Shiptype.SUBMARINE ;
                else if(ship.getText().equals("Destroyer"  )) shiptype = Shiptype.DESTROYER ;
                else if(ship.getText().equals("Patrol Boat")) shiptype = Shiptype.PATROLBOAT;
            }    
        };
        rotateButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                // Rotate counter-clockwise
                if      (direction == Direction.NORTH) direction = Direction.WEST ;
                else if (direction == Direction.WEST ) direction = Direction.SOUTH;
                else if (direction == Direction.SOUTH) direction = Direction.EAST ;
                else if (direction == Direction.EAST ) direction = Direction.NORTH;
            }
            
        });
    }
    public static void setEnableAllButtons(boolean b)
    {
    	rotateButton.setEnabled(b)   ;
        carrierButton.setEnabled(b)  ;
        gunshipButton.setEnabled(b)  ;
        subButton.setEnabled(b)  ;
        destroyerButton.setEnabled(b);
        patrolButton.setEnabled(b);
    }
    public static void disableSelected()
    {
    	selectedButton.setEnabled(false);
    }
    public static void addShip(Ship s)
    {
    	shiplist.add(s);
    }
    public static void removeShip(Ship s)
        {
        	shiplist.remove(s);
        }
    public static boolean isGridEmpty()
        {
        	if (shiplist.size() == 0)
        		return false;
        	else
        		return true;
        }
    public static boolean shipUsed(Ship s)
    {
    	if (s == null)
    		return false;
    	if (shiplist.contains(s))
    		return true;
    	return false;
    }
}
