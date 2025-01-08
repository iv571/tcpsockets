package tcpsocket;

import java.io.*;
import java.net.*;
import java.util.*;

public class TCPServer {
	
	static ServerSocket serverSocket;
	static final int PORT = 1234; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Opening port…\n");
		
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Unable to attach to port!");
			System.exit(1); 
		}
		
		do
		 {
		System.out.println("Handling client");
		 handleClient();
		 } while (true); 
		
		
	}
	
	private static void handleClient()
	 {
		Socket link = null; 
		try
		 {
		 link = serverSocket.accept();
		 Scanner input = new Scanner(link.getInputStream());
		 PrintWriter output = new PrintWriter(link.getOutputStream(),true);
		 int numMessages = 0;
		 String message = input.nextLine();
		 while (!message.equals("***CLOSE***"))
		 {
			 System.out.println("Message received.");
			 numMessages++;
			 output.println("Message " + numMessages + ": " + message);
		 }
		 
		 output.println(numMessages + " messages received.");
		 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		
		finally
		 {
		 try
		 {
		 System.out.println("\n* Closing connection… *");
		 link.close();
		 } catch (IOException ioEx) {
			 System.out.println("Unable to disconnect!");
			 System.exit(1); 
		 }
		 }
	 }

}
