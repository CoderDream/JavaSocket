package com.coderdream.socket.v1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MyServer {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(10000);
		//server.setSoTimeout(6000);
		Socket socket = server.accept();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		
		while (true) {
			String msg = in.readLine();
			System.out.println(msg);
			if(null != msg && !"".equals(msg.trim())) {
				do{
					
					//String msg = reader.readLine();
					
					String msg2 = "hello 1 " + new Date().toLocaleString();


					//System.out.println(msg2);
				}while (true);
			}
			out.println("Server received: " + msg);
			out.flush();
			
			if("bye".equals(msg)) {
				break;
			}
		}
		
		socket.close();
	}
}
