package com.sankiid.concurrency;

public class PrintSequnce {

	public static void main(String[] args) throws InterruptedException {
		Object resource = new Object();
		Thread odd = new Thread(new Odd(resource));
		Thread even = new Thread(new Even(resource));

		odd.start();
		even.start();

		odd.join(2000);
		even.join(2000);
	}

}
