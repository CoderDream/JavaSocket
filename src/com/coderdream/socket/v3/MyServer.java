package com.coderdream.socket.v3;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyServer {
	private final static Logger logger = Logger.getLogger(MyServer.class
			.getName());

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(10000);
		while (true) {
			Socket socket = server.accept();
			invoke(socket);
		}

	}

	private static void invoke(final Socket socket) throws IOException {
		new Thread(new Runnable() {

			@Override
			public void run() {
				ObjectInputStream is = null;
				ObjectOutputStream os = null;

				try {
					is = new ObjectInputStream(new BufferedInputStream(
							socket.getInputStream()));
					os = new ObjectOutputStream(socket.getOutputStream());

					Object obj = is.readObject();

					User user = (User) obj;
					System.out.println("user: " + user.getName() + "/"
							+ user.getPassword());

					user.setName(user.getName() + "_new");
					user.setPassword(user.getPassword() + "_new");

					os.writeObject(user);
					os.flush();

				} catch (IOException e) {
					logger.log(Level.SEVERE, null, e);
					e.printStackTrace();
				} catch (ClassNotFoundException e) {

					logger.log(Level.SEVERE, null, e);
					e.printStackTrace();
				} finally {
					try {
						is.close();
					} catch (Exception e) {
					}
					try {
						os.close();
					} catch (Exception e) {
					}
					try {
						socket.close();
					} catch (Exception e) {
					}
				}

			}

		}).start();
	}
}
