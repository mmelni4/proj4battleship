// Originally Battleship type of ship of size 4
// Renamed from Battleship to Gunship to prevent confusion
// with the name of the GUI class Battleship

package Boat;

import javax.swing.JLabel;

import ImageOp.ImgFunc;
import Logic.Point;

public class Gunship extends Ship
{
	static final int len = 4;
	static final Shiptype type = Shiptype.GUNSHIP;
	JLabel body[];
	public Gunship()
	{
		super();
		setShiptype(type);
		body = new JLabel[4];
		for (int i = 0; i < len; i++)
			body[i] = ImgFunc.getGunshipImage(i);
	}
	public Gunship(Direction d, Point p)
	{
		super(d,p,len);
		setShiptype(type);
		body = new JLabel[4];
		for (int i = 0; i < len; i++)
			body[i] = ImgFunc.getGunshipImage(i);
	}
	public JLabel getBodyImage(int index)
	{
		return body[index];
	}
}
