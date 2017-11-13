package Connection;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

import UI.Battleship;

public class Client
{
    public static void initiateClient() throws IOException 
    {
    	String ip = new String();
    	ip = "127.0.0.1";
    	int port = 6789;
        Socket echoSocket = null;
        ObjectOutputStream out = null;
        ObjectInputStream in = null;

        try
        {
            echoSocket = new Socket(ip, port);
            out = new ObjectOutputStream(echoSocket.getOutputStream());
            in = new ObjectInputStream(echoSocket.getInputStream());
        } catch (UnknownHostException e) {
            Battleship.setInfo("Don't know about host: " + ip);
            System.exit(1);
        } catch (IOException e) {
            Battleship.setInfo("Couldn't get I/O for "
                               + "the connection to: " + ip);
            System.exit(1);
        }

        DataPacket pt1 = new DataPacket();
        DataPacket pt2 = null;
        Battleship.setInfo("Sending point: " + pt1 + " to Server");
        out.writeObject(pt1);
        out.flush();
        Battleship.setInfo("Point sent, waiting for return value");

        try 
        {
             pt2 = (DataPacket) in.readObject();
        }
        catch (Exception ex)
        {
             System.out.println (ex.getMessage());
        }

        System.out.println("Got point: " + pt2 + " from Server");

		out.close();
		in.close();
		echoSocket.close();
    }
}