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
		for(int i = 0; i < len; i++)
			body[i] = ImgFunc.getCarrierImage(i);
	}
	public Carrier(Direction d, Point p)
	{
		super(d,p,len);
		body = new JLabel[5];
		for(int i = 0; i < len; i++)
			body[i] = ImgFunc.getCarrierImage(i);
	}
	public JLabel getBodyImage(int index)
	{
		return body[index];		
	}
}
