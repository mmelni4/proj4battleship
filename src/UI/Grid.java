// This Grid class represents player's grid

package UI;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class Grid
{
	private static Cell grid[][];
	private static JPanel gridPanel;
	
	public Grid()
	{
		gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(10,10,1,1));
		grid = new Cell[10][10];
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
			{
				grid[i][j] = new Cell(i, j);
				if (grid[i][j].getImage() == null)
					return;
				
				gridPanel.add(grid[i][j].getImage());
			}
		Battleship.setInfo("Board setup complete");
	}
	public static Cell get(int x, int y)
	{
		if (x < 0 || x > 9 
			|| y < 0 || y > 9)
			return null;
		else
			return grid[x][y];
	}
	public JPanel getPanel()
	{
		return gridPanel;
	}
	
	public void setStatus(int x, int y, Status status)
	{
		grid[x][y].setStatus(status);
	}
	
	public static void updateBoard()
	{
		gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(3,3,0,0));
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				gridPanel.add(grid[i][j].getImage());				
			}
		}
	}
}
