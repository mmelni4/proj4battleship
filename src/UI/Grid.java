package UI;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ImageOp.ImgFunc;

public class Grid
{
	private JLabel grid[][];
	private JPanel gridPanel;
	
	
	public Grid()
	{
		gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(10,10,0,0));
		grid = new JLabel[10][10];
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
			{
				if ((grid[i][j] = ImgFunc.getDefaultImage()) == null)
					return;
				initMouseListener(grid[i][j]);
				gridPanel.add(grid[i][j]);
			}
		Battleship.setInfo("Board setup complete");
	}
	public static void initMouseListener(JLabel J)
	{
		J.addMouseListener(new GridListener());
	}
	public JLabel get(int x, int y)
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
}
