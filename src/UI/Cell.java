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
		paintShip(s);
		
		return true;
	}
	private void paintShip(Ship s)
	{
		switch (s.getDirection())
		{
		case NORTH:
			ImgFunc.setDirection(s, "north");
			for (int i = 0; i < s.getLength(); i++)
				Grid.get(pos.x + i, pos.y).setImage(s.getBodyImage(i));
			break;
		case EAST:
			ImgFunc.setDirection(s, "east");
			for (int i = 0; i < s.getLength(); i++)
				Grid.get(pos.x, pos.y - i).setImage(s.getBodyImage(i));
			break;
		case SOUTH:
			ImgFunc.setDirection(s, "south");
			for (int i = 0; i < s.getLength(); i++)
				Grid.get(pos.x - i, pos.y).setImage(s.getBodyImage(i));
			break;
		case WEST:
			ImgFunc.setDirection(s, "west");
			for (int i = 0; i < s.getLength(); i++)
				Grid.get(pos.x, pos.y + i).setImage(s.getBodyImage(i));
			break;
		}
	}
	private void addListener()
	{
		img.addMouseListener(new MouseListener()
				{
					@Override
					public void mouseClicked(MouseEvent arg0)
					{
						if (addShip(new Carrier(Direction.WEST, pos)))
							Battleship.setInfo("Ship set at " + pos);
						else
							Battleship.setInfo("Error adding ship at " + pos);
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
