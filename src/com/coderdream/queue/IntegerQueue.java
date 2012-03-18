package com.coderdream.queue;

public class IntegerQueue {
	public static void main(String[] args) {
		Queue theQueue = new Queue(5); // 队列有5个元素

		theQueue.insert(10); // 添加4个元素
		theQueue.insert(20);
		theQueue.insert(30);
		theQueue.insert(40);

		theQueue.remove(); // 移除3个元素
		theQueue.remove(); // (10, 20, 30)
		theQueue.remove();

		theQueue.insert(50); // 添加4个元素
		theQueue.insert(60);
		theQueue.insert(70);
		theQueue.insert(80);
		
		// 遍历队列并移除所有元素
		while (!theQueue.isEmpty()) {
			long n = theQueue.remove(); // (40, 50, 60, 70, 80)
			System.out.print(n);
			System.out.print(" ");
		}
		System.out.println("");
	}
}