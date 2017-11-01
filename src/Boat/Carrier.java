package Boat;
import javax.swing.JLabel;

import Logic.Point;
public class Carrier extends Ship 
{
	static int len = 5;
	JLabel body[];
	public Carrier()
	{
		super();
	}
	public Carrier(Direction d, Point p)
	{
		super(d,p,len);
	}
}
