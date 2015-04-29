package blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class BlogServer {
		public static final int PORT = 3021;
		
		public static void main(String[] args) throws IOException{
			try(
				ServerSocket serverSocket = 
						new ServerSocket(PORT);
				Socket clientSocket = serverSocket.accept();
				PrintWriter out =
						new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream()));
				
			){
				String inputLine;
				while((inputLine = in.readLine())!=null){
					System.out.println("Some Client Enter");
					System.out.println("Requesting... ");
					System.out.println("Clinet Post :" +inputLine);
				}
				
			}catch(IOException e){
				System.err.println("Exception caught when trying to listen on port"
						+ PORT+ " or listening for a connection");
				System.out.println(e.getMessage());
			}
		}
}
