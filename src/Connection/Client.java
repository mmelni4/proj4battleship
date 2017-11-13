package Connection;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

import Logic.Point;
import UI.Battleship;

public class Client
{
	private static String ip;
	private final static int port = 6789;
	private static Socket echoSocket;
	private static ObjectInputStream in;
	private static ObjectOutputStream out;
	public Client()
	{
		ip = "127.0.0.1";
		echoSocket = null;
	}
    public static void initiateClient() throws IOException 
    {
    	
        out = null;
        in = null;

        try
        {
            echoSocket = new Socket(ip, port);
            out = new ObjectOutputStream(echoSocket.getOutputStream());
            in = new ObjectInputStream(echoSocket.getInputStream());
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null ,"Don't know about host: " + ip);
            System.exit(1);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Couldn't get I/O for "
                               + "the connection to: " + ip);
            System.exit(1);
        }

        //DataPacket pt1 = new DataPacket();
        Point pt2 = null;
        //Battleship.setInfo("Sending point: " + pt1 + " to Server");
        //out.writeObject(pt1);
        //out.flush();
        //Battleship.setInfo("Point sent, waiting for return value");
        try 
        {
        	pt2 = (Point) in.readObject();
        }
        catch (Exception ex)
        {
        	System.out.println (ex.getMessage());
        }
        System.out.println("Got point: " + pt2 + " from Server");
        
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