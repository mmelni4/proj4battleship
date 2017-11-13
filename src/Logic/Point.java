package Logic;

import java.io.Serializable;

public class Point implements Serializable
{
	public int x;
	public int y;
	public Point(int xp, int yp)
	{
		x = xp;
		y = yp;
	}
	public boolean equals(Point p)
	{
		return (p.x == x && p.y == y);
	}
	public String toString()
	{
		return "(" + x + ", " + y + ")";
	}
}
