package Boat;
import javax.swing.JLabel;

import ImageOp.ImgFunc;
import Logic.Point;

public class Ship 
{
	final Direction dir;
	final Point pos;
	final int len;
	JLabel body[];
	int health;
	public Ship()
	{
		dir = Direction.NORTH;
		pos = new Point(0, 0);
		len = 0;
		health = len;
	}
	public Ship(Direction d, Point p, int l)
	{
		dir = d;
		pos = p;
		len = l;
		health = len;
	}
	public int getLength()
	{
		return len;
	}
	public int getHealth()
	{
		return health;
	}
	public void hit()
	{
		if (health > 0)
			health--;
	}
	public Point getPosition()
	{
		return pos;
	}
	public Direction getDirection()
	{
		return dir;
	}
	public JLabel getBodyImage(int index)
	{
		return body[index];		
	}
}