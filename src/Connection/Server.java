package Connection;

import java.net.*;

import javax.swing.JOptionPane;

import Logic.Point;
import UI.Battleship;

import java.io.*; 



public class Server 
{ 
	private static int port;
	private static String ip;
	public Server()
	{
		
	}
	public static void initiateServer() 
	{ 
		ServerSocket connectionSocket = null; 
		port = 6789;
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
        } 
		catch (IOException e) 
        { 
			System.err.println("Could not listen on port: " + port); 
			System.exit(1); 
        } 

		Socket clientSocket = null;  
		try {
			connectionSocket.close();
		} catch (IOException e1) {
			Battleship.setInfo("Cannot close port: " + port);
		}
		Battleship.setInfo("Connection success");
		return;
	}
	public static void SendPoint()
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
			ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream()); 
			ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream()); 
       
			DataPacket a = null;
			DataPacket b = null;
	    

			while (true) 
			{ 
				try 
				{
					a = (DataPacket) in.readObject();
					Battleship.setInfo("Received point: " + a.toString());
			    }
			    catch (Exception ex)
			    {
			    	System.out.println (ex.getMessage());
			    	break;
			    }
			} 

			out.close(); 
			in.close(); 
			clientSocket.close(); 
			connectionSocket.close(); 
		}
		catch (IOException e)
		{
			System.err.println("Accept failed."); 
			System.exit(1); 
		}
	} 
} 
