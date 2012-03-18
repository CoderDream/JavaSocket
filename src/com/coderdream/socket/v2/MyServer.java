package com.coderdream.socket.v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(10000);
		while (true) {
			Socket socket = server.accept();
			invoke(socket);
		}

	}

	private static void invoke(final Socket client) throws IOException {
		new Thread(new Runnable() {

			@Override
			public void run() {
				BufferedReader in = null;
				PrintWriter out = null;

				try {
					in = new BufferedReader(new InputStreamReader(
							client.getInputStream()));
					out = new PrintWriter(client.getOutputStream());

					while (true) {
						String msg = in.readLine();
						System.out.println(msg);
						out.println("Server received: " + msg);
						out.flush();

						if ("bye".equals(msg)) {
							break;
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						in.close();
					} catch (Exception e) {
					}
					try {
						out.close();
					} catch (Exception e) {
					}
					try {
						client.close();
					} catch (Exception e) {
					}
				}

			}

		}).start();
	}
}
