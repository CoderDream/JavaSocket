package com.coderdream.socket.v1;

import java.util.Date;

public class DeadCiecle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		do{
			
			//String msg = reader.readLine();
			
			String msg = "hello 1 " + new Date().toLocaleString();


			System.out.println(msg);
		}while (true);

	}

}
