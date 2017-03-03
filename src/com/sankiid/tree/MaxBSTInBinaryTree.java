package com.sankiid.tree;

public class MaxBSTInBinaryTree {

	public static void main(String[] args) {
		Node<Integer> root = new Node<>(6);
		root.left = new Node<>(3);
		root.right = new Node<>(8);
		root.left.left = new Node<>(1);
		root.left.right = new Node<>(5);
		root.right.left = new Node<>(4);
		int[] maxSize = new int[1];
		maxBst(root, new int[1], new int[1], new boolean[1], maxSize);
		System.out.println(maxSize[0]);
	}

	private static int maxBst(Node<Integer> root, int[] min, int[] max,
			boolean[] isBst, int[] maxSize) {
		
		min[0] = Integer.MAX_VALUE;
		max[0] = Integer.MIN_VALUE;

		if (root == null) {
			isBst[0] = true;
			return 0;
		}

		int leftSize = maxBst(root.left, min, max, isBst, maxSize);
		boolean isLeftValid = isBst[0] && root.data > max[0];

		int tmpMin = min[0] > root.data ? root.data : min[0];
		int tmpMax = max[0] < root.data ? root.data : max[0];

		int rightSize = maxBst(root.right, min, max, isBst, maxSize);
		boolean isRightValid = isBst[0] && root.data < min[0];

		min[0] = min[0] < tmpMin ? min[0] : tmpMin;
		max[0] = max[0] > tmpMax ? max[0] : tmpMax;

		if (isLeftValid && isRightValid) {
			isBst[0] = true;
			if (1 + leftSize + rightSize > maxSize[0]) {
				maxSize[0] = 1 + leftSize + rightSize;
			}
			return 1 + leftSize + rightSize;
		}

		isBst[0] = false;
		return -1;
	}

}
