package Boat;

import javax.swing.JLabel;

import ImageOp.ImgFunc;
import Logic.Point;

public class Destroyer extends Ship
{
	static final int len = 3;
	JLabel body[];
	public Destroyer()
	{
		super();
		body = new JLabel[4];
		for (int i = 0; i < len; i++)
			body[i] = ImgFunc.getDestroyerImage(i);
	}
	public Destroyer(Direction d, Point p)
	{
		super(d,p,len);
		body = new JLabel[3];
		for (int i = 0; i < len; i++)
			body[i] = ImgFunc.getDestroyerImage(i);
	}
	public JLabel getBodyImage(int index)
	{
		return body[index];
	}
}
