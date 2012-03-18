package com.coderdream.socket.v1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(10000);
		Socket socket = server.accept();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		
		while (true) {
			String msg = in.readLine();
			System.out.println(msg);
			out.println("Server received: " + msg);
			out.flush();
			
			if("bye".equals(msg)) {
				break;
			}
		}
		
		socket.close();
	}
}
