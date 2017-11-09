package UI;

import java.awt.ComponentOrientation;
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

public class Ribbon 
{
    private JPanel    rPanel;
    private BoxLayout layout;
    private JButton   rotateButton;
    private JButton   carrierButton;
    private JButton   gunshipButton;
    private JButton   subButton;
    private JButton   destroyerButton;
    private JButton   patrolButton;
    
    private static ArrayList<Ship> shiplist;
    private ActionListener boatListener;
    public static Shiptype shiptype;
    public static Direction direction;
    public static boolean selectMode = false;
    
    public Ribbon()
    {
        shiptype = Shiptype.CARRIER;
        shiplist = new ArrayList<Ship>();
        direction = Direction.EAST;
        rPanel = new JPanel();
        layout = new BoxLayout(rPanel,BoxLayout.Y_AXIS);
        
        rPanel.setLayout(layout);
        rPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        rotateButton    = new JButton("Rotate"     );
        carrierButton   = new JButton("Carrier"    );
        gunshipButton   = new JButton("Gunship"    );
        subButton       = new JButton("Submarine"  );
        destroyerButton = new JButton("Destroyer"  );
        patrolButton    = new JButton("Patrol Boat");
        
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
    public static void addShip(Ship s)
    {
    	shiplist.add(s);
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
