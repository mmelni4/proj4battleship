package UI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import Boat.Carrier;
import Boat.Destroyer;
import Boat.Direction;
import Boat.Gunship;
import Boat.PatrolBoat;
import Boat.Ship;
import Boat.Shiptype;
import Boat.Submarine;
import ImageOp.ImgFunc;
import Logic.Point;

public class Cell 
{
	Point pos;
	JLabel img;
	Ship ship;
	Status status;
	
	public Cell()
	{
		pos = new Point(0, 0);
		img = ImgFunc.getDefaultImage();
		ship = null;
		status = Status.EMPTY;
		addListener();
	}
	public Cell(int id)
	{
		pos = new Point(0, 0);
		img = ImgFunc.getDefaultImage();
		ship = null;
		status = Status.EMPTY;
		addOppListener();
	}
	public Cell(int x, int y)
	{
		pos = new Point(x, y);
		img = ImgFunc.getDefaultImage();
		ship = null;
		status = status.EMPTY;
		addListener();
	}
	public Cell(int x, int y, int id)
	{
		
		pos = new Point(x, y);
		img = ImgFunc.getDefaultImage();
		ship = null;
		status = status.UNTOUCHED;
		addOppListener();
	}
	public JLabel getImage()
	{
		return img;
	}
	public Point getPos()
	{
		return pos;
	}
	private void setImage(JLabel image)
	{
		img.setIcon(image.getIcon());
	}
	
	//set Status of current situation in cell
	// 0 = empty by default
	// 1 = untouched
	// 2 = hit
	// 3 = miss
	public void setStatus(Status status)
	{
		this.status = status;
	}
	
	//get the Status of this cell
	public Status getStatus()
	{
		return status;
	}
	// A valid position is one where:
	//	I am within the grid limits &&
	//	I am not touching other ships
	public boolean validPos(Ship s)
	{
		Direction d = s.getDirection();
		int x = -1;
		int y = -1;
		// Am I within the grid limits?
		switch(d)
		{
		case NORTH:	x = pos.x + s.getLength() - 1;	break;
		case EAST :	y = pos.y - s.getLength() + 1;	break;
		case SOUTH:	x = pos.x - s.getLength() + 1;	break;
		case WEST :	y = pos.y + s.getLength() - 1;	break;
		}
		
		if ((x < 0 || x > 9) && (y < 0 || y > 9))
			return false;
		// Am I touching any other ships?
		switch(d)
		{
			case NORTH:	
				for (int i = 0; i < s.getLength(); i++) 
					if (Ribbon.shipUsed(Grid.get(pos.x + i, pos.y).ship))
						return false;
				break;
			case EAST :	
				for (int i = 0; i < s.getLength(); i++)
					if (Ribbon.shipUsed(Grid.get(pos.x, pos.y - i).ship))
						return false;
				break;
			case SOUTH:	
				for (int i = 0; i < s.getLength(); i++) 
					if (Ribbon.shipUsed(Grid.get(pos.x - i, pos.y).ship))
						return false;
				break;
			case WEST :	
				for (int i = 0; i < s.getLength(); i++)
					if (Ribbon.shipUsed(Grid.get(pos.x, pos.y + i).ship))
						return false;
				break;
		}
		return true;
	}
	// I can only add a ship if:
	//	It is a valid position to put it there
	// Otherwise, Cell's current ship is now the new ship, and paint it.
	public boolean addShip(Ship s)
	{
		if (!validPos(s))
			return false;
		ship = s;
		paintShip();
		
		return true;
	}
	public boolean removeShip()
	{
		if (ship == null)
			return false;
		if (Ribbon.shipUsed(ship))
			return false;
		unpaintShip();
		ship = null;
		
		return true;
	}
	private void paintShip()
	{
		Cell c; // use this to save a few memory references, and make code easier to read
		switch (ship.getDirection())
		{
		case NORTH:
			ImgFunc.setDirection(ship, "north");
			for (int i = 0; i < ship.getLength(); i++)
			{
				c = Grid.get(pos.x + i, pos.y);
				c.setImage(ship.getBodyImage(i));
				c.ship = ship;
			}
			break;
		case EAST:
			ImgFunc.setDirection(ship, "east");
			for (int i = 0; i < ship.getLength(); i++)
			{
				c = Grid.get(pos.x, pos.y - i);
				c.setImage(ship.getBodyImage(i));
				c.ship = ship;
			}
			break;
		case SOUTH:
			ImgFunc.setDirection(ship, "south");
			for (int i = 0; i < ship.getLength(); i++)
			{
				c = Grid.get(pos.x - i, pos.y);
				c.setImage(ship.getBodyImage(i));
				c.ship = ship;
			}
			break;
		case WEST:
			ImgFunc.setDirection(ship, "west");
			for (int i = 0; i < ship.getLength(); i++)
			{
				c = Grid.get(pos.x, pos.y + i);
				c.setImage(ship.getBodyImage(i));
				c.ship = ship;
			}
			break;
		}
	}
	private void unpaintShip()
	{
		Point position = ship.getPosition();
		switch (ship.getDirection())
		{
		case NORTH:
			ImgFunc.setDirection(ship, "north");
			for (int i = 0; i < ship.getLength(); i++)
				Grid.get(position.x + i, position.y).setImage(ImgFunc.getDefaultImage());
			break;
		case EAST:
			ImgFunc.setDirection(ship, "east");
			for (int i = 0; i < ship.getLength(); i++)
				Grid.get(position.x, position.y - i).setImage(ImgFunc.getDefaultImage());
			break;
		case SOUTH:
			ImgFunc.setDirection(ship, "south");
			for (int i = 0; i < ship.getLength(); i++)
				Grid.get(position.x - i, position.y).setImage(ImgFunc.getDefaultImage());
			break;
		case WEST:
			ImgFunc.setDirection(ship, "west");
			for (int i = 0; i < ship.getLength(); i++)
				Grid.get(position.x, position.y + i).setImage(ImgFunc.getDefaultImage());
			break;
		}
	}
	private Ship getShip(Shiptype s)
	{
		Ship boat = null;
		switch(s)
		{
		case CARRIER   : boat = new Carrier   (Ribbon.direction, pos); break;
		case GUNSHIP   : boat = new Gunship   (Ribbon.direction, pos); break;
		case SUBMARINE : boat = new Submarine (Ribbon.direction, pos); break;
		case DESTROYER : boat = new Destroyer (Ribbon.direction, pos); break;
		case PATROLBOAT: boat = new PatrolBoat(Ribbon.direction, pos); break;
		}
		return boat;
	}
	private void addListener()
	{
		img.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				
				if (ship == null) // Don't do anything if I clicked a blank cell
					Battleship.setInfo("Ship: No ship here");
				else if (Ribbon.selectMode)
				{
					Ribbon.addShip(ship); // Add ship to used ship list to keep it from being removed
					Ribbon.disableSelected();
					Ribbon.shipsUsed++;
					if (Ribbon.shipsUsed == 5)
						Battleship.setReady(true);
				}
				else
					Battleship.setInfo("Ship: " + ship.toString());
				Ribbon.selectMode = false;	// Invert select mode
			}
				@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				if (Ribbon.selectMode) // Am I in select mode, and is there a placed ship here?
					if (addShip(getShip(Ribbon.shiptype)))
						Battleship.setInfo("Ship set at " + pos);
					else
						Battleship.setInfo("Error adding ship at " + pos);
					
			}
				@Override
			public void mouseExited(MouseEvent arg0) 
			{
				if (Ribbon.selectMode) // Am I in select mode, and is there a placed ship here?
					if (removeShip())
						Battleship.setInfo("Ship removed at " + pos);
					else
						Battleship.setInfo("Error removing ship at " + pos);
			}
				@Override
			public void mousePressed(MouseEvent arg0) {}
				@Override
			public void mouseReleased(MouseEvent arg0) {}
	
		});
	}
	private void addOppListener()
	{
		img.addMouseListener(new MouseListener()
				{
					@Override
					public void mouseClicked(MouseEvent arg0)
					{
						//if (Battleship.boardisReady() && Battleship.ismyTurn())
						//{
							// Server
							if (Battleship.server.isServer())
							{
								Battleship.server.SendData(pos);
							}
							// Client
							else
							{
								Battleship.client.SendData(pos);
							}
							Battleship.useTurn();
						//}
						//else if (!Battleship.ismyTurn())
						//{
							if (Battleship.isServer())
							{
								Battleship.server.ReceiveData();
							}
							else
							{
								Battleship.client.ReceiveData();
							}
							Battleship.useTurn();
						//}
					}


					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
	}
}
