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
	int status;
	
	public Cell()
	{
		pos = new Point(0, 0);
		img = ImgFunc.getDefaultImage();
		ship = null;
		status = 0;
		addListener();
	}
	public Cell(int x, int y)
	{
		pos = new Point(x, y);
		img = ImgFunc.getDefaultImage();
		ship = null;
		addListener();
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
	public void setStatus(int status)
	{
		this.status = status;
	}
	
	//get the Status of this cell
	public int getStatus()
	{
		return status;
	}
	
	public boolean validPos(Ship s)
	{
		Direction d = s.getDirection();
		int x = -1;
		int y = -1;
		switch(d)
		{
		case NORTH:	x = pos.x + s.getLength() - 1;	break;
		case EAST:	y = pos.y - s.getLength() + 1;	break;
		case SOUTH:	x = pos.x - s.getLength() + 1;	break;
		case WEST:	y = pos.y + s.getLength() - 1;	break;
		}
		return !((x < 0 || x > 9) && (y < 0 || y > 9));
	}
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
		unpaintShip();
		ship = null;
		
		return true;
	}
	private void paintShip()
	{
		switch (ship.getDirection())
		{
		case NORTH:
			ImgFunc.setDirection(ship, "north");
			for (int i = 0; i < ship.getLength(); i++)
				Grid.get(pos.x + i, pos.y).setImage(ship.getBodyImage(i));
			break;
		case EAST:
			ImgFunc.setDirection(ship, "east");
			for (int i = 0; i < ship.getLength(); i++)
				Grid.get(pos.x, pos.y - i).setImage(ship.getBodyImage(i));
			break;
		case SOUTH:
			ImgFunc.setDirection(ship, "south");
			for (int i = 0; i < ship.getLength(); i++)
				Grid.get(pos.x - i, pos.y).setImage(ship.getBodyImage(i));
			break;
		case WEST:
			ImgFunc.setDirection(ship, "west");
			for (int i = 0; i < ship.getLength(); i++)
				Grid.get(pos.x, pos.y + i).setImage(ship.getBodyImage(i));
			break;
		}
	}
	private void unpaintShip()
	{
		switch (ship.getDirection())
		{
		case NORTH:
			ImgFunc.setDirection(ship, "north");
			for (int i = 0; i < ship.getLength(); i++)
				Grid.get(pos.x + i, pos.y).setImage(ImgFunc.getDefaultImage());
			break;
		case EAST:
			ImgFunc.setDirection(ship, "east");
			for (int i = 0; i < ship.getLength(); i++)
				Grid.get(pos.x, pos.y - i).setImage(ImgFunc.getDefaultImage());
			break;
		case SOUTH:
			ImgFunc.setDirection(ship, "south");
			for (int i = 0; i < ship.getLength(); i++)
				Grid.get(pos.x - i, pos.y).setImage(ImgFunc.getDefaultImage());
			break;
		case WEST:
			ImgFunc.setDirection(ship, "west");
			for (int i = 0; i < ship.getLength(); i++)
				Grid.get(pos.x, pos.y + i).setImage(ImgFunc.getDefaultImage());
			break;
		}
		ship = null;
	}
	private Ship getShip(Shiptype s)
	{
		Ship boat = null;
		switch(s)
		{
		case CARRIER:
		{
			boat = new Carrier(Ribbon.direction, pos);
			break;
		}
		case GUNSHIP:
		{
			boat = new Gunship(Ribbon.direction, pos);
			break;
		}
		case SUBMARINE:
		{
			boat = new Submarine(Ribbon.direction, pos);
			break;
		}
		case DESTROYER:
		{
			boat = new Destroyer(Ribbon.direction, pos);
			break;
		}
		case PATROLBOAT:
		{
			boat = new PatrolBoat(Ribbon.direction, pos);
			break;
		}
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
				Ribbon.selectMode = false;	// Invert select mode
				if (ship == null) // Don't do anything if I clicked a blank cell
					return;
				else
					Ribbon.addShip(ship); // Add ship to used ship list to keep it from being removed
			}
				@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				if (Ribbon.selectMode && !Ribbon.shipUsed(ship)) // Am I in select mode, and is there a placed ship here?
					if (addShip(getShip(Ribbon.shiptype)))
						Battleship.setInfo("Ship set at " + pos);
					else
						Battleship.setInfo("Error adding ship at " + pos);	
			}
				@Override
			public void mouseExited(MouseEvent arg0) 
			{
				if (Ribbon.selectMode && !Ribbon.shipUsed(ship)) // Am I in select mode, and is there a placed ship here?
					if (removeShip())
						Battleship.setInfo("Ship set at " + pos);
					else
						Battleship.setInfo("Error removing ship at " + pos);
			}
				@Override
			public void mousePressed(MouseEvent arg0) {}
				@Override
			public void mouseReleased(MouseEvent arg0) {}
	
		});
	}
}
