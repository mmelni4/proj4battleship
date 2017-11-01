package Logic;

public class Point 
{
	int x, y;
	public Point(int xp, int yp)
	{
		x = xp;
		y = yp;
	}
	public boolean equals(Point p)
	{
		return (p.x == x && p.y == y);
	}
}
