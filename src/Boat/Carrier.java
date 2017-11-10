package Boat;
import javax.swing.JLabel;

import ImageOp.ImgFunc;
import Logic.Point;
public class Carrier extends Ship 
{
	final static int len = 5;
	final static Shiptype type = Shiptype.CARRIER;
	static JLabel body[];
	public Carrier()
	{
		super();
		setShiptype(type);
		body = new JLabel[5];
		for(int i = 0; i < len; i++)
			body[i] = ImgFunc.getCarrierImage(i);
	}
	public Carrier(Direction d, Point p)
	{
		super(d,p,len);
		setShiptype(type);
		body = new JLabel[5];
		for(int i = 0; i < len; i++)
			body[i] = ImgFunc.getCarrierImage(i);
	}
	public JLabel getBodyImage(int index)
	{
		return body[index];
	}
}
