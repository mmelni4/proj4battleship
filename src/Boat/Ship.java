package Boat;
import Logic.Point;

public class Ship 
{
	Direction dir;
	Point pos;
	int len;
	public Ship()
	{
		dir = Direction.NORTH;
		pos = new Point(0, 0);
		len = 0;
	}
	public Ship(Direction d, Point p, int l)
	{
		dir = d;
		pos = p;
		len = l;
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
}
