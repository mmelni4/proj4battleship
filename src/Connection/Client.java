package Connection;

import java.io.*;
import java.net.*;

public class Client {
    public static void initiateClient() throws IOException {

        Socket echoSocket = null;
        ObjectOutputStream out = null;
        ObjectInputStream in = null;

        try {
            echoSocket = new Socket("127.0.0.1", 6789);
            out = new ObjectOutputStream(echoSocket.getOutputStream());
            in = new ObjectInputStream(echoSocket.getInputStream());
            
        } catch (UnknownHostException e) {
            System.err.println("Error opening socket");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to socket");
            System.exit(1);
        }

	BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	String userInput;

	while ((userInput = stdIn.readLine()) != null) {
	    out.println(userInput);
	    System.out.println("echo: " + in.readLine());
	}

	out.close();
	in.close();
	stdIn.close();
	echoSocket.close();
    }
}

