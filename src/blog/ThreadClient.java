package blog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadClient {
	public static final String IP = "127.0.0.1";
	public static final int PORT = 3021;

	public static void main(String[] args){
		try (
				Socket socket = new Socket(IP, PORT);
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in =	new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
				){
			String outputLine = null;
			while ((outputLine = stdIn.readLine()) != null && outputLine.intern() != "quit") {
				out.println(outputLine);
				System.out.println(in.readLine());
			}

			in.close();
			out.close();
			socket.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}