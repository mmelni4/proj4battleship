package ImageOp;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Boat.Ship;

public class ImgFunc 
{
	private static int IMGSIZE_X = 60;
	private static int IMGSIZE_Y = 60;
	public static JLabel getShipImage()
	{
		JLabel picLabel = null;
		try
		{
		// Resize the image to fit into the JLabel
		ImageIcon imageIcon = new ImageIcon("resources\\carrier\\bow.gif"); // load the image to a imageIcon
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
			imageIcon = new ImageIcon("resources\\carrier\\bow.gif"); // load the image to a imageIcon
			break;
		case 1:
			imageIcon = new ImageIcon("resources\\carrier\\body1.gif"); // load the image to a imageIcon
			break;
		case 2:
			imageIcon = new ImageIcon("resources\\carrier\\body2.gif"); // load the image to a imageIcon
			break;
		case 3:
			imageIcon = new ImageIcon("resources\\carrier\\body3.gif"); // load the image to a imageIcon
			break;
		case 4:
			imageIcon = new ImageIcon("resources\\carrier\\stern.gif"); // load the image to a imageIcon
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
	public static void setShipImage(JLabel picLabel)
	{
		try
		{
		// Resize the image to fit into the JLabel
		ImageIcon imageIcon = new ImageIcon("resources\\carrier\\bow.gif"); // load the image to a imageIcon
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
	public static BufferedImage rotate(BufferedImage image, double angle) 
	{
	    double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
	    int w = image.getWidth(), h = image.getHeight();
	    int neww = (int)Math.floor(w*cos+h*sin), newh = (int) Math.floor(h * cos + w * sin);
	    GraphicsConfiguration gc = getDefaultConfiguration();
	    BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
	    Graphics2D g = result.createGraphics();
	    g.translate((neww - w) / 2, (newh - h) / 2);
	    g.rotate(angle, w / 2, h / 2);
	    g.drawRenderedImage(image, null);
	    g.dispose();
	    return result;
	}

	private static GraphicsConfiguration getDefaultConfiguration() 
	{
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    GraphicsDevice gd = ge.getDefaultScreenDevice();
	    return gd.getDefaultConfiguration();
	}
}
