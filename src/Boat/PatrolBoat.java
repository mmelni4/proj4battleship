// Patrol Boat is  a subclass of class Ship that is of size 2

package Boat;

import javax.swing.JLabel;

import ImageOp.ImgFunc;
import Logic.Point;

public class PatrolBoat extends Ship
{
	final static int len = 2;
	final static Shiptype type = Shiptype.PATROLBOAT;
	JLabel body[];
	
	public PatrolBoat()
	{
		super();
		setShiptype(type);
		body = new JLabel[4];
		for (int i = 0; i < len; i++)
			body[i] = ImgFunc.getPatrolBoatImage(i);
	}
	public PatrolBoat(Direction d, Point p)
	{
		super(d,p,len);
		setShiptype(type);
		body = new JLabel[4];
		for (int i = 0; i < len; i++)
			body[i] = ImgFunc.getPatrolBoatImage(i);
	}
	public JLabel getBodyImage(int index)
	{
		return body[index];
	}
}
