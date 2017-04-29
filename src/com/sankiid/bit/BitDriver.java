package com.sankiid.bit;

public class BitDriver {

	public static void main(String[] args) {
		System.out.println("-----------------------------");
		System.out.println(BitUtils.add(-7, 12));
		System.out.println(BitUtils.subtract(7, 2));
		System.out.println("-----------------------------");
		BitUtils.swap(2, 7);
		System.out.println("-----------------------------");
		BitUtils.findNonRepeating(new int[] { 2, 3, 7, 9, 11, 2, 3, 11 });
		System.out.println("-----------------------------");
		System.out.println(BitUtils.findOnceAppearedNumber(new int[] { 12, 1, 12, 12, 1, 1, 2 }));
		System.out.println("-----------------------------");
		System.out.println(BitUtils.findAbs(-10));
		System.out.println("-----------------------------");
		BitUtils.printBits(2);
		BitUtils.printBits(-2);
		System.out.println("-----------------------------");
		System.out.println("isOppositeSign " + BitUtils.isOppositeSign(5, -10));
		System.out.println("-----------------------------");
		System.out.println("isOdd " + BitUtils.isOdd(2));
		System.out.println("-----------------------------");
		System.out.println("powerOfTwo " + BitUtils.powerOfTwo(1024));
		System.out.println("-----------------------------");
		System.out.println("min " + BitUtils.min(3,9));
		System.out.println("-----------------------------");
		System.out.println("max " + BitUtils.max(3,9));
		System.out.println("-----------------------------");
		System.out.println("count set bits " + BitUtils.bitsets(-2));
		System.out.println("-----------------------------");
		System.out.println("multiply " + BitUtils.multiply(2, 11));
		System.out.println("-----------------------------");
		BitUtils.printBits(3221225472L);
		BitUtils.printBits(2147483648L);
		BitUtils.printBits(1073741824L);
	}

}
