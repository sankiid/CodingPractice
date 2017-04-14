package com.sankiid.concurrency;

public class Odd implements Runnable {

	private Object resource;
	private static int num = 1;

	public Odd(Object resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		while(true){
			synchronized (resource) {
				System.out.println("odd " + num);
				try {
					Thread.sleep(800);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				num += 2;
				resource.notify();
				try {
					resource.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
