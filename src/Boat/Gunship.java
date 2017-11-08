package Boat;

import javax.swing.JLabel;

import ImageOp.ImgFunc;
import Logic.Point;

// Renamed from Battleship to Gunship to prevent confusion
// with the name of the GUI class Battleship
public class Gunship extends Ship
{
	static final int len = 4;
	JLabel body[];
	public Gunship()
	{
		super();
		body = new JLabel[4];
		for (int i = 0; i < len; i++)
			body[i] = ImgFunc.getGunshipImage(i);
	}
	public Gunship(Direction d, Point p)
	{
		super(d,p,len);
		body = new JLabel[4];
		for (int i = 0; i < len; i++)
			body[i] = ImgFunc.getGunshipImage(i);
	}
	public JLabel getBodyImage(int index)
	{
		return body[index];
	}
}
