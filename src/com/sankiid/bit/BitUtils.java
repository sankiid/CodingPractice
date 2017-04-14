package com.sankiid.bit;

public class BitUtils {

	private BitUtils() {
	}

	public static int add(int a, int b) {
		if (a < 0 || b < 0) {
			if (a < 0) {
				return subtract(b, -1 * a);
			}
			return subtract(a, -1 * b);
		}
		while (b > 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
	}

	public static int subtract(int a, int b) {
		while (b != 0) {
			int barrow = (~a) & b;
			a = a ^ b;
			b = barrow << 1;
		}
		return a;
	}

	public static void swap(int i, int j) {
		System.out.println(i + ", " + j);
		i = i ^ j;
		j = i ^ j;
		i = i ^ j;
		System.out.println(i + ", " + j);
	}

	public static void findNonRepeating(int[] arr) {
		int x = 0;
		for (int i = 0; i < arr.length; ++i) {
			x ^= arr[i];
		}
		// find right most set bit;
		int setBit = x & ~(x - 1);
		int a = 0, b = 0;
		for (int i = 0; i < arr.length; ++i) {
			if ((arr[i] & setBit) != 0) {
				a ^= arr[i];
			} else {
				b ^= arr[i];
			}
		}
		System.out.println(a + ", " + b);
	}

	public static int findOnceAppearedNumber(int[] arr) {
		int res = 0;
		int sum = 0;
		for (int i = 0; i < 32; ++i) {
			int setbit = 1 << i;
			sum = 0;
			for (int j = 0; j < arr.length; ++j) {
				sum += (arr[j] & setbit) != 0 ? 1 : 0;
			}
			res |= sum % 3 != 0 ? setbit : 0;
		}
		return res;
	}

	public static int findAbs(int a) {
		if (a > 0)
			return a;
		return (~a + 1);
	}

	public static void printBits(int a) {
		int b = 1 << 31;
		for (int i = 31, j = 1; i >= 0; --i, j++) {
			System.out.print((a & b) != 0 ? 1 : 0);
			a = a << 1;
			if (j % 8 == 0) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}

	public static boolean isOppositeSign(int i, int j) {
		i = i ^ j;
		return (i & (1 << 31)) != 0;
	}

	public static boolean isOdd(int a) {
		return (a & 1) != 0;
	}

	public static boolean powerOfTwo(int a) {
		if (a == 0)
			return false;
		return 0 == (a & (a - 1));
	}

	public static int min(int i, int j) {
		int k = i - j;
		int signBit = (k >> 31) & 01;
		return j + signBit * k;
	}

	public static int max(int i, int j) {
		int k = i - j;
		int signBit = (k >> 31) & 01;
		return i - signBit * k;
	}

	public static int bitsets(int i) {
		// Brian Kernighan's way
		int count = 0;
		while (i != 0) {
			count++;
			i = i & (i - 1);
		}
		return count;
	}
}
