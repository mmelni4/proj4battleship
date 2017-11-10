package Boat;

import javax.swing.JLabel;

import ImageOp.ImgFunc;
import Logic.Point;

public class Destroyer extends Ship
{
	final static int len = 3;
	final static Shiptype type = Shiptype.DESTROYER;
	JLabel body[];
	public Destroyer()
	{
		super();
		setShiptype(type);
		body = new JLabel[4];
		for (int i = 0; i < len; i++)
			body[i] = ImgFunc.getDestroyerImage(i);
	}
	public Destroyer(Direction d, Point p)
	{
		super(d,p,len);
		setShiptype(type);
		body = new JLabel[3];
		for (int i = 0; i < len; i++)
			body[i] = ImgFunc.getDestroyerImage(i);
	}
	public JLabel getBodyImage(int index)
	{
		return body[index];
	}
}
