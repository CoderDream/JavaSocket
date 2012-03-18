package com.coderdream.socket.v2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient1 {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 10000);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		while (true) {
			String msg = reader.readLine();
			out.println("MyClient1 say:" + msg);
			out.flush();

			if ("bye".equals(msg)) {
				break;
			}

			System.out.println("MyClient1 say:" + in.readLine());
		}

		socket.close();

	}
}
