package Boat;
import javax.swing.JLabel;

import ImageOp.ImgFunc;
import Logic.Point;
public class Carrier extends Ship 
{
	static int len = 5;
	JLabel body[];
	public Carrier()
	{
		super();
		body = new JLabel[5];
		body[0] = ImgFunc.getShipImage();
	}
	public Carrier(Direction d, Point p)
	{
		super(d,p,len);
		body = new JLabel[5];
		body[0] = ImgFunc.getShipImage();
	}
}
