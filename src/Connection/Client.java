package Connection;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

import ImageOp.ImgFunc;
import Logic.Point;
import UI.Battleship;

public class Client
{
	private static String ip;
	private final static int port = 6789;
	private static Socket echoSocket;
	private static ObjectInputStream in;
	private static ObjectOutputStream out;
	private static boolean bOnce = false;
	
	public Client() throws IOException
	{
		InetAddress addr;
		addr = InetAddress.getLocalHost();
		ip = JOptionPane.showInputDialog("Enter IP address:");
		echoSocket = null;
		initiateClient();
	}
    public static void initiateClient() throws IOException 
    {
        out = null;
        in = null;

        try
        {
            echoSocket = new Socket(ip, port);
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null ,"Don't know about host: " + ip);
            System.exit(1);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Couldn't get I/O for "
                               + "the connection to: " + ip);
            System.exit(1);
        }
        
    }
    public void ReceiveData()
    {
    	try
    	{
    		if (in == null)
    		{
    			in = new ObjectInputStream(echoSocket.getInputStream());
    		}
    	} catch (IOException e)
    	{
    		JOptionPane.showMessageDialog(null, "Client: Could not open input object stream");
    	}
    	try 
    	{
			Point p = (Point) in.readObject();
			Battleship.setInfo("Receieved point: " + p);
			ImgFunc.setRedImage(Battleship.getGrid().get(p.x, p.y).getImage());
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Client: Could not receive data");
		}
    }
    public void SendData(Point p)
    {
        try 
        {
        	if (out == null)
        	{
        		out = new ObjectOutputStream(echoSocket.getOutputStream());
        	}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Could not open input/output object stream");
		}
    	try 
    	{
			out.writeObject(p);
			out.flush();
		} catch (IOException e) {
			Battleship.setInfo("Could not send point: " + p);
			System.out.println(e);
		}
    }
    public static void CloseConnection()
    {
    	try 
    	{
    		in.close();
            echoSocket.close();
			out.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not close client connection");
		}
       	
    }
}