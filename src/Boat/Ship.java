// Super class Ship includes 5 types of ships subclasses:
// Carrier, Destroyer, Battleship (Gunship here), PatrolBoat, and Submarine
// Specifies direction, position coordinates, length, and level of health ->
// -> that reduces when ship is hit, and equals 0 when ship length becomes 0 (destroyed)

package Boat;
import javax.swing.JLabel;

import ImageOp.ImgFunc;
import Logic.Point;

public class Ship 
{
	final Direction dir;
	final Point pos; // has (x,y) coordinates type
	final int len;
	public Shiptype type;
	JLabel body[];
	int health;
	public Ship()
	{
		dir = Direction.NORTH;
		type = Shiptype.CARRIER;
		pos = new Point(0, 0);
		len = 0;
		health = len;
	}
	public Ship(Direction d, Point p, int l)
	{
		dir = d;
		type = Shiptype.CARRIER;
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
	public Shiptype getShiptype()
	{
		return type;
	}
	public void setShiptype(Shiptype t)
	{
		type = t;
	}
	public JLabel getBodyImage(int index)
	{
		return body[index];		
	}
	public String toString()
	{
		String shiptype = "Ship";
		switch(type)
		{
		case CARRIER   : shiptype = "Carrier"    ; break;
		case GUNSHIP   : shiptype = "Gunship"    ; break;
		case SUBMARINE : shiptype = "Submarine"  ; break;
		case DESTROYER : shiptype = "Destroyer"  ; break;
		case PATROLBOAT: shiptype = "Patrol boat"; break;
		}
		return shiptype;
	}
}