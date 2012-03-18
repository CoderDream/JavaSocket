package com.coderdream.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeOutTest {
	public static void main(String args[]) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8000);
		serverSocket.setSoTimeout(6000); // 等待客户连接的时间不超过6 秒
		Socket socket = serverSocket.accept();
		socket.close();
		System.out.println("服务器关闭");
	}
}