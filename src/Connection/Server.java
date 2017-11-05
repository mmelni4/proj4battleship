package Connection;

import java.net.*; 
import java.io.*; 



public class Server 
{ 
 public static void main(String[] args) throws IOException 
   { 
    ServerSocket connectionSocket = null; 

    try { 
         connectionSocket = new ServerSocket(10007); 
         System.out.println ("Socket open on Port: " +
                             connectionSocket.getLocalPort());
         InetAddress addr = InetAddress.getLocalHost();
         System.out.println("Java InetAddress localHost info: " + addr);
         System.out.println("Local Host Name: " + addr.getHostName());
         System.out.println("Local Host Address: " + addr.getHostAddress());
        } 
    catch (IOException e) 
        { 
         System.err.println("Could not listen on port: 10007."); 
         System.exit(1); 
        } 

    Socket communicationSocket = null; 

    try { 
         communicationSocket = connectionSocket.accept(); 
        } 
    catch (IOException e) 
        { 
         System.err.println("Accept failed."); 
         System.exit(1); 
        } 

    PrintWriter out = new PrintWriter(communicationSocket.getOutputStream(), 
                                      true); 
    BufferedReader in = new BufferedReader( 
            new InputStreamReader( communicationSocket.getInputStream())); 

    String inputLine; 

    while ((inputLine = in.readLine()) != null) 
        { 
         System.out.println ("Server: " + inputLine); 
         out.println(inputLine); 

         if (inputLine.equals("Bye.")) 
             break; 
        } 

    out.close(); 
    in.close(); 
    communicationSocket.close(); 
    connectionSocket.close(); 
   } 
} 
