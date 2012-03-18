package com.coderdream.socket.v3;

import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyClient {
	private final static Logger logger = Logger.getLogger(MyClient.class
			.getName());

	public static void main(String[] args) throws Exception {

		for (int i = 0; i < 100; i++) {
			Socket socket = null;
			ObjectInputStream is = null;
			ObjectOutputStream os = null;
			try {
				socket = new Socket("localhost", 10000);

				os = new ObjectOutputStream(socket.getOutputStream());
				User user = new User("user_" + i, "password_" + i);
				os.writeObject(user);
				os.flush();

				is = new ObjectInputStream(new BufferedInputStream(
						socket.getInputStream()));
				Object obj = is.readObject();
				if (null != obj) {
					user = (User) obj;
					System.out.println("user: " + user.getName() + "/"
							+ user.getPassword());
				}

				socket.close();

			} catch (Exception e) {

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

	}

}
