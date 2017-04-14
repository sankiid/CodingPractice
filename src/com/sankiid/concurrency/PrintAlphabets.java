package com.sankiid.concurrency;

public class PrintAlphabets {

	public static void main(String[] args) throws InterruptedException {
		Object lock = new Object();
		Thread t1 = new Thread(new Alphabets(lock), "0");
		Thread t2 = new Thread(new Alphabets(lock), "1");
		Thread t3 = new Thread(new Alphabets(lock), "2");
		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();
	}

	static class Alphabets implements Runnable {

		private Object lock;

		public Alphabets(Object lock) {
			this.lock = lock;
		}

		@Override
		public void run() {
			try {
				char c = 'a';
				boolean[] arr = new boolean[3];
				arr[0] = true;
				while (true) {
					synchronized (lock) {
						System.out.println(Thread.currentThread().getName() + ":" + c);
						c += 1;
						if(arr[0]){
							
						}else if(arr[1]){
							
						}else{
							
						}
						
						Thread.sleep(500);
						lock.notify();
						lock.wait();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
