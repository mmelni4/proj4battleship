package Boat;
import javax.swing.JLabel;

import Logic.Point;
import UI.Battleship;

public class Ship 
{
	Direction dir;
	Point pos;
	int len;
	JLabel body[];
	public Ship()
	{
		dir = Direction.NORTH;
		pos = new Point(0, 0);
		len = 0;
		body = new JLabel[5];
	}
	public Ship(Direction d, Point p, int l)
	{
		dir = d;
		pos = p;
		len = l;
		body = new JLabel[5];
	}
	public int getLength()
	{
		return len;
	}
	public Point getPosition()
	{
		return pos;
	}
	public Direction getDirection()
	{
		return dir;
	}
	public JLabel getBodyImage()
	{
		return body[0];	
		
	}
}
