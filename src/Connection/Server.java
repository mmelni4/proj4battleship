package Connection;

import java.net.*;

import javax.swing.JOptionPane;

import Logic.Point;
import UI.Battleship;

import java.io.*; 

public class Server 
{ 
	private final static int port = 6789;
	private static ServerSocket connectionSocket;
	private static Socket clientSocket;
	private static ObjectInputStream in;
	private static ObjectOutputStream out;
	private static boolean connected = false;
	public Server()
	{	
		try 
		{
			connectionSocket = new ServerSocket(port); 
			JOptionPane.showMessageDialog(null, "Socket open on Port: " +
                             connectionSocket.getLocalPort());
			InetAddress addr = InetAddress.getLocalHost();
			JOptionPane.showMessageDialog(null, "Java InetAddress localHost info: " + addr + "\n"
         		+ "Local Host Name: " + addr.getHostName() + "\n"
         		+ "Local Host Address: " + addr.getHostAddress());
        } 
		catch (IOException e) 
        { 
			JOptionPane.showMessageDialog(null, "Could not listen on port: " + port); 
			connected = false; 
        } 

		JOptionPane.showMessageDialog(null, "Connection success");
		connected = true;
	}
	public boolean isServer()
	{
		return connected;
	}
	public static void Listen()
	{
		try 
		{ 
			Battleship.setInfo("Waiting for client");
			clientSocket = connectionSocket.accept();
		} 
		catch (IOException e) 
		{ 	
			Battleship.setInfo("Accept failed."); 
			System.exit(1); 
		} 

		try 
		{
			out = new ObjectOutputStream(clientSocket.getOutputStream()); 
			in = new ObjectInputStream(clientSocket.getInputStream()); 
       
			Point a = null;	    
 
			try 
			{
				a = (Point) in.readObject();
				Battleship.setInfo("Received point: " + a.toString());
		    }
		    catch (Exception ex)
		    {
		    	System.out.println (ex.getMessage());
		    }
			 
		}
		catch (IOException e)
		{
			System.err.println("Accept failed."); 
			System.exit(1); 
		}
	} 
	public static void SendData(Point p)
    {
    	try 
    	{
			out.writeObject(p);
			out.flush();
		} catch (IOException e) {
			Battleship.setInfo("Could not send point: " + p);
		}
    }
	private static void CloseConnection()
	{
		try 
		{
			in.close();
			out.close();
			clientSocket.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not close client connection");
		} 
		try {
			connectionSocket.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not close server connection");
		} 
	}
} 
