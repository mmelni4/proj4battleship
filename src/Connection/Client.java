// While connection is being established Client inputs server info
// via Socket instance, that provides stream for input and output
// After receiving coordinates info, sets information to the South label in players grid

package Connection;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

import ImageOp.ImgFunc;
import Logic.Point;
import UI.Battleship;
import UI.Status;

public class Client
{
	private static String ip;
	private final static int port = 6789;
	private static Socket serverSocket;
	private static ObjectInputStream in;
	private static ObjectOutputStream out;
	public SocketAddress sockAdds;
	
	public Client() throws IOException
	{
		ip = JOptionPane.showInputDialog("Enter IP address:");
		serverSocket = null;
		initiateClient();
	}
    public static void initiateClient() throws IOException 
    {
        out = null;
        in = null;

        try
        {
        	serverSocket = new Socket(ip, port);
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null ,"Don't know about host: " + ip);
            System.exit(1);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Couldn't get I/O for "
                               + "the connection to: " + ip);
            System.exit(1);
        }      
    }
    public Status ReceiveData()
    {
		Status status = Status.EMPTY;
    	try
    	{
    		if (in == null)
    		{
    			in = new ObjectInputStream(serverSocket.getInputStream());
    		}
    	} catch (IOException e)
    	{
    		JOptionPane.showMessageDialog(null, "Client: Could not open input object stream");
    	}
    	try 
    	{
			Point p = (Point) in.readObject();
			if (p.x < 0 || p.y < 0)
				return Status.EMPTY;
			if (Battleship.getGrid().get(p.x, p.y).getShip() == null)
			{
				ImgFunc.setMissImage(Battleship.getGrid().get(p.x, p.y).getImage());
				status = Status.MISS;
				
			}
			else
			{
				ImgFunc.setRedImage(Battleship.getGrid().get(p.x, p.y).getImage());
				status = Status.HIT;
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Client: Could not receive data");
		}
    	return status;
    }
    public void SendData(Point p)
    {
        try 
        {
        	if (out == null)
        	{
        		out = new ObjectOutputStream(serverSocket.getOutputStream());
        	}
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Could not open output object stream");
		}
    	try 
    	{
			out.writeObject(p);
			out.flush();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not send point: " + p);
			System.out.println(e);
		}
    }
    public void SendStatus(Status s)
    {
        try 
        {
        	if (out == null)
        	{
        		out = new ObjectOutputStream(serverSocket.getOutputStream());
        	}
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Could not open output object stream");
		}
    	try 
    	{
			out.writeObject(s);
			out.flush();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not send status: " + s);
			System.out.println(e);
		}
    }
    public void ReceiveStatus(Point p)
    {
    	try
    	{
    		if (in == null)
    		{
    			in = new ObjectInputStream(serverSocket.getInputStream());
    		}
    	} catch (IOException e)
    	{
    		JOptionPane.showMessageDialog(null, "Client: Could not open input object stream");
    	}
    	try 
    	{
			Status s = (Status) in.readObject();
			if (s == Status.HIT)
			{
				ImgFunc.setHitImage(Battleship.getOppGrid().get(p.x, p.y).getImage());
				Battleship.setHits();
				Battleship.setInfo("HIT");
			}
			else
			{
				ImgFunc.setMissImage(Battleship.getOppGrid().get(p.x, p.y).getImage());
				Battleship.setMisses();
				Battleship.setInfo("MISS");
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Client: Could not receive data");
		}
    }
    public static void CloseConnection()
    {
    	try 
    	{
    		in.close();
    		serverSocket.close();
			out.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not close client connection");
		}      	
    }
}