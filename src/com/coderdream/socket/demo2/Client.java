package com.coderdream.socket.demo2;

import java.net.Socket;

public class Client {

	public static void main(String args[]) throws Exception {
		final int length = 100;
		String host = "localhost";
		int port = 8000;
		Socket[] sockets = new Socket[length];
		for (int i = 0; i < length; i++) { // 试图建立100 次连接
			sockets[i] = new Socket(host, port);
			Thread.sleep(3000);
			System.out.println("第" + (i + 1) + "次连接成功");
		}
		Thread.sleep(10000);
		for (int i = 0; i < length; i++) {
			sockets[i].close(); // 断开连接
		}
	}
}
