package com.coderdream.queue;

class Queue // 队列类
{
	private int maxSize; // 队列长度，由构造函数初始化
	private long[] queArray; // 队列
	private int front; // 队头
	private int rear; // 队尾
	private int nItems; // 元素的个数
	// --------------------------------------------------------------

	public Queue(int s) // 构造函数
	{
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	// --------------------------------------------------------------
	public void insert(long j) // 进队列
	{
		if (rear == maxSize - 1) // 处理循环
			rear = -1;
		queArray[++rear] = j; // 队尾指针加1,把值j加入队尾
		nItems++;
	}

	// --------------------------------------------------------------
	public long remove() // 取得队列的队头元素。
	{
		long temp = queArray[front++]; // 取值和修改队头指针
		if (front == maxSize) // 处理循环
			front = 0;
		nItems--;
		return temp;
	}

	// --------------------------------------------------------------
	public long peekFront() // 取得队列的队头元素。该运算与 remove()不同，后者要修改队头元素指针。
	{
		return queArray[front];
	}

	// --------------------------------------------------------------
	public boolean isEmpty() // 判队列是否为空。若为空返回一个真值，否则返回一个假值。
	{
		return (nItems == 0);
	}

	// --------------------------------------------------------------
	public boolean isFull() // 判队列是否已满。若已满返回一个真值，否则返回一个假值。
	{
		return (nItems == maxSize);
	}

	// --------------------------------------------------------------
	public int size() // 返回队列的长度
	{
		return nItems;
	}
	// --------------------------------------------------------------
}
