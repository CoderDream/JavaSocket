package com.coderdream.socket.v1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class MyClient {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 10000);
		//socket.setSoTimeout(6000);
		//serverSocket.setSoTimeout(6000);
//		BufferedReader in = new BufferedReader(new InputStreamReader(
//				socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream());
//		BufferedReader reader = new BufferedReader(new InputStreamReader(
//				System.in));

		do{
			
			//String msg = reader.readLine();
			
			String msg = "hello 1 " + new Date().toLocaleString();
			out.println(msg);
			out.flush();
			Thread.sleep(3000);
//			if ("bye".equals(msg)) {
//				break;
//			}

//			System.out.println(in.readLine());
		}while (true);

		//socket.close();

	}
}
