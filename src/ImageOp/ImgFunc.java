// ImgFunction class sets images for ship of certain types
// according to their direction and rescales images to fit the JLabel components

package ImageOp;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Boat.Carrier;
import Boat.Destroyer;
import Boat.Gunship;
import Boat.PatrolBoat;
import Boat.Ship;
import Boat.Submarine;

public class ImgFunc 
{
	private static int IMGSIZE_X = 40;
	private static int IMGSIZE_Y = 40;
	private static String direction = "east";
	public static JLabel getCarrierImage(int segment)
	{
		JLabel picLabel = null;
		ImageIcon imageIcon;
		try
		{
		// Resize the image to fit into the JLabel
		switch(segment)
		{
		case 0:
			imageIcon = new ImageIcon("resources\\" + direction + "\\bow.png");
			break;
		case 1:
			imageIcon = new ImageIcon("resources\\" + direction + "\\body1.png");
			break;
		case 2:
			imageIcon = new ImageIcon("resources\\" + direction + "\\body2.png");
			break;
		case 3:
			imageIcon = new ImageIcon("resources\\" + direction + "\\body3.png");
			break;
		case 4:
			imageIcon = new ImageIcon("resources\\" + direction + "\\stern.png");
			break;
		default:
			imageIcon = null;
		}
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(IMGSIZE_X, IMGSIZE_Y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		picLabel = new JLabel(imageIcon);
		}
		catch(Exception e)
		{ 
			JOptionPane.showMessageDialog(null, "Ship image not found");
		}
		return picLabel;
	}
	public static void setCarrierImage(JLabel picLabel ,int segment)
	{
		ImageIcon imageIcon;
		try
		{
		// Resize the image to fit into the JLabel
		switch(segment)
		{
		case 0:
			imageIcon = new ImageIcon("resources\\" + direction + "\\bow.png");
			break;
		case 1:
			imageIcon = new ImageIcon("resources\\" + direction + "\\body1.png");
			break;
		case 2:
			imageIcon = new ImageIcon("resources\\" + direction + "\\body2.png");
			break;
		case 3:
			imageIcon = new ImageIcon("resources\\" + direction + "\\body3.png");
			break;
		case 4:
			imageIcon = new ImageIcon("resources\\" + direction + "\\stern.png");
			break;
		default:
			imageIcon = null;
		}
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(IMGSIZE_X, IMGSIZE_Y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		picLabel.setIcon(imageIcon);
		}
		catch(Exception e)
		{ 
			JOptionPane.showMessageDialog(null, "Ship image not found");
		}
	}
	public static JLabel getGunshipImage(int segment)
	{
		JLabel picLabel = null;
		ImageIcon imageIcon;
		try
		{
		// Resize the image to fit into the JLabel
		switch(segment)
		{
		case 0:
			imageIcon = new ImageIcon("resources\\" + direction + "\\bow.png");
			break;
		case 1:
			imageIcon = new ImageIcon("resources\\" + direction + "\\body2.png");
			break;
		case 2:
			imageIcon = new ImageIcon("resources\\" + direction + "\\body3.png");
			break;
		case 3:
			imageIcon = new ImageIcon("resources\\" + direction + "\\stern.png");
			break;
		default:
			imageIcon = null;
		}
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(IMGSIZE_X, IMGSIZE_Y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		picLabel = new JLabel(imageIcon);
		}
		catch(Exception e)
		{ 
			JOptionPane.showMessageDialog(null, "Ship image not found");
		}
		return picLabel;
	}
	public static void setGunshipImage(JLabel picLabel, int segment)
	{
		ImageIcon imageIcon;
		try
		{
		// Resize the image to fit into the JLabel
		switch(segment)
		{
		case 0:
			imageIcon = new ImageIcon("resources\\" + direction + "\\bow.png");
			break;
		case 1:
			imageIcon = new ImageIcon("resources\\" + direction + "\\body2.png");
			break;
		case 2:
			imageIcon = new ImageIcon("resources\\" + direction + "\\body3.png");
			break;
		case 3:
			imageIcon = new ImageIcon("resources\\" + direction + "\\stern.png");
			break;
		default:
			imageIcon = null;
		}
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(IMGSIZE_X, IMGSIZE_Y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		picLabel.setIcon(imageIcon);
		}
		catch(Exception e)
		{ 
			JOptionPane.showMessageDialog(null, "Ship image not found");
		}
	}
	public static void setRedImage(JLabel picLabel)
	{
		ImageIcon imageIcon;
		try
		{
		// Resize the image to fit into the JLabel
			imageIcon = new ImageIcon("resources\\red.png");
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(IMGSIZE_X, IMGSIZE_Y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		picLabel.setIcon(imageIcon);
		}
		catch(Exception e)
		{ 
			JOptionPane.showMessageDialog(null, "Red image not found");
		}
	}
	public static void setHitImage(JLabel picLabel)
	{
		ImageIcon imageIcon;
		try
		{
		// Resize the image to fit into the JLabel
			imageIcon = new ImageIcon("resources\\hit.png");
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(IMGSIZE_X, IMGSIZE_Y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		picLabel.setIcon(imageIcon);
		}
		catch(Exception e)
		{ 
			JOptionPane.showMessageDialog(null, "Red image not found");
		}
	}
	public static void setMissImage(JLabel picLabel)
	{
		ImageIcon imageIcon;
		try
		{
		// Resize the image to fit into the JLabel
			imageIcon = new ImageIcon("resources\\miss.png");
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(IMGSIZE_X, IMGSIZE_Y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		picLabel.setIcon(imageIcon);
		}
		catch(Exception e)
		{ 
			JOptionPane.showMessageDialog(null, "Red image not found");
		}
	}
	public static JLabel getSubmarineImage(int segment)
	{
		JLabel picLabel = null;
		ImageIcon imageIcon;
		try
		{
		// Resize the image to fit into the JLabel
		switch(segment)
		{
		case 0:
			imageIcon = new ImageIcon("resources\\" + direction + "\\bow.png");
			break;
		case 1:
			imageIcon = new ImageIcon("resources\\" + direction + "\\body3.png");
			break;
		case 2:
			imageIcon = new ImageIcon("resources\\" + direction + "\\stern.png");
			break;
		default:
			imageIcon = null;
		}
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(IMGSIZE_X, IMGSIZE_Y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		picLabel = new JLabel(imageIcon);
		}
		catch(Exception e)
		{ 
			JOptionPane.showMessageDialog(null, "Ship image not found");
		}
		return picLabel;
	}
	public static void setSubmarineImage(JLabel picLabel, int segment)
	{
		ImageIcon imageIcon;
		try
		{
		// Resize the image to fit into the JLabel
		switch(segment)
		{
		case 0:
			imageIcon = new ImageIcon("resources\\" + direction + "\\bow.png");
			break;
		case 1:
			imageIcon = new ImageIcon("resources\\" + direction + "\\body3.png");
			break;
		case 2:
			imageIcon = new ImageIcon("resources\\" + direction + "\\stern.png");
			break;
		default:
			imageIcon = null;
		}
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(IMGSIZE_X, IMGSIZE_Y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		picLabel.setIcon(imageIcon);
		}
		catch(Exception e)
		{ 
			JOptionPane.showMessageDialog(null, "Ship image not found");
		}
	}
	public static JLabel getDestroyerImage(int segment)
	{
		JLabel picLabel = null;
		ImageIcon imageIcon;
		try
		{
		// Resize the image to fit into the JLabel
		switch(segment)
		{
		case 0:
			imageIcon = new ImageIcon("resources\\" + direction + "\\bow.png");
			break;
		case 1:
			imageIcon = new ImageIcon("resources\\" + direction + "\\body1.png");
			break;
		case 2:
			imageIcon = new ImageIcon("resources\\" + direction + "\\stern.png");
			break;
		default:
			imageIcon = null;
		}
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(IMGSIZE_X, IMGSIZE_Y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		picLabel = new JLabel(imageIcon);
		}
		catch(Exception e)
		{ 
			JOptionPane.showMessageDialog(null, "Ship image not found");
		}
		return picLabel;
	}
	public static void setDestroyerImage(JLabel picLabel, int segment)
	{
		ImageIcon imageIcon;
		try
		{
		// Resize the image to fit into the JLabel
		switch(segment)
		{
		case 0:
			imageIcon = new ImageIcon("resources\\" + direction + "\\bow.png");
			break;
		case 1:
			imageIcon = new ImageIcon("resources\\" + direction + "\\body1.png");
			break;
		case 2:
			imageIcon = new ImageIcon("resources\\" + direction + "\\stern.png");
			break;
		default:
			imageIcon = null;
		}
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(IMGSIZE_X, IMGSIZE_Y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		picLabel.setIcon(imageIcon);
		}
		catch(Exception e)
		{ 
			JOptionPane.showMessageDialog(null, "Ship image not found");
		}
	}
	public static JLabel getPatrolBoatImage(int segment)
	{
		JLabel picLabel = null;
		ImageIcon imageIcon;
		try
		{
		// Resize the image to fit into the JLabel
		switch(segment)
		{
		case 0:
			imageIcon = new ImageIcon("resources\\" + direction + "\\bow.png");
			break;
		case 1:
			imageIcon = new ImageIcon("resources\\" + direction + "\\stern.png");
			break;
		default:
			imageIcon = null;
		}
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(IMGSIZE_X, IMGSIZE_Y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		picLabel = new JLabel(imageIcon);
		}
		catch(Exception e)
		{ 
			JOptionPane.showMessageDialog(null, "Ship image not found");
		}
		return picLabel;
	}
	public static void setPatrolBoatImage(JLabel picLabel, int segment)
	{
		ImageIcon imageIcon;
		try
		{
		// Resize the image to fit into the JLabel
		switch(segment)
		{
		case 0:
			imageIcon = new ImageIcon("resources\\" + direction + "\\bow.png");
			break;
		case 1:
			imageIcon = new ImageIcon("resources\\" + direction + "\\stern.png");
			break;
		default:
			imageIcon = null;
		}
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(IMGSIZE_X, IMGSIZE_Y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		picLabel.setIcon(imageIcon);
		}
		catch(Exception e)
		{ 
			JOptionPane.showMessageDialog(null, "Ship image not found");
		}
	}
	public static JLabel getDefaultImage()
	{
		JLabel picLabel = null;
		try
		{
		// Resize the image to fit into the JLabel
		ImageIcon imageIcon = new ImageIcon("resources\\water.gif"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(IMGSIZE_X, IMGSIZE_Y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		picLabel = new JLabel(imageIcon);
		}
		catch(Exception e)
		{ 
			JOptionPane.showMessageDialog(null, "Default image file not found");
		}
		return picLabel;
	}
	public static JLabel getImage(String path)
	{
		JLabel picLabel = null;
		try
		{
		// Resize the image to fit into the JLabel
		ImageIcon imageIcon = new ImageIcon(path); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(IMGSIZE_X, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		picLabel = new JLabel(imageIcon);
		}
		catch(Exception e)
		{ 
			JOptionPane.showMessageDialog(null, "Image file '"+ path +"'not found");
		}
		return picLabel;
	}
	public static void setDirection(Ship s, String dir) 
	{
	    direction = dir;
	    
	    if (s instanceof Carrier)
    		for (int i = 0; i < s.getLength(); i++)
    			setCarrierImage(s.getBodyImage(i), i);
    	else if (s instanceof Gunship)
    		for (int i = 0; i < s.getLength(); i++)
    			setGunshipImage(s.getBodyImage(i), i);
    	else if (s instanceof Submarine)
    		for (int i = 0; i < s.getLength(); i++)
    			setSubmarineImage(s.getBodyImage(i), i);
    	else if (s instanceof Destroyer)
    		for (int i = 0; i < s.getLength(); i++)
    			setDestroyerImage(s.getBodyImage(i), i);
    	else if (s instanceof PatrolBoat)
    		for (int i = 0; i < s.getLength(); i++)
    			setPatrolBoatImage(s.getBodyImage(i), i);
	}

	private static GraphicsConfiguration getDefaultConfiguration() 
	{
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    GraphicsDevice gd = ge.getDefaultScreenDevice();
	    return gd.getDefaultConfiguration();
	}
}
