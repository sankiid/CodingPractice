package com.sankiid.java;

public class FibPosition {
	// 0,1,1,2,3,5,8,13,21
	public static void main(String[] args) {
		System.out.println(fib(6));
	}

	private static int fib(int i) {
		if (i == 0)
			return 0;
		if (i == 1)
			return 1;
		return 1 + fib(i - 1) + fib(i - 2);
	}

}
