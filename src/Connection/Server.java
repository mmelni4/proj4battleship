package Connection;

import java.net.*;

import javax.swing.JOptionPane;

import ImageOp.ImgFunc;
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
			Battleship.setServer(false);
			return;
        } 

		JOptionPane.showMessageDialog(null, "Connection success");
		Battleship.setServer(true);
		
		try 
		{ 
			JOptionPane.showMessageDialog(null, "Waiting for client");
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
    	try
    	{
    		if (in == null)
    		{
    			in = new ObjectInputStream(clientSocket.getInputStream());
    		}
    	} catch (IOException e)
    	{
    		JOptionPane.showMessageDialog(null, "Client: Could not open input object stream");
    	}
    	try {
			Point p = (Point) in.readObject();
			Battleship.setInfo("Receieved point: " + p);
			ImgFunc.setRedImage(Battleship.getGrid().get(p.x, p.y).getImage());
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
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Server: Could not open output object stream");
		}
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
