package UI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import Boat.Carrier;
import Boat.Direction;
import Boat.Ship;
import ImageOp.ImgFunc;
import Logic.Point;

public class Cell 
{
	Point pos;
	JLabel img;
	Ship ship;
	int status;
	//int id;
	
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

	public Cell(int x, int y, int id)
	{
		
		pos = new Point(x, y);
		img = ImgFunc.getDefaultImage();
		ship = null;
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
	public void setStatus(int status)
	{
		this.status = status;
	}
	
	//get the Status of this cell
	public int getStatus()
	{
		return status;
	}
	
	public boolean validPos(Point p)
	{
		return !((p.x < 0 || p.x > 9) && (p.y < 0 || p.y > 9));
	}
	public boolean addShip(Ship s)
	{
		if (!validPos(pos))
			return false;
		ship = s;
		this.status = 1;
		for (int i = 0; i < s.getLength(); i++)
		{
			Grid.get(pos.x, pos.y - i).setImage(s.getBodyImage(i));;
		}
		//ImgFunc.setShipImage(img);
		return true;
	}
	private void addListener()
	{
		img.addMouseListener(new MouseListener()
				{
					@Override
					public void mouseClicked(MouseEvent arg0)
					{
						if (addShip(new Carrier(Direction.EAST, pos)))
							Battleship.setInfo("Ship set at " + pos);
						else
							Battleship.setInfo("Error adding ship at " + pos);
						Battleship.setInfo("Ship set at " + pos);
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
	private void addOppListener()
	{
		img.addMouseListener(new MouseListener()
				{
					@Override
					public void mouseClicked(MouseEvent arg0)
					{
						/*if(pos.status == 0)
								{
									pos.setStatus = 3;
									pos.setImage(yellow);
									Battleship.setOpponentInfo("Missed!");
								}
							else if(pos.status == 1)
							{
								pos.setStatus = 2; //status 2 = hit
								//pos.getBodyImage(ship.getPosition());
								int imageToSet = mapImage(pos.getBodyImage(ship.getPosition());
								pos.setImage(imageToSet);
								Battleship.setInfo("Hit at position: " + pos);
							}
							else if(pos.status == 2 || pos.status == 3)
								Battleship.setOpponentInfo("Error adding ship at " + pos);												
					*/}


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
