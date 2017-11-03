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
	public Cell()
	{
		pos = new Point(0, 0);
		img = ImgFunc.getDefaultImage();
		ship = null;
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
		img = image;
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
		setImage(s.getBodyImage());
		return true;
	}
	private void addListener()
	{
		img.addMouseListener(new MouseListener()
				{
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if (addShip(new Carrier(Direction.WEST, pos)))
							Battleship.setInfo("Ship set at " + pos);
						else
							Battleship.setInfo("Error adding ship at " + pos);
						//Grid.updateBoard();
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
