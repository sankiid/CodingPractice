package com.sankiid.concurrency;

public class Even implements Runnable {

	private Object resource;
	private static int num = 2;

	public Even(Object resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		while(true){
			synchronized (resource) {
				System.out.println("even " + num);
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
