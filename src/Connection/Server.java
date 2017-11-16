// First player that initiated connection is a server
// Initiates ServerSocket instance 
// Displays server info (ip and port)
// Waiting for client to connect
// Receives Client socket instance for input and output stream
// Close connection when game is over

package Connection;

import java.net.*;

import javax.swing.JOptionPane;

import ImageOp.ImgFunc;
import Logic.Point;
import UI.Battleship;
import UI.Status;

import java.awt.HeadlessException;
import java.io.*; 

public class Server 
{ 
	private final static int port = 6789;
	private static ServerSocket connectionSocket;
	private static Socket clientSocket;
	private static ObjectInputStream in;
	private static ObjectOutputStream out;
	private static String ip;
	
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
			ip = addr.getHostAddress();
			Battleship.setInfo("Waiting for client. IP: " + ip);
        } 
		catch (IOException e) 
        { 
			JOptionPane.showMessageDialog(null, "Port " + port + " is in use. Starting client mode."); 
			Battleship.setServer(false);
			Battleship.setTurn(false);
			return;
        } 

		JOptionPane.showMessageDialog(null, "Connection success");
		Battleship.setServer(true);
		Battleship.setTurn(true);
		try 
		{ 
			clientSocket = connectionSocket.accept();
		} 
		catch (IOException e) 
		{ 	
			JOptionPane.showMessageDialog(null, "Accept failed."); 
			System.exit(1); 
		} 
	}
	public boolean isServer()
	{
		return Battleship.isServer();
	}
	public void ReceiveData()
    {
		Status status = Status.EMPTY;
    	try
    	{
    		if (in == null)
    		{
    			in = new ObjectInputStream(clientSocket.getInputStream());
    		}
    	} catch (IOException e)
    	{
    		JOptionPane.showMessageDialog(null, "Server: Could not open input object stream");
    		System.exit(0);
    	}
    		
    	try 
    	{
   			Object d = in.readObject();
   			// Point p = (Point) in.readObject();
   			Point p = null;
   			if (d instanceof Point)
   			{
   				p = (Point) d;
   				if (p.x == 1337 || p.y == 1337)
   				{
  					Battleship.setReady(true);
   					SendStatus(Status.EMPTY);
   					return;
   				}
   			
   				if (Battleship.getGrid().get(p.x, p.y).getShip() == null)
   				{
   					ImgFunc.setMissImage(Battleship.getGrid().get(p.x, p.y).getImage());
   					Battleship.setMisses();
   					SendStatus(Status.MISS);		
   				}
   				else
   				{
   					ImgFunc.setRedImage(Battleship.getGrid().get(p.x, p.y).getImage());
   					Battleship.setHits();
   					SendStatus(Status.HIT);
   				}
   			}
   			else if (d instanceof Status)
   			{
   				Status s = (Status) d;
    			Point pos = Battleship.lastPoint;
    			if (s == Status.HIT)
    			{
    				ImgFunc.setHitImage(Battleship.getOppGrid().get(pos.x, pos.y).getImage());
    				Battleship.setOpHits();
    				Battleship.setInfo("HIT");
    			}
    			else if (s == Status.MISS)
    			{
    				ImgFunc.setMissImage(Battleship.getOppGrid().get(pos.x, pos.y).getImage());
    				Battleship.setOpMiss();
    				Battleship.setInfo("MISS");
    			}   				
   			}
    		
    	} catch (ClassNotFoundException e) {	
			e.printStackTrace();
    	} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Server: Could not receive data");
		}
    }
	public void SendData(Point p)
    {
        try 
        {
        	if (out == null)
        	{
        		out = new ObjectOutputStream(clientSocket.getOutputStream());
        	}
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Server: Could not open output object stream");
			System.exit(0);
		}
    	try 
    	{
    		Battleship.lastPoint = p;
			out.writeObject(p);
			out.flush();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not send point: " + p);
		}
    }
	public void SendStatus(Status s)
    {
        try 
        {
        	if (out == null)
        	{
        		out = new ObjectOutputStream(clientSocket.getOutputStream());
        	}
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Server: Could not open output object stream");
			System.exit(0); 
		}
    	try 
    	{
			out.writeObject(s);
			out.flush();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not send status: " + s);
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
