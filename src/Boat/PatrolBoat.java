package Boat;

import javax.swing.JLabel;

import ImageOp.ImgFunc;
import Logic.Point;

public class PatrolBoat extends Ship
{
	static final int len = 2;
	JLabel body[];
	public PatrolBoat()
	{
		super();
		body = new JLabel[4];
		for (int i = 0; i < len; i++)
			body[i] = ImgFunc.getPatrolBoatImage(i);
	}
	public PatrolBoat(Direction d, Point p)
	{
		super(d,p,len);
		body = new JLabel[4];
		for (int i = 0; i < len; i++)
			body[i] = ImgFunc.getPatrolBoatImage(i);
	}
	public JLabel getBodyImage(int index)
	{
		return body[index];
	}
}
