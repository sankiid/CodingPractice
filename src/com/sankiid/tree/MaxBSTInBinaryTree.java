package com.sankiid.tree;

public class MaxBSTInBinaryTree {

	static class MinMax {
		int size = 0;
		boolean bst = true;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		Node<Integer> root = new Node<>(6);
		root.left = new Node<>(3);
		root.right = new Node<>(8);
		root.left.left = new Node<>(1);
		root.left.right = new Node<>(5);
		root.right.left = new Node<>(4);
		// [size, isBST, min, max]
		MinMax minMax = maxBst(root);
		System.out.println(minMax.size);
	}

	private static MinMax maxBst(Node<Integer> root) {
		if (root == null) {
			return new MinMax();
		}
		MinMax left = maxBst(root.left);
		MinMax right = maxBst(root.right);

		MinMax result = new MinMax();

		if (!left.bst || !right.bst || root.data < left.max || root.data > right.min) {
			result.bst = false;
			result.size = Math.max(left.size, right.size);
		} else {
			result.bst = true;
			result.size = left.size + right.size + 1;
			result.min = root.left == null ? root.data : left.min;
			result.max = root.right == null ? root.data : right.max;
		}
		return result;
	}
}
