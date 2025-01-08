package tcpsocket;

import java.io.*;
import java.net.*;
import java.util.*;

public class Main {
	
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
		 handleClient();
		 }while (true); 
		
		
	}
	
	private static void handleClient()
	 {
		Socket link = null; 
		try
		 {
		 link = serverSocket.accept(); 
		 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
	 }

}
