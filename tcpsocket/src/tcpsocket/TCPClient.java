package tcpsocket;

import java.io.*;
import java.net.*;
import java.util.*; 

public class TCPClient {
	 private static InetAddress host;
	 private static final int PORT = 1234;
	 public static void main(String[] args)
	 {
	 try
	 {
		 host = InetAddress.getLocalHost();
	 }
	 catch(UnknownHostException uhEx)
	 {
	 System.out.println("Host ID not found!");
	 System.exit(1);
	 }
	 accessServer();
	 }
	 
	 private static void accessServer()
	 { 
		 Socket link = null;
		 try
		 {
		 link = new Socket(host,PORT);
		 Scanner input = new Scanner(link.getInputStream());
		 PrintWriter output = new PrintWriter(link.getOutputStream(),true);
		 Scanner userEntry = new Scanner(System.in);
		 
		 String message, response;
		 do
		 {
		 System.out.print("Enter message: ");
		 message = userEntry.nextLine(); 
		 output.println(message); 
		 } while (!message.equals("***CLOSE***"));
		 }
		 catch(IOException ioEx)
		 { 
		 }
	 }
	 
}
