/**
  File: Client.java
  Author: Student in Fall 2020B
  Description: Client class in package taskone.
*/

package taskone;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Base64;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.json.JSONObject;

/**
 * Class: Client
 * Description: Client tasks.
 */
import java.io.*; 
import java.net.*; 
import java.util.*; 

// Client class 
class Client { 
	
	// driver code 
	public static void main(String[] args) 
	{ 
		// establish a connection by providing host and port 
		// number 
		try (Socket socket = new Socket("localhost", 1234)) { 
			
			// writing to server 
			PrintWriter out = new PrintWriter( 
				socket.getOutputStream(), true); 

			// reading from server 
			BufferedReader in 
				= new BufferedReader(new InputStreamReader( 
					socket.getInputStream())); 

			// object of scanner class 
			Scanner sc = new Scanner(System.in); 
			String line = null; 

			while (!"exit".equalsIgnoreCase(line)) { 
				
				// reading from user 
				line = sc.nextLine(); 

				// sending the user input to server 
				out.println(line); 
				out.flush(); 

				// displaying server reply 
				System.out.println("Server replied "
								+ in.readLine()); 
			} 
			
			// closing the scanner object 
			sc.close(); 
		} 
		catch (IOException e) { 
			e.printStackTrace(); 
		} 
	} 
}
