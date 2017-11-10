package Boat;

import javax.swing.JLabel;

import ImageOp.ImgFunc;
import Logic.Point;

public class Submarine extends Ship 
{
	final static int len = 3;
	final static Shiptype type = Shiptype.SUBMARINE;
	JLabel body[];
	public Submarine()
	{
		super();
		setShiptype(type);
		body = new JLabel[4];
		for (int i = 0; i < len; i++)
			body[i] = ImgFunc.getSubmarineImage(i);
	}
	public Submarine(Direction d, Point p)
	{
		super(d,p,len);
		setShiptype(type);
		body = new JLabel[4];
		for (int i = 0; i < len; i++)
			body[i] = ImgFunc.getSubmarineImage(i);
	}
	public JLabel getBodyImage(int index)
	{
		return body[index];
	}
}
